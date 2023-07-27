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

<div>
	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Id of Agency </button>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" id="agencyId" name="agencyId" class="form-control" />
		
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
<div id="divLockCount" style="display:none">
	<!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-3" >
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
   
  
   
   
	
</div>

<script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>

<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		
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
				url : "checklockagencyinfo.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
						
						$('#divLockCount').css("display", "block"); 
						$("#lockCount").val(response.lockCount);
						
						
						
						
				
				},
				error : function(xhr, status, error) {
				
					
				}
			});
			return false;
		});
	
	
	});
</script>

	

	
