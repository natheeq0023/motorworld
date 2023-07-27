<style>
	.form-control {
	width:60%;
	}
</style>
<br/>
<br/><br/>
<!-- row  -->
<form action="viewPartner.htm" method="post">
  <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;Sno</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="machineSno" name ="machineSno" readonly="readonly" class="form-control" value="${requestScope.machines.machineSno}"/>
         </div>              
    </div>          
   </div>
   <!-- end row -->
   <div class="row">
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;Kind </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="contractId" name ="contractId" readonly="readonly" class="form-control" value="${requestScope.machines.machineKind}"/>
         </div>                     
    </div>              
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;Model</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="partner1Id" name ="userRoleId" readonly="readonly" class="form-control" value="${requestScope.machines.machineModel}"/>
       </div>                 
   </div>             
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Machine&nbsp;Colour</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input  id="partner1Id" name ="userRoleId" readonly="readonly" class="form-control" value="${requestScope.machines.machineColour}"/>
         </div>             
    </div>               
   </div>
   <!-- end row -->
 <!-- row  -->
 
<%-- <div class="row">
<div class="col-xs-5 col-md-12" align="left">
<div class="form-group">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
     <input type="hidden" name="customerId" id="customerId"  value="${requestScope.operator.customerId}"/>
      <input type="hidden" name="operatorPartnerId" id="operatorPartnerId"  value="${requestScope.operator.operatorPartnerId}"/>
<button type="submit" class="btn btn-success btn-bold" id="btnAagree" name="status" value="Refuse">Delete</button> &nbsp;&nbsp;&nbsp;&nbsp;
<button type="submit" class="btn btn-success btn-bold" id="btnChnage"  name="status" value="Stop">Stop</button> &nbsp;&nbsp;&nbsp;&nbsp;
<button type="submit" class="btn btn-success btn-bold" id="btnChnage"  name="status" value="Pause">Pause</button> &nbsp;&nbsp;&nbsp;&nbsp;
</div>
</div>
</div> --%>
</form>
   <!-- end row -->
   