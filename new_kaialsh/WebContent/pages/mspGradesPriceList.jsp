<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.MSPPriceCalculationModel"%>

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
                <h1 class="page-title">MSP Grades Price Listing</h1>
				<%
				
					List<MSPPriceCalculationModel> priceList = (List<MSPPriceCalculationModel>) request.getAttribute("msppriceList");	
				%>
			 <div class="page-content fade-in-up">
                <div class="ibox">
                    <div class="ibox-head">
                        <div class="ibox-title">View MSP grades Price details</div>
                    </div>
                    <div class="ibox-body">
                      <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Jute Variety</th>
										<th>Crop-yr</th>
										<th>Grade 1</th>
										<th>Grade 2</th>
										<th>BGrade 3</th>
										<th>Grade 4</th>
										<th>Grade 5</th>
										<th> Grade 6</th>
											
								</thead>
								<tbody>
									<% 
									int i= 1;
									for(MSPPriceCalculationModel priceListing : priceList){
									%>
									<tr>
										<td><%=i%></td>
										<td><%=priceListing.getJute_variety()%></td>
										<td><%=priceListing.getCrop_yr()%></td>
										<td><%=priceListing.getGrade1()%></td>
				                    	<td><%=priceListing.getGrade2()%></td>
										<td><%=priceListing.getGrade3()%></td>
										<td><%=priceListing.getGrade4()%></td>
										<td><%=priceListing.getGrade5()%></td>
										<td><%=priceListing.getGrade6()%></td>
										
										
										
									</tr>
									<% 
							i++; }
							
							%>
								</tbody>
   
                        </table>
                    </div>
                </div>
                </div> 
            </div>
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
    <script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
                pageLength: 10,
                //"ajax": './assets/demo/data/table_data.json',
                /*"columns": [
                    { "S": "name" },
                    { "data": "office" },
                    { "data": "extn" },
                    { "data": "start_date" },
                    { "data": "salary" }
                ]*/
            });
        })
    </script>
</body>

</html>
