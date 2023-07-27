<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
.textbox
	{
		
 
    .gradient-custom-2 {
/* fallback for old browsers */
    background: #fccb90;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
}

@media (min-width: 768px) {
.gradient-form {
height: 100vh !important;
}
}
@media (min-width: 769px) {
.gradient-custom-2 {
border-top-right-radius: .3rem;
border-bottom-right-radius: .3rem;
}
}
	}
</style>

 <div class="alert alert-danger fade in" id="divNoUserId" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Userid is already exists
</div>


<section>
  <div class="row" style="text-align: center;">
    <div class="col-md-8 mb-4">
      <div class="card mb-4">
        <div class="card-header py-3">
          <h5 style="text-align:center" class="form-label"><b> User Registration </b></h5>
        </div>
       <div></div>
        <div class="card-body">
          <form:form commandName="reg" method="post" onsubmit="return validate(this);">
         
          <div class="form-outline mb-4">
              <input type="text"  name="userId" id="userId"  size="15" onblur="snoCheck(this)" class="form-control" placeholder="User Id" />
           <input type="hidden" name="huserId" id="huserId"/>
              <label class="form-label" for="form6Example3"></label>
            </div>
     
         
         
         <div class="form-outline mb-4">
              <input type="text"  name="fullName" id="name"   size="25"  class="form-control" placeholder="Name " />
         
              <label class="form-label" for="form6Example3"></label>
            </div>
            
             <div class="form-outline mb-4">
              <input type="password"  name="password" id="password"   size="25" class="form-control" placeholder="Password " />
         
              <label class="form-label" for="form6Example3"></label>
            </div>
            
            
            <div class="form-outline mb-4">
              <input type="text"  name="mobileNo" id="mobileNo"   size="25"  name="mobileNo" id="mobileNo"  onkeypress="return numerics(event);" class="form-control" placeholder="Mobile Number " />
         
              <label class="form-label" for="form6Example3"></label>
            </div>
            
             <div class="form-outline mb-4">
              <input type="text"  name="email" id="email"   size="25"  class="form-control" placeholder="Email Id " />
         
              <label class="form-label" for="form6Example3"></label>
            </div>
            
            
      
          

            <button class="btn btn-primary btn-lg btn-block" type="submit">
              Register
            </button>
         </form:form>
        </div>
      </div>
    </div>

   
  </div>
</section>






<%-- <form:form commandName="reg" method="post" onsubmit="return validate(this);">
<!-- div1 started -->
<div id="div1">
	
   <!-- row  -->
 
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="form-control" ><font color="red">*&nbsp;</font>User Id   </label></div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input   type="text" class="textbox" name="userId" id="userId"  size="30" onblur="snoCheck(this)" />
           <input type="hidden" name="huserId" id="huserId"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Name  </label> </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input   type="text" class="textbox" name="fullName" id="name"  size="30" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
    <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Password</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="password" class="textbox" name="password" id="password"  size="30" >

         </div>
                          
    </div>
                    
   </div>
  
   <!-- end row -->
   <!-- row  --> 
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"><font color="red">*&nbsp;</font>Email Id</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" class="textbox" name="email" id="email"  size="30" >
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
      <label for="concept" class="col-xs-5 col-md-3 control-label-left"><font color="red">*&nbsp;</font>Mob&nbsp;No
  		</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">

 <input type="text" class="textbox" name="mobileNo" id="mobileNo"  onkeypress="return numerics(event);" size="15">

      </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
  


<!-- end div2 -->

   <!-- row  -->
   
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
        
<input type="submit"  class="btn btn-success btn-bold" value="Submit">
           
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
	
</div>
<!-- end div3 -->

 

</form:form>
 --%>
<script type="text/javascript" src="js/ajax/jquery.min.js">
</script>
<script type="text/javascript">
	function validate(formObj)
	{
		if(document.getElementById('userId').value=="0")
	   {
		
		 alert("Please Enter Userid");
          document.getElementById('userId').focus();
		  return false;
		}
		else if(document.getElementById('name').value=="")
		{
			 
			 alert("Please Enter Your Name");
	          document.getElementById('name').focus();
			  return false;
		}
		else if(document.getElementById('password').value=="")
		{
			 
			 alert("Please Enter Your Password");
	          document.getElementById('password').focus();
			  return false;
		}
		
		else if(document.getElementById('email').value=="")
		{
			 
			 alert("Please Enter The Email id ");
	          document.getElementById('email').focus();
			  return false;
		}
		else if(document.getElementById('mobileNo').value=="")
		{
			 
			 alert("Please Enter The Mobile No  ");
	          document.getElementById('mobileNo').focus();
			  return false;
		}
	 	
		
		return true;
	}
	
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
							$('#divNoUserId').css("display", "block"); 	
						}
						else
						{
							$('#divNoUserId').css("display", "none"); 	
						}
						
					
					},
					error : function(xhr, status, error) {
						$("#huserId").val("fail");
						alert(error+" "+status+" "+xhr);
						
					}
					
				});
				
				return false;
					
	}
	
</script>




