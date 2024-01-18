<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.VerifyFarmerModel"%>
<%@page import="com.jci.model.FarmerRegModelDTO"%>

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
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>

 <script src="https://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>  
 <script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js" type="text/javascript"></script>  
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />  
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <script type="text/javascript">
	$(document).ready(function ()  
	{  
		 $("#farmerVerific").DataTable({         
	         scrollX: true,
	         "pageLength": 50
	       }); 
	});  
 </script>  
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
                <h1 class="page-title">Farmer Verification</h1>
            </div>
			<%
				 List <FarmerRegModelDTO>  allFarmersList = (List <FarmerRegModelDTO>) request.getAttribute("allFarmersList");
			%>
                   <div class="table-responsive" style="margin-top: 20px;">                    
                        <table id="farmerVerific" class="table table-striped table-bordered table-hover" cellspacing="0"  >
								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Registration No</th>
										<th>Farmer Name</th>
										<th>Mobile No</th>
										<th>State</th>
										<th>District</th>
										<th>Block</th>
										<!-- <th>Land Holding</th> -->
										<th>Is verified</th>
										<!--<th>Registered By</th>-->
										<th>Verify</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
								<%
									int i = 1;
									for(FarmerRegModelDTO farmerRegModelList : allFarmersList){
								%>
									<tr role="row" class="odd">
									<td class="sorting_1"><%=i%></td>
									<td><%=farmerRegModelList.getRegno() %></td>
									<td><%=farmerRegModelList.getF_NAME() %></td> 
									<td><%=farmerRegModelList.getF_MOBILE() %></td>
									<td><%=farmerRegModelList.getState() %></td>
									<td><%=farmerRegModelList.getDistrict() %></td>
									<td><%=farmerRegModelList.getBlock() %></td>
									<td>
								<%
										if(farmerRegModelList.getIS_VERIFIED()==0){
											out.print("Not Verified");
										}else{
											out.print("Verified");
										}
										%>
										</td>
										<%-- <td><%=farmerRegModelList.getF_REG_BY() %></td> --%>
										<% 
											if(farmerRegModelList.getIS_VERIFIED()==0)
											{
										%>
												<td><a href="verifyFarmer2.obj?id=<%=farmerRegModelList.getF_ID()%>" class="btn btn-danger btn-sm btn-block">Verify</a></td>
										<% 
											}else{
										%>
												<td></td>
										<%
											}
										%>
										
										<% 
											if(farmerRegModelList.getIS_VERIFIED()==0)
											{
										%>
												<td><a href="editFarmerReg.obj?id=<%=farmerRegModelList.getF_ID()%>"/>Edit</a></td>
										<% 
											}else{
										%>
												<td></td>
										<%
											}
										%>
										
									<%--	<td>
											 <%
												if(farmerRegModelList.getIS_VERIFIED()==1){
											%>
												Verified
											<% 
												}
												else{
											%>
												<a href="verifyFarmer2.obj?id=<%=farmerRegModelList.getF_ID()%>" class="btn btn-danger btn-sm btn-block">Verify</a>
											<% 		
													
												}
											%> 
										</td> --%>
										
										
										<td><a href="deleteFarmer.obj?id=<%=farmerRegModelList.getF_ID()%>" onclick="return confirm('Are you sure you want to delete this item?');"><i class="btn btn-danger btn-sm btn-block"><i class="fa fa-trash" aria-hidden="true" style="font-size: 15px;"></i></a></td>
										</tr>
									<%
									i++; 
								}
								%>
									</tbody>
                        </table>
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
        /* $(function() {
            $('#example-table').DataTable({
                pageLength: 10,
                "scrollX": true
                //"ajax": './assets/demo/data/table_data.json',
                /*"columns": [
                    { "S": "name" },
                    { "data": "office" },
                    { "data": "extn" },
                    { "data": "start_date" },
                    { "data": "salary" }
                ]
            });
        }) */
        
        
    </script>
    
    <script>
	$(document).ready(function () {
    $('#farmerVerific tfoot th').each(function () {
        var title = $(this).text();
        $(this).html('<input type="text" placeholder="Search ' + title + '" />');
    });
 
     
});

</script>   
</body>

</html>
