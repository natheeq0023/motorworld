 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
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

.table-bordered {
	border: 1px solid #28137B;
}

.table-bordered>tfoot>tr>td {
	border: 1px solid #ddd;
}

tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}

.table-striped>tbody>tr:nth-child(odd)>td,.table-striped>tbody>tr:nth-child(odd)>th
	{
	background-color: #CFDEEA;
}

.table-striped>tbody>tr:nth-child(even)>td,.table-striped>tbody>tr:nth-child(even)>th
	{
	background-color: rgb(232, 241, 249);;
}

.table-bordered>tbody>tr>td,.table-bordered>tbody>tr>th,.table-bordered>tfoot>tr>td,.table-bordered>tfoot>tr>th,.table-bordered>thead>tr>td,.table-bordered>thead>tr>th
	{
	border: 2px solid #FFF;
}
</style> 
<div class="alert alert-danger fade in" id="divNoSales" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> no data 
</div>
<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="lockModel" name="lockModel" class="form-control">
           	<option value="All">All Model of Lock</option>
           		<option value="1">1</option>
           		<option value="2">2</option>
           </select>
				
			
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
           <select  id="userRoleId" name="userRoleId" class="form-control">
           	<option value="All">All Agency</option>
           	
           
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
   <!-- row  -->
<div class="row">
        <div class="col-md-9">
   <div id="divLockSalesHostory" style="display:none">
  
			<table
				class="col-md-9 table-bordered table-striped table-condensed cf">
				<thead class="cf">
					<tr>
						<th class="lbl-lableinfo" align="center">
							SNO
						</th>
						
						<th class="lbl-lableinfo" align="center">
							Type
						</th>
						<th class="lbl-lableinfo" align="center">
							Model
						</th >
						<th class="lbl-lableinfo" align="center">
							No of Locks
						</th>
						
					</tr>
				</thead>
				<tbody id="tb">


				</tbody>
			</table>
			
		</div>
		</div>
	
</div>
<!-- end row  -->
<script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>
<script type="text/javascript" src="../js/allcountrycity.js">
</script>



<script language="javascript">print_country("country");</script>

<script>
	$(document).ready(function() {
	
$('#country').change(
		function(event) {
		
		 	
		
		
			var country = $('#country').val();
			
			
			var city = "All";
			var data = 'country='
					+ encodeURIComponent(country)+'&city='+ encodeURIComponent(city);
				
			$.ajax({
				url : "checkagencydetails.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
						$("#userRoleId").empty().append('<option value="All">All Agency</option>');
												
											$.each(response, function(i, user) {
											
											
											var userRoleId=user.userRoleId;
											var userId=user.userId;
											
											var fullName=user.fullName;
											if(fullName==null)
											{
												fullName="";
											}
											
											
											var options="<option value='"+userRoleId+"'>"+userId+"|"+fullName+"</option>";
					  						
					  						$("#userRoleId").append(options);
					  						
					  						
					
											});
						
				},
				error : function(xhr, status, error) {
				
					$("#userRoleId").empty().append('<option value="All">All Agency</option>');
					
				}
			});
			return false;
		});			
			
			$('#city').change(
		function(event) {
		
		 	
		
		
			var country = $('#country').val();
			
			
			var city = $('#city').val();
			var data = 'country='
					+ encodeURIComponent(country)+'&city='+ encodeURIComponent(city);
				
			$.ajax({
				url : "checkagencydetails.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
						$("#userRoleId").empty().append('<option value="All">All Agency</option>');
												
											$.each(response, function(i, user) {
											
											
											var userRoleId=user.userRoleId;
											var userId=user.userId;
											
											var fullName=user.fullName;
											
											
											
											var options="<option value='"+userRoleId+"'>"+userId+"|"+fullName+"</option>";
					  						
					  						$("#userRoleId").append(options);
					  						
					  						
					
											});
						
				},
				error : function(xhr, status, error) {
				
				
					$("#userRoleId").empty().append('<option value="All">All Agency</option>');
					
				}
			});
			return false;
		});		
			
	
	$('#btnShow').click(
	
		function(event) {
		
		$('#divNoSales').css("display", "none"); 
		$('#divLockSalesHostory').css("display", "none"); 
			var country = $('#country').val();
			var city = $('#city').val();
			var lockModel=$('#lockModel').val();
			var userRoleId=$('#userRoleId').val();
			
			
			var data = 'country='
					+ encodeURIComponent(country)+'&userRoleId='+encodeURIComponent(userRoleId)+'&city='+ encodeURIComponent(city)+'&model='+encodeURIComponent(lockModel)+'&orderFor=lock';
					
			$.ajax({
				
				url : "checksaleshostory.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 				
				success : function(response) {
						
						$('#divLockSalesHostory').css("display", "block"); 
						$("#tb").empty();
						
						$.each(response, function(i, sale) {
						
									var type=sale.type;
									var model=sale.model;
									var quantity=sale.quantity;	
									$("#tb").append("<tr><td>"+(i+1)+"</td><td>"+type+"</td><td>"+model+"</td><td>"+quantity+"</td></tr>");		
					
											});
						
				
				},
				error : function(xhr, status, error) {
				
				$('#divLockSalesHostory').css("display", "none"); 
				$('#divNoSales').css("display", "block"); 
				
					
				}
			});
			return false;
		});
	
	
	});
</script>
