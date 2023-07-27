<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<script type="text/javascript">
function showMe (it, box) {
  var vis = (box.checked) ? "block" : "none";
  document.getElementById(it).style.display = vis;
}
	function validate(formObj)
	{
		var valid=true;
			if(formObj.oldpassword.value=="")
			{
				valid=false;
				
				alert("please enter oldpassword");
				$('#oldpassword').focus()
			}
			else if(formObj.newpassword.value=="")
			{
				valid=false;
				alert("please enter newpassword");
				$('#newpassword').focus()
			}
			else if(formObj.confirmpassword.value=="")
			{
				valid=false;
				alert("please confirm password");
				$('#confirmpassword').focus()
			}
			else if(formObj.confirmpassword.value!=formObj.newpassword.value)
			{
				valid=false;
				alert("Password Mismatch");
				$('#confirmpassword').focus()
			}
			
			
		
		return valid;
	}
	
	

function numerics(code)
 {
    code = (code) ? code : event;
    var charCode = (code.charCode) ? code.charCode : ((code.keyCode) ? code.keyCode : 
        ((code.which) ? code.which : 0));
    if (charCode > 31 && (charCode < 48 || charCode > 57 ))
		{
        alert("Enter 0-9 Digits Only");
        return false;
        }
  return true;
  }

function validateMobile(formObj)
	{
		var valid=true;
		if(formObj.mobileNo.value="")
		{
			valid=false;
			alert("Please Enter New Mobile Number");
			$('#mobileNo').focus()
		}
		
	
	return valid;
	}
	
function profile(){
	
    var mob = document.getElementById("oldmobileNo").value;	
    
	if(mob=='')
      
    	 {
      	  document.getElementById('oldmobileNo').style.borderColor = "red";
            document.getElementById("moblocation").innerHTML=  
                "Please Enter 10 digit Valid Mobile Number !";
            return false;
    	 
    	 }
	  var newmob = document.getElementById("mobileNo").value;
	 if(newmob=='')
	      
	 {
 	  document.getElementById('mobileNo').style.borderColor = "red";
       document.getElementById("newmoblocation").innerHTML=  
           "Please Enter 10 digit Valid Mobile Number !";
       return false;
	 
	 }
}
</script>	




<input type="checkbox" name="c1" onclick="showMe('div1', this)">Change Password<br>
<input type="checkbox" name="c2" onclick="showMe('div2', this)">Change MobileNo<br>

<!-- code change start heare *************************** -->


<div id="div1" style="display:none">

 <form action="updatepassword.htm" method="post" onsubmit="return validate(this);">
	<h1>Change Your Password</h1>
	
     <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left ">
     Old&nbsp;Password </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="password" name="oldpassword" id="oldpassword" class="form-control"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left ">
     New&nbsp;Password </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="password" name="newpassword" id="newpassword" class="form-control"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-3" align="right">
     <label for="concept" class="col-md-2 control-label-left ">
     Confirm&nbsp;Password </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="hidden" name="customerId" id="customerId" value="${sessionScope.authUser.customerId}"/>
       
          <input type="password" name="confirmpassword" id="confirmpassword" class="form-control" />
         </div>
                          
    </div>
              
   </div>
   
   <!-- end row -->
    
   <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-6" align="center">
        <div class="form-group">
        
           <input type="submit" class="btn btn-control" id="btnCheck" name="accountStatus" value="Change Password" />
           
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
	</form>
		</div>
	
	<div id="div2" style="display:none">
	  <form action="updateNumber.htm" method="post" >
	<h1>Change Your Number</h1>
	
     <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
      <label for="concept" class="col-xs-5 col-md-3 control-label-left"><font color="red">*&nbsp;</font>Old&nbsp;Mobile&nbsp;Number
  		</label>
   </div>
  <div class="col-xs-5 col-md-6">
        <div class="form-group">
        
         <input type="text" class="textbox" name="oldmobileNo" id="oldmobileNo"  onkeypress="return numerics(event);" size="15" >
         <span id="moblocation" style="color:red"></span>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
        <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
      <label for="concept" class="col-xs-5 col-md-3 control-label-left"><font color="red">*&nbsp;</font>New&nbsp;Mobile&nbsp;Number
  		</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
       
        
        <input type="text" class="textbox" name="mobileNo" id="mobileNo"  onkeypress="return numerics(event);" size="15" >
         <span id="newmoblocation" style="color:red"></span>
        
   </div>
  </div>
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"><font color="red">*&nbsp;</font>Verify</label>
   </div>
  
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="hidden" name="customer" id="customer" value="${sessionScope.authUser.customerId}"/>
        <input type="hidden" name="userRole" id="userRole" value="${sessionScope.userRole.userRoleId}"/>
           <input type="submit" class="btn btn-control" id="btnCheck"  value="Change MobileNO" onclick="return(profile());" />
           
         </div>
                          
    </div>
                    
   </div>
   

   
   <!-- end row -->
	</form>
	</div>
<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
	<script>
var myVar = setInterval(function(){myTimer()},1000);
var ii=59;
function myTimer() {
    var d = new Date();
    document.getElementById("ptimer").innerHTML = "your otp will expired within "+ii+"sec";
    ii--;
}

	$(document).ready(function() {
	$('#btnVerifyCode').click(function(event) {
		if($("#verifyMobileCode").val()!=$("#verifyConMobileCode").val())
  	{
  		alert($("#verifyMobileCode").val());
  		alert($("#verifyConMobileCode").val());
  		alert("wrong verification code");
  		$("#verifyMobileCode").focus();
  		
  	}
	
	});
	
	$('#btnresend').click(
		function(event) {
			var mobileNo = $('#txtm').val()+$('#mobileNo').val();
			if($('#txtm').val()=="" || $('#mobileNo').val()=="")
			{
				alert("please enter mobileno");
				$('#mobileNo').focus()
				return false;
			}
			var vcode=$('#verifyConMobileCode').val();
			
			var data = 'mobileNo='
					+ encodeURIComponent(mobileNo)+'&otpCode='+encodeURIComponent(vcode);
					
			$.ajax({
				url : "mobileverifyAdmin.htm",
				data : data,
				type : "GET",
 
				success : function(response) {
					if(response=="fail")
					{
						
					}
					else
					{
						
						$('#btnVerifyCode').prop('disabled', false);
						$('#btnVerify').prop('disabled', true);
						$('#verifyConMobileCode').val(response);
						
						
					}
				},
				error : function(xhr, status, error) {
					alert(xhr.responseText);
				}
			});
			return false;
		});
	
	$('#btnVerify').click(
		function(event) {
			
			var mobileNo = $('#txtm').val()+$('#mobileNo').val();
			if($('#txtm').val()=="" || $('#mobileNo').val()=="")
			{
				alert("please enter mobileno");
				$('#mobileNo').focus()
				return false;
			}
			$('#verifyConMobileCode').val("");
			var data = 'mobileNo='
					+ encodeURIComponent(mobileNo)+'&otpCode=';
					
					
			$.ajax({
				
				url : "mobileverifyAdmin.htm",
				data : data,
				type : "GET",
 
				success : function(response) {
				
					if(response=="fail")
					{
						
					}
					else
					{
						
						$('#btnVerifyCode').prop('disabled', false);
						$('#btnVerify').prop('disabled', true);
						$('#verifyConMobileCode').val(response);
						
						
					}
				},
				error : function(xhr, status, error) {
					alert(xhr.responseText);
				}
			});
			return false;
		});
	});
</script>
	





