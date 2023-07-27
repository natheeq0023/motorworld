<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.ctextbox
{
	
	background-color:#C1C1C1;
}
.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
.lbl-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
.btn-titlelableinfo {
    color: #292424;
    background-color: #F0AD4E;
    border-color: #F0AD4E;
    padding: 6px 35px;
}
.table-bordered {
    border: 1px solid #28137B;
}
.table-bordered>tfoot>tr>td {
    border: 1px solid #ddd;
}
tr {
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;
}
.table-striped>tbody>tr:nth-child(odd)>td, .table-striped>tbody>tr:nth-child(odd)>th {
    background-color: #CFDEEA;
}

.table-striped>tbody>tr:nth-child(even)>td, .table-striped>tbody>tr:nth-child(even)>th {
    background-color: rgb(232, 241, 249);;
}
.table-bordered>tbody>tr>td, .table-bordered>tbody>tr>th, .table-bordered>tfoot>tr>td, .table-bordered>tfoot>tr>th, .table-bordered>thead>tr>td, .table-bordered>thead>tr>th {
    border: 2px solid #FFF;
}
</style>
<br/>
<br/>
<br/>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Lock to Machine has been  successfully Connected.
</div>
</c:if>
<div class="alert alert-danger fade in" id="divNoMachines" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Machine not available
</div>
<form action="" method="post" onsubmit="return validate(this);">
<!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-8" align="center">
        <div class="form-group">
           <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive">&nbsp;&nbsp;&nbsp; Machine Lock Connect&nbsp;&nbsp;&nbsp;</button> 
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row -->
   <div class="row">
                    
                   
                   
                    <div class="col-xs-5 col-md-6">
                       
                          
                          
                              <div class="form-group">
                                  <div class="">
                                      <input type="text" class="form-control" size="10"  id="machineSno"  name="machineSno" placeholder="Machine Sno" required>
                                  </div>
                              </div>
                          
                       
                    </div>
                   
                    <div class="col-xs-2 col-md-2">
                        <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" id="btnGet">Get Machine </button> 
                    </div>
         </div>
   <!-- end row -->
   
   <div id="divMachine" style="display:none">
   <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
    Machine Type</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="machineType" name="machineType" readonly="readonly">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
    Machine Model</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="machineModel" name="machineModel" readonly="readonly">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   </div>
   <c:if test="${requestScope.locks ne null}">
   <!-- row  -->
   <div class="row">
        <div class="col-md-9">
   <div id="no-more-tables2">
            <table class="col-md-9 table-bordered table-striped table-condensed cf">
        		<thead class="cf">
        			<tr>
        				<th class="lbl-lableinfo" align="center">&nbsp;&nbsp;&nbsp;NO.</th>
        				
        				<th class="lbl-lableinfo" >
							Type
						</th>
						<th class="lbl-lableinfo">
							Model
						</th>
						<th class="lbl-lableinfo">
							 Lock SNO
						</th>
						<th class="lbl-lableinfo">
							 
						</th>
						
        				
        			</tr>
        		</thead>
        		<tbody>
        		<c:forEach items="${requestScope.locks}" var="lock" varStatus="st">
        			<tr>
        				<td>
        					${st.count }
        				</td>
        				<td>
        					${lock.lockKind}
        				</td>
        				<td>
        					${lock.lockModel}
        				</td>
        				<td>
        					${lock.lockSno}
        				</td>
        				
        				<td>
        					<input type="checkbox" name="lockId" value="${lock.lockId}" >
        				</td>
        				
        				
        				
        			</tr>
        			
        			
        		
        		</c:forEach>
        			
        		</tbody>
        	</table>
        </div>
        </div>
        </div>
        <!-- end row  -->
        </c:if>
       <br/>
  <div id="divConLock" style="display:none">      
       <fieldset>
       		<legend>Connected Locks</legend>
       		 <!-- row  -->
<div class="row">
        <div class="col-md-9">
   <div id="no-more-tables" >
  
			<table
				class="col-md-9 table-bordered table-striped table-condensed cf">
				<thead class="cf">
					<tr>

						<th class="lbl-lableinfo" align="center">
							Lock Type
						</th>
						<th class="lbl-lableinfo" align="center">
							Lock Model
						</th>
						<th class="lbl-lableinfo">
							 LockSNO
						</th>
						
						<th class="lbl-lableinfo">
							
						</th>

					</tr>
				</thead>
				<tbody id="tb">


				</tbody>
			</table>
			
		</div>
		</div>
	
</div>
<!-- end row  -->
       	
       </fieldset>
       </div>

  <div id="divBtnConnect" style="display:none">
  	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
      
	<button type="submit" class="btn btn-success btn-bold" id="btnConnect" >Connect</button> 
	<input type="hidden" name="machineId" id="machineId" >
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  </div>
       
   </form>
   <script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
	
	
	$('#btnGet').click(
		function(event) {
		
			var machineSno = $('#machineSno').val();
			$('#divNoMachines').css("display", "none");
			$('#divConLock').css("display", "none");  
			$('#divBtnConnect').css("display", "none"); 
			$("#machineId").val("");
			
			if(machineSno=="")
			{
				alert("please enter Machine Sno");
				$('#machineSno').focus();
				return false;
			}
			$('#tb').html("");
			
			var data = 'machineSno='
					+ encodeURIComponent(machineSno);
					
			$.ajax({
				url : "checknachine.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
					
					$('#divMachine').css("display", "block"); 
					$('#divBtnConnect').css("display", "block"); 
					$("#machineModel").val(response.machine.machineModel);
					$("#machineType").val(response.machine.machineKind);
					$("#machineId").val(response.machine.machineId);
					
					if(response.connectedLocks!=null)
					{
						$('#divConLock').css("display", "block");  
						for ( var i = 0; i < response.connectedLocks.length; i++) {
							var lock = response.connectedLocks[i];
							$("#tb").append("<tr><td>"+lock.lockKind+"</td><td>"+lock.lockModel+"</td><td>"+lock.lockSno+"</td><td><input type='checkbox' name='connectedLockId' value='"+lock.lockId+"' checked='checked'/>Connected</td></tr>");	
						}
						
					}
					
				
				},
				error : function(xhr, status, error) {
						$('#divNoMachines').css("display", "block"); 
						
				}
			});
			return false;
		});
	
	
	});
</script>
<script type="text/javascript">
	function validate(formObj)
	{
			if(formObj.machineSno.value=="" )
			{
				alert("please enter Machine Sno");
				$('#machineSno').focus();
				return false;
			}
			if( formObj.machineId.value=="")
			{
				alert("please verify Machine Sno");
				$('#machineSno').focus();
				return false;
			}
			return true;
	}
</script>

           