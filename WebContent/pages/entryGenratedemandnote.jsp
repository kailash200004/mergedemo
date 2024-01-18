<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
                <h1 class="page-title">Entry of Genrate Demand Note</h1>
            </div>
            
            <% 
         // Author vishal
         
            %>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="saveentryofGenrateDeamand.obj" method="POST">
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                       <div class="col-sm-4 form-group">
	                                             <label>Contract No </label>
	                                              <span class="text-danger">* </span>&nbsp; <span id="Contract_No" name="Contract_No" class="text-danger"> </span>
	                                        	 <select name="Contract_No" id="Contract_No" class="form-control taxtbox" required>
	                                        		<option value="">-Select-</option>
	                                        		<option value="12345">12345</option>
	                                        		<option value="1234567">1234567</option>
	                                        		<option value="19764567">19764567</option>
	                                        	</select>
                                        </div>
                                        
                                        <div class="col-sm-4 form-group">
												<label>Contract Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Contract_Date" name="Contract_Date" class="text-danger"> </span>
												<input class="form-control" name="Contract_Date" id="Contract_Date" type="date" required>
										</div>
										 
		                                       
                                        <div class="col-sm-4 form-group">
												<label>Payment Due Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Payment_Due_Date" name="Payment_Due_Date" class="text-danger"> </span>
												<input class="form-control" name="Payment_Due_Date" id="Payment_Due_Date" type="date" required>
										</div>
										
										 
										
										
										
										
                                 </div>
                                    
                                   <div class="row">
                                   
                                   
                                   <div class="col-sm-4 form-group">
												<label>Payment / Cancellation Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Cancellation_Date" name="Cancellation_Date" class="text-danger"> </span>
												<input class="form-control" name="Cancellation_Date" id="Cancellation_Date" type="date" required>
										</div>
                                   <div class="col-sm-4 form-group">
												<label>Delay period </label> 
												<span class="text-danger">* </span>&nbsp; <span id="Delay_period " name="Delay_period" class="text-danger"> </span>
												<input class="form-control" name="Delay_period" id="Delay_period" type="text" required>
										</div>
                                   
                                           <div class="col-sm-4 form-group">
												    <label>Payment Ref</label>
												    <input class="form-control taxtbox" name="Payment_Ref" min="0" step="0.01" type="number" placeholder="Actual Qty" required>
												</div>
	                                                 <!-- <div class="col-sm-4 form-group">
														  <label>Actual Qty</label>
														    <input class="form-control taxtbox" name="Actual_Qty" min="0" step="0.01" type="number" placeholder="Actual Qty" required>
														</div>   -->    
                                    </div>
                                    
                                      <div class="row">
                                   
                                            <div class="col-sm-4 form-group">
	                                             <label>Contracted Qty </label>
	                                             <input class="form-control taxtbox" name="Contracted_Qty "  type="text" placeholder="Contracted_Qty" required>
	                                       </div>
                                   
                                          <div class="col-sm-4 form-group">
	                                             <label>Bale Mark</label>
	                                             <input class="form-control taxtbox" name="Bale_Mark"  type="text" placeholder="Bale Mark" required>
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
	                                             <label>Jute Variety Grade wise </label>
	                                             <input class="form-control taxtbox" name="juteewiseqty"   placeholder="Jute Variety Grade wise" required>
	                                       </div>
	                                       
	                                       <div class="col-sm-4 form-group">
	                                             <label>Crop Year </label>
	                                             <input class="form-control taxtbox" name="Crop_Year"  type="text" placeholder="Crop Year" required>
	                                       </div>
	                                     
	                                       
	                                       
	                                      
	                                       
                                    </div>
                                    
                                    <div class="row">
                                    
                                            <div class="col-sm-4 form-group">
	                                             <label>Quality Claim  </label>
	                                             <input type="checkbox" id="enableQualityClaim">
	                                             <select name="Quality_Claim" id="Quality_Claim" class="form-control taxtbox" required disabled>
	                                        		<option value="">-Select-</option>
	                                        		<option value="Grade-down">Grade-down</option>
	                                        		<option value="Moisture">Moisture</option>
	                                        		<option value="Short weight">Short weight</option>
	                                        	</select>
	                                       </div>
	                                        <div class="col-sm-4 form-group">
	                                             <label>Moisture Content</label>
	                                             
	                                             <select name="Moisture_Content" id="Moisture_Content" class="form-control taxtbox" required>
	                                        		<option value="">-Select-</option>
	                                        		<option value="Range 8-16">  Range 8-16</option>
	                                        		<option value="Range 16-24"> Range 16-24</option>
	                                        		<option value="Range 24-32"> Range 24-32</option>
	                                        		<option value="Range 32-40"> Range 32-40</option>
	                                        	
	                                        	</select>
	                                       </div>
	                                       
	                                        <div class="col-sm-4 form-group">
	                                             <label>NCV Percentage</label>

	                                             <select name="NCV_Percentage" id="NCV_Percentage" class="form-control taxtbox" required>
	                                        		<option value="">-Select-</option>
	                                        		<option value="Range 0-10">  Range 0-10</option>
	                                        	
	                                        	
	                                        	</select>
	                                       </div>
	                                      
										  
	                                       
                                         
										  
                                     </div>   
                                     
                                      
                                    <div class="row">
                                    <div class="col-sm-4 form-group">
	                                             <label>NCV Qty.</label>
	                                             <input class="form-control taxtbox" name="NCV_Qty." min="0"  step="0.01"  type="Text" placeholder="NCV Qty." required>
	                                       </div>
	                                       <div class="col-sm-4 form-group">
	                                             <label>MR No</label>
	                                             <input class="form-control taxtbox" name="MR_No" type="Text" placeholder="MR No" required>
	                                       </div>
	                                       
											<div class="col-sm-4 form-group">
												<label>MR Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="MR_Date" name="MR_Date" class="text-danger"> </span>
												<input class="form-control" name="MR_Date" id="MR_Date" type="date" required>
										</div>
	                                        
                                         
	                                       
                                    </div>
                                    <div class="row">
                                   <div class="col-sm-4 form-group">
	                                             <label>Mill Reciept Qty. </label>
	                                             <input class="form-control taxtbox" name="Mill_Reciept_Qty."  type="text" placeholder="Mill_Reciept_Qty." required>
	                                       </div>
	                                         <div class="col-sm-4 form-group">
	                                             <label>Short Qty  </label>
	                                             <input class="form-control taxtbox" name="Short_Qty"   placeholder="Short Qty" required>
	                                       </div>
	                                       <div class="col-sm-4 form-group">
												<label>HO Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="HO_Date" name="HO_Date" class="text-danger"> </span>
												<input class="form-control" name="HO_Date" id="HO_Date" type="date" required>
										</div>
                                           
                                   </div>
                                    <div class="row"> 
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit">
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
    
	$(document).ready(function(){
		 $("#submit").click(function(){
		
			  var contractdate = $("#Date_of_Shipment").val();
			  var instdate = $("#HO_Date").val();
			  var instdate1 = $("#MR_Date").val();
			  var paymenttype = $("#paymenttype").val();
			  
			  if(contractdate =="" || instdate =="" || instdate1 =="")
				  {
				    alert("Please select mandatory Fields!");
				  }
			  if(paymenttype =="letterofcredit")
				  {
					  var dateofship = $("#dateofship").val();
					  var dateofexpiry = $("#dateofexpiry").val();
					  if(dateofship =="" || dateofexpiry =="")
						  {
						    alert("Please select mandatory Fields!");
						  }
				  }
			  
		    });
	 });
	// Get the date input element
	const dateInput = document.getElementById("Date_of_Shipment");

	// Add an event listener to listen for changes in the input value
	dateInput.addEventListener("change", function() {
	    // Get the selected date in yyyy-mm-dd format
	    const selectedDate = this.value;

	    // Split the date into parts (year, month, day)
	    const dateParts = selectedDate.split("-");

	    // Rearrange the parts to create the desired format (dd-mm-yyyy)
	    const formattedDate = dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];

	    // Display the formatted date
	    document.getElementById("Date_of_Shipment").textContent = formattedDate;
	});

		
	</script>
    
    <script>
  $(document).ready(function() {
    // Get references to the checkbox and select elements
    const checkbox = $('#enableQualityClaim');
    const qualityClaimSelect = $('#Quality_Claim');
    
    // Add an event listener to the checkbox
    checkbox.change(function() {
      if (checkbox.is(':checked')) {
        qualityClaimSelect.prop('disabled', false);
      } else {
        qualityClaimSelect.prop('disabled', true);
      }
    });
  });
</script>
    
    <script type="text/javascript">
      function myFunction()  
	      {
    	  $("#doexpiry").hide();
    	  $("#dateofexpiry").hide();
    	  $("#doshipment").hide();
    	  $("#dateofship").hide();
    	  
	       // alert("69");
	      }
    </script>
    
     <script type="text/javascript">
     $("#autorevolvingoption").on("change", function() {
 		var autooption = $("#autorevolvingoption").val();
 		if(autooption == "no")
 			{
 			 $("#autorevolvingamount").hide();
 			 $("#autoamounta").hide();
 			}
 		else
 			{
 			 $("#autorevolvingamount").show();
 			$("#autoamounta").show();
 			}
 	 	});
    </script>
    
     <script type="text/javascript">
	$("#paymenttype").on("change", function() {
		var paymenttype = $("#paymenttype").val();
		if(paymenttype == "letterofcredit")
			{
			  $("#doexpiry").show();
	    	  $("#dateofexpiry").show();
	    	  $("#doshipment").show();
	    	  $("#dateofship").show();
			}
		else
			{
			  $("#doexpiry").hide();
	    	  $("#dateofexpiry").hide();
	    	  $("#doshipment").hide();
	    	  $("#dateofship").hide();
			}
		//alert(paymenttype);
	});
	</script>
		  
    
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
    
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>