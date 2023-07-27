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
	

<form action="" method="post" enctype="multipart/form-data" onsubmit="return validate(this);">
	     <h1 align="center">AgencyRequestForm</h1>
	     <h3 align="left">Organization&nbsp;Information</h3>

	<!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left"><font color="red">*&nbsp;</font>Organization&nbsp;Country </label>
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
     <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Organization&nbsp;Name&nbsp;</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input   type="text" class="textbox" name="organizationName" id="organizationName"  size="30" />
         </div>              
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Upload&nbsp;Document</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="file" id="doc" name="doc"  />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">YearEstablished</label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="yearEstablished" id="yearEstablished" placeholder="DD-MM-YYYY"/>
		
         </div>
                          
    </div>
                    
   </div> 
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Organization&nbsp;Type</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input   type="text" class="textbox" name="organizationType" id="organizationType"  size="30" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <h3 align="left">Requester&nbsp;Contact&nbsp;Information</h3>
    <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
    <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>RequesterName</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" class="textbox" name="requesterName" id="requesterName"  size="30" value="${sessionScope.authUser.fullName }" readonly="readonly">
           <input type="hidden" class="textbox" name="customerId" id="customerId"  size="30" value="${sessionScope.authUser.customerId }" readonly="readonly">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
    <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Street</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" class="textbox" name="street" id="street"  size="30" >

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
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Primary&nbsp;E&nbsp;Mail</label>
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
      <label for="concept" class="col-xs-5 col-md-3 control-label-left"><font color="red">*&nbsp;</font>Mobile&nbsp;Number
  		</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" size="6" id="txtm" class="textbox" name="txtm" id="txtm" readonly="readonly" placeholder="cc"/>
           <input type="text" class="textbox" name="mobileNo" id="mobileNo"  onkeypress="return numerics(event);" size="15">
         <!--   <input type="button" id="btnVerify" value="Verify" class="btn btn-info btn-pressure btn-sensitive"/> -->
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
  <!--  <div class="row">
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
                    
   </div> -->
   <!-- end row -->
   
   <h3><font color="red">*&nbsp;</font>Terms and Conditions<font color="red">*&nbsp;</font></h3>
		<p>
            Submission of this request does not guarantee that your request will be fulfilled after proper documents check up.<br>
            To review the status of your request at any time, please login with your user name and password, which will be emailed to you shortly. &nbsp;Status of requests will not be received over the telephone.<br>
            This request system has been implemented to decrease our carbon footprint and to help protect our environment. We appreciate your support. 
            Thank you.<br>
        </p>
	
	<!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
         <div class="form-group">
          <input type="checkbox"  name="checkValue" id="checkValue"  size="30" value="I confirm that i am ready to take agency">
         </div>  
     
   </div> 
   <div class="col-xs-5 col-md-6">
           <label for="concept" class="col-xs-5 col-md-3 control-label-left">I&nbsp;accept&nbsp;terms&nbsp;and&nbsp;conditions&nbsp;to&nbsp;take&nbsp;Agency&nbsp;from&nbsp;Moaddi&nbsp;Company</label>        
    </div>
              
   </div>
   <!-- end row -->
   
   
    <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-2" align="center">
   </div>
   <div class="col-xs-5 col-md-6" align="center">
        <div class="form-group">
            <input type="submit"  class="btn btn-success btn-bold" value="Payment"/> 
         </div>                 
    </div>            
   </div>
   <!-- end row -->
   
   

</form>
<script type="text/javascript" src="js/ajax/jquery.min.js">
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
			var data = 'mobileNo='
					+ encodeURIComponent(mobileNo)+'&otpCode=';
					
					
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
</c:if>
 <script type="text/javascript">
	function validate(formObj)
	{
		
		if(formObj.country.value=="")
		{
			valid=false;
			alert("please select country");
			$('#country').focus()
			
			return false;
		}
		if(formObj.organizationName.value=="")
		{
			valid=false;
			alert("please enter organizationName");
			$('#organizationName').focus()
			
			return false;
		}
		if(formObj.doc.value=="")
		{
			valid=false;
			alert("please select document");
			$('#doc').focus()
			
			return false;
		}
		if(formObj.yearEstablished.value=="")
		  {
		   valid=false;
		   alert("please enter Date in dd-mm-yyyy Format");
		   $('#yearEstablished').focus()
		   
		   return false;
		  }
		
		if(formObj.organizationType.value=="")
		{
			valid=false;
			alert("please enter organizationType");
			$('#organizationType').focus()
			
			return false;
		}
		if(formObj.street.value=="")
		{
			valid=false;
			alert("please Enter street");
			$('#street').focus()
			
			return false;
		}
		if(formObj.city.value=="")
		{
			valid=false;
			alert("please Select City");
			$('#city').focus()
			
			return false;
		}
		if(formObj.mobileNo.value=="")
		{
			valid=false;
			alert("please Enter Mobile Number");
			$('#mobileNo').focus()
			
			return false;
		}
		
		if(!formObj.checkValue.checked)
		{
			valid=false;
			alert("You must agree to the terms first");
			$('#checkValue').focus()
			
			return false;
		}
		
	
		
		return true;
	}
</script>
