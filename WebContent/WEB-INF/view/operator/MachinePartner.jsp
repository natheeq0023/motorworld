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
		<strong>Success!</strong> Your Machine Partner has been connected
		successfully.
	</div>
</c:if>


<div class="alert alert-danger fade in" id="divNoMachine" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Machine is not exists
</div>
<div class="alert alert-danger fade in" id="divNoUserId" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Partner is not exists
</div>

<div id="divPartner">

	
		
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Partner Id</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="userId" id="userId" class="form-control" placeholder="Partner Id" />
            <input type="hidden" name="userCheck" id="userCheck"> 
             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <div id="userDetails" style="display:none">
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Partner Name</label>
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
          <input type="text" name="machineSno" id="machineSno" class="form-control" placeholder="Machine Sno"/>
            <input type="hidden" name="machineCheck" id="machineCheck"> 
             
         </div>
                          
    </div>
     <div class="col-xs-5 col-md-6">
        <div class="form-group">
          
         </div>
                          
    </div>               
   </div>
   <!-- end row -->
  <div id="machineDetails" style="display:none">
  	 <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine Kind</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="machineKind" id="machineKind" class="form-control" readonly="readonly" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
  

</div>


</div>
<div id="divMachinePartner" style="display:none">
<form method="post" onsubmit="return validate(this);">
<div id="divMachinePartnerCon" style="display:none">
	<fieldset>
	<legend>Machine Partner Connected</legend>
	<!-- row  -->
<div class="row">
        <div class="col-md-9">
   <div id="no-more-tables2">
  
			<table
				class="col-md-9 table-bordered table-striped table-condensed cf">
				<thead class="cf">
					<tr>
						<th class="lbl-lableinfo" align="center">
							Partner Name
						</th>
						<th class="lbl-lableinfo" align="center">
							PartnerId
						</th>
						<th class="lbl-lableinfo" align="center">
							Type
						</th>
						<th class="lbl-lableinfo" align="center">
							Location Name
						</th>
						
						
						<th class="lbl-lableinfo">
							Address
						</th>
						<th class="lbl-lableinfo">
							City
						</th>
						<th class="lbl-lableinfo">
							Country
						</th>
						
						<th class="lbl-lableinfo">
							<input type="hidden" name="connectedLocationId" id="connectedLocationId">
							
						</th>

					</tr>
				</thead>
				
				<tbody id="tb2">


				</tbody>
			</table>
			
		</div>
		</div>
	
</div>
<!-- end row  -->
	
</fieldset>
</div>

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
							Location Name
						</th>
						
						
						<th class="lbl-lableinfo">
							Address
						</th>
						<th class="lbl-lableinfo">
							City
						</th>
						<th class="lbl-lableinfo">
							Country
						</th>
						
						<th class="lbl-lableinfo">
							
							<input type="hidden" name="machineId" id="machineId">
							<input type="hidden" name="userRoleId" id="userRoleId">
							
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

<div id="divAddMachinePartner">
		<!-- row -->
   <div class="row" >
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
      
<button type="submit" class="btn btn-success btn-bold" id="btnMachinePartner" > Connect  Machine to Location</button> 
                             
         </div>
                          
    </div>
                    
   </div>
  
   <!-- end row -->
</div>
</form>

</div>

<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>

<script>
   
  
  $('#machineSno').blur(function() {
   
   	$('#divNoMachine').css("display", "none"); 
   	$('#machineDetails').css("display", "none");
   	$('#divAddMachinePartner').css("display", "none");
   	$('#divMachinePartnerCon').css("display", "none");
   
  	$("#connectedLocationId").val("");
  	$("#machineCheck").val("");
	$("#tb2").html("");
			var valu=this.value+"";
				var data = 'machineSno='
					+ encodeURIComponent(valu);
					
			$.ajax({
				url : "checkpartmachine.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
					
					
					if(response.msg!=null && response.msg=="fail")
					{
						$('#divNoMachine').css("display", "block"); 
						$('#machineDetails').css("display", "none"); 	
						$("#machineCheck").val("fail");
							
					}
					else
					{
						
						$('#divNoMachine').css("display", "none");
						$('#machineDetails').css("display", "block");
						$("#machineCheck").val("success"); 	
						$("#machineId").val(response.machine.machineId);
						
						$("#machineKind").val(response.machine.machineKind);
						if($("#userCheck").val()=="locsuccess")
						{
							$('#divAddMachinePartner').css("display", "block");
						}
						if(response.location!=null)
						{
							$("#connectedLocationId").val(response.location.locationId);
							$('#divMachinePartnerCon').css("display", "block");
							$("#tb2").append("<tr><td>"+response.partner.fullName+"</td><td>"+response.partner.userId+"</td><td>"+response.location.locationType+"</td><td>"+response.location.locationName+"</td><td>"+response.location.address+"</td><td>"+response.location.city+"</td><td>"+response.location.country+"</td><td><input type='radio' name='locationId' value='"+response.location.locationId+"' checked='checked' />Connect</td></tr>");	
							
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
   	$("#tb").html(""); 	
	$('#divMachinePartner').css("display", "none"); 
			var valu=this.value+"";
				var data = 'userId='
					+ encodeURIComponent(valu);
					
			$.ajax({
				url : "checkpartner.htm",
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
						$("#userRoleId").val(response.partner.userRoleId);
						$("#fullName").val(response.partner.fullName);
						if(response.locations!=null)
						{
							$("#userCheck").val("locsuccess");
								$('#divMachinePartner').css("display", "block"); 
							for ( var i = 0; i < response.locations.length; i++) {
								var location = response.locations[i];
								$("#tb").append("<tr><td>"+location.locationType+"</td><td>"+location.locationName+"</td><td>"+location.address+"</td><td>"+location.city+"</td><td>"+location.country+"</td><td><input type='radio' name='locationId' value='"+location.locationId+"' />Connect</td></tr>");	
							}
							if($("#machineCheck").val()=="success")
							{
								$('#divAddMachinePartner').css("display", "block");
							}
						
						}
						
					}
					
				
				},
				error : function(xhr, status, error) {
					
						
				}
				
			});
			
			
		
	});
	
	
	function validate(formObj)
	{
	
		if(formObj.locationId.value=="")
		{
			alert("please select ");
			return false;
		}
		return true;
	}
				
  
</script>


