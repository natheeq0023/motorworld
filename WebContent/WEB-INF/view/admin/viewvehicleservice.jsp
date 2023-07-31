<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.lbl-lableinfo {
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
.table-bordered {
    border: 1px solid #28137B;
}
.table-bordered>tfoot>tr>td {
    border: 1px solid #ddd;
}
tr {
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;
}
.table-striped>tbody>tr:nth-child(odd)>td, .table-striped>tbody>tr:nth-child(odd)>th {
    background-color: #CFDEEA;
}

.table-striped>tbody>tr:nth-child(even)>td, .table-striped>tbody>tr:nth-child(even)>th {
    background-color: rgb(232, 241, 249);;
}
.table-bordered>tbody>tr>td, .table-bordered>tbody>tr>th, .table-bordered>tfoot>tr>td, .table-bordered>tfoot>tr>th, .table-bordered>thead>tr>td, .table-bordered>thead>tr>th {
    border: 2px solid #FFF;
}
</style>


<form action="" method="post" onsubmit="return validate(this);" >
<!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-8" align="center">
        <div class="form-group">
           <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive">&nbsp;&nbsp;&nbsp;Vehicle Service Request &nbsp;&nbsp;&nbsp;</button> 
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <c:if test="${requestScope.orderDetails ne null}">
   <!-- row  -->
   <div class="row">
        <div class="col-md-9">
   <div id="no-more-tables">
            <table class="col-md-9 table-bordered table-striped table-condensed cf">
        		<thead class="cf">
        			<tr>
        				<th class="lbl-lableinfo" align="center">&nbsp;&nbsp;&nbsp;NO.</th>
        				
        				
        				 <th class="lbl-lableinfo" >
							Request Id 
						</th> 
        				<th class="lbl-lableinfo" >
							Vehicle Type
						</th>
						<th class="lbl-lableinfo">
							Vehicle Brand
						</th>
						<th class="lbl-lableinfo">
							 Model Name
						</th>
						<th class="lbl-lableinfo">
							 Year
						</th>
						<th class="lbl-lableinfo">
							 Area
						</th>
						<th class="lbl-lableinfo">
							Customer Name
						</th>
						
        				<th class="lbl-lableinfo">
							 Mobile number
						</th>
						<th class="lbl-lableinfo">
							 Created On 
						</th>
						<th class="lbl-lableinfo">
							 Comment 
						</th>
						<th class="lbl-lableinfo">
							Issue
						</th>
						<th class="lbl-lableinfo">
							 Updated On 
						</th>
						
        			</tr>
        		</thead>
        		<tbody>
        		<c:forEach items="${requestScope.orderDetails}" var="orderDetail" varStatus="st">
        			<tr>
        				<td>
        					${st.count }
        				</td>
        				 <td>
        					${orderDetail.vehicleSeviceRequestId}
        					
        				</td>
        				
        				<td>
        					${orderDetail.vtyqe }
        				</td>
        				<td>
        					${orderDetail.vbrand }
        				</td>
        				<td>
        					${orderDetail.vehicleName }
        				</td>
        				<td>
        					${orderDetail.vehicleYear }
        				</td>
        				<td>
        					${orderDetail.area }
        				</td>
        				<td>
        					${orderDetail.requesterName }
        				</td>
        				<td>
        					${orderDetail.mobileNo }
        				</td>
        				<td>
        					${orderDetail.createdOn }
        				</td>
        				
        				<td>
        					${orderDetail.comment }
        				</td>
        				<td>
        					${orderDetail.issues }
        				</td>
        				<td>
        					${orderDetail.updatedOn }
        				</td>
        				
        				
        			</tr>
        			
        			
        		
        		</c:forEach>
        			
        		</tbody>
        	</table>
        </div>
        </div>
        </div>
        <!-- end row  -->
        </c:if>
        <br/>
      
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Model Name</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" name="vehicleName"  value=${requestScope.vName }> 
         	
         
         </div>
                          
    </div>
                    
   </div>
   
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Year</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" name="vehicleYear" id="vehicleYear" value= ${requestScope.vyear }> 
         	
         
         </div>
                          
    </div>
                    
   </div>
  
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Issues</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <textarea rows="10" cols="30"  id="issues" name="issues">
         	
         </textarea>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
    <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> Comments</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <textarea rows="10" cols="30"  id="comment" name="comment">
         	
         </textarea>
         </div>
                          
    </div>
                    
   </div>
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
   		 <input type="submit" class="btn btn-success btn-bold" id="btnAccept" name="status" value="Completed" />
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
<%--        <input type="hidden" name="orderId" value="${requestScope.orderDetails.vehicleSeviceRequestId}">  --%>
          <input type="submit" class="btn btn-reject btn-bold" id="btnReject" name="status" value="Pending" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->

   </form>
   
   
 <script type="text/javascript">
	function validate(formObj)
	{
		
		if(formObj.comment.value=="")
		{
			valid=false;
			alert("please enter Comments");
			$('#comment').focus()
			
			return false;
		}
	
			if(formObj.issues.value=="")
		{
			valid=false;
			alert("please enter issues");
			$('#issues').focus()
			
			return false;
		}
		 if(formObj.vehicleYear.value=="")
		{
			valid=false;
			alert("please enter vehicle Year");
			$('#machineModel').focus()
			
			return false;
		}
		if(formObj.vehicleName.value=="")
		{
			valid=false;
			alert("please Capture vehicleName");
			$('#vehicleName').focus()
			
			return false;
		}
		
		
		return true;
	}
	
</script>