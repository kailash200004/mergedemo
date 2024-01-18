<%@page import="com.jci.model.ImageVerificationModel"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="java.net.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
     <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <!-- PLUGINS STYLES-->
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
<style>
.scrollmenu {

  overflow: auto;
  white-space: nowrap;
}

.scrollmenu a {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}
</style>
 <script src="https://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>  
 <script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js" type="text/javascript"></script>  
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" /> 
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script> 
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.7.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.print.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.7.1/css/buttons.dataTables.min.css"> 
 
 <script>
  function Geturlvalue()
  {
	 
  }
 </script>
 <!-- ................Scripting........... -->
 
 
</head>

<body class="fixed-navbar" onload="Geturlvalue()">
    <div class="page-wrapper">
        <!-- START HEADER-->
        <!-- END HEADER-->
        <!-- START SIDEBAR-->
        <!-- END SIDEBAR-->
        <div class="content-wrapper">
            <!-- START PAGE CONTENT-->
                 
            
            <%
            String farmerno =(String)request.getSession().getAttribute("farmerno");
        	List<ImageVerificationModel> imageslist = (List<ImageVerificationModel>) request.getAttribute("images");
            String mandate = "";
            String bankdoc = "";
            String idproof = "";
            String regform = "";
            String tallyImage = "";
            String tallyno = "";
           // URL url = new URL(request.getRequestURL().toString());
          //  String urlvalue = url.getFile();
			for(ImageVerificationModel images : imageslist )
			{
			 tallyno = images.getGettally();
             mandate = images.getF_DOC_Mandate();
             bankdoc = images.getF_BANK_DOC();
             idproof = images.getF_ID_PROF();
             regform = images.getF_REG_FORM();
             tallyImage = images.getSlip_image();
             
			}
				 
			  if(farmerno == null)
			  {
				%>
             <h1 class="page-title" class="center">Verify Tally Slip Image</h1>
               <div class="row">
		            <label class="center">Tally Slip Image</label><br><br>
		            <img src="http://49.50.79.121:8080/TallySlip/<%=tallyImage%>" style=" width: 600px;  height: 400px;"/>
	            </div>
	            <%
			  }else
			  {
	            %>
            <h1 class="page-title" class="center">Verify Farmer Images</h1>
	            <div class="row">
		            <label class="center">Farmer mandate Image</label><br><br>
		            <img src="http://49.50.79.121:8080/FarmerRegistration/<%=mandate%>" style=" width: 600px;  height: 400px;"/><br>
	            </div>
	             <div class="row">
		            <label class="center">Farmer Bank Document</label><br><br>
		            <img src="http://49.50.79.121:8080/FarmerRegistration/<%=bankdoc%>" style=" width: 600px;  height: 400px;"/><br>
	            </div>
	             <div class="row">
		            <label class="center">Farmer Id Proof</label><br><br>
		            <img src="http://49.50.79.121:8080/FarmerRegistration/<%=idproof%>" style=" width: 600px;  height: 400px;"/><br>
	            </div>
	             <div class="row">
		            <label class="center">Farmer Registration Form</label><br><br>
		            <img src="http://49.50.79.121:8080/FarmerRegistration/<%=regform%>" style=" width: 600px;  height: 400px;"/><br>
	            </div>
	          <%
			  }
	          %>
            
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
        </div>
    </div>
    <!-- BEGIN THEME CONFIG PANEL-->
     
    <!-- END THEME CONFIG PANEL-->
    <!-- BEGIN PAGA BACKDROPS-->
    <div class="sidenav-backdrop backdrop"></div>
    
    <!-- END PAGA BACKDROPS-->
       
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
</body>

</html>