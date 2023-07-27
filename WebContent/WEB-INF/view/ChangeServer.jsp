<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!-- Page Heading -->
                


                <div class="row">
                  <div class="col-md-3">${param.msg }</div>
                  <div class="col-md-6">
                     <form action="changeserver.htm" method="post" onsubmit="return validate(this)">
                          <div class="panel-body form-horizontal payment-form">
                              <div class="form-group">
                                  <label for="concept" class="col-md-3 control-label-left">Server&nbsp;URL
                                  	Old Url is 
                                  <sup><i class="fa fa-star star-color"></i></sup></label>
                                  <div class="col-md-9">
                                  	 ${applicationScope.serverUrl}
                                      <input type="text" class="form-control form-border" id="serverUrl" name="serverUrl" required>
                                  </div>
                              </div>
                              
                               <div class="form-group">
                                      <label for="amount" class="col-md-3 control-label-left"></label>
                                      <div class="col-md-9"> 
                                           <button type="submit" class="btn btn-success btn-bold">Chanage Server</button> 
                                           
                                      </div>
                               </div>
                               
                          </div>
                      </form>
                  </div>
                  <div class="col-md-3"></div>
                </div>
                <!-- /.row -->
 <script type="text/javascript">
 	function validate(formObj)
 	{
 		if(formObj.server.value=="")
 		{
 			alert("enter server url");
 			return false;
 			
 		}
 		return true;
 	}
 	
 </script>