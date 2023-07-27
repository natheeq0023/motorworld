<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Warehouse has been created successfully.
</div>
</c:if>
<style>
	.form-control {
	width:80%;
	}
	.btnlable
	{
		padding: 6px 2px;
	}
</style>
<style>
#gmap_canvas img {
	max-width: none !important;
	background: none !important
}
</style>
<form action="createsbranch.htm" method="post" onsubmit="return validate(this);">
<div>
	<!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Branch Name </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="branchName" id="branchName" class="form-control"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Location </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
            <input type="text" name="location" id="location" class="form-control"/>
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Contact </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         
<textarea rows="3" cols="20" id="contact" name="contact" class="form-control"></textarea>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    
   
   <!-- end row -->
   
   <div id="divMap" style="display:none">
   
   <div style="overflow: hidden; height: 300px; width: 500px;">
	<div id="gmap_canvas" style="height: 300px; width: 500px;"></div>
	</div>
   </div>
    <br/>
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
  
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
        
<button type="submit" class="btn btn-success" id="btnSubmit">Create Branch</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</div>
</form>
<script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>
<script type="text/javascript" src="../js/countrycity.js">
</script>


<script language="javascript">print_country("country");</script>
<script type="text/javascript">
	function validate(formObj)
	{
		if(formObj.branchName.value=="")
		{
			alert("please  enter the branchName ");
			$("#branchName").focus();
			return false;
		}
		if(formObj.location.value=="")
		{
			alert("please enter the location");
			$("#location").focus();
			return false;
		}
		if(formObj.contact.value=="")
		{
			alert("please enter the contact");
			$("#contact").focus();
			return false;
		}
		return true;
		
	}
</script>




	
