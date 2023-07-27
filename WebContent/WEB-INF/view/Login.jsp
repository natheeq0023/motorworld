<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.divider:after,
.divider:before {
content: "";
flex: 1;
height: 1px;
background: #eee;
}
</style>
<section class="vh-100">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-10 col-lg-6 col-xl-5">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
          class="img-fluid" alt="Sample image">
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
       <form action="login.htm" method="post" onsubmit="return validate(this)">
          <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
            <p class="lead fw-normal mb-0 me-3">Sign in with</p>
            
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
         

          <!-- Email input -->
          <div class="form-outline mb-4">
            <input type="text" id="userId"  name= "userId" class="form-control form-control-lg"
              placeholder="Enter User Id" />
            <label class="form-label" for="form3Example3"></label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-3">
            <input type="password" id="password" name="password" class="form-control form-control-lg"
              placeholder="Enter password" />
            <label class="form-label" for="form3Example4"></label>
          </div>

          <div class="d-flex justify-content-between align-items-center">
            <!-- Checkbox -->
            <div class="form-check mb-0">
              
            </div>
            <a href="forgotpassword.htm" class="text-body" ><b>Forgot password?</b></a>
          </div>

          <div class="text-center text-lg-start mt-4 pt-2">
            <button type="submit" class="btn btn-primary btn-lg"
              style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="showbasic.htm"
                class="link-danger">Register</a></p>
          </div>

        </form>
      </div>
    </div>
  </div>
  <div
    class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
    <!-- Copyright -->
    <div class="text-white mb-3 mb-md-0">
      Copyright © 2023. All rights reserved.
    </div>
    <!-- Copyright -->

    <!-- Right -->
  
    <!-- Right -->
  </div>
</section>

<script type="text/javascript">
	function validate(formObj)
	{
		if(document.getElementById('userId').value=="")
	   {
		
		 alert("please enter UserId");
          document.getElementById('userId').focus();
		  return false;
		}
		else if(document.getElementById('password').value=="")
		{
			 
			 alert("please Enter your password");
	          document.getElementById('password').focus();
			  return false;
		}
		
	
		return true;
	}
</script>