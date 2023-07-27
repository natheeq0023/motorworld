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
 <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="accountKind" name ="accountKind" class="form-control"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  

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
  
   <div class="col-xs-5 col-md-6" >
        <div class="form-group">
        
<button type="button" class="btn btn-success btn-bold" id="btnCheck">Check</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</div>
<div id="divAccountCount" style="display:none">
	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-4 col-md-3" >
     <div class="form-group">
         <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Number Of Accounts</button> 
  
		
         </div>
   
   </div>
   <div class="col-xs-5 col-md-4">
        <div class="form-group">
        <input type="text" size="5" class="ctextbox" id="txtCount"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
	
</div>

<script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>
<script type="text/javascript" src="../js/allcountrycity.js">
</script>
<script type="text/javascript" src="../js/allaccountkindname.js">

</script>



<script language="javascript">print_country("country");</script>
<script language="javascript">print_accountKind("accountKind");</script>
<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		
			var country = $('#country').val();
			var city = $('#city').val();
			var accountKind=$('#accountKind').val();
			
			$('#divAccountCount').css("display", "none"); 
			var data = 'country='
					+ encodeURIComponent(country)+'&city='+ encodeURIComponent(city)+'&accountKind='+ encodeURIComponent(accountKind);
					
			$.ajax({
				url : "checkaccountinfo.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					
					
						$("#txtCount").val(response.count);
						$('#divAccountCount').css("display", "block"); 
						
						
						
						
						
						
					
				
				},
				error : function(xhr, status, error) {
				
					alert("hi"+error);
				}
			});
			return false;
		});
	
	
	});
</script>

	

	
