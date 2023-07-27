<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong>  Account has been ${param.s } successfully.
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
.ctextbox
{
	background-color:#C1C1C1;
}
.btn-control {
    color: #251F1F;
    background-color: #FFFFFF;
    border-color: #063BA5;
}
.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
</style>

<div>


	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive" >Account Kind </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select onchange="print_accountName('accountName',this.selectedIndex);" id="accountKind" name ="accountKind" class="form-control"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive btnlable">Account Name </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="accountName" name ="accountName" class="form-control">
           	<option value="">Select</option>
           </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive btnlable"> &nbsp;&nbsp; Account Id &nbsp;&nbsp; </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         
<input type="text" name="userId"  id="userId" class="form-control"/>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6" >
        <div  align="left">
        
<button  type="button" class="btn btn-success btn-bold" id="btnCheck">Check</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</div>
<div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid AccountId.
</div>
<div class="alert alert-danger fade in" id="divBasic" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> This Account should be Golden Registration.
</div>
         
<br/>
<div id="divCreate" style="display:none">
<form action="updateaccountstatus.htm" method="post">

	<!-- row  -->
   <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Full&nbsp;Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" class="ctextbox" name="fullName" id="fullName"  size="25" readonly="readonly" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Country</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" name="countrty" id="country" size="25" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
     <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> City</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" name="city" id="city"  readonly="readonly"  size="25"  />

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Account Status</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="status" name="status" readonly="readonly" class="ctextbox" size="25"/>
         
	
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  
   <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-6" align="center">
        <div class="form-group">
        <input type="hidden" name="customerId" id="customerId"/>
        <input type="hidden" name="userRoleId" id="userRoleId"/>
           <input type="submit" class="btn btn-control" id="btnPause" name="accountStatus" value="Pause" />
           <input type="submit" class="btn btn-control" id="btnBlock" name="accountStatus" value="Block" />
           <input type="submit" class="btn btn-control" id="btnActive" name="accountStatus" value="Active"  />
           <input type="submit" class="btn btn-control" id="btnStop" name="accountStatus" value="Stop" />
           <input type="button" class="btn btn-control" id="btnView" name="accountStatus" value="View" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->

</form>
</div>

<script type="text/javascript" src="../js/accountkindname.js">

</script>

<script language="javascript">print_accountKind("accountKind");</script>
<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		$('#divSuccess').css("display", "none"); 
		$('#divCreate').css("display", "none"); 
		$('#divInvalid').css("display", "none"); 
		$('#divBasic').css("display", "none"); 
			var userId = $('#userId').val();
			var accountKind = $('#accountKind').val();
			var accountName = $('#accountName').val();
			
			
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
			if(userId=="")
			{
				alert("please enter Account Id");
				$('#userId').focus()
				return false;
			}
			var data = 'userId='
					+ encodeURIComponent(userId)+'&accountKind='+ encodeURIComponent(accountKind)+'&accountName='+ encodeURIComponent(accountName);
					
			$.ajax({
				url : "checkaccountstatus.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					
					if(response.registrationType=="basic")
					{
							$('#divBasic').css("display", "block"); 
					}
					else
					{
						
						$('#divCreate').css("display", "block"); 
						$("#doc").val("");
						$("#city").val("");
						$("#fullName").val(response.fullName);
						$("#country").val(response.country);
						$("#city").val(response.city);
						$("#customerId").val(response.customerId);
						$("#userRoleId").val(response.userRoleId);
						$("#status").val(response.status);
						$("#btn"+response.status+"").attr('disabled',true);
						
						
					}
				
				},
				error : function(xhr, status, error) {
				
				
					$('#divInvalid').css("display", "block"); 
					
				}
			});
			return false;
		});
	
	
	});
</script>

	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong>  Account has been ${param.s } successfully.
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
.ctextbox
{
	background-color:#C1C1C1;
}
.btn-control {
    color: #251F1F;
    background-color: #FFFFFF;
    border-color: #063BA5;
}
.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
</style>

<div>


	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive" >Account Kind </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select onchange="print_accountName('accountName',this.selectedIndex);" id="accountKind" name ="accountKind" class="form-control"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive btnlable">Account Name </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="accountName" name ="accountName" class="form-control">
           	<option value="">Select</option>
           </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive btnlable"> &nbsp;&nbsp; Account Id &nbsp;&nbsp; </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         
<input type="text" name="userId"  id="userId" class="form-control"/>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6" >
        <div  align="left">
        
<button  type="button" class="btn btn-success btn-bold" id="btnCheck">Check</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</div>
<div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid AccountId.
</div>
<div class="alert alert-danger fade in" id="divBasic" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> This Account should be Golden Registration.
</div>
         
<br/>
<div id="divCreate" style="display:none">
<form action="updateaccountstatus.htm" method="post">

	<!-- row  -->
   <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Full&nbsp;Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" class="ctextbox" name="fullName" id="fullName"  size="25" readonly="readonly" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Country</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" name="countrty" id="country" size="25" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
     <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> City</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" name="city" id="city"  readonly="readonly"  size="25"  />

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Account Status</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="status" name="status" readonly="readonly" class="ctextbox" size="25"/>
         
	
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  
   <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-6" align="center">
        <div class="form-group">
        <input type="hidden" name="customerId" id="customerId"/>
        <input type="hidden" name="userRoleId" id="userRoleId"/>
           <input type="submit" class="btn btn-control" id="btnPause" name="accountStatus" value="Pause" />
           <input type="submit" class="btn btn-control" id="btnBlock" name="accountStatus" value="Block" />
           <input type="submit" class="btn btn-control" id="btnActive" name="accountStatus" value="Active"  />
           <input type="submit" class="btn btn-control" id="btnStop" name="accountStatus" value="Stop" />
           <input type="button" class="btn btn-control" id="btnView" name="accountStatus" value="View" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->

</form>
</div>

<script type="text/javascript" src="../js/manageraccountkindname.js">

</script>

<script language="javascript">print_accountKind("accountKind");</script>
<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		$('#divSuccess').css("display", "none"); 
		$('#divCreate').css("display", "none"); 
		$('#divInvalid').css("display", "none"); 
		$('#divBasic').css("display", "none"); 
			var userId = $('#userId').val();
			var accountKind = $('#accountKind').val();
			var accountName = $('#accountName').val();
			
			
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
			if(userId=="")
			{
				alert("please enter Account Id");
				$('#userId').focus()
				return false;
			}
			var data = 'userId='
					+ encodeURIComponent(userId)+'&accountKind='+ encodeURIComponent(accountKind)+'&accountName='+ encodeURIComponent(accountName);
					
			$.ajax({
				url : "checkaccountstatus.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					
					if(response.registrationType=="basic")
					{
							$('#divBasic').css("display", "block"); 
					}
					else
					{
						
						$('#divCreate').css("display", "block"); 
						$("#doc").val("");
						$("#city").val("");
						$("#fullName").val(response.fullName);
						$("#country").val(response.country);
						$("#city").val(response.city);
						$("#customerId").val(response.customerId);
						$("#userRoleId").val(response.userRoleId);
						$("#status").val(response.status);
						$("#btn"+response.status+"").attr('disabled',true);
						
						
					}
				
				},
				error : function(xhr, status, error) {
				
				
					$('#divInvalid').css("display", "block"); 
					
				}
			});
			return false;
		});
	
	
	});
</script>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong>  Account has been ${param.s } successfully.
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
.ctextbox
{
	background-color:#C1C1C1;
}
.btn-control {
    color: #251F1F;
    background-color: #FFFFFF;
    border-color: #063BA5;
}
.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
</style>

<div>


	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive" >Account Kind </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select onchange="print_accountName('accountName',this.selectedIndex);" id="accountKind" name ="accountKind" class="form-control"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive btnlable">Account Name </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="accountName" name ="accountName" class="form-control">
           	<option value="">Select</option>
           </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive btnlable"> &nbsp;&nbsp; Account Id &nbsp;&nbsp; </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         
<input type="text" name="userId"  id="userId" class="form-control"/>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6" >
        <div  align="left">
        
<button  type="button" class="btn btn-success btn-bold" id="btnCheck">Check</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</div>
<div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid AccountId.
</div>
<div class="alert alert-danger fade in" id="divBasic" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> This Account should be Golden Registration.
</div>
         
<br/>
<div id="divCreate" style="display:none">
<form action="updateaccountstatus.htm" method="post">

	<!-- row  -->
   <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Full&nbsp;Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" class="ctextbox" name="fullName" id="fullName"  size="25" readonly="readonly" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Country</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" name="countrty" id="country" size="25" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
     <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> City</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" name="city" id="city"  readonly="readonly"  size="25"  />

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Account Status</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="status" name="status" readonly="readonly" class="ctextbox" size="25"/>
         
	
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  
   <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-6" align="center">
        <div class="form-group">
        <input type="hidden" name="customerId" id="customerId"/>
        <input type="hidden" name="userRoleId" id="userRoleId"/>
           <input type="submit" class="btn btn-control" id="btnPause" name="accountStatus" value="Pause" />
           <input type="submit" class="btn btn-control" id="btnBlock" name="accountStatus" value="Block" />
           <input type="submit" class="btn btn-control" id="btnActive" name="accountStatus" value="Active"  />
           <input type="submit" class="btn btn-control" id="btnStop" name="accountStatus" value="Stop" />
           <input type="button" class="btn btn-control" id="btnView" name="accountStatus" value="View" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->

</form>
</div>

<script type="text/javascript" src="../js/accountkindname.js">

</script>

<script language="javascript">print_accountKind("accountKind");</script>
<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		$('#divSuccess').css("display", "none"); 
		$('#divCreate').css("display", "none"); 
		$('#divInvalid').css("display", "none"); 
		$('#divBasic').css("display", "none"); 
			var userId = $('#userId').val();
			var accountKind = $('#accountKind').val();
			var accountName = $('#accountName').val();
			
			
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
			if(userId=="")
			{
				alert("please enter Account Id");
				$('#userId').focus()
				return false;
			}
			var data = 'userId='
					+ encodeURIComponent(userId)+'&accountKind='+ encodeURIComponent(accountKind)+'&accountName='+ encodeURIComponent(accountName);
					
			$.ajax({
				url : "checkaccountstatus.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					
					if(response.registrationType=="basic")
					{
							$('#divBasic').css("display", "block"); 
					}
					else
					{
						
						$('#divCreate').css("display", "block"); 
						$("#doc").val("");
						$("#city").val("");
						$("#fullName").val(response.fullName);
						$("#country").val(response.country);
						$("#city").val(response.city);
						$("#customerId").val(response.customerId);
						$("#userRoleId").val(response.userRoleId);
						$("#status").val(response.status);
						$("#btn"+response.status+"").attr('disabled',true);
						
						
					}
				
				},
				error : function(xhr, status, error) {
				
				
					$('#divInvalid').css("display", "block"); 
					
				}
			});
			return false;
		});
	
	
	});
</script>

	
 --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong>  Account has been ${param.s } successfully.
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
.ctextbox
{
	background-color:#C1C1C1;
}
.btn-control {
    color: #251F1F;
    background-color: #FFFFFF;
    border-color: #063BA5;
}
.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
</style>

<div>


	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive" >Account Kind </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select onchange="print_accountName('accountName',this.selectedIndex);" id="accountKind" name ="accountKind" class="form-control"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive btnlable">Account Name </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="accountName" name ="accountName" class="form-control">
           	<option value="">Select</option>
           </select>
				
			
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive btnlable"> &nbsp;&nbsp; Account Id &nbsp;&nbsp; </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         
<input type="text" name="userId"  id="userId" class="form-control"/>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6" >
        <div  align="left">
        
<button  type="button" class="btn btn-success btn-bold" id="btnCheck">Check</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</div>
<div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid AccountId.
</div>
<div class="alert alert-danger fade in" id="divBasic" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> This Account should be Golden Registration.
</div>
         
<br/>
<div id="divCreate" style="display:none">
<form action="updateaccountstatus.htm" method="post">

	<!-- row  -->
   <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Full&nbsp;Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" class="ctextbox" name="fullName" id="fullName"  size="25" readonly="readonly" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Country</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" name="countrty" id="country" size="25" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
     <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> City</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" name="city" id="city"  readonly="readonly"  size="25"  />

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Account Status</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" id="status" name="status" readonly="readonly" class="ctextbox" size="25"/>
         
	
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  
   <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-6" align="center">
        <div class="form-group">
        <input type="hidden" name="customerId" id="customerId"/>
        <input type="hidden" name="userRoleId" id="userRoleId"/>
           <input type="submit" class="btn btn-control" id="btnPause" name="accountStatus" value="Pause" />
           <input type="submit" class="btn btn-control" id="btnBlock" name="accountStatus" value="Block" />
           <input type="submit" class="btn btn-control" id="btnActive" name="accountStatus" value="Active"  />
           <input type="submit" class="btn btn-control" id="btnStop" name="accountStatus" value="Stop" />
           <input type="button" class="btn btn-control" id="btnView" name="accountStatus" value="View" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->

</form>
</div>

<script type="text/javascript" src="../js/accountkindname.js">

</script>

<script language="javascript">print_accountKind("accountKind");</script>
<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		$('#divSuccess').css("display", "none"); 
		$('#divCreate').css("display", "none"); 
		$('#divInvalid').css("display", "none"); 
		$('#divBasic').css("display", "none"); 
			var userId = $('#userId').val();
			var accountKind = $('#accountKind').val();
			var accountName = $('#accountName').val();
			
			
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
			if(userId=="")
			{
				alert("please enter Account Id");
				$('#userId').focus()
				return false;
			}
			var data = 'userId='
					+ encodeURIComponent(userId)+'&accountKind='+ encodeURIComponent(accountKind)+'&accountName='+ encodeURIComponent(accountName);
					
			$.ajax({
				url : "checkaccountstatus.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					
					if(response.registrationType=="basic")
					{
							$('#divBasic').css("display", "block"); 
					}
					else
					{
						
						$('#divCreate').css("display", "block"); 
						$("#doc").val("");
						$("#city").val("");
						$("#fullName").val(response.fullName);
						$("#country").val(response.country);
						$("#city").val(response.city);
						$("#customerId").val(response.customerId);
						$("#userRoleId").val(response.userRoleId);
						$("#status").val(response.status);
						$("#btn"+response.status+"").attr('disabled',true);
						
						
					}
				
				},
				error : function(xhr, status, error) {
				
				
					$('#divInvalid').css("display", "block"); 
					
				}
			});
			return false;
		});
	
	
	});
</script>

	
 --%>