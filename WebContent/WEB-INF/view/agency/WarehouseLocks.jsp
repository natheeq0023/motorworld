
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



<div class="alert alert-danger fade in" id="divNoLocks" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong>Locks not available
</div>
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
   <!-- row -->
   <div class="row" >
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
      
<button type="submit" class="btn btn-success btn-bold" id="btnLocks" >LocksDetails</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   
   <!-- end row -->
  
<br/>
 
<!-- row  -->
<div class="row">
        <div class="col-md-9">
   <div id="type-Model-tables" style="display:none">
  
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
							Number
						</th>
						
					</tr>
				</thead>
				<tbody id="tbtypeModel">


				</tbody>
			</table>
			
		</div>
		</div>
	
</div>
<!-- end row  -->

 

   
   

<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>


<script type="text/javascript">
			$(document).ready(function(){
			
			
	$('#btnLocks').click(
		function(event) {
		$('#type-Model-tables').css("display", "none"); 
		$('#divNoLocks').css("display", "none"); 
		 
		
		
			var warehouseId = $('#warehouseId').val();
			
			if(warehouseId=="")
			{
				alert("please select warehouse");
				$('#warehouseId').focus()
				return false;
			}
			
			
			var data = 'warehouseId='
					+ encodeURIComponent(warehouseId);
					
			$.ajax({
				url : "checkwarehouselock.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
						var map = {};
						$.each(response, function(i, lock) {
							var lockId=lock.lockId;
							var lockKind=lock.lockKind;
							var lockModel=lock.lockModel;
							
							if(map[lockKind+"|"+lockModel])
							{
								var count=parseInt(map[lockKind+"|"+lockModel])+1;
								map[lockKind+"|"+lockModel]=count;
							
							}
							else
							{
								map[lockKind+"|"+lockModel]=1;
							}
											
					
						});
						
					
					
						$("#tbtypeModel").empty();
					
						for (var i in map) {
							   var arrayOfStrings = i.split("|");
							  var appendTxt = "<tr><td>"+arrayOfStrings[0]+"</td><td>"+arrayOfStrings[1]+"</td><td>"+map[i]+"</td></tr>";
								
								
								$("#tbtypeModel").append(appendTxt);
								
							}
						$('#type-Model-tables').css("display", "block"); 
						
						
				},
				error : function(xhr, status, error) {
					$('#divNoLocks').css("display", "block"); 
				}
			});
			return false;
		});		
				
			
				
				     
			});
		
			
		
    
		</script>