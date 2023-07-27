<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty param.s}">
	<div class="alert alert-success fade in" id="divSuccess">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong>  ${param.p } has been ${param.s }ed successfully.
</div>
</c:if>
<style>
	.form-control {
	width:80%;
	}
	.btnlable
	{
		padding: 6px 2px;
	}
	.btn-lableinfo {
    color: #fff;
    background-color: #5B9BD5;
    border-color: #5B9BD5;
}


.ctextbox
{
	background-color:#C1C1C1;
}
.btn-control {
    color: #251F1F;
    background-color: #FFFFFF;
    border-color: #063BA5;
}
</style>
<div>
	<!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive">Page Name </label>
   
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
           <select  id="pageName" name ="pageName" class="form-control"></select>
		
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   
  
   <!-- row  -->
   <div class="row">
     <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="btn btn-lableinfo btn-pressure btn-sensitive">Page SNO </label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         
<input type="text" name="pageSNO"  id="pageSNO" class="form-control"/>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
  
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
        
<button type="button" class="btn btn-success" id="btnCheck">Check</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
</div>
<div class="alert alert-danger fade in" id="divInvalid" style="display:none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Error!</strong> In valid PageSNO.
</div>

         

<div id="divControl" style="display:none">
<form action="updatepagestatus.htm" method="post">
	
   <!-- row  -->
   <div class="row">
 
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Country</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" name="countrty" id="country" size="25" readonly="readonly"/>
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left"> City</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" name="city" id="city"   size="25"  readonly="readonly"/>

         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
   <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
     <label for="concept" class="col-xs-5 col-md-3 control-label-left">Page Status</label>
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
         <input type="text" class="ctextbox" id="status" name="status" size="25" readonly="readonly"/>
         
	
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
  
   <!-- row  -->
   <div class="row">
   
   
   <div class="col-xs-8 col-md-6" align="center">
        <div class="form-group">
        
        <input type="hidden" name="id" id="id"/>
        <input type="hidden" name="page" id="page"/>
           <input type="submit" class="btn btn-control" id="btnPause" name="pageStatus" value="Pause" />
           <input type="submit" class="btn btn-control" id="btnBlock" name="pageStatus" value="Block" />
           <input type="submit" class="btn btn-control" id="btnActive" name="pageStatus" value="Active"  />
           <input type="submit" class="btn btn-control" id="btnStop" name="pageStatus" value="Stop" />
           <input type="button" class="btn btn-control" id="btnView" name="pageStatus" value="View" />
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->

</form>
</div>

<script type="text/javascript">
var page_arr = new Array("Warehouse Page", "Machine Page", "Lock Page");

function print_page(pageName){

    //given the id of the <select> tag as function argument, it inserts <option> tags
    var option_str = document.getElementById(pageName);
    option_str.length=0;
    option_str.options[0] = new Option('Select','');
    option_str.selectedIndex = 0;
    for (var i=0; i<page_arr.length; i++) {
    option_str.options[option_str.length] = new Option(page_arr[i],page_arr[i]);
    }
}

</script>

<script language="javascript">print_page("pageName");</script>
<script type="text/javascript" src="../js/ajax/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
	
	
	$('#btnCheck').click(
		function(event) {
		$('#divSuccess').css("display", "none"); 
		$('#divControl').css("display", "none"); 
		$('#divInvalid').css("display", "none"); 
		
			var id = $('#pageSNO').val();
			var pageName = $('#pageName').val();
			if(pageName=="")
			{
				alert("please select PageName");
				$('#pageName').focus()
				return false;
			}
			
			if(id=="")
			{
				alert("please enter "+pageName+" SNO");
				$('#pageSNO').focus()
				return false;
			}
			
			var data = 'id='
					+ encodeURIComponent(id)+'&pageName='+ encodeURIComponent(pageName);
					
			$.ajax({
				url : "checkpagestatus.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
						$('#divControl').css("display", "block"); 
						$("#country").val(response.country);
						$("#city").val(response.city);
						$("#id").val(response.id);
						$("#status").val(response.status);
						$("#page").val(pageName);
						$("#btn"+response.status+"").attr('disabled',true);
						
						
						
					
				
				},
				error : function(xhr, status, error) {
					$('#divInvalid').css("display", "block"); 
				}
			});
			return false;
		});
		
		$('#btnView').click(
		function(event) {
			window.location="viewpage.htm?page="+$("#page").val()+"&id="+$("#id").val();
		});
	
	
	});
</script>

	
