<style>
	.form-control {
	width:60%;
	}
</style>
<br/>
<br/><br/>
<!-- row  -->
<form action="viewagreement.htm" method="post">
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Contract&nbsp;No </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="contractId" name ="contractId" class="form-control" value="${requestScope.operator.contractId}"/>
	
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Partner&nbsp;No.1&nbsp;ID </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="partner1Id" name ="userRoleId" class="form-control" value="${requestScope.operator.userRoleId}"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Kind&nbsp;Of&nbsp;Account </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="accountKind1" name ="accountKind1" class="form-control" value="Operartor"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Partner&nbsp;No.2&nbsp;ID </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="partner2Id" name ="partner2Id" class="form-control" value="${requestScope.operator.userId}"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Kind&nbsp;Of&nbsp;Account </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="accountKind1" name ="accountKind1" class="form-control" value="Customer"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Agreement% </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="agreementPercentage" name ="agreementPercentage" class="form-control" value="${requestScope.operator.percentage}"/>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">%Of </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="percentageOf" name ="percentageOf" class="form-control"/>
		</div>
   </div>
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">StartDate </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="startDate" id="startDate" placeholder="DD-MM-YYYY" value="${requestScope.operator.startDate}"/>
   </div>
   </div>
   </div>
   <!-- end row -->
		 <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">EndDate </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
          <input type="text" name="endDate" id="endDate" placeholder="DD-MM-YYYY" value="${requestScope.operator.enddate}"/>
		</div>
    </div>
    </div>
   <!-- end row -->
 <!-- row  -->
 
<div class="row">
<div class="col-xs-5 col-md-12" align="left">
<div class="form-group">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
     <input type="hidden" name="customerId" id="customerId"  value="${requestScope.operator.customerId}"/>
      <input type="hidden" name="operatorPartnerId" id="operatorPartnerId"  value="${requestScope.operator.operatorPartnerId}"/>
<button type="submit" class="btn btn-success btn-bold" id="btnAagree" name="status" value="Agree">Agree</button> &nbsp;&nbsp;&nbsp;&nbsp;
<button type="submit" class="btn btn-success btn-bold" id="btnCancel" name="status" value="Cancel">Cancel</button> &nbsp;&nbsp;&nbsp;&nbsp;
<button type="submit" class="btn btn-success btn-bold" id="btnChnage">Change</button> &nbsp;&nbsp;&nbsp;&nbsp;
</div>
</div>
</div>
</form>
   <!-- end row -->
   