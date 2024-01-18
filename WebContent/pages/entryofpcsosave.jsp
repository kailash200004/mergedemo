
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.jci.model.EntryofpcsoModel"%>
<!DOCTYPE html>
<html lang="en">

<head>
		<style>
	.myname {
   width: 100%;
  height: 32px;
} 
 
	</style>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- PLUGINS STYLES-->
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
     <script src="https://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>  
</head>
<body class="fixed-navbar">
    <div class="page-wrapper">
        <!-- START HEADER-->
        <%@ include file="header.jsp"%>
        <!-- END HEADER-->
        <!-- START SIDEBAR-->
        <%@ include file="sidebar.jsp"%>
        <!-- END SIDEBAR-->
        <div class="content-wrapper">
            <!-- START PAGE CONTENT-->
            <div class="page-heading">
                <h1 class="page-title">Save Entry of PCSO</h1>
            </div>
            
            	<%
				
						List<EntryofpcsoModel> allentryofpcsolist = (List<EntryofpcsoModel>) request.getAttribute("entryofpcso");	
						
				%>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <div class="ibox-head">
								<span>${msg}</span>
							</div>
                            <div class="ibox-body">
                                <form action="saveentryofpcsodata.obj" method="POST">
                                <% 
                            double num = 0 , sum = 0;    
							int mill = 0;
                            int a = 1,b = 1;    
							for(EntryofpcsoModel entryofpcsolist : allentryofpcsolist){
								 if(a<=b)
                                 {
							%>
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>Reference.No.</label>
                                            <input class="form-control" name="refno" type="text" value="<%=entryofpcsolist.getReference_no()%>" readonly name="referenceno">
                                        </div>
                                        
                                         <div class="col-sm-4 form-group">
											<label>Reference Date</label> 
											<input class="form-control" name="refdate" type="text" value="<%=entryofpcsolist.getReference_date()%>" readonly name="referencedate">
										</div>
										
										 <div class="col-sm-4 form-group">
											<label>PCSO Date</label> 
											<input class="form-control" name="pcsodate" type="text" name="pcsodate" value="<%=entryofpcsolist.getPcso_date()%>" readonly>
										</div>
										 </div><br>
                                        <div class="row">
                                        <div class="col-sm-4 form-group">
                                             <label>Mill Code</label>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Mill Name</label>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Total allocation</label>
                                        </div>
                                        </div>
                                        <%
                                        a++;
                                        }
                                        %>
                               <div class="row">         
                                          <div class="col-sm-4 form-group">
						      <input type="text" class="myname" name="millcode<%=mill%>" id="millcode<%=mill%>" value="<%=entryofpcsolist.getMill_code() %>" readonly>
							  </div>
							  <div class="col-sm-4 form-group">
							  <input type="text" class="myname" name="millname<%=mill%>" id="millname<%=mill%>" value="<%=entryofpcsolist.getMill_name() %>" readonly>
							  </div>
							  <div class="col-sm-4 form-group">
							  <input type="text" class="myname" name="totalallocation<%=mill%>" id="totalallocation<%=mill%>" value="<%=entryofpcsolist.getTotal_allocation()%>" readonly>
							  </div>
                               </div>         
                                        
                                        <% 
							mill++;
                             
                            num = Double.parseDouble(entryofpcsolist.getTotal_allocation());
                            sum = sum + num;
                                        
							
								  }  
							
							%>
							<div class="row"> 
							<div class="col-sm-4 form-group">
							</div>
							<div class="col-sm-4 form-group">
							</div>
							<div class="col-sm-4 form-group">
							  <input type="text" class="myname" name="totalallocation" id="totalallocation<%=mill%>" value="Sum of total allocation = <%=sum%> " readonly>
							 </div>  
							 </div>                
							<input name="count" id="count" type="hidden" value="<%=mill%>" >
							 <input name="sumoftotalallocation" id="sumoftotalallocation" type="hidden" value="<%=sum%>" >
                                    <div class="form-group col-sm-12">
                                     <button class="btn btn-default"><a href="entryofpcso.obj">Reset</a></button>
                                        <button class="btn btn-default" type="submit" id="submit">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
        </div>
    </div>
    
    <div class="sidenav-backdrop backdrop"></div>
     
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    
      	<script type="text/javascript">
	$(document).ready(function(){
		 $("#submit").click(function(){
			
		 });
	 });
	
	</script>
			
		 }
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>