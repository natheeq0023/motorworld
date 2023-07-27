<style>

.form-control {
	width:80%;
	background-color: #5B9BD5;
	color:#FFF;
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
</style> 

<div>
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
        
<button type="button" class="btn btn-success btn-bold" id="btnCheck">Check</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</div>
<div id="divWarehouseCount" style="display:none">
	<!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-4" >
     <div class="form-group">
     <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Number Of Warehouses</button> 
  
     </div>
     </div>
   
   <div class="col-xs-4 col-md-3">
        <div class="form-group">
          <input type="text" class="ctextbox" size="5" id="warehouseCount"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-4" >
     <div class="form-group">
      <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Number Of Machines</button> 
   
     </div>
     </div>
   
   <div class="col-xs-4 col-md-3">
        <div class="form-group">
        <input type="text" class="ctextbox" size="5" id="machineCount"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-4" >
     <div class="form-group">
     <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Number Of Locks</button> 
   
     </div>
     </div>
   
   <div class="col-xs-4 col-md-3">
        <div class="form-group">
         <input type="text" size="5" class="ctextbox" id="lockCount"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-4" >
     <div class="form-group">
     <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Total Cost of money</button> 
  
     </div>
     </div>
   
   <div class="col-xs-4 col-md-3">
        <div class="form-group">
          <input type="text" class="ctextbox" size="5" id="totalCost"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-4" >
     <div class="form-group">
     <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" > Agencie's Warehouses</button> 
   
     </div>
     </div>
   
   <div class="col-xs-4 col-md-3">
        <div class="form-group">
         <input type="text" class="ctextbox" size="5" id="agencyWarehouseCount"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
	
</div>

<script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>
<script type="text/javascript" src="../js/allcountrycity.js">
</script>



<script language="javascript">print_country("country");</script>

<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		
			var country = $('#country').val();
			var city = $('#city').val();
			
			
			$('#divWarehouseCount').css("display", "none"); 
			var data = 'country='
					+ encodeURIComponent(country)+'&city='+ encodeURIComponent(city);
					
			$.ajax({
				url : "checkwarehouseplaceinfo.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
						
						$('#divWarehouseCount').css("display", "block"); 
						$("#warehouseCount").val(response.warehouseCount);
						$("#lockCount").val(response.lockCount);
						$("#machineCount").val(response.machineCount);
						$("#totalCost").val(response.totalCost);
						$("#agencyWarehouseCount").val(response.agencyWarehouseCount);
						
						
				
				},
				error : function(xhr, status, error) {
				
					
				}
			});
			return false;
		});
	
	
	});
</script>

	

	
