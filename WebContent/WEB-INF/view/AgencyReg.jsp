<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
.ctextbox
{
	background-color:#C1C1C1;
}
.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
.btn-titlelableinfo {
    color: #292424;
    background-color: #F0AD4E;
    border-color: #F0AD4E;
    padding: 6px 35px;
}
</style>

	<!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-8">
        <div class="form-group">
            <label for="concept" class="btn btn-titlelableinfo btn-pressure btn-sensitive" >To &nbsp;become &nbsp;new&nbsp; Agency you should be golden &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>customer and he should confirm to be Agency
 </label>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->

 <div class="row">
                    
                   
                   
                    <div class="col-xs-5 col-md-6">
                       
                          
                          
                              <div class="form-group">
                                  <div class="">
                                      <input type="text" class="form-control" size="10"  id="userId"  name="userId" placeholder="User ID" required>
                                  </div>
                              </div>
                          
                       
                    </div>
                   
                    <div class="col-xs-2 col-md-2">
                        <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" id="btnCheck">Check</button> 
                    </div>
         </div>
 <div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid UserId.
</div>
<div class="alert alert-danger fade in" id="divBasic" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> This Account should be Golden Registration.
</div>
         
<div id="divAgenReg" style="display:none">
<form method="post" enctype="multipart/form-data" onsubmit="return validate(this);">
	<!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Full&nbsp;Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" class="ctextbox" name="fullName" id="fullName"  size="15" readonly="readonly" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Country</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="text" class="ctextbox" name="country" id="country" size="15" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> City</label>
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
         <input type="text" class="ctextbox" name="city" id="city"   size="15"  />

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   </form>
   </div>
   
   <script>
	$(document).ready(function() {
	
	$('#btnCheck').click(
		function(event) {
		
		$('#divAgenReg').css("display", "none"); 
		$('#divInvalid').css("display", "none"); 
		$('#divBasic').css("display", "none"); 
			var userId = $('#userId').val();
			
			if(userId=="")
			{
				alert("please enter User Id");
				$('#userId').focus()
				return false;
			}
			
			var data = 'userId='
					+ encodeURIComponent(userId);
					
			$.ajax({
				url : "checkagencyregaccount.htm",
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
						
						$('#divAgenReg').css("display", "block"); 
						$("#doc").val("");
						$("#city").val("");
						$("#fullName").val(response.fullName);
						$("#country").val(response.country);
						$("#city").val(response.city);
						$("#customerId").val(response.customerId);
						
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
   
   