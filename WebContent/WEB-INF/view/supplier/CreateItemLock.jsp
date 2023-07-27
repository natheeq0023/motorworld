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
		<strong>Success!</strong> Your Item Lock has been created
		successfully.
	</div>
</c:if>


<div class="alert alert-danger fade in" id="divNoItemBarCode" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> ItemBarCodeNo is not exists
</div>
<div class="alert alert-danger fade in" id="divNoLockId" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Lock SNO is not exists
</div>

<div id="divItemLock">

	
		
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Lock SNO</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="lockSno" id="lockSno" class="form-control" placeholder="Lock SNO" />
            <input type="hidden" name="lockCheck" id="lockCheck"> 
             <input type="hidden" name="lockId" id="lockId">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <div id="lockDetails" style="display:none">
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Lock Kind</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="lockKind" id="lockKind" class="form-control" readonly="readonly" />
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
							Lock Type
						</th>
						<th class="lbl-lableinfo">
							Lock SNO
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

<div id="divAddLock" style="display:none">
		<!-- row -->
   <div class="row" >
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
      
<button type="submit" class="btn btn-success btn-bold" id="btnQuantity" > Connect  Item to Lock</button> 
                             
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
						
						if($("#lockCheck").val()=="success")
						{
							$('#divConItemBtn').css("display", "block");
						}
						
						
					}
					
				
				},
				error : function(xhr, status, error) {
				
					
						
				}
				
			});
			
			
		
	});
	
	  $('#lockSno').blur(function() {
	  
   	$('#divNoLockId').css("display", "none"); 
   	$('#lockDetails').css("display", "none"); 	
   	$('#divConItemBtn').css("display", "none"); 	
	
			var valu=this.value+"";
				var data = 'lockSno='
					+ encodeURIComponent(valu);
					
			$.ajax({
				url : "checklock.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
					
					
					if(response.msg!=null && response.msg=="fail")
					{
						$('#divNoLockId').css("display", "block"); 
						$('#userDetails').css("display", "none"); 	
						$("#lockCheck").val("fail");
							
					}
					else
					{
						
						$('#divNoLockId').css("display", "none");
						$('#lockDetails').css("display", "block");
						$("#lockCheck").val("success"); 	
						$("#lockId").val(response.lockId);
						$("#lockKind").val(response.lockKind);
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
					$('#divAddLock').css("display", "block"); 
					
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
					
					
					
					
					var lockId=$("#lockId").val();
					var lockKind=$("#lockKind").val();
						
				
					var tbodyRows=$("#tb > tr").length;
					var isNotExist=true;
					var tableRow;
				
					for(var index=0;index<tbodyRows;index++)
					{
						
						 tableRow=$("#tb").find('tr').eq(index);
						 
						var titemBarcode=tableRow.find('td').eq(0).text();
						
						var tlockId=tableRow.find('td').eq(4).text();
						
						
						if(itemBarcode==titemBarcode &&  tlockId==lockId)
						{
							
							itemQuantity=parseInt(itemQuantity)+parseInt(tableRow.find('td').eq(2).text());
							
							isNotExist=false;
							break;
							
						}
						
						
					}
					var appendTxt = "<td>"+itemBarcode+"</td><td>"+itemName+"</td><td>"+itemQuantity+"</td><td>"+lockKind+"</td><td>"+lockId+"</td><td><a  onclick='deleteRow(this)'>delete</a><input type='hidden' name='itemId' value='"+itemId+"'  id='itemId'/><input type='hidden' name='iquantity' id='iquantity' value='"+itemQuantity+"'/><input type='hidden' name='lockId'  value='"+lockId+"'/></td>";
					
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
				
					$('#divAddLock').css("display", "block"); 
				}
				else
				{
					
					$('#divAddLock').css("display", "none"); 
				}
				
				
			}
				
  
</script>


