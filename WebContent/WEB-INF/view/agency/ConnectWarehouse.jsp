<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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

.ctextbox
{
	background-color:#C1C1C1;
}
.btn-lableinfo {
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
</style>
<!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-8" align="center">
        <div class="form-group">
           <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive">&nbsp;&nbsp;&nbsp; Salesman Connect Warehouse details&nbsp;&nbsp;&nbsp;</button> 
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
<!-- row  -->
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Salesman has been connect to warehouse successfully.
</div>
</c:if>

 <div class="row">
                    
                   
                   
                    <div class="col-xs-5 col-md-6">
                       
                          
                          
                              <div class="form-group">
                                  <div class="">
                                      <input type="text" class="form-control" size="10"  id="userId"  name="userId" placeholder="Salesman ID" required>
                                  </div>
                              </div>
                          
                       
                    </div>
                   
                    <div class="col-xs-2 col-md-2">
                        <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" id="btnCheck">Check</button> 
                    </div>
         </div>
 <div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid SalesmanId.
</div>

         

<div id="divConnect" style="display:none">

	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Full&nbsp;Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" class="ctextbox" name="fullName" id="fullName"  size="15" readonly="readonly" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Country</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="text" class="ctextbox" name="country" id="country" size="15" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> City</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="text" class="ctextbox" name="city" id="city"   size="15" readonly="readonly"  />

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   
   
   
<form action="connectwarehouse.htm" method="post"  onsubmit="return validate(this);">
	
   
   <c:if test="${requestScope.warehouses ne null}">
   <!-- row  -->
   <div class="row">
        <div class="col-md-9">
   <div id="no-more-tables">
            <table class="col-md-9 table-bordered table-striped table-condensed cf">
        		<thead class="cf">
        			<tr>
        				<th class="lbl-lableinfo" align="center">&nbsp;&nbsp;&nbsp;NO.</th>
        				
        				<th class="lbl-lableinfo" >WarehouseSNO</th>
        				<th class="lbl-lableinfo" >Address </th>
        				<th class="lbl-lableinfo" >City </th>
        				
        				<th class="lbl-lableinfo" >Country</th>
        				<th class="lbl-lableinfo">
        					&nbsp;&nbsp;&nbsp;
        				</th>
        				
        			</tr>
        		</thead>
        		<tbody>
        		<c:forEach items="${requestScope.warehouses}" var="warehouse" varStatus="st">
        			<tr>
        				<td>
        					${st.count }
        				</td>
        				
        				
        				<td>
        					${warehouse.warehouseSno }
        				</td>
        				<td>
        					${warehouse.address }
        				</td>
        				<td>
        					${warehouse.city }
        				</td>
        				<td>
        					${warehouse.country }
        				</td>
        				<td>
        					<input type="checkbox" name="warehouseId" id="warehouseId${warehouse.warehouseSno}" value="${warehouse.warehouseId}">
        				</td>
        			</tr>
        			
        			
        		
        		</c:forEach>
        			
        		</tbody>
        	</table>
        </div>
        </div>
        </div>
        <!-- end row  -->
        <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2">
    
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
        	<input type="hidden" name="userRoleId" id="userRoleId"/>
        	
           <input type="submit" class="btn btn-lableinfo btn-pressure btn-sensitive" id="btnSubmit" value="Connect" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
        </c:if>
</form>
</div>

<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		$('#divSuccess').css("display", "none"); 
		$('#divConnect').css("display", "none"); 
		$('#divInvalid').css("display", "none"); 
		 
			var userId = $('#userId').val();
			
			if(userId=="")
			{
				alert("please enter salesman Id");
				$('#userId').focus()
				return false;
			}
			
			var data = 'userId='
					+ encodeURIComponent(userId);
					
			$.ajax({
				url : "checksalesman.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					
						
						$('#divConnect').css("display", "block"); 
						
						
						$("#fullName").val(response.fullName);
						$("#country").val(response.country);
						$("#city").val(response.city);
						$("#userRoleId").val(response.userRoleId);
						
						
						
					
				
				},
				error : function(xhr, status, error) {
					$('#divInvalid').css("display", "block"); 
					$('#divConnect').css("display", "none"); 
				}
			});
			return false;
		});
	
	
	});
	
	function validate(formObj)
	{
	
		
		if($("input:checkbox:checked").length<=0)
		{
			alert("please select atleast one warehouse");
			return false;
		}
		return true;
	}
</script>

           