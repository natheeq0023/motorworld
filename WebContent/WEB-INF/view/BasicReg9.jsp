

<div id="div1">
<table width='100%' border='0' align='center' cellspacing='1' cellpadding='5' class='input-table innertextCp'>		
<tr><td width="100%" COLSPAN=2 align='center'><font color="red" size=3></font></td></tr>
<tr>
<td width="50%">
<font color="red">*&nbsp;</font>Country
</td>
<td width="50%" align="left">
<select onchange="print_city('city',this.selectedIndex);" id="country" name ="country"></select>
</td>
</tr>
<tr>
<td width="50%">
<font color="red">*&nbsp;</font>City
</td>
<td width="50%" align="left">
<select name ="city" id ="city">
	<option value="">Select</option>
</select>
<script type="text/javascript">
var country_arr = new Array("Saudi Arabia", "United Arab Emirates", "Qatar", "Kuwait", "Bahrain", "Oman", "Egypt", "India");
var country_code = new Array("+966", "+971", "+974", "+965","+973","+968","+20","+91");

var c_a = new Array();
c_a[0]="";
c_a[1]="Riyadh|Jeddah|Mecca|Medina|Al-Ahsa|Ta'if|Dammam|Khamis Mushait|Buraidah|Khobar|Tabuk|Ha'il|Hafar Al-Batin|Jubail|Al-Kharj|Qatif|Abha|Najran|Yanbu|Al Qunfudhah";
c_a[2]="Dubai|Abu Dhabi|Sharjah|Al Ain|Ras al-Khaimah|Ajman|Fujairah|Umm al-Quwain|Khor Fakkan|Dibba Al-Hisn";
c_a[3]="Doha |Al Wakra|Umm Said|Al Khor|Madinat Al-Shamal|Al Ruwais|Al Zubara|Dukhan";
c_a[4]="Kuwait City|Dasman|Sharq|Dasma|Da'iya|Sawabir|Mirgab|Jibla|Salhiya|Bneid il-Gar|Keifan";


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

function print_city(city, selectedIndex){
    var option_str = document.getElementById(city);
    option_str.length=0;    // Fixed by Julian Woods
    option_str.options[0] = new Option('Select','');
    option_str.selectedIndex = 0;
    var city_arr = c_a[selectedIndex].split("|");
    for (var i=0; i<city_arr.length; i++) {
    option_str.options[option_str.length] = new Option(city_arr[i],city_arr[i]);
    
    }
    $("#txtCm").val(country_code[selectedIndex-1]);
     $("#txtm").val(country_code[selectedIndex-1]);
}
</script>
<script language="javascript">print_country("country");</script>

</td>
</tr>
<tr>
<td width="50%"><font color="red">*&nbsp;</font>Nationality</td>
<td width="50%" align="left">
<select name="nationality" id="nationality">
	<option value="">Select</option>
	<option value="Saudi">Saudi</option>
	<option value="Indian">Indian</option>
</select>

</td>
</tr>
<tr>
<td width="50%"><font color="red">*&nbsp;</font>Kind of Id Proof</td>
<td width="50%" align="left">
<select name="idProofId" id="idProofId">
	<option value="">Select</option>
	<option value="Eqamah">Eqamah</option>
	<option value="Passport Number">Passport Number</option>
	<option value="Audhar">Audhar</option>
</select>

</td>
</tr>
<tr>
<td width="50%"><font color="red">*&nbsp;</font>User Id No</td>
<td width="50%" align="left"><input type="text" class="search" name="CreateUser_1userName" id="userName" property="userName" size="30" />
<div id="userMessage" name="userMessage" ></div>
<div></div>
</td>
</tr>


<tr>
<td width="50%"><font color="red">*&nbsp;</font>Mobile Number</td>
<td width="50%" align="left">
<input type="text" size="6" id="txtm" name="txtm" readonly="readonly"/>
<input type="text" class="search" name="CreateUser_1mobileNo" id="mobileNo" property="mobileNo" onkeypress="return numerics(event);" size="15"></td>
</tr>
<tr>
<td width="50%"><font color="red">*&nbsp;</font> Confirm Mobile Number</td>
<td width="50%" align="left"><input type="text" size="6" id="txtCm" name="txtCm" readonly="readonly"/>
<input type="text" class="search" name="CreateUser_1contactNumber" id="contactNumber" property="contactNumber" onkeypress="return numerics(event);" size="15" ></td>
</tr>
<tr>
<td width="50%"><font color="red">*&nbsp;</font>E-Mail address</td>
<td width="50%" align="left"><input type="text" class="search" name="CreateUser_1email" id="email" property="email" size="30" ></td>
</tr>
<tr>
<td width="50%"><font color="red">*&nbsp;</font>Confirm E-Mail Address</td>
<td width="50%" align="left"><input type="text" class="search" name="CreateUser_1confirmEmail" id="confirmEmail" property="confirmEmail" size="30" ></td>
</tr>
<tr>
<td width="50%"><font color="red">*&nbsp;</font>Address</td>
<td width="50%" align="left"> <textarea name="CreateUser_1address" id="address" property="address" class="search" cols="30" rows="3"></textarea></td>
</tr>
<tr>
<td>

</td>
<td width="27%" align="center">

<input type="button" class="submit-btn" id="next1" value="Next" onclick="next1Click()"/>&nbsp;&nbsp;

</tr>
</table>
</div>
<script type="text/javascript">
 
 function next1Click() {
  	
  	$('#div1').css("display", "none");
  	$('#div2').css("display", "block"); 
  	$('#div3').css("display", "none"); 
  	
 }
</script>
<div id="div2" style="display:none">
<table width='100%' border='0' align='center' cellspacing='1' cellpadding='5' class='input-table innertextCp'>		

<tr>
<td width="50%"><font color="red">*&nbsp;</font>Full Name as in Id</td>
<td width="50%" align="left"><input type="text" class="search" name="CreateUser_1name" id="name" property="name" size="30" onkeypress="return alnumrics(event);"></td>
</tr>

<tr>
<td width="50%"><font color="red">*&nbsp;</font>Gender</td>
<td width="50%" align="left">
<input type="radio" class="search" name="CreateUser_gender"   size="30" value="Male" checked="checked"/>Male
<input type="radio" class="search" name="CreateUser_gender"   size="30" value="FeMale"/>FeMale

</td>
</tr>

<tr>
<td width="50%"><font color="red">*&nbsp;</font>Date of Birth</td>
<td width="50%" align="left">
<input id="dob" name="dob" id="dob" type="text" readonly="readonly"/>
<div id="chooserSpan" class="dateChooser select-free" style="display: none; visibility: hidden; width: 160px;"></div>
<b>AD</b>
<img src="images/calendar.gif" onclick="showChooser(this, 'dob', 'chooserSpan', 1900, 2100, 'd-m-Y', true);" />
						
<b>HJ</b><img id="date_btn_1" src="istamicimages/cal.png" style="vertical-align: top;" />


			<script type="text/javascript">
				Calendar.setup({
					inputField     :    "dob",   // id of the input field
					button         :    "date_btn_1",   // trigger for the calendar (button ID)
		       		ifFormat       :    "%Y-%m-%d",       // format of the input field
		       		dateType	   :	'jalali',
		       		weekNumbers    : false
				});
			</script>
</td>
</tr>
<tr>
<td>

</td>
<td width="27%" align="center">
<input type="button" class="submit-btn" value="Previous" onclick="previous1Click()"/>&nbsp;&nbsp;
<input type="button" class="submit-btn" value="Next" onclick="next2Click()"/>&nbsp;&nbsp;

</tr>
</table>

</div>
