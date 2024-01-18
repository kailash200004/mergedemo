<!DOCTYPE html>
<html lang="en">


<%@page import="com.jci.model.RawJuteProcurementAndPayment"%>

<%@page import="java.util.List"%>

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
		 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<!-- PAGE LEVEL PLUGINS-->
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->

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
				<h1 class="page-title">Batch Identification Number(BIN)</h1>
			</div>
			
			<%
				List<String> allDpcList = (List) request.getAttribute("allDpcList");
			%>

			<%
			String dpcCenter = (String) session.getAttribute("dpc_center");

			String dpcid = (String) session.getAttribute("dpcId");

			String region_id = (String) session.getAttribute("region");

			int refid = (int) session.getAttribute("refId");
			%>
			
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">

							<div class="ibox-body">
								<form action="BinPurchasemapping_mid.obj" method="POST">
									<div class="row">
										<div class="col-sm-4 form-group">
											<label>Name of Dpc</label> 
											<select
												name="dpcname" id="dpcname"
												class="form-control">
											<option value="" required>-Select-</option>

											</select>
											<%-- <input id="dpcname"  readonly class="form-control"
												type="text" name="dpcname" value="<%=dpcCenter%>" placeholder="DPC Name" required> --%>
										</div>
										<div class="col-sm-4 form-group">
											<label>Crop Year</label> <select name="cropyr" id="cropyr"
												class="form-control">
												<option value="">-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
												<option value="2023-2024">2023-2024</option>
											</select>
										</div>
										 
										 <div class="col-sm-4 form-group">
                                            <label>Date of purchase</label><span class="text-danger">* </span>&nbsp;  
                                            <input class="form-control" type="date" name="datepurchase" id="datepurchase" placeholder="Date of Purchase">
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Select BIN Number</label> 
											<select name="binNo" id="binNo"
												class="form-control">
												<option value="">-Select BIN No-</option>
												
												 
											</select>
										</div>
										 </div>
										
                                        
                                        <div class="row col-sm-4 form-group">
                                        <button class="btn btn-default" type="submit" id="submit">Submit</button>
                                   		 </div>
								
					  
								</form>
								
								
								<div id="dvTable"></div>
								
								
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

	<script>
		$(function() {
			var dtToday = new Date();
			var month = dtToday.getMonth() + 1;
			var day = dtToday.getDate();
			var year = dtToday.getFullYear();
			if (month < 10)
				month = '0' + month.toString();
			if (day < 10)
				day = '0' + day.toString();
			var maxDate = year + '-' + month + '-' + day;
			$('#datepurchase').attr('max', maxDate);
		});
	</script>
	
	<script>
	$("#basis").on("change", function() {
		
		 
		
		var msp_no;
		var variety = (this.value);	
		if(variety=="msp"){
			msp_no = 1;
		}
		else if(variety=="commercial"){
			msp_no = 2;
		}
		$.ajax({
			type:"GET",
			url:"findJuteOnBasis.obj",
			data:{"msp_no":msp_no},
			success:function(result){
 				   var data= jQuery.parseJSON(result);
	 					 var html = "<option disabled selected value>-Select-</option>";
 				     for (var i = 0; i< data.length; i++){
 				    	 var sar = data[i]
 					 html += "<option value="+sar+">"+data[i]+"</option>"			
 				  } 
 				$("#jutevariety").html(html);
			}		
		});
	});
	</script>
	
	<script>
	$("#jutevariety").on("change", function() {
		var basis_no;
		var grade;
		var count=0;
		var data;
		var basis = document.getElementById("basis").value;	
		if(basis=="commercial")
			basis_no=2;
		else if(basis=="msp")
			basis_no=1;
		 var variety = (this.value);
			 $.ajax({
				type:"GET",
				url:"findGradeOnJuteVariety.obj",
				data: jQuery.param({ "variety": variety, "basis_no" : basis_no}) ,
				success:function(result){
					data = jQuery.parseJSON(result);
					count = data.length;
					$('#lblName').text('Enter Grade Details');
					 if(variety=='Bimli'){
						$('#form2 input').remove();
						$('#form2 label').remove();
					}else if(variety=="Mesta"){
						$('#form2 input').remove();
						$('#form2 label').remove();
					}
					 else{
						$('#form2 input ').remove();
						$('#form2 label').remove();
					} 
					
			        for (i=0;i<data.length;i++){
			        	$('<div class="form-group">').appendTo('#form2');
			        	$('<label/>').text(data[i]+" : ").appendTo('#form2');
			        	// $('<br/>').appendTo('#form2');
	 				    $('<input/>').attr({ type: 'text', id: 'grade'+i, name: 'grade'+i,value:'' }).appendTo('#form2');
	 				   $('</div>').appendTo('#form2');
	 				    //$('<br/>').appendTo('#form2');
			        }
	 			  } 		     
				});	
	});	
	</script>
	<!-- <script>
	$(document).ready(function(){
	  
	 var dpcCode= $("#dpcname").val();
	 
	 alert(dpcCode);
	 $.ajax({
 		url:"GetDpcName.obj",
 		type : 'GET',
 		data : {dpcCode : dpcCode},
 		success : function(data) {
 			$("#dpcname").val(data.replace(/\"/g, ""));
 		}
 	});
	});
</script> -->
	<script>
$("#cropyr").on("change", function() {
	var cropyr=document.getElementById("cropyr").value;
	  var dpcid=  document.getElementById("dpcname").value;
	//alert(cropyr);
	 $.ajax({
		   type:"GET",
		   url:"findBinno.obj",
		   data:jQuery.param({"cropyr":cropyr, "dpcid":dpcid}),
		   success:function(result){
			   var data= jQuery.parseJSON(result);
			   var html = "<option disabled selected value>-Select-</option>";
			     for (var i = 0; i< data.length; i++){
			    	 
				 html += "<option value=" +data[i]+">"+data[i]+"</option>"
				// alert(data);
			   }
			   $("#binNo").html(html);
		   
	   }
		   
	   }); 
});
</script>
	<script>

       $(document).ready(function(){
    	   var myVar = '<%=(String) session.getAttribute("region")%>';

							 // alert(myVar);

							$
									.ajax({
										type : "GET",
										url : "findDpcByRegion.obj",
										data : {"id" : myVar},
										success : function(result) {

											var data = jQuery.parseJSON(result);
											var html = "<option disabled selected value>-Select-</option>";
											for (var i = 0; i < data.length; i++) {
												console.log(data[i].split("-")[0]
																+ " "
																+ data[i]
																		.split("-")[1]);
												html += "<option value="
														+ data[i].split("-")[0]
														+ ">"
														+ data[i].split("-")[1]
														+ "</option>"
											}
											$("#dpcname").html(html);

										}

									});

						});
	</script>
<script>
$("#dpcname").on("change", function() {
	var cropyr=document.getElementById("cropyr").value;
	  var dpcid=  document.getElementById("dpcname").value;
	alert(cropyr);
	 $.ajax({
		   type:"GET",
		   url:"findBinno.obj",
		   data:jQuery.param({"cropyr":cropyr, "dpcid":dpcid}),
		   success:function(result){
			   var data= jQuery.parseJSON(result);
			   var html = "<option disabled selected value>-Select-</option>";
			     for (var i = 0; i< data.length; i++){
			    	 
				 html += "<option value=" +data[i]+">"+data[i]+"</option>"
				// alert(data);
			   }
			   $("#binNo").html(html);
		   
	   }
		   
	   }); 
});
</script>
<script>
	$("#binNO").on("change", function() {
		//alert('Hi from Bino');		 
		var binNo = document.getElementById("binNO").value;	
		var vstat=1;
		 //alert(basis);
			 $.ajax({
				type:"GET",
				url:"GetdetailsbasedonBinNo.obj",
				data : {
					binNo : binNo
				},
				success:function(result){
					data = jQuery.parseJSON(result);
					//alert(data.length);
			        var customers = new Array();
			        customers.push(["SL.no","Basis", "Jute Variety", "Net Qty", "Amount Payable","Garsate Rate","Carry-forward Loose Jute Qty","Carry-forward Rope Qty"]);
			        var j=0;
			        for (var i = 0; i <=data.length-1; i++) {
			        	j=j+1;
			        	customers.push([j, data[i][0], data[i][1],data[i][2],data[i][3],data[i][4],"<input  type='text'>","<input type='text'>"]);
			        }			        
			        var table = $("<table />");
			        table[0].border = "1";
			 		
			        var columnCount = customers[0].length;
			        var row = $(table[0].insertRow(-1));
			        for (var i = 0; i < columnCount; i++) {
			            var headerCell = $("<th />");
			            headerCell.html(customers[0][i]);
			            row.append(headerCell);
			        }
			        for (var i = 1; i < customers.length; i++) {
			            row = $(table[0].insertRow(-1));
			            for (var j = 0; j < columnCount; j++) {
			                var cell = $("<td />");
			                cell.html(customers[i][j]);
			                row.append(cell);
			            }
			        }
			        var dvTable = $("#dvTable");
			        dvTable.html("");
			        dvTable.append(table);


					 

	 			  } 		     
				});	
	});	
	</script>

</body>
</html>