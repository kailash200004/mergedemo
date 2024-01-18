<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.UserRoleModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page import="java.util.List"%>
<%@page import="com.jci.model.UserRegistrationModel"%>
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
                <h1 class="page-title">User Profile</h1>
                 
            </div>
				
				<%
					UserRegistrationModel userProfile = (UserRegistrationModel)request.getAttribute("profile");
				
					
				%>
			            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <span>${msg}</span>
                            <div class="ibox-body">
                                <form action="updatesaveuserProfile.obj" method="POST">
                                    <div class="row">
                      
                          <div class="col-sm-4 form-group">
                                            <label>User Name</label> 
                                            <input type ="hidden" name="id" value ="<%=userProfile.getRefid()%>">
											<input class="form-control" name="username" id="username" placeholder="User Name" value="<%=userProfile.getUsername()%>" >
                                        </div>
                                        <div class="col-sm-4 form-group">
                                        <label>Employee Id</label> 
										<input class="form-control" name="employeeid" placeholder="Employee Id" id="employeeid" value="<%=userProfile.getEmployeeid()%>" readonly>
											
										</div>
													<div class="col-sm-4 form-group">
                                            <label>Email</label>
                                            <input class="form-control" id="emailAddress"  name="emailAddress"  placeholder="Bin Email" value="<%=userProfile.getEmail()%>" readonly>
                                          
                                        </div>
										</div>
										<div class="row">
				
                                        <div class="col-sm-4 form-group">
                                             <label>Employee Name</label>
                                        <input class="form-control"  name="employeename" type="text" placeholder="Employee Name" id="employeename"" value="<%=userProfile.getEmployeename()%>" >
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Zone Name</label>

                                        	<%
												List<ZoneModel> zoneList = (List<ZoneModel>) request.getAttribute("zoneList");
											%>
											<select class="form-control" name="zone" id="zone">
												<option disabled selected value>-Select-</option>
												<%
													for(ZoneModel zoneLists : zoneList) {
												%>
												<option value="<%=zoneLists.getZonecode()%>"><%=zoneLists.getZonename()%></option>
												<%
													}
												%>
											</select>
										</div>
                                        <div class="col-sm-4 form-group">
											<label>Region Name</label>
                                        	<select class="form-control" name="region" id="region">
												<option disabled selected value>-Select-</option>
											</select></div>
                                    </div>
										   <div class="row">
							<div class="col-sm-4 form-group">
											<label>Center Name</label>
                                        	<select class="form-control" name="centerordpc" id="centerordpc">
												<option disabled selected value>-Select-</option>
											</select></div>
											
 										
												
										
												<div class="col-sm-4 form-group">
											<label>Mobile Number</label>
                                        	<input class="form-control"  id="mobile" name="mobile" placeholder="Mobile Number" value = "<%=userProfile.getMobileno()%>" >
										</div>
										
										<div class="col-sm-4 form-group">
											<label class="required">Role</label>  &nbsp;&nbsp;&nbsp; <span id="errType" name="errType" class="text-danger"> </span>
											<%
												List<UserRoleModel> roleList = (List<UserRoleModel>) request.getAttribute("roleList");
											%>
											<select class="form-control" name="role" id="role">
												<option disabled selected value>-Select-</option>
												<%
													for (UserRoleModel roleLists : roleList) {
												%>
												<option value="<%=roleLists.getRole_Id()%>"><%=roleLists.getRole_name()%></option>
												<%
													}
												%>
											</select>
										</div>
                                    </div>            
                                    <div class="row">
                                    <div class="col-sm-4 form-group">
											<label class="required">User Type</label> &nbsp;&nbsp;&nbsp; <span id="errUserType" name="errUserType" class="text-danger" > </span>
											<select class="form-control" name="usertype" id="usertype" required>
												<option disabled selected value>-Select-</option>
												<option>Web Portal</option>
												<option>Mobile Application</option>
											</select>
										</div>
                                    </div>                        
                                    <div class="form-group col-sm-12">
                                    <button class="btn btn-default" type="submit">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
		$("#zone").on("change", function() {
			var id = (this.value);
		
			if(id!=null){
				$.ajax({
					type:"GET",
					url:"findRoByZone.obj",
					data:{"id":id},
					success:function(result){				 
		 				var data= jQuery.parseJSON(result);
	 	 				var html = "<option disabled selected value>-Select-</option>";
		 				  for (var i = 0; i< data.length; i++){
		 					 html += "<option value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>"
		 				  }
		 				  //alert(html)
		 				$("#region").html(html);
					}			
				});
			}
		});
		
		$("#region").on("change", function() {
			var id = (this.value);	
			if(id!=null){
				$.ajax({
					type:"GET",
					url:"findDpcByRegion.obj",
					data:{"id":id},
					success:function(result){
		 				   var data= jQuery.parseJSON(result);
	 	 					 var html = "<option disabled selected value>-Select-</option>";
		 				     for (var i = 0; i< data.length; i++){
		 					 html += "<option value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>"
		 				  } 
		 				$("#centerordpc").html(html);
					}			
				});
			} 
		});
	</script>
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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