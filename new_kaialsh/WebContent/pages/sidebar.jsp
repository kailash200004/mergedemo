<!DOCTYPE html>
<html lang="en">
<head>
<script src="./assets/vendors/jquery/dist/jquery.min.js"
	type="text/javascript"></script>
<script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
	type="text/javascript"></script>
<script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
	type="text/javascript"></script>

</head>
<style>
body {
	zoom: 85%;
}
.side-menu li a{

    color: #fff;

}
.sidebarleft {
	
}
</style>
<nav class="page-sidebar" id="sidebar" style="height: 90%; overflow-y: auto;">
	<div class="page-brand">
		<a class="link" href="#"> <span class="brand"> <span
				class="brand-tip"> <img src="assets/img/logo5.png">
			</span>
		</span> <span class="brand-mini"> <img src="assets/img/logo5.png">
		</span>
		</a>
	</div>
	<div id="sidebar-collapse"  class="sidebarleft">
		<div class="admin-block d-flex">
			<div>
				<img style="border-radius: 37px;"
					src="https://placehold.jp/100x100.png" width="45px" />
			</div>
			
  <div class="admin-info">
  
	<div class="font-strong">Welcome <br>
	<span style="color: #ffc107;">
	<%
		String Email=(String)request.getSession().getAttribute("usrname");
	
		out.println(Email);
		
		if(Email==null){
			//String redirectURL = "http://49.50.79.121:8080/jcicms/index.obj";
		    String redirectURL = "http://localhost:8080/jciadmin/index.obj";
		    response.sendRedirect(redirectURL);
		
		}
		
  	%>
	</span>
	
	
	</div></div>
			
			</div>
			
		<ul class="side-menu metismenu">
			<li><a href="dashboard.obj"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">Dashboard</span> </a></li>

			<!-- <li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">Privileges</span> <i
					class="fa fa-angle-left arrow"></i></a> -->
				<ul class="nav-2-level ">
					<li class="nav-label" data-pre="1" id="o1"><a href="userrole.obj" ><b><i class="sidebar-item-icon fa fa-th-large"></i>Add Role</b></a></li>
					<li class="nav-label" data-pre="2" id="o2"><a href="useraction.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Add Action</b></a></li>
					<li class="nav-label" data-pre="3" id="o3"><a href="userprivilige.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Add Privileges</b></a></li>
					<!-- <li class="nav-label" data-pre="4" id="o4"><a href="viewuserrole.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>View User Role</b></a></li>
					 -->
				</ul><!-- </li> -->
				
			<!-- <li><a href="javascript:void(0);;"><i class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">0. &nbsp;User Management</span><i 
					class="fa fa-angle-left arrow"></i></a>-->
				<ul class="nav-2-level"> 
					<li   data-pre="5" id="o5"><a  href="UserRegistration.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>User Registration</b></a></li>
					<li   data-pre="6" id="o6"><a  href="viewUserRegistration.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>View User Registration</b></a></li>

			</ul><!-- </li> -->
			
				<ul class="nav-2-level">
					<li  data-pre="7" id="o7"><a  href="FarmerRegistration.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Farmer Registration</b></a></li>
					<li  data-pre="8" id="o8"><a  href="ViewFarmerRegistration.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>View Farmer List Reg</b></a></li>
				</ul><!-- </li> -->
				
				<!-- <li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">2. &nbsp;Market Arrival</span> <i
					class="fa fa-angle-left arrow"></i></a> -->
				<ul class="nav-2-level ">
					<li  data-pre="9" id="o9"><a href="rulingMarketForm.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Ruling Market Rate at DPC</b></a></li>
					<li  data-pre="10" id="o10"><a href="viewmarketArrival.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>View Ruling Market List</b></a></li>				 
					<li  data-pre="11" id="o11"><a href="jbaRate.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>JBA Rate</b></a></li>
					<li  data-pre="12" id="o12"><a href="JbaPriceList.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>JBA List</b></a></li>
				</ul><!-- </li> -->

		<!-- 	<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">3. &nbsp;Raw Jute Procurement</span> <i
					class="fa fa-angle-left arrow"></i></a> -->
				<ul class="nav-2-level ">
					<li data-pre="13" id="o13"><a href="mspPriceCalculation.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>MSP Grades Price </b></a></li>
					<li data-pre="14" id="o14"><a href="commercialPriceCalculation.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Commercial Ceiling Price Intimation </b></a></li>
					<li data-pre="15" id="o15"><a href="rawJutePaymentAndProcurement.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Raw Jute Procurement & Payment</b></a></li>				
					<li data-pre="16" id="o16"><a href="dailyPurchaseConf.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Daily Purchase Confirmation</b></a></li>
					<li data-pre="17" id="o17"><a href="Distributionoftallyslips.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Distribution of tally Slip</b></a></li>
				  	<li data-pre="18" id="o18"><a href="mspGradesPriceList.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>MSP Grades Price Listing </b></a></li>
					<li data-pre="19" id="o19"><a href="viewCommercialCeilingPrice.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>View Commercial Ceiling Price Intimation</b></a></li>
					<li data-pre="20" id="o20"><a href="tallyapproval.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Verification Pending Tally Slip</b></a></li>
					<li data-pre="21" id="o21"><a href="viewVerifiedTallySlipList.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Verified Tally Slip List</b></a></li>
					<li data-pre="53" id="o21"><a href="viewVerifiedTallySlipList_RM.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Verified Tally Slip List RM</b></a></li>
					<li data-pre="54" id="o21"><a href="viewVerifiedTallySlipList_ZM.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Verified Tally Slip List ZM</b></a></li>
					<li data-pre="22" id="o22"><a href="disputedtallyslip.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Disputed Tally Slip List</b></a></li>					
					<li data-pre="23" id="o23"><a href="dailyPurchaseList.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Daily Purchase List</b></a></li>				
					<li data-pre="24" id="o24"><a href="viewDistributionoftallyslips.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>View Distribution of Tally Slip</b></a></li>
					
				</ul><!-- </li> -->
			<!-- <li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">4. &nbsp;Progress of Assortment</span> <i
					class="fa fa-angle-left arrow"></i></a> -->
				<ul class="nav-2-level ">
					<li  data-pre="25" id="o25"><a href="balePreparation.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Bale Preparation</b></a></li>
					<li  data-pre="26" id="o26"><a href="viewbalePreparation.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <b>View Bale Preparation</b></a></li>
					<li  data-pre="27" id="o27"><a href="addRopeMaking.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Rope Making</b></a></li>
					<li  data-pre="28" id="o28"><a href="ropeMakingListing.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>View Rope Making</b></a></li>
				
				</ul><!-- </li>
 -->
			 
				
				
				
			<!-- <li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">5.&nbsp;BIN Performance Calculation</span> <i
					class="fa fa-angle-left arrow"></i></a> -->
				<ul class="nav-2-level ">				
					<li  data-pre="29" id="o29"><a href="bin.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Batch Identification Number</b></a></li>
					<li  data-pre="30" id="o30"><a href="binList.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>BIN List</b></a></li>				
					<li  data-pre="31" id="o31"><a href="binPurchasemapping.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>BIN Purchase Mapping</b></a></li>				
					<li  data-pre="32" id="o32"><a href="fingain.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>FinGainAnd WeightGain</b></a></li>
					<li  data-pre="33" id="o33"><a href="BinListfromDb.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>BIN Gain List</b></a></li>

				</ul><!-- </li> -->
				<!-- <li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">6.&nbsp;Contract</span> <i
					class="fa fa-angle-left arrow"></i></a> -->
				<ul class="nav-2-level">
					<li  data-pre="34" id="o34"><a href="entryofpcso.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Entry of PCSO</b> </a></li>
					<!-- <li  data-pre="35" id="o35"><a href="pcsolist.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>PCSO List</b></a></li> -->
					<li  data-pre="36" id="o36"><a href="entry_derivativeprice.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Entry of Derivative Price</b></a></li>
					<li  data-pre="37" id="o37"><a href="entryderivativepricelist.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Entry of Derivative Price List</b></a></li>
					<li  data-pre="38" id="o38"><a href="contractgenerationPCSOWise.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Contract Generation PCSO Wise</b></a></li>
					<li  data-pre="39" id="o39"><a href="contractgenerationMillWise.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Contract Generation Mill Wise</b></a></li>
					<li  data-pre="40" id="o40"><a href="viewcontractgeneration.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Contract Generation List</b></a></li>
				</ul><!-- </li> -->
			<!-- <li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">7.&nbsp;Payment Arrangement</span> <i
					class="fa fa-angle-left arrow"></i></a> -->
				<ul class="nav-2-level ">

					<li  data-pre="41" id="o41"><a href="entryofpayment.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Entry of payment instrument</b></a></li>
					<li  data-pre="42" id="o42"><a href="HOdispatch.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>HO Dispatch Instruction</b></a></li>
					<li  data-pre="43" id="o43"><a href="entryofsale.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Entry of Sale</b></a></li>
					<li  data-pre="44" id="o44"><a href="uploadingreceipt.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Uploading of receipt</b></a></li>
					
					

				</ul><!-- </li> -->
				
				<!-- <li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">8.&nbsp;Commercial / Daily Sales / Free Sale</span> <i class="fa fa-angle-left arrow"></i></a> -->
				<ul class="nav-2-level">

					<li  data-pre="45" id="o45"><a href="entryofoperationcost.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Entry of Operation Cost</b></a></li>					
					<li  data-pre="46" id="o46"><a href="salespricecalculation.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Sale Price Calculation</b></a></li>
					<li  data-pre="47" id="o47"><a href="contractgenerationcommercial.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Contract Generation Commercial</b></a></li>
					<li  data-pre="48" id="o48"><a href="salespricecalculationlist.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Sale Price Calculation List</b></a></li>
					<li  data-pre="49" id="o49"><a href="entryofoperationcostlist.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Entry of Operation Cost List</b></a></li>
					<li  data-pre="50" id="o50"><a href="viewcontractgenerationcommercial.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Contract Generation Commercial List</b></a></li>
					<li  data-pre="52" id="o52"><a href="MSPgradesCombination.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>MSP Grades Combination</b></a></li>
				
				</ul><!-- </li> -->
		
	</div>
	<script>
$(document).ready(function(){
	//alert("krishna");
});

</script>

	<script>

		$(document).ready(function() {
		for(var i=1; i<51;i++){
			$("#o"+i).hide();
			
			}
			//alert("yes");
			var roleid=<%=(int)request.getSession().getAttribute("roleId")%>;
			var userAction = new Array();
			var allActions = new Array();
		$.get('userpriviligeajax.obj',{roleId : roleid},
				function(responseText) {
					var text = responseText.replace("[","").replace("]","");
					userAction = text.split(",");
					//alert("userAction >>>>> "+ userAction);
					

$.ajax({
			url : "userpriviligeajaxallData.obj",
			type : "GET",
			success : function(result) {
				var data = jQuery.parseJSON(result);
				allActions = result.split(",");
				//alert("allActions >>>>> "+ allActions);
				
				$.each(allActions,function(key,value) {
					
					var keys=value.split(":")[0].replace('["',"").replace('"',"");
					values=value.split(":")[1].replace('"]',"").replace('"',"");
				//	console.log("keys"+ keys);
				//	console.log("values "+values);


					for(var j=0;j<userAction.length;j++){
						for(var i=0;i<=51; i++){
					if($("#o"+i).data("pre") == userAction[j]){
					
						$("#o"+i).show();
							}
						}
					}	 
					
				});
			}

		});
	});

//var one = $("#one").data("pre");
		//var one= this.getAttribute("data-pre");
	//alert(one);

});


</script>
	<!-- <div class="foter-bottom">
		<div>
			<img src="assets/img/icon1.png" class="sidebar-item-icon"><span>Logout</span>
		</div>
	</div> -->
	<!-- foter-bottom -->
</nav>
</html>