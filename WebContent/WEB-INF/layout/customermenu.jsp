 <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <span class="pull-left lang_conv" >
                  <button class="btn btn-warning">MOTOR</button>
                  <button class="btn btn-success">WORLD</button> 
                </span>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand mob_logo" href="">
                    <span>
<!--                         <b style="font-weight:bold;font-size:30px;color:purple">Form-29</b> -->
                       
                    <span>
                </a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav hide-on-mobile">
                 <li>
                    <a class="page-scroll" href="customerhome.htm">Home&nbsp;&nbsp;&nbsp;<font color="white">|</font></a>
                    
                </li>
               <li>
                <li>
                    <a class="page-scroll" href="aboutUs.htm">About Us&nbsp;&nbsp;&nbsp;<font color="white">|</font></a>
                </li>
            
                <li>
                    <a class="page-scroll" href="contactUs.htm" style="border:none;">Contact</a>
                </li> 
                <!--  
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Home <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a class="page-scroll" href="#">About Us</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="page-scroll" href="#">Site Map</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="page-scroll" href="#" style="border:none;">Contact</a>
                        </li>
                    </ul>
                </li>
                -->
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav" style="height:450px;background-color:#C1C1C1;padding-top:40px;margin-top:80px;">
                    <li class="active">
                        <a href="customerhome.htm"><i class="fa fa-fw fa-dashboard"></i> Home</a>
                    </li>
                    <li>
                        <a href="vehicleservice.htm"><i class="fa fa-fw fa-bar-chart-o"></i> Vehicle Service</a>
                    </li>
                    <li>
                        <a href="rtoService.htm"><i class="fa fa-fw fa-table"></i>RTO Services</a>
                    </li>
                    <li>
                        <a href="myorders.htm?cid=${sessionScope.authUser.customerId }"><i class="fa fa-fw fa-table"></i>My Request</a>
                    </li>
                     <li>
                  <!--        <a href="deliveryNote.htm"><i class="fa fa-fw fa-table"></i>Delivery Note</a>
                    </li>
                     <li>
                        <a href="agencyrequest.htm"><i class="fa fa-fw fa-table"></i>Traffic Fine </a>
                    </li>
                     -->
                    <li>
                        <a href="signout.htm"><i class="fa fa-fw fa-desktop"></i>Signout</a>
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
            <div style="background-color: #FFFFFF;width:100%;height:20px">
               
            </div>
             <div style="background-color:#5B9BD5;width:100%;height:25px">
             <!-- row  -->
   <div class="row">
  
   <div class="col-xs-2 col-md-2 hide-on-mobile" align="center">
    <font color="#FFFFFF"><strong>Welcome ${sessionScope.authUser.fullName }</strong></font>
   </div>
  <%--  <div class="col-xs-1 col-md-1 hide-on-mobile" style="border:1px solid #FFFFFF;background-color:#000000;width:2px;height:25px">
    
   </div>
    <div class="col-xs-2 col-md-2" align="center">
     
       <a href="profile.htm?cid=${sessionScope.authUser.customerId}&uid=${sessionScope.authUser.userId}"><font color="white"><strong>Account</strong></font></a>
   </div>
   <div class="col-xs-1 col-md-1" style="border:1px solid #FFFFFF;background-color:#000000;width:2px;height:25px">
    
   </div>
    <div class="col-xs-1 col-md-3 hide-on-mobile" align="center">
     <font color="#FFFFFF"><strong></strong></font>
   </div>
    <div class="col-xs-3 col-md-1" align="right" style="border:1px solid #FFFFFF;height:25px">
     <font color="#FFFFFF"><strong></strong></font>
   </div>
    <div class="col-xs-1 col-md-1" style="border:1px solid #FFFFFF;background-color:#000000;width:2px;height:25px">
    
   </div>
    <div class="col-xs-2 col-md-2" align="center">
     <font color="red"><strong></strong></font>
   </div>
   
                    
   </div> --%>
   <!-- end row -->
               
            </div>
            
        </nav>