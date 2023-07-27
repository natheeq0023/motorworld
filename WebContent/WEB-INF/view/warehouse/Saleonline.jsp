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
	
 
   
   <!-- end row -->
  
 
	
   
   <!-- row  -->
  
  
   <!-- row  -->
   
   <!-- end row -->
    <div class="row">
   <div class="col-xs-5 col-md-4" >
     <div class="form-group">
      <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Sale Online</button> 
   
     </div>
     </div>
  
                    
   </div>
   <!-- row  -->
   <div class="row">
        <div class="col-md-9">
   <div id="no-more-tables">
            <table class="col-md-9 table-bordered table-striped table-condensed cf">
        		<thead class="cf">
        			<tr>
        				<th class="lbl-lableinfo" align="center">&nbsp;&nbsp;&nbsp;NO.</th>
        				<th class="lbl-lableinfo" > Sno</th>
        				<th class="lbl-lableinfo" >Invoice No</th>
        				<th class="lbl-lableinfo" >Date </th>
        				<th class="lbl-lableinfo" >Agency Name</th>
        				<th class="lbl-lableinfo" >Machine Quantitiy</th>
        				<th class="lbl-lableinfo" >Lock Quantity</th>
        				<th class="lbl-lableinfo" >Select</th>
        				
        			</tr>
        		</thead>
        		<tbody>
        		
        			
        			<tr>
        				<td>
        					
        				</td>
        				
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					 
        				</td>
        				<td>
        					 <input type="checkbox">
        				</td>
        			</tr>
        			<tr>
        				<td>
        					
        				</td>
        				
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					 
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					 <input type="checkbox">
        				</td>
        			</tr>
        			<tr>
        				<td>
        					
        				</td>
        				
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					 
        				</td>
        				<td>
        					 
        				</td>
        				<td>
        					 <input type="checkbox">
        				</td>
        			</tr>
        			<tr>
        				<td>
        					
        				</td>
        				
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					 
        				</td>
        				<td>
        					
        				</td>
        				<td>
        					 <input type="checkbox">
        				</td>
        			</tr>
        			
        			
        		
        		
        			
        		</tbody>
        	</table>
        </div>
        </div>
        </div>
        <!-- end row  -->
        <!-- row  -->
   
     <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-4" >
     <div class="form-group">
      <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >More Details</button> 
   
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
			var machineModel=$('#machineModel').val();
			
			$('#divMachineCount').css("display", "none"); 
			var data = 'country='
					+ encodeURIComponent(country)+'&city='+ encodeURIComponent(city)+'&machineModel='+encodeURIComponent(machineModel);
					
			$.ajax({
				url : "checkmachineplaceinfo.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
						
						$('#divMachineCount').css("display", "block"); 
						
						$("#machineCount").val(response.machineCount);
						$("#totalCost").val(response.totalCost);
						$("#agencyMachineCount").val(response.agencyMachineCount);
						
						
				
				},
				error : function(xhr, status, error) {
				
					
				}
			});
			return false;
		});
	
	
	});
</script>

	

	
