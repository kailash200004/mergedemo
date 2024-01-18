
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

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
                <h1 class="page-title">Entry of PCSO (Production Control cum Supply Order)</h1>
            </div>
            
            	<%
				
						List<EntryofpcsoModel> allentryofpcsolist = (List<EntryofpcsoModel>) request.getAttribute("entryofpcsolist");	
						
				%>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <div class="ibox-head">
								<span>${msg}</span>
							</div>
                            <div class="ibox-body">
                                <form action="entryofpcsosave.obj" method="POST">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>Reference.No.</label>
                                            <input class="form-control" type="text" name="referenceno" placeholder="Reference.No." required>
                                        </div>
                                        
										
										
										 <div class="col-sm-4 form-group">
											<label>Reference Date</label> 
											<input class="form-control" name="referencedate" id="referencedate"  placeholder="dd-mm-yyyy" readonly required>
										</div>
										
										
										
										 <div class="col-sm-4 form-group">
											<label>PCSO Date</label> 
											<input class="form-control" name="pcsodate" id="pcsodate"  placeholder="dd-mm-yyyy" readonly required>
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
							<% 
							int mill = 0;
							for(EntryofpcsoModel entryofpcsolist : allentryofpcsolist){
								
							%>
						      <div class="col-sm-4 form-group">
						      <input type="text" class="myname" name="millcode<%=mill%>" id="millcode<%=mill%>" value="<%=entryofpcsolist.getMill_code() %>" readonly>
							  </div>
							  <div class="col-sm-4 form-group">
							  <input type="text" class="myname" name="millname<%=mill%>" id="millname<%=mill%>" value="<%=entryofpcsolist.getMill_name() %>" readonly>
							  </div>
							  <div class="col-sm-4 form-group">
							  <input type="number" step = "any" class="myname" name="totalallocation<%=mill%>" id="totalallocation<%=mill%>">
							  </div>
							<% 
							mill++;
							
								  }  
							
							%>
								 <input name="count" id="count" type="hidden" value="<%=mill%>" >
                                                                       
                                    <div class="form-group col-sm-12">
                                        <button class="btn btn-default" type="submit" id="submit">Next</button>
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
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
 <script>
	$( "#referencedate" ).datepicker({ dateFormat: 'dd-mm-yy'    });
	$( "#pcsodate" ).datepicker({ dateFormat: 'dd-mm-yy'    });
</script>
   
    
      	<script type="text/javascript">
	$(document).ready(function(){
		 $("#submit").click(function(){
			 var referencedate = document.getElementById("referencedate").value;
			 var pcsodate = document.getElementById("pcsodate").value;

			 if(referencedate == "")
				 {
				 alert("Please Select Reference Date!!!");
				 return false;
				 }
			 if(pcsodate == "")
			 {
			 alert("Please Select pcsodate Date!!!");
			 return false;
			 }
		 });
	 });
	
	</script>
			
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


	<script src="./assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script
		src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- PAGE LEVEL PLUGINS-->
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>