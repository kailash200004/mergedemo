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
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
 
    <script>
    
	function binno_check(){
    	var finyr = $("#FinYear").val();
    	var binno = $("#binNO").val();
    	var fingain;
		var weightgain;
    	$.ajax({
    		type: 'GET',
    		url: 'calculateGainFromproc.obj',
    		data:{"FinYear":finyr, "binNO":binno},
    		success: function(result){
    			//alert(result);
    			var data= jQuery.parseJSON(result);
    		
    			// alert( fingain + " "+weightgain );
    			 $.ajax({
    				    
    		    		type: 'GET',
    		    		url: 'InsertBinDataTodb.obj',
    		    		data:{"FinYear":finyr, "binNO":binno,"FinGain":data[0][0], "WeightGain":data[0][1]},
    		    		success: function(data1){
    		    			
    		    		}
    		    	});	
    		    	
    		}
    	
    	});
    	
	}
    
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
                <h1 class="page-title">Fin Gain and Weight Gain</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            
                            <div class="ibox-body">
                                <form method="POST">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>Financial Year</label>
                                            <select class="form-control" name="FinYear"  id= "FinYear"  placeholder="Financial Year" required>
                                            <option disabled selected value>-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
												<option value="2022-2023">2023-2024</option>
												<option value="2022-2023">2024-2025</option>
												<option value="2022-2023">2025-2026</option>
												<option value="2022-2023">2026-2027</option>
												<option value="2022-2023">2027-2028</option>
												<option value="2022-2023">2028-2029</option>
												<option value="2022-2023">2029-2030</option>
												<option value="2022-2023">2030-2031</option>
                                            </select>
                                         </div>
                                         <div class="col-sm-4 form-group">
											<label>Bin Number</label>
											<span class="text-danger">* </span>&nbsp; <span id="errbinno" name="errbinno"
												class="text-danger"> </span>
                      
                                        	 <select class="form-control" name="binNO" id="binNO" onblur="binno_check()">
                                                                           <option disabled selected value>-Select-</option>
                                                                           <option  value="321">-321-</option>
                                                                     </select>
										</div>
                                    	
                                        
                                    </div>
                                     
                                    <div class="form-group">
                                        <button class="btn btn-default" type="submit" id="submit" >Submit</button>
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