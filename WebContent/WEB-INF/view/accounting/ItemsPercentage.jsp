<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.lform-control {
    display: block;
    width: 50%;
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
</style>
<br/>
<br/>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Items Percentage has been created successfully.
</div>
</c:if>
<form action="itemspercentage.htm" method="post" onsubmit="return validate(this);">
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
     <label for="concept" class="control-label-left" >Item&nbsp;BarCode </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  type="text" id="itemBarcode" name ="itemBarcode" class="form-control "/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-6" align="right">
     <label for="concept" class="control-label-left" >Company Will Take From This Item For any Sale
 </label>
   
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
           <input  type="text" id="itemPercentage" name ="itemPercentage" class="lform-control" />
		
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
           <button type="submit" class="btn btn-success btn-bold">Save</button> 
                                           

				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   </form>
   <script type="text/javascript" src="../js/ajax/jquery.min.js">

</script>
<script type="text/javascript" src="../js/countrycity.js">
</script>

<script language="javascript">print_country("country");</script>
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
		if(formObj.city.value=="")
		{
			valid=false;
			alert("please enter city");
			$('#city').focus()
			
			return false;
		}
	
		if(formObj.itemBarcode.value=="")
		{
			valid=false;
			alert("please enter itemBarcode");
			$('#itemBarcode').focus()
			
			return false;
		}
		if(formObj.itemPercentage.value=="")
		{
			valid=false;
			alert("please enter itemPercentage");
			$('#itemPercentage').focus()
			
			return false;
		}
		
		return true;
	}
</script> 
   
