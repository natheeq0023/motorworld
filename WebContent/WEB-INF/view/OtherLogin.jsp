<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.errMsg}">
	<div class="alert alert-danger fade in" id="divInvalid" >
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> ${param.errMsg }
</div>
</c:if>

<c:if test="${not empty param.suMsg}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong>  ${param.suMsg }
</div>
</c:if>
<form action="otherlogin.htm" method="post" onsubmit="return validate(this);">
<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="control-label-left" >User&nbsp;Id </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  type="text" id="userId" name ="userId" class="form-control form-border"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="control-label-left" >Password </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  type="password" id="password" name ="password" class="form-control form-border"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="control-label-left" >Account&nbsp;Kind </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select onchange="print_accountName('accountName',this.selectedIndex);" id="accountKind" name ="accountKind" class="form-control form-border"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="control-label-left">Account&nbsp;Name </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="accountName" name="accountName" class="form-control form-border">
           	<option value="">Select</option>
           </select>
				
			
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
           <button type="submit" class="btn btn-success btn-bold">Login</button> 
                                           <u><a href="#">Forgot Password</a></u>

				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   </form>
   
   <script type="text/javascript">
   var acckind_arr = new Array("Company", "Other Account");
var acname_a = new Array();
acname_a[0]="";
acname_a[1]="MainManager|Manager|Administration|Accounting|Controller|Support|Calling Centre|Warehouse";
acname_a[2]="Agency|Salesman|Operator|Supplier|Charger|Partner";




function print_accountName(accountName, selectedIndex){
    var option_str = document.getElementById(accountName);
    option_str.length=0;    
    option_str.options[0] = new Option('Select','');
    option_str.selectedIndex = 0;
    var acname_arr = acname_a[selectedIndex].split("|");
    for (var i=0; i<acname_arr.length; i++) {
    option_str.options[option_str.length] = new Option(acname_arr[i],acname_arr[i]);
    
    }
    
}
function print_accountKind(accountKind){

    //given the id of the <select> tag as function argument, it inserts <option> tags
    var option_str = document.getElementById(accountKind);
    option_str.length=0;
    option_str.options[0] = new Option('Select','');
    option_str.selectedIndex = 0;
    for (var i=0; i<acckind_arr.length; i++) {
    option_str.options[option_str.length] = new Option(acckind_arr[i],acckind_arr[i]);
    }
}
   

</script>

<script language="javascript">print_accountKind("accountKind");</script>
<script type="text/javascript" src="js/ajax/jquery.min.js">
</script>

<script type="text/javascript">
	function validate(formObj)
	{
		var accountKind = $('#accountKind').val();
			var accountName = $('#accountName').val();
			
			var userId = $('#userId').val();
			var password=$('#password').val();
			if(userId=="")
			{
				alert("please enter UserId Id");
				$('#userId').focus()
				return false;
			}
			if(password=="")
			{
				alert("please enter password");
				$('#password').focus()
				return false;
			}
			if(accountKind=="")
			{
				alert("please select account kind");
				$('#accountKind').focus()
				return false;
			}
			if(accountName=="")
			{
				alert("please select Account Name");
				$('#accountName').focus()
				return false;
			}
			return true;
	}
</script>



<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.errMsg}">
	<div class="alert alert-danger fade in" id="divInvalid" >
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> ${param.errMsg }
</div>
</c:if>

<c:if test="${not empty param.suMsg}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong>  ${param.suMsg }
</div>
</c:if>
<form action="otherlogin.htm" method="post" onsubmit="return validate(this);">
<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="control-label-left" >User&nbsp;Id </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  type="text" id="userId" name ="userId" class="form-control form-border"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="control-label-left" >Password </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  type="password" id="password" name ="password" class="form-control form-border"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="control-label-left" >Account&nbsp;Kind </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select onchange="print_accountName('accountName',this.selectedIndex);" id="accountKind" name ="accountKind" class="form-control form-border"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="control-label-left">Account&nbsp;Name </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="accountName" name="accountName" class="form-control form-border">
           	<option value="">Select</option>
           </select>
				
			
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
           <button type="submit" class="btn btn-success btn-bold">Login</button> 
                                           <u><a href="#">Forgot Password</a></u>

				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   </form>
   
   <script type="text/javascript">
   var acckind_arr = new Array("Company", "Other Account");
var acname_a = new Array();
acname_a[0]="";
acname_a[1]="MainManager|Manager|Administration|Accounting|Controller|Support|Calling Centre|Warehouse";
acname_a[2]="Agency|Salesman|Operator|Supplier|Charger|Partner";




function print_accountName(accountName, selectedIndex){
    var option_str = document.getElementById(accountName);
    option_str.length=0;    
    option_str.options[0] = new Option('Select','');
    option_str.selectedIndex = 0;
    var acname_arr = acname_a[selectedIndex].split("|");
    for (var i=0; i<acname_arr.length; i++) {
    option_str.options[option_str.length] = new Option(acname_arr[i],acname_arr[i]);
    
    }
    
}
function print_accountKind(accountKind){

    //given the id of the <select> tag as function argument, it inserts <option> tags
    var option_str = document.getElementById(accountKind);
    option_str.length=0;
    option_str.options[0] = new Option('Select','');
    option_str.selectedIndex = 0;
    for (var i=0; i<acckind_arr.length; i++) {
    option_str.options[option_str.length] = new Option(acckind_arr[i],acckind_arr[i]);
    }
}
   

</script>

<script language="javascript">print_accountKind("accountKind");</script>
<script type="text/javascript" src="js/ajax/jquery.min.js">
</script>

<script type="text/javascript">
	function validate(formObj)
	{
		var accountKind = $('#accountKind').val();
			var accountName = $('#accountName').val();
			
			var userId = $('#userId').val();
			var password=$('#password').val();
			if(userId=="")
			{
				alert("please enter UserId Id");
				$('#userId').focus()
				return false;
			}
			if(password=="")
			{
				alert("please enter password");
				$('#password').focus()
				return false;
			}
			if(accountKind=="")
			{
				alert("please select account kind");
				$('#accountKind').focus()
				return false;
			}
			if(accountName=="")
			{
				alert("please select Account Name");
				$('#accountName').focus()
				return false;
			}
			return true;
	}
</script>


 --%>