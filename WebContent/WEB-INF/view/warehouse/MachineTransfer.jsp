
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.form-control {
	width: 60%;
}
.wform-control {
	width: 100%;
}

.ctextbox {
	background-color: #C1C1C1;
}

.btn-lableinfo {
	color: #fff;
	background-color: #5B9BD5;
	border-color: #5B9BD5;
}

.lbl-lableinfo {
	color: #fff;
	background-color: #5B9BD5;
	border-color: #5B9BD5;
}

.btn-titlelableinfo {
	color: #292424;
	background-color: #F0AD4E;
	border-color: #F0AD4E;
	padding: 6px 35px;
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

<br />
<br />

<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your MachineTransfer has been transfered successfully.
</div>
</c:if>

<div class="alert alert-danger fade in" id="divNoMachines" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Machines not available
</div>
<div class="alert alert-danger fade in" id="divNoAgency" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Agencyid inavlid
</div>
<!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
     Kind&nbsp;of&nbsp;Machine</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <select name="machineKind" id="machineKind" class="form-control">
	       	     	  <option value="">Select</option>
	       	     	  <option value="School Machine">School Machine</option>
	       	     	  <option value="Masjid Machine">Masjid Machine</option>
	       	     	  <option value="Normal Machine">Normal Machine</option>
	      </select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;Model </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select name="machineModel" id="machineModel" class="form-control">
	       	     	  <option value="">Select</option>
	       	     	  <option value="1">M123</option>
	       	     	  <option value="2">M4568</option>
	       	     	  <option value="3">M7894</option>
	       	     	</select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <div id="divMPrice" style="display:none">
   <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
    Price</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="machineprice" name="machineprice" readonly="readonly">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
   Discount</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="machinediscount" name="machinediscount" readonly="readonly">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   
   <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
  Final Price</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="txtmachineFinalPrice" name="txtmachineFinalPrice" readonly="readonly">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  
   <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
  AgencyId</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="agencyId" name="agencyId" >
         </div>
                          
    </div>
                    
   </div>
   <!-- end row --> 
<!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
  No of Machines</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="machineQuantity" name="machineQuantity" onkeypress="javascript:return isNumber (event)">
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
      
<button type="button" class="btn btn-success btn-bold" id="addMachineOrder" >Place Machine Order</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</div>
<br/>
 <form action="" method="post" onsubmit="return validate(this);">
<!-- row  -->
<div class="row">
        <div class="col-md-9">
   <div id="no-more-tables">
  
			<table
				class="col-md-9 table-bordered table-striped table-condensed cf">
				<thead class="cf">
					<tr>

						<th class="lbl-lableinfo" align="center">
							Type
						</th>
						<th class="lbl-lableinfo" align="center">
							Model
						</th>
						<th class="lbl-lableinfo">
							 Price
						</th>
						<th class="lbl-lableinfo">
							Discount
						</th>
						<th class="lbl-lableinfo">
							Final Price
						</th>
						<th class="lbl-lableinfo">
							Quantity
						</th>
						<th class="lbl-lableinfo">
							Total Cost
						</th>
						<th class="lbl-lableinfo">
							
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

 

   
   <div id="divOrder" style="display:none">
   <!-- row  -->
 
   <div class="row" >
   
   <div class="col-xs-5 col-md-2" align="right">
    Total Cost
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
      
<input type="text" class="btn  btn-bold" id="txtTotalCost" value="0"  readonly="readonly"> 
                             
         </div>
                          
    </div>
                    
   </div>
   
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
    Delivery Address</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <select name="warehouseId" id="warehouseId" class="form-control wform-control">
	       	     	  <option value="">Select</option>
	       	     	  
	       	     	  
	      </select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row -->
   <div class="row" >
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
 
 	<input type="hidden" id="userRoleId" name="userRoleId">     
<button type="submit" class="btn btn-success btn-bold" id="btnOrder" > Transfer</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   </div>
   <!-- end row -->
   
  
</form>
<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>


<script type="text/javascript">
			$(document).ready(function(){
			
			
	$('#machineModel').change(
		function(event) {
		$('#divMPrice').css("display", "none"); 
		 	
		$('#divNoMachines').css("display", "none"); 
		
			var machineKind = $('#machineKind').val();
			var machineModel = $('#machineModel').val();
			if(machineKind=="")
			{
				alert("please select machineKind");
				$('#machineKind').focus()
				return false;
			}
			
			if(machineModel=="")
			{
				alert("please select machineModel");
				$('#machineModel').focus()
				return false;
			}
			
			
			var data = 'machineKind='
					+ encodeURIComponent(machineKind)+'&machineModel='+ encodeURIComponent(machineModel);
					
			$.ajax({
				url : "checkmachineprice.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
						$('#divMPrice').css("display", "block"); 
						$("#machineprice").val(response.price);
						$("#machinediscount").val(response.discount);
						var disAmout=response.price*response.discount/100;
						$("#txtmachineFinalPrice").val(response.price-disAmout);
						$("#machineQuantity").val("");
						
				},
				error : function(xhr, status, error) {
					$('#divNoMachines').css("display", "block"); 
				}
			});
			return false;
		});		
				
				
			
				$('#addMachineOrder').click(
				function(event) {
				
					if($("#agencyId").val()=="")
					{
						alert("please select agencyId");
						$('#agencyId').focus()
						return false;
					}
					var is=false;
					var data = 'agencyId='
					+ encodeURIComponent($("#agencyId").val());
					if(!document.getElementById("agencyId").readOnly)
					{
					
								$.ajax({
									url : "checkagencywarehouse.htm",
									data : data,
									contentType: 'application/json',
					   				mimeType: 'application/json',
									
									type : "GET",
					 
									success : function(response) {
											
											
											$("#warehouseId").empty().append('<option value="">---Select Delivery address---</option>');
												$("#userRoleId").val(response.agency.userRoleId);
											$.each(response.warehouses, function(i, warehouse) {
											var warehouseId=warehouse.warehouseId;
											var warehouseSno=warehouse.warehouseSno;
											var address=warehouse.address;
											var city=warehouse.city;
											var country=warehouse.country;
											
											var options="<option value='"+warehouseId+"'>"+warehouseSno+"|"+address+" "+city+" "+country+" </option>";
					  						$("#warehouseId").append(options);
					  						
					  						$("#agencyId").attr('readonly', true);
					
											});
											$('#divOrder').css("display", "block"); 
						var kind=$("#machineKind").val();
						var model=$("#machineModel").val();
						var price=$("#machineprice").val();
						
						var discount=$("#machinediscount").val();
						var disAmout=price*discount/100;
						var finalPrice=price-disAmout;
						var quantity=$("#machineQuantity").val();
						if(quantity=="" || quantity<0)
						{
							alert("please enter machineQuantity");
							$('#machineQuantity').focus()
							return false;
						}
						var totalPrice=finalPrice*quantity;
						var tcost=parseFloat($("#txtTotalCost").val())+parseFloat(totalPrice);
					$("#txtTotalCost").val(tcost);
					
						var tbodyRows=$("#tb > tr").length;
						var isNotExist=true;
						var tableRow;
					
						for(var index=0;index<tbodyRows;index++)
						{
							
							 tableRow=$("#tb").find('tr').eq(index);
							 
							var tkind=tableRow.find('td').eq(0).text();
							
							var tmodel=tableRow.find('td').eq(1).text();
							if(kind==tkind && model==tmodel)
							{
								
								quantity=parseInt(quantity)+parseInt(tableRow.find('td').eq(5).text());
								totalPrice=parseFloat(totalPrice)+parseFloat(tableRow.find('td').eq(6).text());
								isNotExist=false;
								break;
								
							}
							
							
						}
						var appendTxt = "<td>"+kind+"</td><td>"+model+"</td><td>"+price+"</td><td>"+discount+"</td><td>"+finalPrice+"</td><td>"+quantity+"</td><td>"+totalPrice+"</td> <td><a  onclick='deleteRow(this)'>delete</a><input type='hidden' name='orderFor' value='machine'/><input type='hidden' name='type' value='"+kind+"'  id='type'/><input type='hidden' name='model' value='"+model+"' id='model'/> <input type='hidden' name='quantity' id='quantity' value='"+quantity+"'/></td>";
						
						if(isNotExist)
						{
							$("#tb").append("<tr>"+appendTxt+"</tr>");	
						}
						else
						{
							
							 tableRow.html(appendTxt);
						}		
											
											
									},
									error : function(xhr, status, error) {
										
										$('#divNoAgency').css("display", "block");
										return  false; 
									}
								});
					}
					else
					{
							$('#divOrder').css("display", "block"); 
						var kind=$("#machineKind").val();
						var model=$("#machineModel").val();
						var price=$("#machineprice").val();
						
						var discount=$("#machinediscount").val();
						var disAmout=price*discount/100;
						var finalPrice=price-disAmout;
						var quantity=$("#machineQuantity").val();
						if(quantity=="" || quantity<0)
						{
							alert("please enter machineQuantity");
							$('#machineQuantity').focus()
							return false;
						}
						var totalPrice=finalPrice*quantity;
						var tcost=parseFloat($("#txtTotalCost").val())+parseFloat(totalPrice);
					$("#txtTotalCost").val(tcost);
					
						var tbodyRows=$("#tb > tr").length;
						var isNotExist=true;
						var tableRow;
					
						for(var index=0;index<tbodyRows;index++)
						{
							
							 tableRow=$("#tb").find('tr').eq(index);
							 
							var tkind=tableRow.find('td').eq(0).text();
							
							var tmodel=tableRow.find('td').eq(1).text();
							if(kind==tkind && model==tmodel)
							{
								
								quantity=parseInt(quantity)+parseInt(tableRow.find('td').eq(5).text());
								totalPrice=parseFloat(totalPrice)+parseFloat(tableRow.find('td').eq(6).text());
								isNotExist=false;
								break;
								
							}
							
							
						}
						var appendTxt = "<td>"+kind+"</td><td>"+model+"</td><td>"+price+"</td><td>"+discount+"</td><td>"+finalPrice+"</td><td>"+quantity+"</td><td>"+totalPrice+"</td> <td><a  onclick='deleteRow(this)'>delete</a><input type='hidden' name='orderFor' value='machine'/><input type='hidden' name='type' value='"+kind+"'  id='type'/><input type='hidden' name='model' value='"+model+"' id='model'/> <input type='hidden' name='quantity' id='quantity' value='"+quantity+"'/></td>";
						
						if(isNotExist)
						{
							$("#tb").append("<tr>"+appendTxt+"</tr>");	
						}
						else
						{
							
							 tableRow.html(appendTxt);
						}		
					}
			
			
					
						
					
					
					
				});	  
				
				     
			});
			function deleteRow(obj)
			{
				var trow=$(obj).parent().parent();
				
				var amount=trow.find('td').eq(6).text();
				
				var tcost=parseFloat($("#txtTotalCost").val())-parseFloat(amount);
				$("#txtTotalCost").val(tcost);
				
				
				
				trow.remove();
				var rows=$("#tb > tr").length;
				if(rows>0)
				{
				
					$('#divOrder').css("display", "block"); 
				}
				else
				{
					
					$('#divOrder').css("display", "none"); 
					$("#agencyId").attr('readonly', false);
					$("#agencyId").val("");
					$("#machineQuantity").val("");
				}
				
				
			}
			
			 function isNumber(evt) {
        var iKeyCode = (evt.which) ? evt.which : evt.keyCode
        if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
            return false;
           
		
        return true;
    }    
    
    function validate(formObj)
    {
    		if($('#warehouseId').val()=="")
			{
				alert("please select Delivery Address");
				$('#warehouseId').focus()
				return false;
			}
    	return true;
    	
    } 
		</script>