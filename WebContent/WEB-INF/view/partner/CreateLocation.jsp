<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Location has been created successfully.
</div>
</c:if>

<style>
	.form-control {
	width:80%;
	}
	.btnlable
	{
		padding: 6px 2px;
	}
</style>
<style>
#gmap_canvas img {
	max-width: none !important;
	background: none !important
}
</style>
<form action="createlocation.htm" method="post" onsubmit="return validate(this);">
<div>
	<!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Country </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select onchange="print_city('city',this.selectedIndex);" id="country" name="country" class="form-control"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">City </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="city" name="city" class="form-control">
           	<option value="">Select</option>
           </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
 
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Type </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <select name="locationType" id="locationType">
          	<option value="">Select</option>
          	<option value="Shopping Mall">Shopping Mall</option>
          </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
 
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Name </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="locationName" id="locationName">
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Address </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         
<textarea rows="3" cols="20" id="address" name="address" class="form-control"></textarea>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
        
<button type="button" class="btn" id="btnSubmit" onclick="GetLocation()">Show Adress in Google Map</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <div id="divMap" style="display:none">
   
   <div style="overflow: hidden; height: 300px; width: 500px;">
	<div id="gmap_canvas" style="height: 300px; width: 500px;"></div>
	</div>
   </div>
    <br/>
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
  
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
       
<button type="submit" class="btn btn-success" id="btnSubmit">Create Location</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</div>
</form>
<script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>
<script type="text/javascript" src="../js/countrycity.js">
</script>


<script language="javascript">print_country("country");</script>
<script type="text/javascript">
	function validate(formObj)
	{
		var valid=true;
		if(formObj.country.value=="")
		{
			alert("please select the country");
			$("#country").focus();
			return false;
		}
		if(formObj.city.value=="")
		{
			alert("please select the city");
			$("#city").focus();
			return false;
		}
		if(formObj.locationType.value=="")
		{
			alert("please enter the location type");
			$("#locationType").focus();
			return false;
		}
		if(formObj.locationName.value=="")
		{
			alert("please enter the location Name");
			$("#locationName").focus();
			return false;
		}
		
		
		if(formObj.address.value=="")
		{
			alert("please enter the address");
			$("#address").focus();
			return false;
		}
		
		
		
		return valid;
		
	}
	

</script>


<script type="text/javascript"> 
function init_map(latitude,longitude,address){

var myOptions = {zoom:14,center:new google.maps.LatLng(latitude,longitude),mapTypeId: google.maps.MapTypeId.ROADMAP};
map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);
marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(latitude, longitude)});
infowindow = new google.maps.InfoWindow({content:address });
google.maps.event.addListener(marker, "click", function(){infowindow.open(map,marker);});
infowindow.open(map,marker);}

</script>

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript">
    
    
    <!--
        function GetLocation() {
        var valid=true;
        $('#divMap').css("display", "none"); 
        if($("#country").val()=="")
		{
			alert("please select the country");
			$("#country").focus();
			return false;
		}
		if($("#city").val()=="")
		{
			alert("please select the city");
			$("#city").focus();
			return false;
		}
		
		if($("#address").val()=="")
		{
			alert("please enter the address");
			$("#address").focus();
			return false;
		}
        
        if(valid)
           {
	            var geocoder = new google.maps.Geocoder();
	            var address = document.getElementById("locationName").value+","+document.getElementById("locationType").value+","+document.getElementById("address").value+","+document.getElementById("city").value+","+document.getElementById("country").value;
	            var daddress = document.getElementById("locationName").value+"<br/>"+document.getElementById("locationType").value+"<br/>"+document.getElementById("address").value+"<br/>"+document.getElementById("city").value+"<br/>"+document.getElementById("country").value;
	            
	            geocoder.geocode({ 'address': address }, function (results, status) {
	                if (status == google.maps.GeocoderStatus.OK) {
	                    var latitude = results[0].geometry.location.lat();
	                     var longitude = results[0].geometry.location.lng();
	                  
	                    $('#divMap').css("display", "block"); 
	                    init_map(latitude,longitude,daddress);
	
	                } else {
	                    alert("Request failed.");
	                    $('#divMap').css("display", "none"); 
	                    
	                }
	            });
            }
        };
        //-->
    </script>

	
