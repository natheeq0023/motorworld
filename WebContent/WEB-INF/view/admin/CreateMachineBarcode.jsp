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
<form:form commandName="createmachinebarcode" method="post" enctype="multipart/form-data">
	

  
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;Photo </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="file" name="machinePhoto" id="machinePhoto" class="form-control"/>
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
        
<input type="submit"  class="btn btn-success btn-bold" value="Add Machine"/>
           
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
</form:form>
       	
       	    
       	    
       	    
       	   