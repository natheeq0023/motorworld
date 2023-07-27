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
           <select  id="lockModel" name="lockModel" class="form-control">
           	<option value="All">All Model of Locks</option>
           	 <option value="1">L123</option>
	       	     	  <option value="2">L4568</option>
	       	     	  <option value="3">L7894</option>
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
<div id="divLockCount" style="display:none">
	
   
   <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-4" >
     <div class="form-group">
      <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Number Of Locks</button> 
  
     </div>
     </div>
   
   <div class="col-xs-4 col-md-3">
        <div class="form-group">
          <input type="text" size="5" id="lockCount" class="ctextbox"/>
		
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
          <input type="text" size="5" id="totalCost" class="ctextbox"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-4" >
     <div class="form-group" >
      <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" > Agencie's Locks</button> 
  
     </div>
     </div>
   
   <div class="col-xs-4 col-md-3">
        <div class="form-group" >
         <input type="text" size="5" id="agencyLockCount" class="ctextbox"/>
		
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
			var lockModel=$('#lockModel').val();
			
			$('#divLockCount').css("display", "none"); 
			var data = 'country='
					+ encodeURIComponent(country)+'&city='+ encodeURIComponent(city)+'&lockModel='+encodeURIComponent(lockModel);
					
			$.ajax({
				url : "checklockplaceinfo.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
						
						$('#divLockCount').css("display", "block"); 
						$("#lockCount").val(response.lockCount);
						$("#totalCost").val(response.totalCost);
						$("#agencyLockCount").val(response.agencyLockCount);
						
						
				
				},
				error : function(xhr, status, error) {
				
					
				}
			});
			return false;
		});
	
	
	});
</script>

	

	
