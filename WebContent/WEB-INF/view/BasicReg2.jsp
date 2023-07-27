<style>
	.textbox
	{
		
    border-style: solid;
    border-color: #00FF00;

	}
</style>
<script type="text/javascript" src="js/ajax/jquery.min.js">
</script>
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
<select name="nationality" class="textbox">
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

<div></div>
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
<input type="file" name="loader1" id="loader1" />
<input type="button" id="subbutton" value="Upload"/>
<img id="imgfile" height="100" width="100"/>
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
	
</script>
<script>
var myVar = setInterval(function(){myTimer()},1000);
var i=59;
function myTimer() {
    var d = new Date();
    document.getElementById("ptimer").innerHTML = "your otp will expired within "+i+"sec";
    i--;
}
</script>
<script>
	$(document).ready(function() {
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
            alert('success'+result);
            $("#imgfile").attr('src', 'uploads/'+result);
            },
            error : function(result){
                alert('error'+JSON.stringify(result));
            }
        });
  }
});
</script>

