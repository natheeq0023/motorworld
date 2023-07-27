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
</style>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Lock has been created successfully.
</div>
</c:if>
<div class="alert alert-danger fade in" id="divNoLock" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> LockSerialNo is alreadyexists
</div>
<form:form commandName="createlock" method="post" enctype="multipart/form-data" onsubmit="return validate(this);">
	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
    <!--  <label for="concept" class="col-md-2 control-label-left">
     Lock&nbsp;SerialNo </label> -->
       <label for="concept" class="btn btn-info btn-pressure btn-sensitive btn-scanner">
     BarcodeOn</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="lockSerialNo" id="lockSerialNo" class="form-control" placeholder="lockSerialNo"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">
     Kind&nbsp;of&nbsp;Lock</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <select name="lockKind" id="lockKind" class="form-control">
	       	     	  <option value="">Select</option>
	       	     	  <option value="School Lock">School Lock</option>
	       	     	  <option value="Masjid Lock">Masjid Lock</option>
	       	     	  <option value="Normal Lock">Normal Lock</option>
	      </select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Lock&nbsp;Model </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select name="lockModel" id="lockModel" class="form-control">
	       	     	  <option value="">Select</option>
	       	     	  <option value="1">L123</option>
	       	     	  <option value="2">L4568</option>
	       	     	  <option value="3">L7894</option>
	       	     	</select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Lock&nbsp;Photo </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="file" name="lockPhoto" id="lockPhoto" class="form-control"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Lock&nbsp;Color</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="lockColor" id="lockColor" class="form-control"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
     <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Lock&nbsp;Price</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="lockPrice" id="lockPrice" class="form-control" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Lock&nbsp;Size</label>
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
           <form:select path="warehouseId" id="warehouseId" cssClass="form-control">
	       	     	<form:option value="0" label="Select" />
					  <form:options  cssClass="form-control" items="${warehouseList}" itemValue="warehouseId" itemLabel="warehouseSno" />
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
      <input type="hidden" id="lockSerialNoCheck" name="lockSerialNoCheck">  
<input type="submit"  class="btn btn-success btn-bold" value="Add Lock"/>
          <!--  <input type="button" value="sms" onclick="sms()"> -->
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
		
		if(formObj.lockSerialNo.value=="")
		{
			valid=false;
			alert("please enter lockSerialNo");
			$('#lockSerialNo').focus()
			
			return false;
		}
		else if(formObj.lockSerialNoCheck.value=="" || formObj.lockSerialNoCheck.value=="fail")
		{
			alert("lockSerialNo already exists");
			$("#lockSerialNo").focus();
			return false;
		}
		if(formObj.lockKind.value=="")
		{
			valid=false;
			alert("please enter lockKind");
			$('#lockKind').focus()
			
			return false;
		}
		if(formObj.lockModel.value=="")
		{
			valid=false;
			alert("please enter lockModel");
			$('#lockModel').focus()
			
			return false;
		}
		if(formObj.lockPhoto.value=="")
		{
			valid=false;
			alert("please Capture lockPhoto");
			$('#lockPhoto').focus()
			
			return false;
		}
		if(formObj.lockColor.value=="")
		{
			valid=false;
			alert("please enter lockColor");
			$('#lockColor').focus()
			
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
			alert("please select warehouseId");
			$('#warehouseId').focus()
			
			return false;
		}
		
		return true;
	}
	$('#lockSerialNo').keyup(function() {
   	$('#divNoLock').css("display", "none"); 	
   
	
		
				var data = 'lockSerialNo='
					+ encodeURIComponent(this.value);
					
			$.ajax({
				url : "checklocksno.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
					
					$("#lockSerialNoCheck").val(response.msg);
					
					if(response.msg=="fail")
					{
						$('#divNoLock').css("display", "block"); 	
					}
					else
					{
						$('#divNoLock').css("display", "none"); 	
					}
					
				
				},
				error : function(xhr, status, error) {
					
						
				}
				
			});
			
			
		
	});
	
	
</script>
       	   	    
       	    
       	    
       	   