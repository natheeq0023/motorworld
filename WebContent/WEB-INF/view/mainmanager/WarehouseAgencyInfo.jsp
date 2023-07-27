 
<style>

.form-control {
	width:80%;
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
<div class="alert alert-danger fade in" id="divNoAgency" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Agencyid inavlid
</div> 
<div>
	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Id of Agency </button>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" id="agencyId" name="agencyId" class="form-control"/>
		
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
          <input type="text" size="5" class="ctextbox" id="warehouseCount"/>
		
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
        <input type="text" size="5" class="ctextbox" id="machineCount"/>
		
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
         <input type="text" size="5" class="ctextbox" id="totalCost"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   
	
</div>

<script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>

<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		
			$('#divNoAgency').css("display", "none");
			var agencyId = $('#agencyId').val();
			if(agencyId=="")
			{
				alert("Please enter the Agency Id");
				return false;
			}
			
			$('#divWarehouseCount').css("display", "none"); 
			var data = 'agencyId='
					+ encodeURIComponent(agencyId);
					
			$.ajax({
				url : "checkwarehouseagencyinfo.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
						
						$('#divWarehouseCount').css("display", "block"); 
						$("#warehouseCount").val(response.agencyWarehouseCount);
						$("#lockCount").val(response.lockCount);
						$("#machineCount").val(response.machineCount);
						$("#totalCost").val(response.totalCost);
						
						
						
				
				},
				error : function(xhr, status, error) {
					$('#divNoAgency').css("display", "block");
					
				}
			});
			return false;
		});
	
	
	});
</script>

	

	
