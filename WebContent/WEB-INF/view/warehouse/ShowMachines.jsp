<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <style>

.form-control {
	width:80%;
	background-color: #5B9BD5;
	color:#FFF;
	}
	.ctextbox
{
	background-color:#E48B0D;
	color: #fff;
}
.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}
</style> 

<div>
	
 
   
   <!-- end row -->
  
 
	
   
   <!-- row  -->
  
  
   <!-- row  -->
   
   <!-- end row -->
       <!-- row  -->
   <div class="row">
        <div class="col-md-9">
   <div id="tablediv">
            <table class="col-md-9 table-bordered table-striped table-condensed cf" id="countrytable">
        		<thead class="cf">
        			<tr>
        				<th class="lbl-lableinfo" align="center">&nbsp;&nbsp;&nbsp;NO.</th>
        				<th class="lbl-lableinfo" > Machine&nbsp;Model</th>
        				<th class="lbl-lableinfo" >Machine SNo</th>
        				<th class="lbl-lableinfo" >Price</th>
        				<th class="lbl-lableinfo" >Select</th>
        				
        			</tr>
        		</thead>
        		<tbody>
        		<c:forEach items="${requestScope.machinesForm}" var="machine" varStatus="st">
        			<tr>
        				<td>
        				
        					${st.count }
        				</td>
        				
        				<td>
        				   				
        					${machine.machineModel }
        				</td>
        				<td>
        					${machine.machineSno }
        				</td>
        				<td>
        					${machine.machineId }
        				</td>
        				<td>
        					<input type="checkbox">
        				</td>
        			</tr>
        			
        			
        		
        		</c:forEach>
        			
        		</tbody>
        	</table>
        </div>
        </div>
        </div>
        <!-- end row  -->
         <div class="row">
   <div class="col-xs-5 col-md-4" >
     <div class="form-group">
      
   
     </div>
     </div>
   
   <div class="col-xs-4 col-md-3">
        <div class="form-group">
        
		
         </div>
                          
    </div>
                    
   </div>
        <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-4" >
   
   
     <div class="form-group">
      <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Agency Id</button> 
       <input type="text" size="10" id="agencyId"/>
     </div>
     </div>
   
  
                    
   </div>
     <!-- row  -->
   <div class="row">
   <div class="col-xs-5 col-md-4" >
     <div class="form-group">
      <button type="button" class="btn btn-lableinfo btn-pressure btn-sensitive" >Complete Transfer</button> 
   
     </div>
     </div>
 
                    
   </div>
   <!-- end row -->
	
</div>




