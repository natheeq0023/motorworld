<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <div class="alert alert-danger fade in" id="divNoUserId" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> Userid is already exists
</div>
<style>
	.textbox
	{
		
    border-style: solid;
    border-color: #00FF00;

	}
</style>
<form:form commandName="reg" action="showbasic.htm" method="post" onsubmit="return validate(this);">
<!-- div1 started -->
<div id="div1">
	<!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left"><font color="red">*&nbsp;</font>Country </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select onchange="print_ccode(this.selectedIndex);" id="country" name ="country" class="textbox"></select>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left"><font color="red">*&nbsp;</font>City </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="city" name ="city" class="textbox">
           	<option value="">Select</option>
           </select>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left"><font color="red">*&nbsp;</font>Nationality</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
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
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
      <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Kind&nbsp;of&nbsp;Id </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select name="idProofId" id="idProofId" class="textbox">
			<option value="">Select</option>
			<option value="National ID">National ID</option>
			<option value="Eqamah">Eqamah</option>
			<option value="Passport Number">Passport Number</option>
		</select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>User&nbsp;Id&nbsp;No
   </div>
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
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"><font color="red">*&nbsp;</font>Confirm Password</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="password" class="textbox" name="cpassword" id="cpassword"  size="30" >
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
      <label for="concept" class="col-xs-5 col-md-3 control-label-left"><font color="red">*&nbsp;</font>Mobile&nbsp;Number
  		</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" size="6" id="txtm" class="textbox" name="txtm" id="txtm" readonly="readonly" placeholder="cc"/>
<input type="text" class="textbox" name="mobileNo" id="mobileNo"  onkeypress="return numerics(event);" size="15">
<input type="button" id="btnVerify" value="Verify" class="btn btn-info btn-pressure btn-sensitive"/>
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
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" class="textbox" name="verifyMobileCode" size="10" id="verifyMobileCode"   size="30" />
<input type="button"  id="btnVerifyCode" class="btn btn-info btn-pressure btn-sensitive"   value="VerifyCode" disabled="disabled">
<input type="hidden"  name="verifyConMobileCode" size="10" id="verifyConMobileCode"   size="30" >
	<input type="button" value="Resend" id="btnresend" class="btn btn-warning"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="button" class="btn btn-success btn-bold" id="btnContinue1" value="Continue" onclick="nextContinue1()"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   

</div>
<!-- div1 closed -->



<!-- div2 started -->
<div id="div2" style="display:none">
<!-- row -->
<div class="row">
                    
                    <div class="col-md-4">
                     <span class="btn btn-info btn-pressure btn-sensitive" style="width:500px;" >Id Verification </span>  
                    </div>
                    
</div>
<!-- end row -->
<!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Photo&nbsp;Album</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="file" name="loader1" id="loader1" />

<img id="imgfile" height="100" width="100"/>&nbsp;<input type="button" id="subbutton" value="Upload"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">FullName&nbsp;as&nbsp;in Id</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="textbox" name="fullName" id="fullName" size="30" >
         <input type="hidden" name="idProofFileName" id="idProofFileName"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
	<!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> E&nbsp;Mail</label>
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
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Confirm&nbsp;E&nbsp;Mail</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="textbox" name="confirmEmail" id="confirmEmail" size="30" >
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Gender</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="radio" class="textbox" name="gender"   size="30" value="Male" checked="checked"/>Male
<input type="radio" class="textbox" name="gender"   size="30" value="FeMale"/>FeMale

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Birth&nbsp;Date</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="radio" id="dbAD" name="dob" value="AD" checked="checked"/>
	AD
	<input type="radio" id="dbHJ" name="dob" value="HJ"/>
	HJ
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <select name="day" id="day">
		<option value="">DD</option>
		
	</select>
	<select name="month" id="month">
		<option value="">MM</option>
	</select>
	<select name="year" id="year">
		<option value="">YYYY</option>
	</select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="button" class="btn btn-success btn-bold" id="btnContinue2" value="Continue" onclick="nextContinue2()"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->


</div>
<!-- end div2 -->
<!-- start div3 -->
<div id="div3" style="display:none">
	<!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <label for="concept" class="col-md-2 control-label-left"><font color="red">*</font>Question&nbsp;in&nbsp;Case&nbsp;Of&nbsp;Forget&nbsp;Password </label>
   
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
    </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <select name="secretQId" id="secretQId"  class="" size="1" style="width:300px" tabindex="1"  onKeyDown='if(event.keyCode==13){event.keyCode=9;return true;}'>
<option value="0">-Select One-</option>
<option value="1">What is your Favorite Movie</option>
<option value="2">What is your Favorite colour</option>
<option value="3">Who is your Favorite Author</option>
<option value="4">Who is your Favorite Hero</option>
<option value="5">What was the Firstname of your Favorite Teacher</option>
<option value="6">What is Your Name of the city where Your born</option>
</select>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" name="ans" id="ans" placeholder="Answer" size="38"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left"><font color="red">*&nbsp;</font>Captcha </label>
   </div>
  <!--  <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" id="txtCaptcha" name="txtCaptcha" readonly="readonly"/>
         </div>
                          
    </div> -->
     <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" id="txtCaptcha" name="txtCaptcha" readonly="readonly"
           style="background-image:url(images/1.jpg); text-align:center; border:none;
            font-weight:bold; font-family:Modern"/>
             <input type="image" src="images/refresh.jpg" id="btnrefresh" value="Refresh" alt="Submit" width="40" height="18" onclick="DrawCaptcha();">
          </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left"><font color="red">*&nbsp;</font>Verification Code </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         
<input type="text" name="txtInput"  id="txtInput"/>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
        <input type="hidden" name="registrationType" value="golden"/>
<input type="submit"  class="btn btn-success btn-bold" value="Submit">
           
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
	
</div>
<!-- end div3 -->

 

</form:form>

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
	
	return true;
		
	}
</script>

<script type="text/javascript">
var country_arr = new Array("Saudi Arabia", "United Arab Emirates", "Qatar", "Kuwait", "Bahrain", "Oman", "Egypt", "India");
var country_code = new Array("+966", "+971", "+974", "+965","+973","+968","+20","+91");

var city_a = new Array();
city_a[0]="";
city_a[1]="Al Makkah|Al Riyadh|Al Bahah|Al Hudud|Shamaliyah|Al Jawf|Al Madinah|Al Qasim|Ar Riyad|Ash Sharqiyah (Eastern Province)|Ha'il|Jizan|Makkah|Najran|Tabuk";
city_a[2]="Ajman|Abu Dhabi|Al Fujayrah|Sharjah|Dubai|Khaymah|Qaywayn";
city_a[3]="Abu az Zuluf|Abu Thaylah|Ad Dawhah al Jadidah|Al Arish|Al Bida ash Sharqiyah";
city_a[4]="Al Ahmadi|Hawalli |Al Salimiyah|Kuwait City|Sabah as Salim|Salwa|Al Fahahil";
city_a[5]="Manama|Muharraq |Riffa|Hamad Town|Isa Town|Jidaf|Seef|Saar|Jufair|Hoora";
city_a[6]="Muskat|Salalah|Sohar|Nizwa|Sur|Seeb|Muttrah|Bahla|Ibra";	
city_a[7]="Cairo|Giza|Aswan|alexendria|Luxor|Aswan|Asyut|Giza|Fayium";
city_a[8]="Delhi|Mumbai|Banglore|Chennai|Hyderbad|kolkata|Ahmedabad|Lucknow";

function print_city(city, selectedIndex){
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

function print_ccode(selectedIndex){
   
    document.getElementById("txtm").value=country_code[selectedIndex-1];
    print_city("city", selectedIndex)
    
}
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
  		alert("please select country");
  		$("#country").focus();
  		
  	}
  	else if($("#city").val()=="")
  	{
  		valid=false;
  		alert("please select city");
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
  	if($("#loader1").val()=="")
  	{
  		valid=false;
  		alert("please upload image");
  		$("#loader1").focus();
  		
  	}else if($("#fullName").val()=="")
  	{
  		valid=false;
  		alert("please enter fullName");
  		$("#fullName").focus();
  		
  	}
  	else if($("#email").val()=="")
  	{
  		valid=false;
  		alert("please enter email");
  		$("#email").focus();
  		
  	}
  	else if($("#email").val()!="" && reg.test($("#email").val()) == false)
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

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script>
$(document).ready(function(){
  $("#subbutton").click(function(){
          processFileUpload();
  });

  $("#loader1").on('change',prepareLoad);
  var files;
  function prepareLoad(event)
  {
      console.log(' event fired'+event.target.files[0].name);
      files=event.target.files;
  }
  function processFileUpload()
  {
      console.log("fileupload clicked");
      var oMyForm = new FormData();
      oMyForm.append("file", files[0]);
     $
        .ajax({
            url : "${pageContext.request.contextPath}/uploadMyFile.htm",
            data : oMyForm,
            type : "POST",
            enctype: 'multipart/form-data',
            processData: false, 
            contentType:false,
            success : function(result) {
            $("#idProofFileName").val(result);
            $("#imgfile").attr('src', 'uploads/'+result);
            },
            error : function(result){
                alert('error'+JSON.stringify(result));
            }
        });
  }
});
</script>

