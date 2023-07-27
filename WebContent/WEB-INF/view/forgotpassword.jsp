<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <style>
	.textbox
	{
		
    border-style: solid;
    border-color: #00FF00;

	}
</style>
 <div class="alert alert-danger fade in" id="divNoUserId" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Please Enter Valid UserId !
</div>
 
 
 <!-- Page Heading -->
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-xs-5 col-md-2">
                     
                    </div>
                    <div class="col-xs-5 col-md-6">
                        <form action="">
                          
                              <div class="form-group">
                                  
                              </div>
                          
                        </form>
                    </div>
                    <div class="col-xs-2 col-md-2">
                         
                    </div>
                </div>
                
<c:if test="${not empty param.errMsg}">
	<div class="alert alert-danger fade in" id="divInvalid" >
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> ${param.errMsg }
</div>
</c:if>

<c:if test="${not empty param.suMsg}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong>  ${param.suMsg }
</div>
</c:if>
                <div class="row">
                  <div class="col-md-3"></div>
                  <div class="col-md-6">
                     <form action="updatePassword.htm" method="post">
                          <div class="panel-body form-horizontal payment-form">
                              <div class="form-group">
                                  <label for="concept" class="col-md-3 control-label-left">User&nbsp;Id<sup><i class="fa fa-star star-color"></i></sup></label>
                                  <div class="col-md-9">
                                      <input type="text" class="form-control form-border" id="userId" name="userId" required onblur="snoCheck(this)" >
                                      <input type="hidden" name="huserId" id="huserId"/>
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label for="concept" class="col-md-3 control-label-left">New Password<sup><i class="fa fa-star star-color"></i></sup></label>
                                  <div class="col-md-9">
                                      <input type="password" class="form-control form-border" id="newpassword" name="newpassword" required>
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label for="concept" class="col-md-3 control-label-left">Confirm Password<sup><i class="fa fa-star star-color"></i></sup></label>
                                  <div class="col-md-9">
                                      <input type="password" class="form-control form-border" id="confirmpassword" name="confirmpassword" required>
                                  </div>
                              </div>
                              
                               <div class="form-group">
                                      <label for="amount" class="col-md-3 control-label-left"></label>
                                      <div class="col-md-9"> 
                                           <button type="submit" id="submit" class="btn btn-success btn-bold">Submit</button> 
                                           
                                      </div>
                               </div>
                               
                          </div>
                      </form>
                  </div>
                  <div class="col-md-3"></div>
                </div>
                <!-- /.row -->
                
                <script>
                
                 function snoCheck(obj)
		{
		
			
			$('#divNoUserId').css("display", "none"); 	
	  
					if(obj.value=="")
					{
					  return false;
					}
					var data ='userId='+ encodeURIComponent(obj.value);
					
					$.ajax({
					url : "checkuserid.htm",
					data : data,
					contentType: 'application/json',
	   				mimeType: 'application/json',
					
					type : "GET",
	 
					success : function(response) {
						
						$("#huserId").val(response.msg);
						if(response.msg=="fail")
						{
							$('#divNoUserId').css("display", "none"); 	
							$('#submit').removeAttr('disabled');
						}
						else
						{
							$('#divNoUserId').css("display", "block"); 	
							$('#submit').attr('disabled','disabled');
						}
						
					
					},
					error : function(xhr, status, error) {
						$("#huserId").val("success");
						alert(error+" "+status+" "+xhr);
						
					}
					
				});
				
				return false;
	}
	</script>