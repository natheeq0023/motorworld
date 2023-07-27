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


<form action="" method="post">
<!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-8" align="center">
        <div class="form-group">
           <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive">&nbsp;&nbsp;&nbsp;Agency Order Request&nbsp;&nbsp;&nbsp;</button> 
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
							Type
						</th>
						<th class="lbl-lableinfo">
							Model
						</th>
						<th class="lbl-lableinfo">
							 Price
						</th>
						<th class="lbl-lableinfo">
							Discount
						</th>
						<th class="lbl-lableinfo">
							Final&nbsp;Price
						</th>
						<th class="lbl-lableinfo">
							Quantity
						</th>
						<th class="lbl-lableinfo">
							Total&nbsp;Cost
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
        					${orderDetail.type }
        				</td>
        				<td>
        					${orderDetail.model }
        				</td>
        				<td>
        					${orderDetail.price }
        				</td>
        				<td>
        					${orderDetail.discount }
        				</td>
        				<td>
        					${orderDetail.finalPrice }
        				</td>
        				<td>
        					${orderDetail.quantity }
        				</td>
        				<td>
        					${orderDetail.totalCost }
        				</td>
        				<c:set var="totalCost" value="${totalCost+orderDetail.totalCost}"/>
        				
        				
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
        <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-8" align="center">
        <div class="form-group">
           <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive">&nbsp;&nbsp;&nbsp;Agency Details&nbsp;&nbsp;&nbsp;</button> 
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Operator Name </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           ${requestScope.operator.fullName }
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">MobileNo </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           ${requestScope.operator.mobileNo }
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    
        <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-8" align="center">
        <div class="form-group">
           <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive">&nbsp;&nbsp;&nbsp;Shifting Address&nbsp;&nbsp;&nbsp;</button> 
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">warehouseSno </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           ${requestScope.warehouse.warehouseSno }
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Address </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
            ${requestScope.warehouse.address }
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
            ${requestScope.warehouse.city }
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Country </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
            ${requestScope.warehouse.country }
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
    <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">Ordered Date </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
            ${requestScope.order.createdOn }
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-md-2 control-label-left">TotalCost </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           ${totalCost }
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <c:if test="${requestScope.order.status=='Pending'}">
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
   		
     <input type="submit" class="btn btn-success btn-bold" id="btnAccept" name="status" value="Accept" />
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
       	 <input type="hidden" name="orderId" value="${requestScope.order.orderId}">
          <input type="submit" class="btn btn-reject btn-bold" id="btnReject" name="status" value="Reject" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   </c:if>
   </form>