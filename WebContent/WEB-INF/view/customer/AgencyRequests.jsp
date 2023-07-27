<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<br/>
<br/>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Agency Request has been completed successfully.
</div>
</c:if>
<c:if test="${empty param.s}">
	

<form action="" method="post">
	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left">
     Description</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <textarea rows="10" cols="45" class="form-control" name="description" id="description">
          	
          </textarea>
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
        
<input type="submit"  class="btn btn-success btn-bold" value="submit"/>
           
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</form>
</c:if>