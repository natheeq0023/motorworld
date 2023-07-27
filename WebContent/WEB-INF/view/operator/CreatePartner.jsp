<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Account has been created successfully.
</div>
</c:if>
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
.btn-titlelableinfo {
    color: #292424;
    background-color: #F0AD4E;
    border-color: #F0AD4E;
    padding: 6px 35px;
}
</style>
<!-- row  -->
 <!--   <div class="row">
   
   
   <div class="col-xs-8 col-md-8">
        <div class="form-group">
            <label for="concept" class="btn btn-titlelableinfo btn-pressure btn-sensitive" >To &nbsp;create &nbsp;new&nbsp; Accounting he should be golden &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>customer and he should confirm to be Accounting
 </label>
         </div>
                          
    </div>
                    
   </div> -->
   <!-- end row -->
   <form action="sendtopartner.htm" method="post">
<!-- div1 started -->
<div id="div1">
 <div class="row">
        <div class="col-xs-5 col-md-6">
       
                              <div class="form-group">
                                  <div class="">
                                      <input type="text" class="form-control" size="10"  id="userId"  name="userId" placeholder="Account ID" required>
                                  </div>
                              </div>
                          
                       
                    </div>
                   
                    <div class="col-xs-2 col-md-2">
                        <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" id="btnCheck">Check</button> 
                    </div>
         </div>
 <div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid AccountId.
</div>
<div class="alert alert-danger fade in" id="divBasic" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> This Account should be Golden Registration.
</div>
   

<div id="divCreate" style="display:none">

	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
  
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
      
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="hidden" class="ctextbox" name="fullName" id="fullName"  size="15" readonly="readonly" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2">
    
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
        	<input type="hidden" name="customerId" id="customerId"/>
        	<input type="hidden" name="userRole" id="userRole" value="Partner"/>
       <input type="button" class="btn btn-success btn-bold" id="btnContinue1" value="Confirm Add" onclick="nextContinue1()"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->


</div>
</div>

<!-- Div two started  -->
<!-- row  -->
 <div id="div2" style="display:none">
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right" >
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">First&nbsp;Partner</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="text" class="ctextbox" name="userRoleId" id="userRoleId" value="${sessionScope.userRole.userId }" size="15" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Second&nbsp;Partner</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="text" class="ctextbox" name="partnerid" id="partnerid"   size="15"  />
       

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
  
   <!-- end row -->
 <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">StartDate </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="startDate" id="startDate" placeholder="DD-MM-YYYY"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
		 <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">EndDate </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="enddate" id="enddate" placeholder="DD-MM-YYYY"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
     <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2">
    
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
      
       <input type="button" class="btn btn-success btn-bold" id="btnContinue2" value="Continue" onclick="nextContinue2()"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
</div>
<!--***************************************************************************************  -->
<!-- row  -->
 <div id="div3" style="display:none">
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
   
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
       
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->

 <!-- row  -->
 
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Percentage </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="percentage" id="percentage" />
		
         </div>
                          
    </div>
     <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <select name = "percentagemonth" id= "percentagemonth">
                 <option value="Select">Select Month</option>
                 <option value="Each Month">Each month</option>
                 <option value="Each 3 Month">Each 3 month</option>
                 <option value="Each 6 Month">Each 6 month</option>
                 <option value="Each 12 Month">Each 12 month</option></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
		 <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    <label for="concept" class="col-xs-5 col-md-3 control-label-left">Amount&nbsp;Now </label>
   
   </div>
    <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="amountnow" id="amountnow" />
		
         </div>
                          
    </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <select name = "amountmonth" id= "amountmonth">
                 <option value="Select">Select Month</option>
                 <option value="Each Month">Each month</option>
                 <option value="Each 3 Month">Each 3 month</option>
                 <option value="Each 6 Month">Each 6 month</option>
                 <option value="Each 12 Month">Each 12 month</option></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
     <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2">
    
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
      
       <input type="button" class="btn btn-success btn-bold" id="btnContinue2" value="Continue" onclick="nextContinue3()"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
</div>


<!--******************************************************************************************  -->


<!-- Div three started  -->

 <!-- row  -->
 <div id="div4" style="display:none">
  <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
      
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
       
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <div class="row">
                    
                   
                   
                    <div class="col-xs-5 col-md-6">
                       
                          
                          
                              <div class="form-group">
                                  <div class="">
                                      <input type="text" class="form-control" size="5"  id="machineSno"  name="machineSno"  placeholder="No Of machine" required>
                                  </div>
                              </div>
                          
                       
                    </div>
                   
                    <div class="col-xs-2 col-md-2">
                        <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" id="addMachine" >Add</button> 
                    </div>
         </div>
   <!-- end row -->
	<!-- row  -->
	 <div class="alert alert-danger fade in" id="divNo" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> This machine/lock is not available
</div>
      
<div class="row">
        <div class="col-md-9">
   <div id="no-more-tables">
  
			<table name="mytable" id="tb_cartTable"
				class="col-md-9 table-bordered table-striped table-condensed cf">
				<thead class="cf">
					<tr>

						
						<th class="lbl-lableinfo" align="center">
							Machine SNo
						</th>
						
						<th class="lbl-lableinfo" align="center">
							Action
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
<!-- Row start   -->
	 <div class="row">
   
   <div class="col-xs-5 col-md-2">
    
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
      
    
         </div>
                          
    </div>
                    
   </div>
   
 <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-6" align="center">
        <div class="form-group">
        
        <input type="hidden" name="id" id="id"/>
        <input type="hidden" name="page" id="page"/>
        <input type="hidden" id="machineSno11">  
         <!--   <input type="submit" class="btn btn-success btn-bold" id="btnPause" name="pageStatus" value="View" />
           <input type="submit" class="btn btn-success btn-bold" id="btnBlock" name="pageStatus" value="Delete" />
           <input type="submit" class="btn btn-success btn-bold" id="btnActive" name="pageStatus" value="Stop"  />
           <input type="submit" class="btn btn-success btn-bold" id="btnStop" name="pageStatus" value="Pause" />
           <input type="button" class="btn btn-success btn-bold" id="btnView" name="pageStatus" value="Change Machine" />
         --> </div>
                          
    </div>
                    
   </div>
   <!-- end row -->


<!-- Row start   -->
	 <div class="row">
   
   <div class="col-xs-5 col-md-2">
    
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
      
    
         </div>
                          
    </div>
                    
   </div>
   
     <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2">
    
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
      
        <input type="button" class="btn btn-success btn-bold" id="btnContinue3" value="Continue" onclick="nextContinue4()" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
</div>
<!-- Div Four started  -->

 <!-- row  -->
 <div id="div5" style="display:none">
  <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
      
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
       
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    <label for="concept" class="col-xs-5 col-md-3 control-label-left">Contract&nbsp;NO </label>
   
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         
           <input type="text" class="form-control" size="2"  id="serialNumber"  name="contractId" readonly="readonly">
		
         </div>
                          
    </div>
                    
   </div>
     <!-- end row -->
	<!-- row  -->
	
      

<!-- Row start   -->
	 <div class="row">
   
   <div class="col-xs-5 col-md-2">
    
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
      
    
         </div>
                          
    </div>
                    
   </div>
   
 
<!-- Row start   -->
	 <div class="row">
   
   <div class="col-xs-5 col-md-2">
    
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
      
    
         </div>
                          
    </div>
                    
   </div>
   
     <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2">
    
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
      
       <input type="submit" class="btn btn-success btn-bold" id="btnContinue3" value="Send to Partner" />
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
	$('#btnCheck').click(
		function(event) {
		$('#divSuccess').css("display", "none"); 
		$('#divCreate').css("display", "none"); 
		$('#divInvalid').css("display", "none"); 
		$('#divBasic').css("display", "none"); 
			var userId = $('#userId').val();
			
			if(userId=="")
			{
				alert("please enter Account Id");
				$('#userId').focus()
				return false;
			}
			
			var data = 'userId='
					+ encodeURIComponent(userId);
					
			$.ajax({
				url : "checkaccounts.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					if(response.registrationType=="basic")
					{
							$('#divBasic').css("display", "block"); 
					}
					else
					{
						
						$('#divCreate').css("display", "block"); 
						$("#doc").val("");
						$("#city").val("");
						$("#fullName").val(response.fullName);
						$("#country").val(response.country);
						$("#partnerid").val(response.userId);
						$("#customerId").val(response.customerId);
						$("#countryCode").val(response.countryCode);
						$("#email").val(response.email);
						
					}
				
				},
				error : function(xhr, status, error) {
					$('#divInvalid').css("display", "block"); 
				}
			});
			return false;
		});	    
	
	$('#addMachine').click(
			
			function(event) {
				
			$('#divOrder').css("display", "none"); 
			
			var model=$("#machineSno").val();
			var model11 = $("#machineSno11").val();
			
			
			if(model=="")
			{
				alert("please enter Machine Sno");
				$('#machineSno').focus()
				return false;
			}
						
			else if (model11=="fail") { 
		    	
				alert("this machine is not avaliable");
				$('#machineSno').focus()
			 
		    }
			
			else
		   {
		  
		
			var tbodyRows=$("#tb > tr").length;
			var isNotExist=true;
			var tableRow;
		     
			for(var index=0;index<tbodyRows;index++)
			{
				tableRow=$("#tb").find('tr').eq(index);
				 
				var tkind=tableRow.find('td').eq(0).text();
				
				var tmodel=tableRow.find('td').eq(1).text();
			}
			
			var appendTxt = "<td>"+model+"</td><input type='hidden' name='model' value='"+model+"'  id='model'/> <td><a  onclick='deleteRow(this)'>Delete</a></td>";
			
			if(isNotExist)
			{
				$("#tb").append("<tr>"+appendTxt+"</tr>");	
			}
			else
			{
				 tableRow.html(appendTxt);
			}		
			}
			
				
				});  
	});

	function findInTable(str, tableID){
		
		   $('#' + tableID + 'tr').each(function(){
		   alert(tableID);
	       $(this).children('td').each(function(){
	       alert(str);
	       if ( $(this).html() == str ){
	    	   alert(str);
	            	 return false;
	            		            }
	       });
	    
		   }); 
	
      ;
	}
	
</script>
<script type="text/javascript">	
	function nextContinue1() {
	  	var valid=true;
		
	  	
	  	
	  	if(valid)
	  	{
	  	
		  	$('#div1').css("display", "none");
		  	$('#div2').css("display", "block"); 
		  	$('#div3').css("display", "none"); 
	  	}
	  	
	 }
	function nextContinue2() {
		 
	  	var valid=true;
	  	if($("#startDate").val()=="")
	  	{
	  		valid=false;
	  		alert("please enter start date");
	  		$("#country").focus();
	  		
	  	}else if($("#endDate").val()=="")
	  	{
	  		valid=false;
	  		alert("please enter end date");
	  		$("#city").focus();
	  		
	  	}
		
	  	if(valid)
		{
		
			$('#div1').css("display", "none");
		  	$('#div3').css("display", "block"); 
		  	$('#div2').css("display", "none"); 
		  	$('#div4').css("display", "none"); 
		} 
		return valid;
	  	
	 }
	function nextContinue3() {
	 
	  	var valid=true;
		 if($("#percentage").val()=="")
	  	{
	  		valid=false;
	  		alert("please enter percentageof amount");
	  		$("#percentage").focus();
	  		
	  	}
		 if($("#month").val()=="")
		  	{
		  		valid=false;
		  		alert("please select Month");
		  		$("#month").focus();
		  		
		  	}
	  	if(valid)
		{
			$('#div1').css("display", "none");
		  	$('#div4').css("display", "block"); 
		  	$('#div2').css("display", "none"); 
		  	$('#div3').css("display", "none"); 
		} 
		return valid;
	  	
	 }
	function nextContinue4() {
		var valid=true;
	  	
	  	if(valid)
		{
	  		var text = "PACO";
	         var possible = "0123456789";

	         for( var i=0; i < 5; i++ )
	             text += possible.charAt(Math.floor(Math.random() * possible.length));
		  	$("#serialNumber").val(text);
			$('#div2').css("display", "none");
		  	$('#div5').css("display", "block"); 
		  	$('#div3').css("display", "none"); 
		  	$('#div4').css("display", "none"); 
		  
		} 
		return valid;
	  	
	 }
	
		function snoCheck(obj)
	    {		
		$('#divNo').css("display", "none"); 	
		var machineSno = $('#machineSno').val();
		var data = 'machineSno='
			+ encodeURIComponent(machineSno);
				$.ajax({
				url : "checkmachinesno.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',				
				type : "GET", 
				success : function(response) {					
					$(machineSno).val(response.msg);
					if(response.msg=="fail")
					{
						$('#divNo').css("display", "block"); 
						$('#machineSno11').val(response.msg);
						
					}
					else
					{
						$('#divNo').css("display", "none"); 	
						$('#machineSno11').val(response.msg);
					}
				},
				error : function(xhr, status, error) {
				
				}
				
			});
			
			return false;		
		  }
		function deleteRow(obj)
		{
			var trow=$(obj).parent().parent();
			var amount=trow.find('td').eq(4).text();
			var tcost=parseFloat($("#model").val())-parseFloat(amount);
			$("#txtTotalCost").val(tcost);
			trow.remove();
			var rows=$("#tb > tr").length;
			if(rows>0)
			{
			   $('#divOrder').css("display", "block"); 
			}
			else
			{
			   $('#divOrder').css("display", "none"); 
			}
		
		}
	  
</script>


           