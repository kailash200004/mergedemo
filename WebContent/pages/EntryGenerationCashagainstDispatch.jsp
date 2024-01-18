<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jci.model.GenrationDemandNoteModel"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.jci.model.GenrationDEmandDto"%>
<!DOCTYPE html>
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
<!-- PAGE LEVEL STYLES-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- CORE SCRIPTS-->

<style>
.required:after {
	content: " *";
	color: red;
}
</style>
</head>
<body class="fixed-navbar" onload="myFunction()">
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
				<h1 class="page-title"> Generation of Cash against Dispatch Document</h1>
			</div>

			<%
			GenrationDEmandDto genrationDemandNoteModel  = (GenrationDEmandDto) request.getAttribute("cotract_No");
			List<Object>getdataList1=(List<Object>)request.getAttribute("getdataList1");
			   
			
				String formattedDate = (String)request.getAttribute("formattedDate");
			
			
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span>${msg}</span>
							<div class="ibox-body">
								<form action="saveentryofGenrationCashDocument.obj" method="POST">
									<div class="row">
											<div class="col-sm-4 form-group">
												<label>BOS Date</label> <input
													class="form-control taxtbox" name="BOS_Date"
													id=" BOS_Date" min="0" step="0.01" type="date" 
													placeholder="BOS Date" required>
											</div>

											<div class="col-sm-4 form-group">
												<label>CAD Date</label> <span class="text-danger">*
												</span>&nbsp; <span id="CAD_Date"class="text-danger"> </span>
												 <input class="form-control" type="date" placeholder="CAD_Date"
													name="CAD_Date" id="CAD_Date" 
													 required>
											</div>


										</div>

										<div class="row">
											<div class="col-sm-4 form-group">
												<label>BOS No </label> <input
													class="form-control taxtbox" name="BOS_No" id="BOS_No" min="0"
													step="0.01"   type="text" 
													placeholder="BOS_No" required>
											</div>
										
											
										</div>
										
										<div class="row">
											<div class="col-sm-12 form-group">
												<input type="submit" value="Submit" class="btn btn-primary"
													id="submit">
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

	<script type="text/javascript">
		$(document).ready(function() {
			$("#submit").click(function() {

				var contractdate = $("#Contract_Date").val();
				var instdate = $("#Payment_Due_Date").val();
				var instdate1 = $("#Cancellation_Date").val();
				var paymenttype = $("#Unit_charge").val();
				var Remarks = $("#Remarks").val();

				if (contractdate == "" || instdate == "" || instdate1 == "" || paymenttype == "" || Remarks == "") {
					alert("Please select mandatory Fields!");
				}
			});
		});
		
					const dateInput = document.getElementById("Contract_Date");
					dateInput.addEventListener("change",function() {
							const selectedDate = this.value;
							const dateParts = selectedDate.split("-");
							const formattedDate = dateParts[2] + "-"+ dateParts[1] + "-" + dateParts[0];
							document.getElementById("Contract_Date").textContent = formattedDate;
						});
						const dateInput = document.getElementById("Payment_Due_Date");
						dateInput.addEventListener("change",function() {
							const selectedDate = this.value;
							const dateParts = selectedDate.split("-");
							const formattedDate = dateParts[2] + "-"
									+ dateParts[1] + "-" + dateParts[0];
							document.getElementById("Payment_Due_Date").textContent = formattedDate;
						});
					const dateInput = document.getElementById("Cancellation_Date");
					dateInput.addEventListener("change",function() {
							const selectedDate = this.value;
							const dateParts = selectedDate.split("-");
							const formattedDate = dateParts[2] + "-"
									+ dateParts[1] + "-" + dateParts[0];
							document.getElementById("Cancellation_Date").textContent = formattedDate;
						});
	</script>

	<script>
		$(document).ready(function() {
			const checkbox = $('#enableQualityClaim');
			const qualityClaimSelect = $('#Waiver_Approved_By');
			checkbox.change(function() {
				if (checkbox.is(':checked')) {
					qualityClaimSelect.prop('disabled', false);
				} else {
					qualityClaimSelect.prop('disabled', true);
				}
			});
		});
	</script>

	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
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