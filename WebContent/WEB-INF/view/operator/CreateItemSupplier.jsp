<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.form-control {
	width: 60%;
}
</style>
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
		<strong>Success!</strong> Your Item Quantity has been created
		successfully.
	</div>
</c:if>


<div class="alert alert-danger fade in" id="divNoItemBarCode" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> ItemBarCodeNo is not exists
</div>
<div class="alert alert-danger fade in" id="divNoUserId" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Supplier Id is not exists
</div>

<div id="divItemPrice">

	
		
		 <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
   Warehouse </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <select name="warehouseId" id="warehouseId" class="form-control wform-control">
	       	     	  <option value="">Select</option>
	       	     	  <c:forEach items="${requestScope.warehouses}" var="warehouse">
	       	     	  	 <option value="${warehouse.warehouseId}">${warehouse.warehouseSno}|
	       	     	  	 ${warehouse.address}|
	       	     	  	  ${warehouse.city}|
	       	     	  	   ${warehouse.country}
	       	     	  	 
	       	     	  	 
	       	     	  	 </option>
	       	     	  </c:forEach>
	      </select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Supplier Id</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="userId" id="userId" class="form-control" placeholder="Supplier Id" />
            <input type="hidden" name="userCheck" id="userCheck"> 
             <input type="hidden" name="userRoleId" id="userRoleId">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <div id="userDetails" style="display:none">
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Supplier Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="fullName" id="fullName" class="form-control" readonly="readonly" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   </div>
		<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
    <!--  <label for="concept" class="col-md-2 control-label-left ">
     Machine&nbsp;SerialNo </label> -->
     <label for="concept" class="btn btn-info btn-pressure btn-sensitive btn-scanner">
     BarcodeOn</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="itemBarcode" id="itemBarcode" class="form-control" placeholder="ItemBarcodeNo"/>
            <input type="hidden" name="itemCheck" id="itemCheck"> 
             <input type="hidden" name="itemId" id="itemId">
         </div>
                          
    </div>
     <div class="col-xs-5 col-md-6">
        <div class="form-group">
          
         </div>
                          
    </div>               
   </div>
   <!-- end row -->
  <div id="itemDetails" style="display:none">
  	 <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Item&nbsp;Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="itemName" id="itemName" class="form-control" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">
  Quantity</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="itemQuantity" name="itemQuantity" onkeypress="javascript:return isNumber (event)">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <div  id="divConItemBtn"  style="display:none">
   	 <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
      
<button type="button" class="btn btn-success btn-bold" id="addItem" >Place Item </button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   </div>

</div>


</div>
<form method="post">
<!-- row  -->
<div class="row">
        <div class="col-md-9">
   <div id="no-more-tables">
  
			<table
				class="col-md-9 table-bordered table-striped table-condensed cf">
				<thead class="cf">
					<tr>

						<th class="lbl-lableinfo" align="center">
							Item Barcode
						</th>
						<th class="lbl-lableinfo" align="center">
							Item Name
						</th>
						
						
						<th class="lbl-lableinfo">
							Quantity
						</th>
						<th class="lbl-lableinfo">
							warehouse
						</th>
						<th class="lbl-lableinfo">
							Supplier
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

<div id="divAddSupplier" style="display:none">
		<!-- row -->
   <div class="row" >
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
      
<button type="submit" class="btn btn-success btn-bold" id="btnQuantity" > Connect  Item to Supplier</button> 
                             
         </div>
                          
    </div>
                    
   </div>
  
   <!-- end row -->
</div>
</form>



<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>

<script>
   
  
  $('#itemBarcode').blur(function() {
   
   	$('#divNoItemBarCode').css("display", "none"); 
   	$('#itemDetails').css("display", "none"); 
   	$('#divConItemBtn').css("display", "none"); 	
  
	
			var valu=this.value+"";
				var data = 'itemBarcode='
					+ encodeURIComponent(valu);
					
			$.ajax({
				url : "checkitem.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
					
					
					if(response.msg!=null && response.msg=="fail")
					{
						$('#divNoItemBarCode').css("display", "block"); 
						$('#itemDetails').css("display", "none"); 	
						$("#itemCheck").val("fail");
							
					}
					else
					{
						
						$('#divNoItemBarCode').css("display", "none");
						$('#itemDetails').css("display", "block");
						$("#itemCheck").val("success"); 	
						$("#itemId").val(response.itemId);
						$("#itemQuantity").val("");
						$("#itemName").val(response.itemName);
						
						if($("#userCheck").val()=="success")
						{
							$('#divConItemBtn').css("display", "block");
						}
						
						
					}
					
				
				},
				error : function(xhr, status, error) {
				
					
						
				}
				
			});
			
			
		
	});
	
	  $('#userId').blur(function() {
	  
   	$('#divNoUserId').css("display", "none"); 
   	$('#userDetails').css("display", "none"); 	
   	$('#divConItemBtn').css("display", "none"); 	
	
			var valu=this.value+"";
				var data = 'userId='
					+ encodeURIComponent(valu);
					
			$.ajax({
				url : "checksupplier.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
					
					
					if(response.msg!=null && response.msg=="fail")
					{
						$('#divNoUserId').css("display", "block"); 
						$('#userDetails').css("display", "none"); 	
						$("#userCheck").val("fail");
							
					}
					else
					{
						
						$('#divNoUserId').css("display", "none");
						$('#userDetails').css("display", "block");
						$("#userCheck").val("success"); 	
						$("#userRoleId").val(response.userRoleId);
						$("#fullName").val(response.fullName);
						if($("#itemCheck").val()=="success")
						{
							$('#divConItemBtn').css("display", "block");
						}
						
					}
					
				
				},
				error : function(xhr, status, error) {
					
						
				}
				
			});
			
			
		
	});
	
	
	
				$('#addItem').click(
					function(event) {
					$('#divAddSupplier').css("display", "block"); 
					var warehouseId=$("#warehouseId").val();
					if(warehouseId=="")
					{
						alert("Please select warehouse");
						$("#warehouseId").focus();
						return false;
					}
					var itemQuantity=$("#itemQuantity").val();
					if(itemQuantity=="")
					{
						alert("Please enter itemQuantity");
						$("#itemQuantity").focus();
						return false;
					}
					var itemBarcode=$("#itemBarcode").val();
					var itemName=$("#itemName").val();
					var itemId=$("#itemId").val();
					
					
					var warehouseName=$('#warehouseId').find('option:selected').text();
					
					var userIdName=$("#userId").val()+","+$("#fullName").val();
						
				
					var tbodyRows=$("#tb > tr").length;
					var isNotExist=true;
					var tableRow;
				
					for(var index=0;index<tbodyRows;index++)
					{
						
						 tableRow=$("#tb").find('tr').eq(index);
						 
						var titemBarcode=tableRow.find('td').eq(0).text();
						var twarehouseName=tableRow.find('td').eq(3).text();
						var tuserIdName=tableRow.find('td').eq(4).text();
						
						
						if(itemBarcode==titemBarcode && twarehouseName==warehouseName && tuserIdName==userIdName)
						{
							
							itemQuantity=parseInt(itemQuantity)+parseInt(tableRow.find('td').eq(2).text());
							
							isNotExist=false;
							break;
							
						}
						
						
					}
					var appendTxt = "<td>"+itemBarcode+"</td><td>"+itemName+"</td><td>"+itemQuantity+"</td><td>"+warehouseName+"</td><td>"+userIdName+"</td><td><a  onclick='deleteRow(this)'>delete</a><input type='hidden' name='itemId' value='"+itemId+"'  id='itemId'/><input type='hidden' name='iquantity' id='iquantity' value='"+itemQuantity+"'/><input type='hidden' name='warehouseId' id='warehouseId' value='"+warehouseId+"'/><input type='hidden' name='supplierId' id='supplierId' value='"+$("#userRoleId").val()+"'/></td>";
					
					if(isNotExist)
					{
						$("#tb").append("<tr>"+appendTxt+"</tr>");	
					}
					else
					{
						
						 tableRow.html(appendTxt);
					}		
				});  
				
				function deleteRow(obj)
			{
				var trow=$(obj).parent().parent();
				
				
				
				
				
				trow.remove();
				var rows=$("#tb > tr").length;
				if(rows>0)
				{
				
					$('#divAddSupplier').css("display", "block"); 
				}
				else
				{
					
					$('#divAddSupplier').css("display", "none"); 
				}
				
				
			}
				
  
</script>


