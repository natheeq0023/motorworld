 <style>

.form-control {
	width:80%;
	background-color: #5B9BD5;
	color:#FFF;
	}
	.ctextbox
{
	background-color:#E48B0D;
	color: #fff;
}
.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
</style> 
<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="itemBarcode" id="itemBarcode" placeholder="Item Barcode" class="form-control">
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->



	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select onchange="print_city('city',this.selectedIndex);" id="country" name="country" class="form-control"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="city" name="city" class="form-control">
           	<option value="All">All City</option>
           </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="operator" name="operator" class="form-control">
           	<option value="All">All Operator</option>
           </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="supplier" name="supplier" class="form-control">
           	<option value="All">All Supplier</option>
           </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="machine" name="machine" class="form-control">
           	<option value="All">All Machine</option>
           </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    
  
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
        
<button type="button" class="btn btn-success btn-bold" id="btnShow">Show</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
<script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>
<script type="text/javascript" src="../js/allcountrycity.js">
</script>



<script language="javascript">print_country("country");</script>