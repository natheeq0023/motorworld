<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
	.textbox
	{
		
    border-style: solid;
    border-color: #00FF00;

	}
</style>

<script type="text/javascript">
var citiesByState = {
Bike: ["Hero Honda","TVS","Baja","KTM","Suzuki"],
Car: ["Hyundai","Toyota","Nexa","MG","Ford","Volswogan","Suzuki"]
}
function makeSubmenu(value) {
if(value.length==0) document.getElementById("city").innerHTML = "<option></option>";
else {
var citiesOptions = "";
for(cityId in citiesByState[value]) {
citiesOptions+="<option>"+citiesByState[value][cityId]+"</option>";
}
document.getElementById("city").innerHTML = citiesOptions;
}
}
function displaySelected() { var country = document.getElementById("country").value;
var city = document.getElementById("city").value;
alert(country+"\n"+city);
}
function resetSelection() {
document.getElementById("country").selectedIndex = 0;
document.getElementById("city").selectedIndex = 0;
}
</script>
 

     
      
           
 
 <section>
  <div class="row" style="text-align: center;">
    <div class="col-md-8 mb-4">
      <div class="card mb-4">
        <div class="card-header py-3">
          <h5 style="text-align:center" class="form-label"><b> Please Fill The RTO Service Detail Form </b></h5>
        </div>
       <div></div>
        <div class="card-body">
         <form:form commandName="reg" method="post" onsubmit="return validate(this);">
          <input type="hidden" class="textbox" name="fullName" id="fullName"  size="30" value="${sessionScope.authUser.fullName }" readonly="readonly">
           <input type="hidden" class="textbox" name="customerId" id="customerId"  size="30" value="${sessionScope.authUser.customerId }" readonly="readonly">
           <input type="hidden" class="textbox" name="mobileNo" id="mobileNo"  size="30" value="${sessionScope.authUser.mobileNo }" readonly="readonly">
           <input type="hidden" class="textbox" name="email" id="email"  size="30" value="${sessionScope.authUser.email }" readonly="readonly">
   
      
            <!-- 2 column grid layout with text inputs for the first and last names -->
            <div class="row mb-4">
              <div class="col">
                <div class="form-outline">
                
                  <select  id="country" name ="vtype" class="form-control"  onchange="makeSubmenu(this.value)">
					           <option value="" disabled selected>Vehicle Type</option>
					           <option>Car</option> 
					           <option>Bike </option>
                  </select>
                  <label class="form-label" for="form6Example1"></label>
                </div>
              </div>
              <div class="col">
                <div class="form-outline">
                  
                  
                  <select  id="city" name ="vbrand" class="form-control">
                   <option value="" disabled selected>Vehicle Brand</option>
           	<option>Select</option>
           </select>
                  <label class="form-label" for="form6Example2"></label>
                </div>
              </div>
            
          <div class="form-outline mb-4">
              <input type="text" name="vehicleName" id="vehicleName" class="form-control" placeholder="Model Name" />
              <label class="form-label" for="form6Example3"></label>
            </div>
     
     
            <!-- Text input -->
            <div class="form-outline">
              
              <select  id="area" name ="area" class="form-control">
            <option value="" disabled selected>Area</option>
           	<option>RT Nagar</option>
           	<option>Hebbal </option>
           	<option>CKM</option>
           </select>
              
              <label class="form-label" for="form6Example3"></label>
            </div>
            <div class="form-outline">
              
              <select  id="rtoservicetype" name ="rtoservicetype" class="form-control">
            <option value="" disabled selected>RTO Service</option>
           	<option>Clearance Certificate</option>
           	<option>Ownership  Transfer</option>
           	<option>Driving Licence </option> 
           	<option> Other</option>
           	
           </select>
              
              <label class="form-label" for="form6Example3"></label>
            </div>
            
            
            
            

           </div>

            <button class="btn btn-primary btn-lg btn-block" type="submit">
              Submit
            </button>
         </form:form>
        </div>
      </div>
    </div>

   
  </div>
</section>
 
 
 
 
<script type="text/javascript" src="js/ajax/jquery.min.js">
</script>
<script type="text/javascript">
	function validate(formObj)
	{
		if(document.getElementById('country').value=="")
	   {
		
		 alert("please select your vehicle type");
          document.getElementById('country').focus();
		  return false;
		}
		else if(document.getElementById('city').value=="")
		{
			 
			 alert("please select your vehicle brand");
	          document.getElementById('city').focus();
			  return false;
		}
		
		else if(document.getElementById('vehicleName').value=="")
		{
			 
			 alert("Enter the Vehicle Model");
	          document.getElementById('vehicleName').focus();
			  return false;
		}
		else if(document.getElementById('area').value=="")
		{
			 
			alert("please select your Area");
			document.getElementById('area').focus();
			return false;
		} 
		else if(document.getElementById('rtoservicetype').value=="")
		{
			 
			alert("please select service needed ");
			document.getElementById('rtoservicetype').focus();
			return false;
		} 
		
		return true;
	}
</script>

<script type="text/javascript">
/* var country_arr = new Array("Bike       ", "Car       ");

var city_a = new Array();
city_a[0]="";
city_a[1]="Hero Honda|TVS|Bajaj|KTM|Suzuki";
city_a[2]="Hyundai|Toyota|Nexa|MG|Ford|Volswogan|Suzuki";


function print_city(city, selectedIndex){
	alert("zczcxzc");
    var option_str = document.getElementById(city);
    option_str.length=0;    
    option_str.options[0] = new Option('Select','');
    option_str.selectedIndex = 0;
    var city_arr = city_a[selectedIndex].split("|");
    for (var i=0; i<city_arr.length; i++) {
    option_str.options[option_str.length] = new Option(city_arr[i],city_arr[i]);
    
    }
}



function print_country(country){

    //given the id of the <select> tag as function argument, it inserts <option> tags
    var option_str = document.getElementById(country);
    option_str.length=0;
    option_str.options[0] = new Option('Select','');
    option_str.selectedIndex = 0;
    for (var i=0; i<country_arr.length; i++) {
    option_str.options[option_str.length] = new Option(country_arr[i],country_arr[i]);
    
    }
}
 */


</script>
<script language="javascript">print_country("country");</script>
<script type="text/javascript">
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
  function nextContinue1() {
  	var valid=true;
  	if($("#country").val()=="")
  	{
  		valid=false;
  		alert("please select type");
  		$("#country").focus();
  		
  	}else if($("#city").val()=="")
  	{
  		valid=false;
  		alert("please select brand");
  		$("#city").focus();
  		
  	}
  	
  	else if($("#nationality").val()=="")
  	{
  		valid=false;
  		alert("please select nationality");
  		$("#nationality").focus();
  		
  	}else if($("#idProofId").val()=="")
  	{
  		valid=false;
  		alert("please select kind of Id Proof");
  		$("#country").focus();
  		
  	}
  	else if($("#userId").val()=="")
  	{
  		valid=false;
  		alert("please enter UserId");
  		$("#userId").focus();
  		
  	}
  	else if($("#huserId").val()=="" || $("#huserId").val()=="fail")
  	{
  		valid=false;
  		alert("UserId is already exists");
  		$("#userId").focus();
  		
  	}
  	else if($("#password").val()=="")
  	{
  		valid=false;
  		alert("please enter password");
  		$("#password").focus();
  		
  	}
  	else if($("#password").val()!=$("#cpassword").val())
  	{
  		valid=false;
  		alert("mismatched password");
  		$("#cpassword").focus();
  		
  	}
  	else if($("#mobileNo").val()=="")
  	{
  		valid=false;
  		alert("please enter the mobileNo");
  		$("#mobileNo").focus();
  		
  	}
  	else if($("#verifyConMobileCode").val()=="")
  	{
  		valid=false;
  		alert("please verify the mobile no");
  		$("#mobileNo").focus();
  		
  	}
  	else if($("#verifyMobileCode").val()=="")
  	{
  		valid=false;
  		alert("please verify the mobile no");
  		$("#verifyMobileCode").focus();
  		
  	}
  	else if($("#verifyMobileCode").val()!=$("#verifyConMobileCode").val())
  	{
  		valid=false;
  		alert("wrong verification code");
  		$("#verifyMobileCode").focus();
  		
  	} 
  	
  	
  	if(valid)
  	{
  	
	  	$('#div1').css("display", "none");
	  	$('#div2').css("display", "block"); 
	  	$('#div3').css("display", "none"); 
  	}
  	
 }
  
	
</script>
<script>
var myVar = setInterval(function(){myTimer()},1000);
var ii=59;
function myTimer() {
    var d = new Date();
    document.getElementById("ptimer").innerHTML = "your otp will expired within "+ii+"sec";
    ii--;
}
</script>
<script>
	$(document).ready(function() {
	$('#btnVerifyCode').click(function(event) {
		if($("#verifyMobileCode").val()!=$("#verifyConMobileCode").val())
  	{
  		
  		alert("wrong verification code");
  		$("#verifyMobileCode").focus();
  		
  	}
  	else
  	{
  		$('#btnVerifyCode').prop('disabled', true);
		$('#btnVerify').prop('disabled', true);
		$("#mobileNo").attr('readonly', true);
		$('#btnresend').prop('disabled', true);
  		alert("your mobile is successfully verified");
  		
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
			
			var data = 'cc='
					+ encodeURIComponent($('#txtm').val())+'&mobileNo='
					+ encodeURIComponent($('#mobileNo').val())+'&otpCode='+encodeURIComponent(vcode);
					
			$.ajax({
				url : "mobileverify.htm",
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
			var data = 'cc='
					+ encodeURIComponent($('#txtm').val())+'&mobileNo='
					+ encodeURIComponent($('#mobileNo').val())+'&otpCode=';
					
					
				
			$.ajax({
				url : "mobileverify.htm",
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
<script type="text/javascript">

	var d=new Date();
        var y=d.getFullYear();
        var mon_ar=mon_ar=new Array("01","02","03","4","05","06","07","08","09","10","11","12");
         var day_ar=mon_ar=new Array("01","02","03","4","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
        
        for (var i=0; i<day_ar.length; i++) {
	        $('#day')
	         .append($("<option></option>")
	         .attr("value",i+1)
	         .text(mon_ar[i]));
    
    }
        for (var i=0; i<mon_ar.length; i++) {
	        $('#month')
	         .append($("<option></option>")
	         .attr("value",i+1)
	         .text(mon_ar[i]));
    
    }
	        
	 			
	        
	        
	        	for(var i=1900;i<=y;i++)
	        	{
	        		
	        		$('#year')
	         .append($("<option></option>")
	         .attr("value",i)
	         .text(i));
        	}
        	
	$('input:radio[name="dob"]').change(
    function(){
        var value=$(this).val();
        
        $('#year option[value!="0"]').remove();
        $('#month option[value!="0"]').remove();
        
       y=d.getFullYear();
        var j=1900;
	         
        if(value=="HJ")
	        { 
	        	y=y-500;
	        	j=1298;
	        
	        
	        	mon_ar=new Array("Muhharam","Safar","Rabi I","Rabi II","Jumada I","Jumada II","Rajab","Shaban","Ramadan","Shawwal","Dhu al-Qa'dah","Dhu al-Hijjah");
	        
        }
        else
        {
        	mon_ar=new Array("01","02","03","4","05","06","07","08","09","10","11","12");
	        
        }
        
        $('#month')
	         .append($("<option></option>")
	         .attr("value","")
	         .text("MM"));
	          
        $('#year')
	         .append($("<option></option>")
	         .attr("value","")
	         .text("YYYY"));
        for (var i=0; i<mon_ar.length; i++) {
	        $('#month')
	         .append($("<option></option>")
	         .attr("value",i+1)
	         .text(mon_ar[i]));
    
    }
	        
	 			
	        
	        
	        	for(var i=j;i<=y;i++)
	        	{
	        		
	        		$('#year')
	         .append($("<option></option>")
	         .attr("value",i)
	         .text(i));
        	}
    });

function nextContinue2() {
  	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
  	var valid=true;
	 if($("#email").val()=="")
  	{
  		valid=false;
  		alert("please enter email");
  		$("#email").focus();
  		
  	}else if($("#email").val()!="" && reg.test($("#email").val()) == false)
  	{
  		 

        
            alert('Invalid Email Address format');
            valid=false;;
            $("#email").focus();
        
	}
	 else if($("#confirmEmail").val()=="")
	  	{
	  		valid=false;
	  		alert("please enter Confirm EMail");
	  		$("#confirmEmail").focus();
	  		
	  	}
  	else if($("#email").val()!=$("#confirmEmail").val())
  	{
  		valid=false;
  		alert("mismatched mail");
  		$("#confirmEmail").focus();
  		
  	}
  	else if($("#day").val()=="")
  	{
  		valid=false;
  		alert("please select day");
  		$("#day").focus();
  		
  	}
  	else if($("#month").val()=="")
  	{
  		valid=false;
  		alert("please select month");
  		$("#month").focus();
  		
  	}
  	else if($("#year").val()=="")
  	{
  		valid=false;
  		alert("please select year");
  		$("#year").focus();
  		
  	}
  	if(valid)
	{
	
		$('#div1').css("display", "none");
	  	$('#div3').css("display", "block"); 
	  	$('#div2').css("display", "none"); 
	} 
	return valid;
  	
 }
</script>
<script type="text/javascript">

   //Created / Generates the captcha function    
    function DrawCaptcha()
    {
        var a = Math.ceil(Math.random() * 10)+ '';
        var b = Math.ceil(Math.random() * 10)+ '';       
        var c = Math.ceil(Math.random() * 10)+ '';  
        var d = Math.ceil(Math.random() * 10)+ '';  
        var e = Math.ceil(Math.random() * 10)+ '';  
        
        var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e ;
		
        document.getElementById('txtCaptcha').value = code;
    }
    // Validate the Entered input aganist the generated security code function   
    function ValidCaptcha(){
        var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
        var str2 = removeSpaces(document.getElementById('txtInput').value);
        if (str1 == str2) return true;        
        return false;
        
    }

    // Remove the spaces from the entered and generated code
    function removeSpaces(string)
    {
        return string.split(' ').join('');
    }
    
    window.DrawCaptcha();
    
    
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

