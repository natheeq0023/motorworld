<style>
	.form-control {
	width:80%;
	}
	.ctextbox
{
	background-color:#C1C1C1;
}
.btn-textbox {
    color:#1F1E1E;
    background-color: #C1C1C1;
    border-color: #C1C1C1;
}
</style>

<div>
	<!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Country </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select onchange="print_city('city',this.selectedIndex);" id="country" name="country" class="form-control"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">City </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="city" name="city" class="form-control">
           	<option value="All">All</option>
           </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Account&nbsp;Kind </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="accountKind" name ="accountKind" class="form-control"></select>
		
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
<div id="divBalance" style="display:none">
	<!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" size="20" id="totalCost"/>  <input type="button" class="btn btn-bold btn-textbox" id="btnCurrency"  />
		
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
			$('#divBalance').css("display", "none"); 
			var country = $('#country').val();
			var city = $('#city').val();
			var accountKind=$('#accountKind').val();
			
			
			var data = 'country='
					+ encodeURIComponent(country)+'&city='+ encodeURIComponent(city)+'&accountKind='+ encodeURIComponent(accountKind);
					
			$.ajax({
				url : "checkcompanybalance.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					
					
						
						$('#divBalance').css("display", "block"); 
						
						$('#totalCost').val(response.totalCost);
						$('#btnCurrency').val(response.currency);
						
						
						
						
					
				
				},
				error : function(xhr, status, error) {
				
					
				}
			});
			return false;
		});
	
	
	});
</script>

	

	
