<!DOCTYPE html>


<%@page import="java.util.HashMap"%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<!-- GLOBAL MAINLY STYLES-->
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
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
<!-- PAGE LEVEL STYLES-->
<style>
.required:after {
	content: " *";
	color: red;
}
</style>


</head>
<script type="text/javascript">
	var list = "";
	var data1 = "";
	var data2 = "";
	var data3 = "";
	var data4 = "";
	var data5 = "";
	const final_list = new Array();
	var pcso1;
	</script>

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
				<h1 class="page-title">Contract Generation PCSO Wise</h1>
			</div>

			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">

							<div class="ibox-body">
								<span>${msg}</span>
								<form action="savecontractgenerationPcsoWise.obj" method="POST">
									<div class="row">
									
									
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> 
											<% List<Date> pcso=(List<Date>)request.getAttribute("pcso");
											%>
											<select class="form-control pcso" name="pcso_date" id="pcso_date" required>
											<% for(int i=0; i< pcso.size(); i++){ %>
											<option value="<%= pcso.get(i) %>"><%=pcso.get(i) %>
											</option>
											<%} %>
											</select>
											

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> 
											<% List<Date> pcso2=(List<Date>)request.getAttribute("pcso");
											%>
											<select class="form-control  pcso" name="pcso2_date" id="pcso2_date" required>
											<% for(int i=0; i< pcso2.size(); i++){ %>
											<option value="<%= pcso2.get(i) %>"><%=pcso2.get(i) %>
											</option>
											<%} %>
											</select>
											

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> 
											<% List<Date> pcso3=(List<Date>)request.getAttribute("pcso");
											%>
											<select class="form-control pcso" name="pcso3_date" id="pcso3_date" required>
											<% for(int i=0; i< pcso3.size(); i++){ %>
											<option value="<%= pcso3.get(i) %>"><%=pcso3.get(i) %>
											</option>
											<%} %>
											</select>
											

										</div>
										</div>
										<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> 
											<% List<Date> pcso4=(List<Date>)request.getAttribute("pcso");
											%>
											<select class="form-control pcso" name="pcso4_date" id="pcso4_date" required>
											<% for(int i=0; i< pcso4.size(); i++){ %>
											<option value="<%= pcso.get(i) %>"><%=pcso.get(i) %>
											</option>
											<%} %>
											</select>
											

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> 
											<% List<Date> pcso5=(List<Date>)request.getAttribute("pcso");
											%>
											<select class="form-control pcso" name="pcso5_date" id="pcso5_date" required>
											<% for(int i=0; i< pcso5.size(); i++){ %>
											<option value="<%= pcso5.get(i) %>"><%=pcso5.get(i) %>
											</option>
											<%} %>
											</select>
											

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Contract Quantity</label> <input
												type="number" name="contract_Qty" id="contract_Qty"
												class="form-control" placeholder="Contract Quantity" required>
										</div>
										</div>
										<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">(Contract Number) BT- </label> <input
												class="form-control" name="contactnumber"
												id="contactnumber" type="number" placeholder="Contract Number"
												required>
										
									</div>
								
									<div class="col-sm-4 form-group">
											<label class="required">Contract Date</label> <input
												type="date" name="contract_date" id="contract_date"
												class="form-control" required>

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Crop Year</label> 
											<select name="crop_year" id="crop_year" class="form-control"
												required>
												<option disabled selected value>-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
												</select>
										</div>
										</div>
										<div class="row">
										
										<div id="list"></div>
										<div id="list1"></div>
										<div id="list2"></div>
										<div id="list3"></div>
										<div id="list4"></div>
										
										<!-- <table>
										<tr>
										<td>abc</td></tr>
										</table>
										</div> -->
										
										</div>
										<div class="row">
										<div class="col-sm-4 form-group">
											
											<label class="required">TD1</label>
											<input type="number" name="grade1" id="grade1"
												class="form-control"  />
												</div>
											<label class="required">TD2_W1</label>
											<input type="number" name="grade2" id="grade2"
												class="form-control"  />
												<label class="required">TD3_W2_M1_B1</label>
											<input type="number" name="grade3" id="grade3"
												class="form-control"  />
												<label class="required">TD4_W3_M2_B2</label>
											<input type="number" name="grade4" id="grade4"
												class="form-control"  />
												<label class="required">TD5_W4_M3_B3</label>
											<input type="number" name="grade5" id="grade5"
												class="form-control"  />
												<label class="required">TD6_W5_M4_B4</label>
											<input type="number" name="grade6" id="grade6"
												class="form-control"  />
												<label class="required">TD7_W6_M5_B5</label>
											<input type="number" name="grade7" id="grade7"
												class="form-control"  />
												<label class="required">TD8_W7_M6_B6</label>
											<input type="number" name="grade8" id="grade8"
												class="form-control"  />
												<label class="required">W8</label>
											<input type="number" name="grade9" id="grade9"
												class="form-control"  />
										</div>

										<!-- <div class="col-sm-4 form-group">
											<label class="required">Type of Delivery</label> <select type="text"
												name="delibry_type" id="delibry_type" class="form-control"
												required>
											<option disabled selected value>-Select-</option>
												<option value="Mill Delivery">Mill Delivery</option>
												<option value="Ex-Godown">Ex-Godown</option>
												</select>
										</div> -->
									</div>
									<div class="row">
										<div class="form-group">
											<button class="btn btn-success" type="submit">Submit</button>
										</div>
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



	<!-- PAGE LEVEL SCRIPTS-->
</body>
<script>	

 $("#pcso_date").on("change", function() {
	//alert("yes");
	pcso1= this.value;
	//alert(pcso);
	$.ajax({
		type:'GET',
		url:'pcso_details.obj',
		data:{"pcso":pcso1, "list":list},
		success: function(result){
			alert(result);
			var htmlTable='<table><tr><th></th></tr>';
			    data1= jQuery.parseJSON(result);
			   htmlTable+='<tr><th>Mill code</th><th>Mill Name</th><th>Total allocation</th></tr>';
			   for (i=0;i<data1.length;i++){
				   
				   htmlTable+='<tr><td style="text-align:center">'+data1[i]["mill_code"]+'</td><td style="text-align:center">'+data1[i]["name"]+'</td><td style="text-align:center">'+data1[i]["qty"]+'</td></tr>';
		        }
			   htmlTable+='</table>';
			   $("#list").html(htmlTable);
			  
		       
			
		}
	})
	
}); 
	</script>
	<script>
  $("#pcso2_date").on("change", function() {
	
	var pcso2= this.value;
	//alert(pcso);
	$.ajax({
		type:'GET',
		url:'pcso_details.obj',
		data:{"pcso":pcso2 , "list":list},
		success: function(d){
			alert(d);
			var htmlTable='<table border="3px"><tr><th></th></tr>';
			var htmlTable1='<table border="3px"><tr><th>PCSO2</th></tr>';
			   data2= jQuery.parseJSON(d);
			  const isame = [];
			  const jsame = [];
			  var j;
			  var i;
			 
			   htmlTable+='<tr><th style="text-align:center">Mill code</th><th style="text-align:center">Mill Name</th><th style="text-align:center">'+pcso1+'</th><th style="text-align:center">'+pcso2+'</th><th>Total</th></tr>';
			   for (i=0;i<data1.length;i++){
				   for (j=0;j<data2.length;j++){
				
					 if(data1[i]["mill_code"]==data2[j]["mill_code"]){
						// same[i] = data2[j]["mill_code"];
						isame.push(j);
						jsame.push(i);
						 htmlTable+='<tr><td style="text-align:center">'+data1[i]["mill_code"]+'</td><td style="text-align:center">'+data1[i]["name"]+'</td><td style="text-align:center">'+data1[i]["qty"]+'</td><td style="text-align:center">'+data2[j]["qty"]+'</td><td style="text-align:center">'+(data2[j]["qty"]+data1[i]["qty"])+'</td></tr>';
					 
					 
					}
			 }	 	 
		} 			
				   for (i=0;i<data2.length;i++){
					   for (var z=0; z<isame.length; z++){
						   if(i == z){
							   continue;
						   }
						   else{
							   htmlTable+='<tr><td style="text-align:center">'+data2[j]["mill_code"]+'</td><td style="text-align:center">'+data2[j]["name"]+'</td><td style="text-align:center">0</td><td style="text-align:center">'+data2[j]["qty"]+'</td></tr>';
					  		 }
					   }
				   }
					   for (j=0;j<data1.length;j++){
						   for (var z=0; z<jsame.length; z++){
							   if(j == z){
								   continue;
							   }
							   else{
								 
								   htmlTable+='<tr><td style="text-align:center">'+data1[i]["mill_code"]+'</td><td style="text-align:center">'+data1[i]["name"]+'</td><td style="text-align:center">'+data1[i]["qty"]+'</td><td style="text-align:center">0</td></tr>';	
							   }
						   }
						
					   }
					 
				   
			   	
			   
			
			   htmlTable+='</table>';
			   $("#list").html(htmlTable);
			  
		}   
			
		
	});
	
  });
	</script>
	<script>
 $("#pcso3_date").on("change", function() {
	
	var pcso= this.value;
	
	$.ajax({
		type:'GET',
		url:'pcso_details.obj',
		data:{"pcso":pcso, "list":list},
		success: function(result){
			
			var htmlTable='<table><tr><th></th></tr>';
			   var data3= jQuery.parseJSON(result);
			   for (i=0;i<data3.length;i++){
				   
				   htmlTable+='<tr><th>'+data3[i]["name"]+'</th></tr>';
		        }
			   htmlTable+='</table>';
			   $("#list2").html(htmlTable);
			  
		       
			
		}
	})
	
}); 
	
 $("#pcso4_date").on("change", function() {
	alert("yes");
	var pcso= this.value;
	//alert(pcso);
	$.ajax({
		type:'GET',
		url:'pcso_details.obj',
		data:{"pcso":pcso},
		success: function(result){
			//alert(result);
			var htmlTable='<table><tr><th></th></tr>';
			   var data4= jQuery.parseJSON(result);
			   for (i=0;i<data4.length;i++){
				   
				   htmlTable+='<tr><th>'+data4[i]+'</th></tr>';
		        }
			   htmlTable+='</table>';
			   $("#list3").html(htmlTable);
			  
		       
			
		}
	})
	
}); 

 $("#pcso5_date").on("change", function() {
	alert("yes");
	var pcso= this.value;
	
	//alert(pcso);
	$.ajax({
		type:'GET',
		url:'pcso_details.obj',
		data:{"pcso":pcso},
		success: function(result){
			//alert(result);
			var htmlTable='<table><tr><th></th></tr>';
			   var data5= jQuery.parseJSON(result);
			   for (i=0;i<data5.length;i++){
				   
				   htmlTable+='<tr><th>'+data5[i]+'</th></tr>';
		        }
			   htmlTable+='</table>';
			   $("#list4").html(htmlTable);
			  
		       
			
		}
	})
	
}); 


	</script>
</html>
