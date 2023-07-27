<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.form-control {
	width: 60%;
}
</style>
<br />
<br />
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
		<a href="#" class="close" data-dismiss="alert">&times;</a>
		<strong>Success!</strong> Your Machine Price has been created
		successfully.
	</div>
</c:if>





<div id="divMachinePrice">

	<form action="createmachineprice.htm" method="post"
		onsubmit="return validate(this);">
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-5" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					New&nbsp;Price&nbsp;Details
				</label>

			</div>


		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Kind&nbsp;of&nbsp;Machine
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<select name="machineKind" id="machineKind" class="form-control">
						<option value="">
							Select
						</option>
						<option value="School Machine">
							School Machine
						</option>
						<option value="Masjid Machine">
							Masjid Machine
						</option>
						<option value="Normal Machine">
							Normal Machine
						</option>
					</select>
				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Machine&nbsp;Model
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<select name="machineModel" id="machineModel" class="form-control">
						<option value="">
							Select
						</option>
						<option value="1">
							M123
						</option>
						<option value="2">
							M4568
						</option>
						<option value="3">
							M7894
						</option>
					</select>
				</div>

			</div>

		</div>
		<!-- end row -->

		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Machine Price
				</label>

			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="price" id="price" class="form-control"
						onkeypress="javascript:return isNumber (event)"
						onkeyup="calcFinalPrice()" />
				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Discount
				</label>

			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="discount" id="discount"
						class="form-control"
						onkeypress="javascript:return isNumber (event)"
						onkeyup="calcFinalPrice()" />

				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Final Price
				</label>

			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="finalPrice" id="finalPrice"
						class="form-control" readonly="readonly" />
				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					StartDate
				</label>

			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="startDate" id="startDate"
						placeholder="DD-MM-YYYY" />

				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					EndDate
				</label>

			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="endDate" id="endDate"
						placeholder="DD-MM-YYYY" />

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

					<button type="submit" class="btn btn-success btn-bold"
						id="btnCheck">
						Save Machine Price
					</button>

				</div>

			</div>

		</div>
		<!-- end row -->







	</form>



</div>





<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
<script type="text/javascript">
	function validate(formObj)
	{
		
		if(formObj.machineKind.value=="")
		{
			valid=false;
			alert("please enter machineKind");
			$('#machineKind').focus()
			
			return false;
		}
		if(formObj.machineModel.value=="")
		{
			valid=false;
			alert("please enter machineModel");
			$('#machineModel').focus()
			
			return false;
		}
		
		if(formObj.price.value=="")
		{
			valid=false;
			alert("please enter price");
			$('#price').focus()
			
			return false;
		}
		else if(isNaN(formObj.price.value))
		{	valid=false;
			alert("please enter price correct number format");
			$('#price').focus()
		 	return false;
		}
		if(formObj.discount.value=="")
		{
			valid=false;
			alert("please enter discount");
			$('#discount').focus()
			
			return false;
		}
		else if(isNaN(formObj.discount.value))
		{	valid=false;
			alert("please enter discount correct number format");
			$('#discount').focus()
		 	return false;
		}
		if(formObj.startDate.value=="")
		{
			valid=false;
			alert("please enter startDate");
			$('#startDate').focus()
			
			return false;
		}
		else if(!validatedate(formObj.startDate))
		{
			return false;
		}
		else
		{
			var sdate=stripTime(getMyDateVaalue(formObj.startDate));
			var nowDate =stripTime(new Date());
			
			if(!(sdate>=nowDate))
			{
				alert("please enter startDate is greater than or equal to today date");
				$('#startDate').focus();
				return false;
			}
		}
		if(formObj.endDate.value=="")
		{
			valid=false;
			alert("please enter endDate");
			$('#endDate').focus()
			
			return false;
		}
		else if(!validatedate(formObj.endDate))
		{
			return false;
		}
		else
		{
			var sdate=stripTime(getMyDateVaalue(formObj.startDate));
			var edate=stripTime(getMyDateVaalue(formObj.endDate));
			
			if(!(edate>=sdate))
			{
				alert("please enter end Date is greater than or equal to start Date");
				$('#endDate').focus();
				return false;
			}
		}
		return true;
	}
</script>
<script>
    function calcFinalPrice()
    {
    	var disAmout=$("#price").val()*$("#discount").val()/100;
    	$("#finalPrice").val($("#price").val()-disAmout);
    }
    function isNumber(evt) {
        var iKeyCode = (evt.which) ? evt.which : evt.keyCode
        if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
            return false;
           
		
        return true;
    }
       
  function validatedate(inputText)
  {
	  var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\-]\d{4}$/;
	  // Match the date format through regular expression
	  if(inputText.value.match(dateformat))
	  {
		 
		  //Test which seperator is used '/' or '-'
		  var opera1 = inputText.value.split('/');
		  var opera2 = inputText.value.split('-');
		  lopera1 = opera1.length;
		  lopera2 = opera2.length;
		  // Extract the string into month, date and year
		  if (lopera1>1)
		  {
		  	var pdate = inputText.value.split('/');
		  }
		  else if (lopera2>1)
		  {
		  	var pdate = inputText.value.split('-');
		  }
		  var dd = parseInt(pdate[0]);
		  var mm  = parseInt(pdate[1]);
		  var yy = parseInt(pdate[2]);
		  // Create list of days of a month [assume there is no leap year by default]
		  var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31];
		  if (mm==1 || mm>2)
		  {
			  if (dd>ListofDays[mm-1])
			  {
				  alert('Invalid date format!');
				  return false;
			  }
		  }
		  if (mm==2)
		  {
			  var lyear = false;
			  if ( (!(yy % 4) && yy % 100) || !(yy % 400)) 
			  {
			  	lyear = true;
			  }
			  if ((lyear==false) && (dd>=29))
			  {
				  alert('Invalid date format!');
				  return false;
			  }
			  if ((lyear==true) && (dd>29))
			  {
				  alert('Invalid date format!');
				  return false;
			  }
		   }
		  }
		  else
		  {
			  alert("Invalid date format!");
			 inputText.focus();
			  return false;
	  }
	  return true;
  } 
  function getMyDateVaalue(inputText)
  {
  		  var opera1 = inputText.value.split('/');
		  var opera2 = inputText.value.split('-');
		  lopera1 = opera1.length;
		  lopera2 = opera2.length;
		  // Extract the string into month, date and year
		  if (lopera1>1)
		  {
		  	var pdate = inputText.value.split('/');
		  }
		  else if (lopera2>1)
		  {
		  	var pdate = inputText.value.split('-');
		  }
		  var dd = parseInt(pdate[0]);
		  var mm  = parseInt(pdate[1]);
		  var yy = parseInt(pdate[2]);
		  
		  return new Date(yy, mm - 1, dd)
  }
  function stripTime(inputDate) {
    var strippedInputDate = new Date(inputDate.getFullYear(), inputDate.getMonth() + 1, inputDate.getDate()); // Require to add one to the month as in JavaScript January is month 0
    return strippedInputDate;
  }
</script>

