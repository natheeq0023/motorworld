<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.form-control {
	width:60%;
	}
</style>
<br/>
<br/>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Machine Price has been created successfully.
</div>
</c:if>

<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;SNO </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="machineSno" name ="machineSno" class="form-control"/>
		
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
        
<button type="button" class="btn btn-success btn-bold" id="btnCheck">Check</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  <div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid MachineSno.
</div>
   
 <div id="divMachinePrice" style="display:none">
 	
 
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
           <input type="text" name="finalPrice" id="finalPrice" class="form-control" readonly="readonly"/>
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
          <input type="text" name="discount" id="discount" class="form-control" onkeypress="javascript:return isNumber (event)" onkeyup="calcFinalPrice()"/>
		
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
        <input type="text" name="machinePriceId" id="machinePriceId"/>
     <a href="editmachinepage.htm?machinePriceId="+machinePriceId>Edit Machine Price</a>
   </div>
   </div>
   <!-- end row -->
  
	
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
		if(formObj.startDate.value=="")
		{
			valid=false;
			alert("please enter startDate");
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
    	var disAmout=$("#price").val()*$("#discount").val()/100;
    	$("#finalPrice").val($("#price").val()-disAmout);
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
			var machineSno = $('#machineSno').val();
			if(machineSno=="")
			{
				alert("please enter machineSno");
				$('#machineSno').focus();
				return false;
			}
			
			
			$('#divMachinePrice').css("display", "none"); 
			$('#divPreviousrice').css("display", "none"); 
			var data = 'machineSno='+ encodeURIComponent(machineSno);
					
			$.ajax({
				url : "checkmachine.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
						$('#divMachinePrice').css("display", "block"); 
						$("#machineId").val(response.machineId);
						$("#machinePriceId").val(response.machinePriceId);
					    $("#finalPrice").val(response.price);
						$("#discount").val(response.discount);
						$("#startDate").val(response.fromDate);
						$("#endDate").val(response.toDate);
						
						
				},
				error : function(xhr, status, error) {
					$('#divInvalid').css("display", "block"); 
					
				}
			});
			return false;
		});
	
	
	});
</script>