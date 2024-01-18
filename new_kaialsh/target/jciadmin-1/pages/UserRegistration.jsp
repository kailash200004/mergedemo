<%@page import="com.jci.model.UserRoleModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<%@ page import="javax.servlet.http.HttpServletRequest"%>
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
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/resources/css/styleUserReg.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/responsivevoice.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/custom.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/jquery.mCustomScrollbar.concat.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/jquery.validate.min.js'></script>
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
.field-icon {
  float: right;
  margin-left: -25px;
  margin-top: -25px;
  position: relative;
  z-index: 2;
}

.container{
  padding-top:50px;
  margin: auto;
}

 .required:after {
    content:" *";
    color: red;
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
				<h1 class="page-title">User Registration</h1>
			</div>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div class="ibox-head">
								<!-- <div class="ibox-title">Basic form</div> -->
								<span>${msg}</span>
							</div>
							<div class="ibox-body">
								<form action="saveUserMid.obj" method="POST" name="myForm"  onsubmit="return validate()" >
								<input type="hidden" name="emailCheck" id="emailCheck">
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">EMS Name</label>  &nbsp;&nbsp;&nbsp; <span id="errName" name="errName" class="text-danger"> </span>
											<input class="form-control" name="username" id="username" type="text" placeholder="EMS Name" value="" oninput="allow_alphabets(this)" onkeyup="deleteErrorMsg">
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">EMS Password</label>  &nbsp;&nbsp;&nbsp; <span id="errPass" name="errPass" class="text-danger"> </span>
											<input id="password" type="password" class="form-control" name="password" value="" placeholde="Password" >
											 <span toggle="#password" class="fa fa-fw fa-eye field-icon toggle-password"></span>
										</div>
										<div class="col-sm-4 form-group"> 
											<label class="required" class="required">Is HO</label> &nbsp;&nbsp;&nbsp; <span id="errho" name="errho" class="text-danger"> </span> 
											<select class="form-control" name="ho" id="ho">
												<option disabled selected value>-Select-</option>
												<option value="1">Yes</option>
												<option value="0">No</option>
											</select>
										</div>
									</div>
									<div class="row">
										
										<div class="col-sm-4 form-group">
											<label id="zoneLabel" class="required">Zone</label>  &nbsp;&nbsp;&nbsp; <span id="errZone" name="errZone" class="text-danger"> </span>
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
											<!-- <input class="form-control" type="text" name="zone" placeholder="Zone"> -->
										</div>
										<div class="col-sm-4 form-group">
											<label id="regionLabel" class="required">Region</label>&nbsp;&nbsp;&nbsp; <span id="errRegion" name="errRegion" class="text-danger"> </span>
											<!-- <input class="form-control" type="text" name="region" placeholder="Region" required> -->
											<select class="form-control" name="region" id="region">
												<option disabled selected value>-Select-</option>
											</select>
										</div>
										<div class="col-sm-4 form-group">
											<label id="dpclabel" class="required">DPC</label> &nbsp;&nbsp;&nbsp; <span id="errDPC" name="errDPC" class="text-danger"> </span>
											<select class="form-control" name="centerordpc" id="centerordpc">
												<option disabled selected value>-Select-</option>
											</select>
										</div>
									</div>
									<div class="row">
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
										
										<div class="col-sm-4 form-group">
											<label class="required">EMP ID</label>  &nbsp;&nbsp;&nbsp; <span id="errID" name="errID" class="text-danger"> </span>
											<input class="form-control" name="employeeid" type="text" placeholder="Employee Id" id="employeeid">
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">EMP Name</label>  &nbsp;&nbsp;&nbsp; <span id="errEMP" name="errEMP" class="text-danger"> </span>
											<input class="form-control" name="employeename" type="text" placeholder="Employee Name" id="employeename">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">EMP Email</label> &nbsp;&nbsp;&nbsp; <span id="errEmail" name="errEmail" class="text-danger"> </span>
											<input class="form-control" autocomplete="off" type="text"  id="emailAddress" oninvalid="this.setCustomValidity('Please enter a valid Email')" oninput="this.setCustomValidity('')"   name="emailAddress" placeholder="Email address" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" onkeyup="validatemail()">
											<span  style="color: red; font-size: 13px;" id="EmailError">Please enter a valid Email</span> 
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Mobile Number</label>  &nbsp;&nbsp;&nbsp; <span id="errMobile" name="errMobile" class="text-danger"> </span>
										<div class="input-group-prepend">										 
    										<span class="input-group-text" id="basic-addon1">+91</span>
											<input class="form-control" type="tel" maxlength="10" minlength="10" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"" id="mobile" name="mobile" title="10 digit mobile number" placeholder="Mobile Number">
										
										</div>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">User Type</label> &nbsp;&nbsp;&nbsp; <span id="errUserType" name="errUserType" class="text-danger" > </span>
											<select class="form-control" name="usertype" id="usertype" required>
												<option disabled selected value>-Select-</option>
												<option>Web Portal</option>
												<option>Mobile Application</option>
											</select>
										</div>
									</div>
<!-- 									<div class="row">
									<div class="form-group">
										<button class="btn btn-default" type="submit">Submit</button>
									</div>
									</div> -->
														<div class="row">
								<div class="col-sm-12 form-group">
								 <input type="submit" value="Submit" class="btn btn-primary">
									<!-- <input class="btn btn-primary" type="submit" id="enq_submit">Submit</button> -->
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
	<script>
	 $("#ho").change(function () {
		//var val = this.val;
		var val = $('#ho option:selected').val();
		if(val==1){
			$("#zoneLabel, #regionLabel, #dpclabel").hide();
			$("#zone, #region, #centerordpc").hide();
		}
		if(val==0){
			$("#zoneLabel, #regionLabel, #dpclabel").show();
			$("#zone, #region, #centerordpc").show();
		}
     });
	
	</script>
	<script>
	 function validate() {
	
	 var username = document.forms["myForm"]["username"].value;
	 var password = document.forms["myForm"]["password"].value;
	 var ho = document.forms["myForm"]["ho"].value;
	 var zone = document.forms["myForm"]["zone"].value;
	 var region = document.forms["myForm"]["region"].value;
	 var centerordpc = document.forms["myForm"]["centerordpc"].value;
	 var usertype = document.forms["myForm"]["usertype"].value;
	 var employeeid = document.forms["myForm"]["employeeid"].value;
	 var employeename = document.forms["myForm"]["employeename"].value;
	 var emailAddress = document.forms["myForm"]["emailAddress"].value;
	 var mobile = document.forms["myForm"]["mobile"].value;
	 	  if (username == "") {
		    document.getElementById("errName").innerHTML = "Name can not be empty!";
		    document.getElementById("username").focus();
		    return false;
	 	  }
		  else if(password == ""){
			 document.getElementById("errPass").innerHTML = "Password can not be empty!";
			document.getElementById("password").focus();
			return false;
	     }
		  else if(ho == ""){
				 document.getElementById("errho").innerHTML = "Ho can not be empty!";
				document.getElementById("ho").focus();
				return false;
		  }
		  else if(ho==0){
			  if(zone == ""){
				    
				  document.getElementById("errZone").innerHTML = "Zone can not be empty!";
					document.getElementById("zone").focus();
					return false;
				 
		  }
		  else if(region == ""){
				 document.getElementById("errRegion").innerHTML = "Region can not be empty!";
				document.getElementById("region").focus();
				return false;
		  }
		  else if(centerordpc == ""){
				 document.getElementById("errDPC").innerHTML = "Dpc can not be empty!";
				document.getElementById("centerordpc").focus();
				return false;
		  }
		  else if(usertype == ""){
				 document.getElementById("errType").innerHTML = "Usertype can not be empty!";
				document.getElementById("usertype").focus();
				return false;
		  }
		  else if(employeeid == ""){
				 document.getElementById("errID").innerHTML = "Employeeid can not be empty!";
				document.getElementById("employeeid").focus();
				return false;
		     }
			  else if(employeename == ""){
					 document.getElementById("errEMP").innerHTML = "Employeename can not be empty!";
					document.getElementById("employeename").focus();
					return false;
			  }
		  
		  else if(emailAddress == ""){
				 document.getElementById("errEmail").innerHTML = "Email Address can not be empty!";
				document.getElementById("emailAddress").focus();
				return false;
		  }
		  else if(mobile == ""){
				 document.getElementById("errMobile").innerHTML = "Mobile No. can not be empty!";
				document.getElementById("mobile").focus();
				return false;
		  }
			  
			  }
	  
		  else if(ho==1){
			   
		    if(usertype == ""){
				 document.getElementById("errType").innerHTML = "Usertype can not be empty!";
				document.getElementById("usertype").focus();
				return false;
		  }
		  else if(employeeid == ""){
				 document.getElementById("errID").innerHTML = "Employeeid can not be empty!";
				document.getElementById("employeeid").focus();
				return false;
		     }
			  else if(employeename == ""){
					 document.getElementById("errEMP").innerHTML = "Employeename can not be empty!";
					document.getElementById("employeename").focus();
					return false;
			  }
		  
		  else if(emailAddress == ""){
				 document.getElementById("errEmail").innerHTML = "Email Address can not be empty!";
				document.getElementById("emailAddress").focus();
				return false;
		  }
		  else if(mobile == ""){
				 document.getElementById("errMobile").innerHTML = "Mobile No. can not be empty!";
				document.getElementById("mobile").focus();
				return false;
		  }
			  
			  }
	  
	 
	  

}
	  </script>
	  
	  <script>
function deleteErrorMsg(){
        
 var username = document.forms["myForm"]["username"].value;
        if(username.length>2){
               $("#errName").hide();
        }
}
	  
</script> 
	  
<!-- <script>
function deleteErrorMsg(){
        
 var username = document.forms["myForm"]["username"].value;
        if(username.length>2){
               $("#errName").hide();
        }
}
	  
</script> -->

	<script>
		$("#zone").on("change", function() {
			var id = (this.value);
			//alert(id);
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
	
	<script>
		$(document).ready(function() {
			$('#emailTosend').keyup(function(e) {
				if (e.keyCode == 8){}
					//alert('backspace trapped')
					
					
					
			})
		});
		</script>
		
		<script>
		$('#emailTosend').keyup(function(){
			   var str = this.value.replace(/(\w)[\s,]+(\w?)/g, '$1, $2');
			   if (str!=this.value) this.value = str; 
		});
		
		$('#emailTosend').keyup(function(){
		    var val = $("#emailTosend").val();
		    let text = val;
		    let result = text.indexOf(" ");
		    if(result != -1){
		    	alert(result);
		    }
			
			/* var str = this.value.replace(/(\w)[\s,]+(\w?)/g, '$1, $2');
		     if (str!=this.value) this.value = str; */ 
		});
		</script>
		
		<script>
$(document).ready(function() {
	
	  $("#EmailError").hide();
   	  $('#emailAddress').keyup(function() { 
        $("#EmailError").hide();
        var hasError = false;
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/; 
        var emailaddressVal = $("#emailAddress").val();
        if(emailaddressVal == '') {
            $("#EmailError").show();
            hasError = true;
        } 
        else if(!emailReg.test(emailaddressVal)) {
        	$("#EmailError").show();
            hasError = true;
        }
        if(hasError == true) { return false; }
 
    });
});
</script>

  <div class="sidenav-backdrop backdrop"></div>
<!--      <script>
		$(document).ready(function() {
			$('#emailTosend').keyup(function(e) {
				if (e.keyCode == 8){}
					//alert('backspace trapped')
			})
		});
		</script>
		<script src="build/js/intlTelInput.js"></script>
		<script>
		$('#emailTosend').keyup(function(){
			   var str = this.value.replace(/(\w)[\s,]+(\w?)/g, '$1, $2');
			   if (str!=this.value) this.value = str; 
		});
		
		$('#emailTosend').keyup(function(){
		    var val = $("#emailTosend").val();
		    let text = val;
		    let result = text.indexOf(" ");
		    if(result != -1){
		    	alert(result);
		    }
			/* var str = this.value.replace(/(\w)[\s,]+(\w?)/g, '$1, $2');
		     if (str!=this.value) this.value = str; */ 
		});
		</script> -->
		
<!-- 		
		<script>
		$('#mob_frm').submit(function(e) {
            e.preventDefault();
            if(!$('#mobile').val().match('[0-9]{10}'))  {
                alert("Please put 10 digit mobile number");
                return;
            }  
        });
		
		</script>
		
		
		<script>
			$('#mob_frm').submit(function(e) {
            e.preventDefault();
            if(!$('#mobile').val().match('[0-9]{10}'))  {
                alert("Please put 10 digit mobile number");
                return;
            }  

        });</script> -->
        
        
        
        <script>
        $(".toggle-password").click(function() {

        	  $(this).toggleClass("fa-eye fa-eye-slash");
        	  var input = $($(this).attr("toggle"));
        	  if (input.attr("type") == "password") {
        	    input.attr("type", "text");
        	  } else {
        	    input.attr("type", "password");
        	  }
        	});
        </script>
        
        
        
        
<!--  <script>
function validate() {

	 let username = document.forms["myForm"]["username"].value;
	 let password = document.forms["myForm"]["password-field"].value;
	 
	 
	 if (username == "") {
		    alert("Name must be filled out");
		    document.forms["myForm"]["username"].focus();
		    return false;
		  }
		  else if(password == ""){
			  alert("Caste must be filled out");
			  document.forms["myForm"]["password-field"].focus();
			  return false;
		  }
}
        
 </script>   -->  
<script>
$(document).ready(function() {
	
	  $("#EmailError").hide();
     $('#emailAddress').keyup(function() { 
        $("#EmailError").hide();
        var hasError = false;
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
 
        var emailaddressVal = $("#emailAddress").val();
        if(emailaddressVal == '') {
            $("#EmailError").show();
            hasError = true;
        }
 
        else if(!emailReg.test(emailaddressVal)) {
        	//alert('error');
        	 $("#EmailError").show();
            hasError = true;
        }
        if(hasError == true) { return false; }
 
    });
});
</script>
<script>
    function allow_alphabets(element){
        let textInput = element.value;
        textInput = textInput.replace(/[^A-Za-z ]*$/gm, ""); 
        element.value = textInput;
    }
</script>
<script>
function validatemail(){
	var email = document.getElementById("emailAddress").value;
	var flag = false;
	for(var i=0; i<email.length; i++){
		if(email[i]=='@'){
			flag =  true
			  $.ajax({
					type:"GET",
					url:"validateEmail.obj",
					data:{"Email":email},
					success:function(result){
						document.getElementById("emailCheck").value = result;
    					if(result == 'false'){
    						document.getElementById("errEmail").innerHTML = " Email Already Exists!";
    					}
    					else{
    						document.getElementById("errEmail").innerHTML = "";
    					}
    				}			
			  });
		}
	}
	
}
</script>

	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
</body>
</html>