<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
	.textbox
	{
		
    border-style: solid;
    border-color: #00FF00;

	}
</style>
<script type="text/javascript" src="js/ajax/jquery.min.js">
</script>
<script type="text/javascript">
	function validate(formObj)
	{
		if(document.getElementById('secretQId').value=="0")
	   {
		
		 alert("please select your Hint Question");
          document.getElementById('secretQId').focus();
		  return false;
		}
		else if(document.getElementById('ans').value=="")
	{
		 
		 alert("please Enter your Answer");
          document.getElementById('ans').focus();
		  return false;
	}
	
	else if(document.getElementById('txtInput').value=="")
	{
		 
		 alert("please Enter the verification code");
          document.getElementById('txtInput').focus();
		  return false;
	}
	 else if(!ValidCaptcha())
	{
		 
		alert("In valid verification code");
		document.getElementById('txtInput').focus();
		return false;
	}
		
	}
</script>
<form:form commandName="reg" method="post" onsubmit="return validate(this);">
<div id="div1">
<table width='100%' border='0' align='center' cellspacing='1' cellpadding='5' class='input-table innertextCp'>		
<tr><td width="100%" COLSPAN=2 align='center'><font color="red" size=3></font></td></tr>
<tr>
<td width="50%" align="right">
<font color="red">*&nbsp;</font>Country
</td>
<td width="50%" align="left">
<select onchange="print_ccode(this.selectedIndex);" id="country" name ="country" class="textbox"></select>

<script type="text/javascript">
var country_arr = new Array("Saudi Arabia", "United Arab Emirates", "Qatar", "Kuwait", "Bahrain", "Oman", "Egypt", "India");
var country_code = new Array("+966", "+971", "+974", "+965","+973","+968","+20","+91");




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

function print_ccode(selectedIndex){
   
    document.getElementById("txtm").value=country_code[selectedIndex-1];
    
}
</script>
<script language="javascript">print_country("country");</script>

</td>

</tr>




<tr>
<td width="50%" align="right"><font color="red">*&nbsp;</font>Nationality</td>
<td width="50%" align="left">
<select name="nationality" class="textbox" id="nationality">
  <option value="">-- select one --</option>
  <option value="afghan">Afghan</option>
  <option value="albanian">Albanian</option>
  <option value="algerian">Algerian</option>
  <option value="american">American</option>
  <option value="andorran">Andorran</option>
  <option value="angolan">Angolan</option>
  <option value="antiguans">Antiguans</option>
  <option value="argentinean">Argentinean</option>
  <option value="armenian">Armenian</option>
  <option value="australian">Australian</option>
  <option value="austrian">Austrian</option>
  <option value="azerbaijani">Azerbaijani</option>
  <option value="bahamian">Bahamian</option>
  <option value="bahraini">Bahraini</option>
  <option value="bangladeshi">Bangladeshi</option>
  <option value="barbadian">Barbadian</option>
  <option value="barbudans">Barbudans</option>
  <option value="batswana">Batswana</option>
  <option value="belarusian">Belarusian</option>
  <option value="belgian">Belgian</option>
  <option value="belizean">Belizean</option>
  <option value="beninese">Beninese</option>
  <option value="bhutanese">Bhutanese</option>
  <option value="bolivian">Bolivian</option>
  <option value="bosnian">Bosnian</option>
  <option value="brazilian">Brazilian</option>
  <option value="british">British</option>
  <option value="bruneian">Bruneian</option>
  <option value="bulgarian">Bulgarian</option>
  <option value="burkinabe">Burkinabe</option>
  <option value="burmese">Burmese</option>
  <option value="burundian">Burundian</option>
  <option value="cambodian">Cambodian</option>
  <option value="cameroonian">Cameroonian</option>
  <option value="canadian">Canadian</option>
  <option value="cape verdean">Cape Verdean</option>
  <option value="central african">Central African</option>
  <option value="chadian">Chadian</option>
  <option value="chilean">Chilean</option>
  <option value="chinese">Chinese</option>
  <option value="colombian">Colombian</option>
  <option value="comoran">Comoran</option>
  <option value="congolese">Congolese</option>
  <option value="costa rican">Costa Rican</option>
  <option value="croatian">Croatian</option>
  <option value="cuban">Cuban</option>
  <option value="cypriot">Cypriot</option>
  <option value="czech">Czech</option>
  <option value="danish">Danish</option>
  <option value="djibouti">Djibouti</option>
  <option value="dominican">Dominican</option>
  <option value="dutch">Dutch</option>
  <option value="east timorese">East Timorese</option>
  <option value="ecuadorean">Ecuadorean</option>
  <option value="egyptian">Egyptian</option>
  <option value="emirian">Emirian</option>
  <option value="equatorial guinean">Equatorial Guinean</option>
  <option value="eritrean">Eritrean</option>
  <option value="estonian">Estonian</option>
  <option value="ethiopian">Ethiopian</option>
  <option value="fijian">Fijian</option>
  <option value="filipino">Filipino</option>
  <option value="finnish">Finnish</option>
  <option value="french">French</option>
  <option value="gabonese">Gabonese</option>
  <option value="gambian">Gambian</option>
  <option value="georgian">Georgian</option>
  <option value="german">German</option>
  <option value="ghanaian">Ghanaian</option>
  <option value="greek">Greek</option>
  <option value="grenadian">Grenadian</option>
  <option value="guatemalan">Guatemalan</option>
  <option value="guinea-bissauan">Guinea-Bissauan</option>
  <option value="guinean">Guinean</option>
  <option value="guyanese">Guyanese</option>
  <option value="haitian">Haitian</option>
  <option value="herzegovinian">Herzegovinian</option>
  <option value="honduran">Honduran</option>
  <option value="hungarian">Hungarian</option>
  <option value="icelander">Icelander</option>
  <option value="indian">Indian</option>
  <option value="indonesian">Indonesian</option>
  <option value="iranian">Iranian</option>
  <option value="iraqi">Iraqi</option>
  <option value="irish">Irish</option>
  <option value="israeli">Israeli</option>
  <option value="italian">Italian</option>
  <option value="ivorian">Ivorian</option>
  <option value="jamaican">Jamaican</option>
  <option value="japanese">Japanese</option>
  <option value="jordanian">Jordanian</option>
  <option value="kazakhstani">Kazakhstani</option>
  <option value="kenyan">Kenyan</option>
  <option value="kittian and nevisian">Kittian and Nevisian</option>
  <option value="kuwaiti">Kuwaiti</option>
  <option value="kyrgyz">Kyrgyz</option>
  <option value="laotian">Laotian</option>
  <option value="latvian">Latvian</option>
  <option value="lebanese">Lebanese</option>
  <option value="liberian">Liberian</option>
  <option value="libyan">Libyan</option>
  <option value="liechtensteiner">Liechtensteiner</option>
  <option value="lithuanian">Lithuanian</option>
  <option value="luxembourger">Luxembourger</option>
  <option value="macedonian">Macedonian</option>
  <option value="malagasy">Malagasy</option>
  <option value="malawian">Malawian</option>
  <option value="malaysian">Malaysian</option>
  <option value="maldivan">Maldivan</option>
  <option value="malian">Malian</option>
  <option value="maltese">Maltese</option>
  <option value="marshallese">Marshallese</option>
  <option value="mauritanian">Mauritanian</option>
  <option value="mauritian">Mauritian</option>
  <option value="mexican">Mexican</option>
  <option value="micronesian">Micronesian</option>
  <option value="moldovan">Moldovan</option>
  <option value="monacan">Monacan</option>
  <option value="mongolian">Mongolian</option>
  <option value="moroccan">Moroccan</option>
  <option value="mosotho">Mosotho</option>
  <option value="motswana">Motswana</option>
  <option value="mozambican">Mozambican</option>
  <option value="namibian">Namibian</option>
  <option value="nauruan">Nauruan</option>
  <option value="nepalese">Nepalese</option>
  <option value="new zealander">New Zealander</option>
  <option value="ni-vanuatu">Ni-Vanuatu</option>
  <option value="nicaraguan">Nicaraguan</option>
  <option value="nigerien">Nigerien</option>
  <option value="north korean">North Korean</option>
  <option value="northern irish">Northern Irish</option>
  <option value="norwegian">Norwegian</option>
  <option value="omani">Omani</option>
  <option value="pakistani">Pakistani</option>
  <option value="palauan">Palauan</option>
  <option value="panamanian">Panamanian</option>
  <option value="papua new guinean">Papua New Guinean</option>
  <option value="paraguayan">Paraguayan</option>
  <option value="peruvian">Peruvian</option>
  <option value="polish">Polish</option>
  <option value="portuguese">Portuguese</option>
  <option value="qatari">Qatari</option>
  <option value="romanian">Romanian</option>
  <option value="russian">Russian</option>
  <option value="rwandan">Rwandan</option>
  <option value="saint lucian">Saint Lucian</option>
  <option value="salvadoran">Salvadoran</option>
  <option value="samoan">Samoan</option>
  <option value="san marinese">San Marinese</option>
  <option value="sao tomean">Sao Tomean</option>
  <option value="saudi">Saudi</option>
  <option value="scottish">Scottish</option>
  <option value="senegalese">Senegalese</option>
  <option value="serbian">Serbian</option>
  <option value="seychellois">Seychellois</option>
  <option value="sierra leonean">Sierra Leonean</option>
  <option value="singaporean">Singaporean</option>
  <option value="slovakian">Slovakian</option>
  <option value="slovenian">Slovenian</option>
  <option value="solomon islander">Solomon Islander</option>
  <option value="somali">Somali</option>
  <option value="south african">South African</option>
  <option value="south korean">South Korean</option>
  <option value="spanish">Spanish</option>
  <option value="sri lankan">Sri Lankan</option>
  <option value="sudanese">Sudanese</option>
  <option value="surinamer">Surinamer</option>
  <option value="swazi">Swazi</option>
  <option value="swedish">Swedish</option>
  <option value="swiss">Swiss</option>
  <option value="syrian">Syrian</option>
  <option value="taiwanese">Taiwanese</option>
  <option value="tajik">Tajik</option>
  <option value="tanzanian">Tanzanian</option>
  <option value="thai">Thai</option>
  <option value="togolese">Togolese</option>
  <option value="tongan">Tongan</option>
  <option value="trinidadian or tobagonian">Trinidadian or Tobagonian</option>
  <option value="tunisian">Tunisian</option>
  <option value="turkish">Turkish</option>
  <option value="tuvaluan">Tuvaluan</option>
  <option value="ugandan">Ugandan</option>
  <option value="ukrainian">Ukrainian</option>
  <option value="uruguayan">Uruguayan</option>
  <option value="uzbekistani">Uzbekistani</option>
  <option value="venezuelan">Venezuelan</option>
  <option value="vietnamese">Vietnamese</option>
  <option value="welsh">Welsh</option>
  <option value="yemenite">Yemenite</option>
  <option value="zambian">Zambian</option>
  <option value="zimbabwean">Zimbabwean</option>
</select>

</td>
</tr>
<tr>
<td width="50%" align="right"><font color="red">*&nbsp;</font>Kind of Id </td>
<td width="50%" align="left">
<select name="idProofId" id="idProofId" class="textbox">
	<option value="">Select</option>
	<option value="National ID">National ID</option>
	<option value="Eqamah">Eqamah</option>
	<option value="Passport Number">Passport Number</option>
</select>

</td>
</tr>
<tr>
<td width="50%" align="right"><font color="red">*&nbsp;</font>User Id No</td>
<td width="50%" align="left" ><input   type="text" class="textbox" name="userId" id="userId"  size="30" />


</td>
</tr>




<tr>
<td width="50%" align="right"><font color="red">*&nbsp;</font>Password</td>
<td width="50%" align="left"><input type="text" class="textbox" name="password" id="password"  size="30" ></td>
</tr>
<tr>
<td width="50%" align="right"><font color="red">*&nbsp;</font>Confirm Password</td>
<td width="50%" align="left"><input type="text" class="textbox" name="cpassword" id="cpassword"  size="30" ></td>
</tr>
<tr>
<td width="50%"  align="right"><font color="red">*&nbsp;</font>Mobile Number</td>
<td width="50%" align="left">
<input type="text" size="6" id="txtm" class="textbox" name="txtm" id="txtm" readonly="readonly" placeholder="cc"/>
<input type="text" class="textbox" name="mobileNo" id="mobileNo"  onkeypress="return numerics(event);" size="15">

</td>

</tr>
<tr>
<td width="50%"></td>
	<td  align="left">
		<input type="button" id="btnVerify" value="Verify" style="background-color: #1E90FF; 
    padding: 2px 4px;
    font: 13px sans-serif;
    text-decoration: none;
    border: 1px solid #000;
    border-color: #aaa #444 #444 #aaa;
    color: white"/>
	</td>
</tr>
<tr>
<td width="50%" align="right">Verify</td>
<td width="50%" align="left">
<input type="text" class="textbox" name="verifyMobileCode" size="10" id="verifyMobileCode"   size="30" />
<input type="button"  id="btnVerifyCode"    value="VerifyCode" disabled="disabled">
<input type="hidden"  name="verifyConMobileCode" size="10" id="verifyConMobileCode"   size="30" >
	<input type="button" value="Resend" style="background-color: #FF6600"/>
</td>
</tr>
<tr>
	<td>
	</td>
	<td>
		<p id="ptimer">
		</p>
	</td>
</tr>
<tr>
	<td></td>
	<td  align="left">
		<input type="button" id="btnContinue1" value="Continue" onclick="nextContinue1()"/>
	</td>
</tr>
</table>
</div>

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
  		alert("please select country");
  		$("#country").focus();
  		
  	}else if($("#nationality").val()=="")
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
  		alert($("#verifyMobileCode").val());
  		alert($("#verifyConMobileCode").val());
  		alert("wrong verification code");
  		$("#verifyMobileCode").focus();
  		
  	}
	
	});
	$('#btnVerify').click(
		function(event) {
			var mobileNo = $('#txtm').val()+$('#mobileNo').val();
			$('#verifyConMobileCode').val("");
			var data = 'mobileNo='
					+ encodeURIComponent(mobileNo);
					
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
<div id="div2" style="display:none">
<table width='100%' border='0' align='center' cellspacing='1' cellpadding='5' class='input-table innertextCp'>		
	<tr>
<td width="50%" align="right">E-Mail</td>
<td width="50%" align="left"><input type="text" class="textbox" name="email" id="email"  size="30" ></td>
</tr>
<tr>
<td width="50%" align="right">Confirm E-Mail</td>
<td width="50%" align="left"><input type="text" class="textbox" name="email" id="confirmEmail" size="30" ></td>
</tr>
<tr>
<td width="50%" align="right">Gender
<td width="50%" align="left" >
<input type="radio" class="textbox" name="gender"   size="30" value="Male" checked="checked"/>Male
<input type="radio" class="textbox" name="gender"   size="30" value="FeMale"/>FeMale

</td>
</tr>
<tr>
<td width="50%" align="right">Birth Date</td>
<td width="50%" align="left">
	<input type="radio" id="dbAD" name="dob" value="AD" checked="checked"/>
	AD
	<input type="radio" id="dbHJ" name="dob" value="HJ"/>
	HJ
</td>
</tr>
<tr>
<td width="50%" align="right"></td>
<td width="50%" align="left">
	<select name="day" id="day">
		<option value="">DD</option>
		
	</select>
	<select name="month" id="month">
		<option value="">MM</option>
	</select>
	<select name="year" id="year">
		<option value="">YYYY</option>
	</select>
</td>
</tr>
<tr>
	<td></td>
	<td  align="left">
		<input type="button" id="btnContinue2" value="Continue" onclick="nextContinue2()"/>
	</td>
</tr>
	
</table>
</div>
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
  	
  	$('#div1').css("display", "none");
  	$('#div3').css("display", "block"); 
  	$('#div2').css("display", "none"); 
  	
 }
</script>
<div id="div3" style="display:none">
	<table width='100%' border='0' align='center' cellspacing='1' cellpadding='5' class='input-table innertextCp'>		

		<tr>
<td align="center"><font color="red">*&nbsp;</font>Question in Case Of Forget Password
</td>
</tr>
<tr>
<td  align="center">
<select name="secretQId" id="secretQId"  class="" size="1" style="width:300px" tabindex="1"  onKeyDown='if(event.keyCode==13){event.keyCode=9;return true;}'>
<option value="0">-Select One-</option>
<option value="1">What is your Favorite Movie</option>
<option value="2">What is your Favorite colour</option>
<option value="3">Who is your Favorite Author</option>
<option value="4">Who is your Favorite Hero</option>
<option value="5">What was the Firstname of your Favorite Teacher</option>
<option value="6">What is Your Name of the city where Your born</option>
</select>
</td>
</tr>
<tr>
	<td align="center">
		<input type="text" name="ans" id="ans" placeholder="Answer" size="38"/>
	</td>
</tr>
		
	<tr>
<td align="center">Captcha
<input type="text" id="txtCaptcha" name="txtCaptcha" readonly="readonly"/>
</td>							
</tr>
<tr>
<td align="center">Verification Code
<input type="text" name="txtInput"  id="txtInput"/>

</td>
</tr>

<tr>
<td align="center">

<input type="hidden" name="registrationType" value="basic"/>
<input type="submit"  value="Submit">

</tr>
</table>
</div>


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
    </script> 


</form:form>

