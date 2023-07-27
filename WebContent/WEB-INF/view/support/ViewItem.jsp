<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong>  Account has been ${param.s } successfully.
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
</style>

 <div class="row">
                    
                   
                   
                    <div class="col-xs-5 col-md-6">
                       
                          
                          
                              <div class="form-group">
                                  <div class="">
                                      <input type="text" class="form-control" size="10"  id="itemBarcode"  name="itemBarcode" placeholder="itemBarcodeNo" required>
                                  </div>
                              </div>
                          
                       
                    </div>
                   
                    <div class="col-xs-2 col-md-2">
                        <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" id="btnCheck">Open</button> 
                    </div>
         </div>
 <div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid AccountId.
</div>

         

<div id="divCreate" style="display:none">
<form action="updateaccountstatus.htm" method="post" enctype="multipart/form-data" onsubmit="return validate(this);" enctype="multipart/form-data">
	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Item&nbsp;Barcode</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" class="ctextbox" name="itemBarcode" id="itemBarcodeNo"  size="15" readonly="readonly" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">ItemName</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="text" class="ctextbox" name="itemName" id="itemName" size="15" />
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
         <img id="imgfile" height="100" width="100"/> 
          <!--  <input type="text" class="ctextbox" name="itemPhotoName" id="itemPhotoName"   size="15"  /> -->
         </div>
                 
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <!-- <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">ItemPhotoName</label>
   </div>
       <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="text" class="ctextbox" name="itemPhotoName" id="itemPhotoName"   size="15"  />

         </div>
                          
    </div>
                    
   </div> -->
   <!-- end row -->
 <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">ItemGroup</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         
         <select class="ctextbox" name="itemGruop" id="itemGruop">
           <option value=""></option>
           <option value="SoftDrinks">SoftDrinks</option>
           <option value="Toys">Toys</option>
           <option value="chipse">chipse</option>
           <option value="Biscuit">Biscuit</option>
         </select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left" > itemSize</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="text" class="ctextbox" name="itemSize" id="itemSize"   size="15"  />

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left" > ItemIngredients</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <textarea  rows="4" cols="30" class="ctextbox" name="itemIngredients" id="itemIngredients"    ></textarea>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left" > Status</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="text" class="ctextbox" name="status" id="status"   size="25" readonly="readonly" />

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    
  

</form>
</div>

<script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		$('#divSuccess').css("display", "none"); 
		$('#divCreate').css("display", "none"); 
		$('#divInvalid').css("display", "none"); 
			var itemBarcode = $('#itemBarcode').val();
			
			if(itemBarcode=="")
			{
				alert("please enter itemBarcode ");
				$('#itemBarcode').focus()
				return false;
			}
			
			var data = 'itemBarcode='
					+ encodeURIComponent(itemBarcode);
					
			$.ajax({
				url : "checkitem.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
						$('#divCreate').css("display", "block"); 
						$("#itemBarcode").val(response.fullName);
						$("#itemName").val(response.itemName);
						$("#itemSize").val(response.itemSize);
						$("#itemGruop").val(response.itemGruop);
						$("#itemIngredients").val(response.itemIngredients);
						$("#itemPhotoName").val(response.itemPhotoName);
						$("#itemBarcodeNo").val(response.itemBarcode);
						$("#itemId").val(response.itemId);
						$("#status").val(response.status);
						 $("#imgfile").attr('src', '../uploads/item/'+response.itemId+'/'+response.itemPhotoName);
				
				},
				error : function(xhr, status, error) {
					$('#divInvalid').css("display", "block"); 
				}
			});
			return false;
		});
	
	

			
	
	});
</script>

           