<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<br/>


<form action="" method="post" onsubmit="return validate(this);">
<!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-8" align="center">
        <div class="form-group">
           <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive">&nbsp;&nbsp;&nbsp;Operator Order Request&nbsp;&nbsp;&nbsp;</button> 
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
        <br/>
        <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-8" align="center">
        <div class="form-group">
           <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive">&nbsp;&nbsp;&nbsp;Operator Details&nbsp;&nbsp;&nbsp;</button> 
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
   <div class="alert alert-danger fade in" id="divNo" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> This machine/lock is not available
</div>
   <!-- end row -->
   <c:if test="${requestScope.order.status=='Accept'}">
   <c:set value="1" var="orCount"/>
   <c:forEach items="${requestScope.orderDetails}" var="orderDetail" varStatus="st">
   		<c:forEach begin="1" end="${orderDetail.quantity }" >
   			<!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
    
        					<input type="text" value="${orderDetail.type }" id="type${orCount}" name="type${st.count}" readonly="readonly">
        					</div>
        						 <div class="col-xs-5 col-md-2" align="right">
        					<input type="text" value="${orderDetail.model}" id="model${orCount}" name="model${st.count}" readonly="readonly">
        					
        				
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <input type="text" id="sno${orCount}" name="${orderDetail.orderFor}Sno" placeholder="${orderDetail.orderFor}Sno" onblur="snoCheck(this)">
            <input type="hidden"  name="hsno" id="hsno${orCount}" value="">
            <c:set value="${orCount+1}" var="orCount"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   		</c:forEach>
   </c:forEach>
   
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
   		
   		 <input type="submit" class="btn btn-success btn-bold" id="btnAccept" name="status" value="Transfer" />
   </div>
   <div class="col-xs-5 col-md-2">
        <div class="form-group">
       	 <input type="hidden" name="orderId" value="${requestScope.order.orderId}">
         
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   </c:if>
   </form>
   <script type="text/javascript">
	function validate(formObj)
	{
		
		var allMachineSno = document.getElementsByName("machineSno");
		var mSno;
		
		var valid = true;
		for (var i = 0, max = allMachineSno.length; i < max; i++) {
		
		    if (allMachineSno[i].value=="") { 
		    	mSno=allMachineSno[i];
		    	
		       valid = false;
		       break;
		    }
		}
		if(!valid)
		{
			alert("please Enter MachineSNO");
			mSno.focus();
			return false;
		}
		
		var allLockSno = document.getElementsByName("lockSno");
		var lSno;
		
		var valid = true;
		for (var i = 0, max = allLockSno.length; i < max; i++) {
		
		    if (allLockSno[i].value=="") { 
		    	lSno=allLockSno[i];
		    	
		       valid = false;
		       break;
		    }
		}
		if(!valid)
		{
			alert("please Enter LockSNO");
			lSno.focus();
			return false;
		}
		
		var allhSno = document.getElementsByName("hsno");
		var sn;
		
		var valid = true;
		for (var i = 0, max = allhSno.length; i < max; i++) {
		
		    if (allhSno[i].value=="" || allhSno[i].value=="fail") { 
		    	sn="#sno"+(i+1);
		    	
		       valid = false;
		       break;
		    }
		}
		if(!valid)
		{
			alert("this machine/lock "+$(sn).val()+" is not avialable");
			$(sn).focus();
		    return false;
		}
		
	return true;
	}
	function snoCheck(obj)
	{
		
		$('#divNo').css("display", "none"); 	
   
				var cid=obj.id;
				var cname=obj.name;
				var cno=cid.substring(3);
				var lastIn=cname.length-cno.length-2;
				var tp=cname.substring(0,lastIn);
				var hid="#hsno"+cno;
				curl="check"+tp+"sno.htm";
				$(hid).val("");
				
				var data = tp+'Sno='
					+ encodeURIComponent(obj.value);
				$.ajax({
				url : curl,
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
					
					$(hid).val(response.msg);
					if(response.msg=="fail")
					{
						$('#divNo').css("display", "block"); 	
					}
					else
					{
						$('#divNo').css("display", "none"); 	
					}
					
				
				},
				error : function(xhr, status, error) {
					
					
				}
				
			});
			
			return false;
				
				
					
			
	
	}
	</script>