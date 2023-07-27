<!-- row  -->
   <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Full&nbsp;Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         ${requestScope.customer.fullName }
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Email&nbsp;Id</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         ${requestScope.customer.email }
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Mobile Number</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         ${requestScope.customer.mobileNo }
         </div>
                          
    </div>
                    
   </div>
   <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Nationality</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         ${requestScope.customer.nationality }
         </div>
                          
    </div>
                    
   </div>
   <!-- image code start heare -->
    <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label">PhotoId</label>
   </div>
   <div class="col-xs-5 col-md-6">
            <div class="form-group">
        <img alt="" src="../uploads/${requestScope.customer.idProofFileName }" height="100" width="100">
         </div>
                       
    </div>
                    
   </div>
   
   
   <!--image code end heare  -->
   <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Date&nbsp;Birth</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         ${requestScope.customer.dateOfBirth }
         </div>
                          
    </div>
                    
   </div>
   
   <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Gender</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         ${requestScope.customer.gender }
         </div>
                          
    </div>
                    
   </div>
   <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label"> Created Date</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         ${requestScope.customer.createdOn }
         </div>
                          
    </div>
                    
   </div>
   
    <div class="row">
      <div class="col-xs-5 col-md-2" align="right">
  
   </div>
         <div class="col-xs-5 col-md-6">
        <div class="form-group">
       <a href="changeprofile.htm?cid=${sessionScope.userRole.customerId}&uid=${sessionScope.userRole.userRoleId}"><font color="red"><strong>Change Profile</strong></font></a>
         </div>
                          
    </div>              
   </div>
   