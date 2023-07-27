
<style>
	.btn-reject {
    color: #fff;
    background-color: #E61D42;
    border-color: #E62D4F;
}
</style>
<br/>
<br/><br/>
<form action="" method="post">

      <h1 align="center">Operator Request Form</h1>
      <h3>OrganizationInfo</h3>
       <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Organization&nbsp;Country&nbsp;</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input   type="text" class="textbox" name="country" id="country"  size="30" value="${requestScope.operator.country}" />
           <input   type="hidden" class="textbox" name="customerId" id="customerId"  size="30" value="${requestScope.operator.customerId}" />
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
           <input   type="text" class="textbox" name="organizationName" id="organizationName"  size="30" value="${requestScope.operator.organizationName}" />
         </div>              
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Government&nbsp;Id&nbsp;</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
        <img alt="" src="../uploads/operatorrequest/${requestScope.operator.operatorRequestId}/${requestScope.operator.doc}" height="100" width="100">
         </div>              
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Year&nbsp;Established&nbsp;</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input   type="text" class="textbox" name="yearEstablished" id="yearEstablished"  size="30" value="${requestScope.operator.yearEstablished}" />
         </div>              
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>Organization&nbsp;Type&nbsp;</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input   type="text" class="textbox" name="organizationType" id="organizationType"  size="30" value="${requestScope.operator.organizationType}" />
         </div>              
    </div>
                    
   </div>
   <!-- end row -->
   <h3>Requester ContactInformation</h3>
   <!-- row  -->
   <div class="row">
    <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Requester&nbsp;Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" class="ctextbox" name="requesterName" id="requesterName"  size="15" readonly="readonly" value="${requestScope.operator.requesterName}" />
          <%--  <input type="text" class="ctextbox" name="email" id="email"  size="15" readonly="readonly" value="${requestScope.customer.email}" hidden="true"/> --%>
           <input type="text" class="ctextbox" name="countryCode" id="countryCode"  size="15" readonly="readonly" value="${requestScope.customer.countryCode}" hidden="true"/>
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
           <input   type="text" class="textbox" name="street" id="street"  size="30" value="${requestScope.operator.street}" />
         </div>              
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-2 control-label-left"><font color="red">*&nbsp;</font>City</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input   type="text" class="textbox" name="city" id="city"  size="30" value="${requestScope.operator.city}" />
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
          <input type="text" class="textbox" name="email" id="email"  size="30" value="${requestScope.operator.email}">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
    <!-- row  -->
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Primary&nbsp;E&nbsp;MobileNo</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" class="textbox" name="mobileNo" id="mobileNo"  size="30" value="${requestScope.operator.mobileNo}">
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->

 <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Comment</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <textarea rows="10" cols="30"  id="comment" name="comment">
         	
         </textarea>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
   		<input type="hidden" value="${requestScope.operator.operatorRequestId }" name="operatorRequestId" id="operatorRequestId"/>
     <input type="submit" class="btn btn-success btn-bold" id="btnAccept" name="status" value="Accept" />
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
          <input type="submit" class="btn btn-reject btn-bold" id="btnReject" name="status" value="Reject" />
         </div>
                          
    </div>
                    
   </div>
   
   <!-- end row -->
</form>