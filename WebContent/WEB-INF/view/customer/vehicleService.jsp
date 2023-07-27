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
          <h5 style="text-align:center" class="form-label"><b> Please Fill The Vehicle Details </b></h5>
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
		if(document.getElementById('area').value=="")
	   {
		
		 alert("please select your Area");
          document.getElementById('area').focus();
		  return false;
		}
		else if(document.getElementById('city').value=="")
		{
			 
			 alert("please Enter your Vehcile Brand");
	          document.getElementById('city').focus();
			  return false;
		}
		
		else if(document.getElementById('country').value=="")
		{
			 
			 alert("please Enter the Vehicle Type ");
	          document.getElementById('country').focus();
			  return false;
		}
		
		return true;
	}
</script>