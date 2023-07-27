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

<form:form commandName="createAd" method="post" enctype="multipart/form-data" onsubmit="return validate(this);">
	
   <!-- row  -->
   <div class="row">
     <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left"> </label>
   </div>
   
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <select name="Vtype" id="Vtype" class="form-control" placeholder="Vehicle Type">
	       	     	  <option value="">Select</option>
	       	     	  <option value="School Machine">Car</option>
	       	     	  <option value="Masjid Machine">Bike</option>
	       	     	  <option value="Normal Machine">others</option>
	      </select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
    <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left"> </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="title" id="title" class="form-control" placeholder="Title"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
     <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left"> </label>
   </div>
  
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
              <input type="file" name="vehiclePhoto" id="vehiclePhoto" class="form-control" placeholder="Photo">
      </div>
   </div>
   </div> 
   <!-- end row -->
   <!-- row  -->
   
   <!-- end row -->
    <!-- row  -->
   <div class="row">
     <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left"> </label>
   </div>
  
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="price" id="price" class="form-control" placeholder="price"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  
   
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left"> </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <textarea name="description" rows="5" cols="40" class="form-control">Description</textarea>
    </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
     <!-- row  -->
   <div class="row">
 
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
     <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left"> </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
      
<input type="submit"  class="btn btn-success btn-bold" value="Post"/>
           
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
		
		if(formObj.title.value=="")
		{
			valid=false;
			alert("please enter Title");
			$('#title').focus()
			
			return false;
		}
		
		if(formObj.Vtype.value=="")
		{
			valid=false;
			alert("please enter Vehicle type");
			$('#Vtype').focus()
			
			return false;
		}
		if(formObj.price.value=="")
		{
			valid=false;
			alert("please enter Price");
			$('#price').focus()
			
			return false;
		}
		if(formObj.vehiclePhoto.value=="")
		{
			valid=false;
			alert("please Capture Vehicle Photo");
			$('#vehiclePhoto').focus()
			
			return false;
		}
		if(formObj.description.value=="")
		{
			valid=false;
			alert("please enter description");
			$('#description').focus()
			
			return false;
		}
		
		
		return true;
	}
	/* $('#machineSerialNo').keyup(function() {
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
			
			
		
	}); */
</script>
       	
       	    
       	    
       	    
       	   