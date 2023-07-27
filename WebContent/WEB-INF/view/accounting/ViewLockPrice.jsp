<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.form-control {
	width:60%;
	}
</style>
<script>
function profile(){
	
    var mob = document.getElementById("price").value;	
    
	if(mob=='')
      
    	 {
      	  document.getElementById('price').style.borderColor = "red";
            document.getElementById("pricelocation").innerHTML=  
                "Please Enter Price !";
            return false;
    	 
    	 }
	  var newmob = document.getElementById("discount").value;
	 if(newmob=='')
	      
	 {
 	  document.getElementById('discount').style.borderColor = "red";
       document.getElementById("discountlocation").innerHTML=  
           "Please enter the discount !";
       return false;
	 
	 }
	 var newmo = document.getElementById("startDate").value;
	 if(newmo=='')
	      
	 {
 	  document.getElementById('startDate').style.borderColor = "red";
       document.getElementById("startlocation").innerHTML=  
           "Please enter the start date !";
       return false;
	 
	 }
	 var newm = document.getElementById("endDate").value;
	 if(newm=='')
	      
	 {
 	  document.getElementById('endDate').style.borderColor = "red";
       document.getElementById("endlocation").innerHTML=  
           "Please enter the end date !";
       return false;
	 
	 }
	
}
function msg() {
	 var v= confirm("Are u sure?");  
	 if(v==true){  
	 alert("ok");  
	 }  
	 else{  
	 alert("cancel");  
	 }  
	
}
</script>
<br/>
<br/>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Lock Price has been Updated Successfully!.
</div>
</c:if>

<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Lock&nbsp;SNO </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="lockSno" name ="lockSno" class="form-control"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">s
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
        
<button type="button" class="btn btn-success btn-bold" id="btnCheck">Check</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  <div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid LockSno.
</div>
   
 <div id="divMachinePrice" style="display:none">
 	
 	<form action="editlockpage.htm" method="post" >
 		<!-- row  -->
      <!-- end row -->
   <!-- row  -->
 
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Previous Final Price </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="pfinalPrice" id="pfinalPrice" class="form-control" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Discount Given </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="pdiscount" id="pdiscount" class="form-control" onkeypress="javascript:return isNumber (event)" onkeyup="calcFinalPrice()"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">StartDate </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="pstartDate" id="pstartDate" placeholder="DD-MM-YYYY"/>
		
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
          <input type="text" name="pendDate" id="pendDate" placeholder="DD-MM-YYYY"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-5" align="s">
     <label for="concept" class="col-md-2 control-label-left">New&nbsp;Price&nbsp;Details </label>
   
   </div>
   
                    
   </div>
   <!-- end row -->
   
		<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine Price </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="finalPrice" id="finalPrice" class="form-control"/>
           <span id="pricelocation" style="color:red"></span>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Discount </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="discount" id="discount" class="form-control" onkeypress="javascript:return isNumber (event)" onkeyup="calcFinalPrice()"/>
		<span id="discountlocation" style="color:red"></span>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Final Price </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="price" id="price" class="form-control" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">StartDate </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="startDate" id="startDate" placeholder="DD-MM-YYYY"/>
		<span id="startlocation" style="color:red"></span>
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
          <input type="text" name="endDate" id="endDate" placeholder="DD-MM-YYYY"/>
		<span id="endlocation" style="color:red"></span>
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
        <input type="hidden" name="lockId" id="lockId"/>
         <input type="hidden" name="lockPriceId" id="lockPriceId"/>
    <input type="submit" class="btn btn-control" id="btnPause" name="accountStatus" value="Edit" onclick="return(profile());"/>
    <input type="submit" class="btn btn-control" id="btnBlock" name="accountStatus" value="Delete" onclick="return(msg());" />
   </div>
   </div>
   </div>
   <!-- end row -->
   </form>
	
	<div id="divPreviousrice" style="display:none">
		<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Previous Price </label>
   
   </div>
   
                    
   </div>
   <!-- end row -->
		
	</div>
 	
 </div>
 
 
 
 <script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
<script type="text/javascript">
	function validate(formObj)
	{
		
		if(formObj.price.value=="")
		{
			valid=false;
			alert("please enter price");
			$('#price').focus()
			
			return false;
		}
		if(formObj.discount.value=="")
		{
			valid=false;
			alert("please enter discount");
			$('#discount').focus()
			
			return false;
		}
		if(formObj.newstartDate.value=="")
		{
			valid=false;
			alert("please startDate startDate");
			$('#startDate').focus()
			
			return false;
		}
		if(formObj.endDate.value=="")
		{
			valid=false;
			alert("please enter endDate");
			$('#endDate').focus()
			
			return false;
		}
		
		return true;
	}
</script>
<script>
    function calcFinalPrice()
    {
    	var disAmout=$("#finalPrice").val()*$("#discount").val()/100;
    	$("#price").val($("#finalPrice").val()-disAmout);
    }
    function isNumber(evt) {
        var iKeyCode = (evt.which) ? evt.which : evt.keyCode
        if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
            return false;
           
		
        return true;
    }    
</script>

<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
			$('#divInvalid').css("display", "none"); 
			var lockSno = $('#lockSno').val();
			if(lockSno=="")
			{
				alert("please enter machineSno");
				$('#lockSno').focus();
				return false;
			}
			
			
			$('#divMachinePrice').css("display", "none"); 
			$('#divPreviousrice').css("display", "none"); 
			var data = 'lockSno='+ encodeURIComponent(lockSno);
					
			$.ajax({
				url : "checklock.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
						$('#divMachinePrice').css("display", "block"); 
						$("#lockId").val(response.lockId);
						$("#lockPriceId").val(response.lockPriceId);
						$("#pfinalPrice").val(response.price);
						$("#pdiscount").val(response.discount);
						$("#pstartDate").val(response.fromDate);
						$("#pendDate").val(response.toDate);
						
						
				},
				error : function(xhr, status, error) {
					$('#divInvalid').css("display", "block"); 
					
				}
			});
			return false;
		});
	
	
	});
</script>