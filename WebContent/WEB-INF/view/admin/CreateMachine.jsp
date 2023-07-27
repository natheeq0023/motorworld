<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.form-control {
	width:60%;
	}
	
	
	.btnlable
	{
		padding: 6px 2px;
	}
	.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
</style>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Machine has been created successfully.
</div>
</c:if>
<div class="alert alert-danger fade in" id="divNoMachine" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> MachineSerialNo is alreadyexists
</div>
<form:form commandName="createmachine" method="post" enctype="multipart/form-data" onsubmit="return validate(this);">
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
          <input type="text" name="machineSerialNo" id="machineSerialNo" class="form-control" placeholder="MacineSerialNo"/>
           
         </div>
                          
    </div>
     <div class="col-xs-5 col-md-6">
        <div class="form-group">
          
         </div>
                          
    </div>               
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
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
   
   <div class="col-xs-5 col-md-3" align="right">
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
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;Photo </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="file" name="machinePhoto" id="machinePhoto" class="form-control"/>
         </div>
         
         <div>
         
          <td>
				<c:forEach var="photo" items="${account.photos }">
					<img src="${pageContext.request.contextPath }/assets/images/${photo }" width="120">
				</c:forEach>
			</td>
         </div> 
         
         
<!--          <div class="col-xs-5 col-md-6"> -->
<!--      <input type="file" name="machinePhoto" multiple="multiple" /> -->
<!--     </div> -->
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;Color</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="machineColor" id="machineColor" class="form-control"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;Price</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="machinePrice" id="machinePrice" class="form-control" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;Size</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group"> 	
          Height:<input type="text" name="height" id="height" size="5" />
	       	     	 	   	 
	       	     	 	   	 	Depth:<input type="text" name="depth" id="depth" size="5" />
	       	     	 	   	 
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group"> 	
         
	       	     	 	   	 	Width:<input type="text" name="width" id="width" size="5" />
	       	     	 	   	 
	       	     	 	   	 	Weight:<input type="text" name="weight" id="weight" size="5" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Warehouse </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <form:select path="warehouseId" id="warehouseId" cssClass="form-control" >
	       	     	  <form:option value="0" label="Select" />
					  <form:options  cssClass="form-control" items="${warehouseList}" itemValue="warehouseId" itemLabel="warehouseSno"  />
	       </form:select>
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
        <input type="hidden" name="machineSerialNoCheck" id="machineSerialNoCheck">
<input type="submit"  class="btn btn-success btn-bold" value="Add Machine"/>
           
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
</form:form>
 <script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
    <script type="text/javascript">
	function validate(formObj)
	{
		
		if(formObj.machineSerialNo.value=="")
		{
			valid=false;
			alert("please enter machineSerialNo");
			$('#machineSerialNo').focus()
			
			return false;
		}
		else if(formObj.machineSerialNoCheck.value=="" || formObj.machineSerialNoCheck.value=="fail")
		{
			alert(" machineSerialNo already exists");
			$("#machineSerialNo").focus();
			return false;
		}
		if(formObj.machineKind.value=="")
		{
			valid=false;
			alert("please enter machineKind");
			$('#machineKind').focus()
			
			return false;
		}
		if(formObj.machineModel.value=="")
		{
			valid=false;
			alert("please enter machineModel");
			$('#machineModel').focus()
			
			return false;
		}
		if(formObj.machinePhoto.value=="")
		{
			valid=false;
			alert("please Capture machinePhoto");
			$('#machinePhoto').focus()
			
			return false;
		}
		if(formObj.machineColor.value=="")
		{
			valid=false;
			alert("please enter machineColor");
			$('#machineColor').focus()
			
			return false;
		}
		if(formObj.height.value=="")
		{
			valid=false;
			alert("please select height");
			$('#height').focus()
			
			return false;
		}
		if(formObj.depth.value=="")
		{
			valid=false;
			alert("please enter depth");
			$('#depth').focus()
			
			return false;
		}
		if(formObj.width.value=="")
		{
			valid=false;
			alert("please enter width");
			$('#width').focus()
			
			return false;
		}
		if(formObj.weight.value=="")
		{
			valid=false;
			alert("please enter weight");
			$('#weight').focus()
			
			return false;
		}
		if(formObj.warehouseId.value=="0")
		{
			valid=false;
			alert("please enter warehouseId");
			$('#warehouseId').focus()
			
			return false;
		}
		
		return true;
	}
	$('#machineSerialNo').keyup(function() {
   	$('#divNoMachine').css("display", "none"); 	
   
	
		
				var data = 'machineSerialNo='
					+ encodeURIComponent(this.value);
					
			$.ajax({
				url : "checkmachinesno.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
					
					$("#machineSerialNoCheck").val(response.msg);
					
					if(response.msg=="fail")
					{
						$('#divNoMachine').css("display", "block"); 	
					}
					else
					{
						$('#divNoMachine').css("display", "none"); 	
					}
					
				
				},
				error : function(xhr, status, error) {
					
						
				}
				
			});
			
			
		
	});
</script>
       	
       	    
       	    
       	    
       	   