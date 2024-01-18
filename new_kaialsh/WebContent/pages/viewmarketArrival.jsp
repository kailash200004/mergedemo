<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.MarketArrivalModel"%>

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
 <script type="text/javascript">
	$(document).ready(function ()  
	{  
		 $("#example-table").DataTable({         
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
                <h1 class="page-title">Market Arrival Details</h1>
                 
            </div>
				
				<%
				
	            	
		            String dpcCenter = (String) session.getAttribute("dpc_center");
		            String dpcid = (String) session.getAttribute("dpcId");
		            	
		            	
		               //  List<String> farmerno= (List<String>) request.getAttribute("farmerNo");
		                // out.println("== "+farmerno);
						List<MarketArrivalModel> allmarketArrivalList = (List<MarketArrivalModel>) request.getAttribute("marketArrivalList");	
						
				%>
			 <div class="page-content fade-in-up">
                <div class="ibox">
                    <span>${msg}</span>
                    <div class="ibox-body">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>Sl.No</th>
										<!-- <th>Region Name</th>
										<th>DPC Name</th> -->
										<th>Basis</th>
										<th>Arrival Date</th>
										<th>Jute Variety</th>
										<th>Crop Year</th> 										
										<th>Arrived Quantity</th>
										<th>Minimum Moisture</th>
										<th>Maximum Moisture</th>
								
										<th>Grade1</th>
										<th>Grade2 </th>
										<th>Grade3 </th>
										<th>Grade4 </th>
										<th>Grade5 </th>
										<th>Grade6 </th>
										<th>Grade7 </th>
										<th>Grade8 </th>
										<th>Grade_rate1 </th>
										<th>Grade_rate2 </th>
										<th>Grade_rate3 </th>
										<th>Grade_rate4 </th>
										<th>Grade_rate5 </th>
										<th>Grade_rate6 </th>
										<th>Grade_rate7 </th>
										<th>Grade_rate8 </th>
										 

									</tr>
								</thead>
								<tbody>
									<% 
									int i= 1;
							for(MarketArrivalModel marketArrivalList : allmarketArrivalList){
								
								 if(i<=200){  
							%>
									<tr>
										<td><%=i%></td>
										<%-- <td><%=marketArrivalList.getRegionName()%></td>
										<td><%=marketArrivalList.getDpcnames()%></td> --%>
								        <td><%=marketArrivalList.getBasis()%></td>
				                    	<td><%=marketArrivalList.getDatearrival()%></td>

										 <td><%=marketArrivalList.getJutevariety()%>
										<td><%=marketArrivalList.getCropyr()%></td> 
										<td><%=marketArrivalList.getArrivedqty()%></td>
										<td><%=marketArrivalList.getMixmois()%></td>
										<td><%=marketArrivalList.getMaxmois()%></td>
									<td><%=marketArrivalList.getGrade1()%></td>
									<td><%=marketArrivalList.getGrade2()%></td>
									<td><%=marketArrivalList.getGrade3()%></td>
									<td><%=marketArrivalList.getGrade4()%></td>
									<td><%=marketArrivalList.getGrade5()%></td>
									<td><%=marketArrivalList.getGrade6()%></td>
									<td><%=marketArrivalList.getGrade7()%></td>
									<td><%=marketArrivalList.getGrade8()%></td>
									<td><%=marketArrivalList.getGrade_rate1()%></td>
									<td><%=marketArrivalList.getGrade_rate2()%></td>
									<td><%=marketArrivalList.getGrade_rate3()%></td>
									<td><%=marketArrivalList.getGrade_rate4()%></td>
									<td><%=marketArrivalList.getGrade_rate5()%></td>
									<td><%=marketArrivalList.getGrade_rate6()%></td>
									<td><%=marketArrivalList.getGrade_rate7()%></td>
									<td><%=marketArrivalList.getGrade_rate8()%></td>
									<%-- <td><a href="bnaDelete.obj?id=<%=marketArrivalList.getMrarefid()%>" class="btn btn-danger btn-sm btn-block" onclick="return confirm('Are you sure you want to delete this BNA')">Delete</a></td> 
									 --%>	
										<%-- <td><%=bnaList.getEnable()==1?"Active":"Inactive"%></td>
	--%>
 						 

									</tr>
									<% 
								  }  
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
    /*  $(function() {
            $('#example-table').DataTable({
                pageLength: 10,
                //"ajax": './assets/demo/data/table_data.json',
                /*"columns": [
                    { "S": "name" },
                    { "data": "office" },
                    { "data": "extn" },
                    { "data": "start_date" },
                    { "data": "salary" }
                ]
            });
        })*/
    </script>
</body>

</html>