<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong> Your Account has been created successfully.
</div>
</c:if>
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

 <div class="row">
                    
                   
                   
                   
                   
                    <div class="col-xs-2 col-md-2" align="center">
                    <a class="btn btn-lableinfo btn-pressure btn-sensitive" href="createsalesman.htm">Create&nbspSalesMan</a>
                        
                    </div>
         </div>
 
 <c:if test="${requestScope.orders ne null}">
   <!-- row  -->
   <div class="row">
        <div class="col-md-9">
   <div id="no-more-tables">
            <table class="col-md-9 table-bordered table-striped table-condensed cf">
        		<thead class="cf">
        			<tr>
        				<th class="lbl-lableinfo" align="center">&nbsp;&nbsp;&nbsp;NO.</th>
        				
        				<th class="lbl-lableinfo" >Ordered Date</th>
        				<th class="lbl-lableinfo" >Status </th>
        				<th class="lbl-lableinfo" >View</th>
        				
        			</tr>
        		</thead>
        		<tbody>
        		<c:forEach items="${requestScope.userRole}" var="user" varStatus="st">
        			<tr>
        				<td>
        					${st.count }
        				</td>
        				
        				
        				<td>
        					${user.fullName }
        				</td>
        				<td>
        					${user.City}
        				</td>
        				<td>
        					${user.Country}
        				</td>
        				<td>
        					<a href="">View</a>
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
 
 
           