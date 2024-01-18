<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.BalePreparationModel"%>
<%@page import="com.jci.model.BalePreparation"%>
<%@page import="java.text.SimpleDateFormat"%>




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
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- PLUGINS STYLES-->
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
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
                <h1 class="page-title">Bale Preparation List</h1>
                 
            </div>
				
				<%
					List<BalePreparation> viewBalePreparation = (List<BalePreparation>) request.getAttribute("viewBalePreparation");
					//out.println(viewBalePreparation);
				
				%>
			 <div class="page-content fade-in-up">
                <div class="ibox">
                    <span>${msg}</span>
                    <div class="ibox-body">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>S.No.</th> 
										<th>Crop Year</th>
										<th>Bin Number</th> 										
										<th>Jute Variety</th>
										<th>Basis</th>
										<th>Slip No From</th>
										<th>Slip No To</th>
										<th>Bale No</th>
										<th>Packing Date</th>
										<th>Place Of Packing</th>
										<th>Jute Grade</th>
										<!-- <th></th>
										<th></th> -->
									</tr>
								</thead>
								<tbody>
									<% 
									int i= 1;
									for(BalePreparation balePreparationLists : viewBalePreparation){
									
									%>
									<tr>
										<td><%=i%></td>
										<td><%=balePreparationLists.getCrop_year()%></td>
										<td><%=balePreparationLists.getBin_no()%></td>
										<td><%=balePreparationLists.getJute_variety()%></td>
										<td><%=balePreparationLists.getBasis()%></td>
										<%-- <%
											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
											String dates= formatter.format(balePreparationLists.getPackingDate());
										%> --%>
										<td><%=balePreparationLists.getSlip_no_from()%></td>
										<td><%=balePreparationLists.getSlip_no_to()%></td>
										<td><%=balePreparationLists.getBale_no()%></td>
										<td><%=balePreparationLists.getPacking_date()%></td>
										<td><%=balePreparationLists.getPlace_of_packing()%></td>
										<td><%=balePreparationLists.getJute_grade()%></td>
			          					<td><a href="editBaleP.obj?id=<%=balePreparationLists.getBaleId()%>" class="btn btn-warning btn-sm btn-block">  <i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td>
				                     	<td><a  href="deleteBaleP.obj?id=<%=balePreparationLists.getBaleId()%>" onclick="return confirm('Are you sure you want to delete this item?');" class="btn btn-danger btn-sm btn-block">  <i class="fa fa-trash" aria-hidden="true" style="font-size: 15px;"></i></a></td>
									</tr>
									<% 
							i++; }
							%>
								</tbody>
   
                        </table>
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