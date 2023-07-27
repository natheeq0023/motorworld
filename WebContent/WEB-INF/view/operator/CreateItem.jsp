<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.form-control {
	width:60%;
	}
	
	
	.btnlable
	{
		padding: 6px 2px;
	}
	.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
</style>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Item has been created successfully.
</div>
</c:if>
<div class="alert alert-danger fade in" id="divNoItemBarCode" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> ItemBarCodeNo is alreadyexists
</div>
<form:form commandName="createitem" method="post" enctype="multipart/form-data" onsubmit="return validate(this);">
	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
    <!--  <label for="concept" class="col-md-2 control-label-left ">
     Machine&nbsp;SerialNo </label> -->
     <label for="concept" class="btn btn-info btn-pressure btn-sensitive btn-scanner">
     BarcodeOn</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="itemBarcode" id="itemBarcode" class="form-control" placeholder="ItemBarcodeNo"/>
           
         </div>
                          
    </div>
     <div class="col-xs-5 col-md-6">
        <div class="form-group">
          
         </div>
                          
    </div>               
   </div>
   <!-- end row -->
  
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Item&nbsp;Photo </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="file" name="itemPhoto" id="itemPhoto" class="form-control"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Item&nbsp;Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="itemName" id="itemName" class="form-control" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
 
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Item&nbsp;Group </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select name="itemGruop" id="itemGruop" class="form-control">
	       	     	  <option value="">Select</option>
	       	     	  <option value="SoftDrinks">SoftDrinks</option>
	       	     	  <option value="Toys">Toys</option>
	       	     	  <option value="biscuit">biscuit</option>
	       	     	</select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
  
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Item&nbsp;Size</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="itemSize" id="itemSize" class="form-control"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
 
     <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Item&nbsp;Ingredients</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
        <!--    <input type="text" name="itemSize" id="itemSize" class="form-control"/> -->
           <textarea rows="4" cols="30" name="itemIngredients" id="itemIngredients"></textarea>
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
   <input type="hidden" name="itemCheck" id="itemCheck">     
<input type="submit"  class="btn btn-success btn-bold" value="Add Item"/>
           
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
</form:form>
 <script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>
 <script type="text/javascript">
	function validate(formObj)
	{
		
		if(formObj.itemBarcode.value=="")
		{
			valid=false;
			alert("please enter itemBarcode");
			$('#itemBarcode').focus()
			
			return false;
		}
		else if(formObj.itemCheck.value=="" || formObj.itemCheck.value!="fail")
		{
			alert(" itemBarcode already exists");
			$("#itemBarcode").focus();
			return false;
		}
		if(formObj.itemPhoto.value=="")
		{
			valid=false;
			alert("please select itemPhoto");
			$('#itemPhoto').focus()
			
			return false;
		}
		if(formObj.itemName.value=="")
		{
			valid=false;
			alert("please enter itemName");
			$('#itemName').focus()
			
			return false;
		}
		if(formObj.itemGruop.value=="")
		{
			valid=false;
			alert("please enter itemGruop");
			$('#itemGruop').focus()
			
			return false;
		}
		if(formObj.itemSize.value=="")
		{
			valid=false;
			alert("please enter itemSize");
			$('#itemSize').focus()
			
			return false;
		}
		if(formObj.itemIngredients.value=="")
		{
			valid=false;
			alert("please enter itemIngredients");
			$('#itemIngredients').focus()
			
			return false;
		}
		
		return true;
	}
	
	$('#itemBarcode').blur(function() {
   	$('#divNoItemBarCode').css("display", "none"); 	
   
	
			var valu=this.value+"";
				var data = 'itemBarcode='
					+ encodeURIComponent(valu);
					
			$.ajax({
				url : "checkitem.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
					
					
					if(response.msg=="fail")
					{
						$('#divNoItemBarCode').css("display", "none"); 
						$("#itemCheck").val("fail");
							
					}
					else
					{
						
						$('#divNoItemBarCode').css("display", "block");
						$("#itemCheck").val("success"); 	
					}
					
				
				},
				error : function(xhr, status, error) {
					
						
				}
				
			});
			
			
		
	});
</script>

       	
       	    
       	    
       	    
       	   