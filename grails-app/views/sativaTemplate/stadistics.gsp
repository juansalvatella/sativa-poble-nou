<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
				 <div class="container-fluid">
				 		<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
						  <li class="active"><a href="#tablePerDay" role="tab" data-toggle="tab">Tabla del dia</a></li>
						  <li id="tableDivPeriod"><a href="#tablePerPeriod" role="tab" data-toggle="tab"> Aportaciones por período</a></li>
						  <li id="tableDivGeneticPeriod"><a href="#tablePerGeneticPeriod" role="tab" data-toggle="tab"> Geneticas período</a></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content">
						  <div class="tab-pane active" id="tablePerDay">
						  		<div class="row">
						  			<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'day',controller:'geneticOrders']" >
							        <div class="col-lg-4">
									    <div class="input-group">
									      <input type="date" id="calendar1" class="form-control">
									      <input type="hidden" name="currentDate" id="hiddenCalendar">
									      <span class="input-group-btn">
									        <button class="btn btn-default" type="submit">Filtrar</button>
									      </span>
									    </div>
									  </div>
							        </g:form>
							    </div>

						  		<table class="tableStadistic table table-bordered table-condensed">
						 			<thead>
						 				<tr>
							 				<th class="col-lg-2">Numero de socio</th>
							 				<th class="col-lg-2">Genética</th>
							 				<th class="col-lg-2">Gramos</th>
							 				
							 				<th class="col-lg-2">Fecha</th>
							 				<th class="col-lg-4 center">Firma</th>
						 				</tr>
						 			</thead>
						 			<tbody>
						 				<g:if test="${stadisticsPerDay}">
					 						<g:each in="${stadisticsPerDay}">
					 							<tr>
					 								<td style="vertical-align:middle">${it.partner.code}</td>
					 								<td style="vertical-align:middle">${it.genetic.name}</td>
					 								<td style="vertical-align:middle">${it.genetic.type.grams*it.amount}gr</td>
					 								<td style="vertical-align:middle"><g:formatDate  timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy HH:mm" date="${it.dateCreated}"/> </td>
					 								<td  style="vertical-align:middle" class="center"><g:img dir="css/img/geneticOrdersSigns" file="${it.id}.png" class="imageSign" base="${grailsApplication.config.grails.serverURL}" />
					 							</tr>
					 						</g:each>
						 				</g:if>
						 				<g:else>
						 					
						 				</g:else>
						 			</tbody>
				 				</table>
						  </div>
						  <div class="tab-pane" id="tablePerPeriod">
						  		<div class="row">
							        <div class='col-lg-3'>
							        	<p>Desde</p>
							        </div>
							        <div class='col-lg-3'>
							        	<p>Hasta</p>
							        </div>
							    </div>
						  		<div class="row">
							        <div class='col-lg-12'>
							        	<div class="row">
											  <div class="col-lg-3">
											    <div class="input-group">
											    	
											     <input type="date"  value="${new Date().format('dd/MM/yyyy')}" id="calendar2" class=" form-control">
											    </div>
											  </div>
											  <div class="col-lg-3">
											  	<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'periodic',controller:'geneticOrders']" >
												    <div class="input-group">
												    	<input type="hidden" name="start" value="" class="hiddenCalendar2">
												    	<input type="hidden" name="end" value="" class="hiddenCalendar3">
												     <input type="date"  value="${new Date().format('dd/MM/yyyy')}" id="calendar3" class="form-control">
												      <span class="input-group-btn">
												        <button type="submit" class="btn btn-default" >Filtrar</button>
												      </span>
												    </div>
												</g:form>
											</div>
							        </div>
							    </div>
							    <g:if test="${stadisticsPerPeriod}">	
							    	<h3 style="margin-top:70px"><b>Total de gramos:</b> ${totalPerPeriod}g</h3>								
							  		<table class="table tableStadistic2 table-bordered table-condensed">
							 			<thead>
							 				<tr>
								 				<th>Numero de socio</th>
								 				<th>Cantidad total</th>
							 				</tr>
							 			</thead>
							 			<tbody>
							 				<g:if test="${stadisticsPerPeriod}">
						 						<g:each in="${stadisticsPerPeriod}">
						 							<tr>
						 								<td>${it.partner.code}</td>
						 								<td>${it.amount}</td>
						 							</tr>
						 						</g:each>
							 				</g:if>
							 				<g:else>
							 					
							 				</g:else>
							 			</tbody>
					 				</table>
					 			</g:>
						  </div>
						 </div>
						  <div class="tab-pane" id="tablePerGeneticPeriod">
						  		<div class="row">
							        <div class='col-lg-3'>
							        	<p>Desde</p>
							        </div>
							        <div class='col-lg-3'>
							        	<p>Hasta</p>
							        </div>
							    </div>
						  		<div class="row">
							        <div class='col-lg-12'>
							        	<div class="row">
											  <div class="col-lg-3">
											    <div class="input-group">
											    	
											     <input type="date" value="${new Date().format('dd/MM/yyyy')}" id="calendar4" class="form-control ">
											    </div>
											  </div>
											  <div class="col-lg-3">
											  	<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'genetics',controller:'geneticOrders']" >
												    <div class="input-group">
												    	<input type="hidden" name="start" value="" class="hiddenCalendar2">
												    	<input type="hidden" name="end" value="" class="hiddenCalendar3">
												     <input type="date"  value="${new Date().format('dd/MM/yyyy')}" id ="calendar5" class=" form-control">
												      <span class="input-group-btn">
												        <button type="submit" class="btn btn-default" >Filtrar</button>
												      </span>
												    </div>
												</g:form>
											</div>
							        </div>
							    </div>
							    <g:if test="${listGenetics}">	
							    	<g:set var="count" value="${1}" />								
							  		<h3 style="margin-top:70px;"><b>Total de compras:</b> ${totalBuys}</h3>
							  		<h3><b>Total de gramos:</b> ${totalGrams}g</h3>
							  		<table class="tableStadistic2 table" id="tableGenetics" >
							 			 	<tr>
								                 <g:each in="${listGenetics}">
								                    <td><b>${it.name.name}:</b> ${it.amount} (${it.name.type.grams * it.amount}) gr</td>                   
								                      <g:if test="${count % 5 == 0 && count!=0}">
								                        </tr><tr>
								                      </g:if>
								                    <g:set var="count" value="${count + 1}" />
								                 </g:each>
								            </tr>
					 				</table>

					 				<h1>GRAFICO</h1>
					 			</g:>
						  		
						  </div>
						

				 </div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<g:render template="/sativaTemplate/scriptsTemplate"  />
<div class="footer">
	<div class="footer-inner">
		 2014 &copy; Sativa
	</div>
</div>

<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   var now = new Date("${daySelected}")
   var end = new Date()
   var start   = new Date()
   start.setDate(start.getDate()-30)
   if ("${start}" != "") {
   		start = new Date("${start}")
   }
   if ("${end}" != ""){
   		 end = new Date("${end}")
   }
   
   



   var day = ("0" + now.getDate()).slice(-2);
   var month = ("0" + (now.getMonth() + 1)).slice(-2);
   var today 	 = now.getFullYear()+"-"+(month)+"-"+(day) ;



   day = ("0" + start.getDate()).slice(-2);
   month = ("0" + (start.getMonth() + 1)).slice(-2);
   var auxStart 	 = start.getFullYear()+"-"+(month)+"-"+(day) ;



   day = ("0" + end.getDate()).slice(-2);
   month = ("0" + (end.getMonth() + 1)).slice(-2);
   var auxEnd 	 = end.getFullYear()+"-"+(month)+"-"+(day) ;



   if ("${page}" == "periodic") {
   		$('#tableDivPeriod').tab('show')
   		$('#tablePerPeriod').addClass('active');
   		$('#tablePerDay').removeClass('active');
   		$('#tablePerGeneticPeriod').removeClass('active');
   } 

   else if ("${page}" == "genetics") {
   		$('#tableDivGeneticPeriod').tab('show')
   		$('#tablePerGeneticPeriod').addClass('active');
   		$('#tablePerDay').removeClass('active');
   		$('#tablePerPeriod').removeClass('active');
   } 


   $('#calendar1').val(today)
   $('#calendar2').val(auxStart)
   $('#calendar3').val(auxEnd)
   $('#calendar4').val(auxStart)
   $('#calendar5').val(auxEnd)

	if (now) {
		$('#hiddenCalendar').val(now.toISOString())
	}
	if (start){
   		$('.hiddenCalendar2').val(start.toISOString())
    }
    if (end) {
   		$('.hiddenCalendar3').val(end.toISOString())
   	}

   $('#calendar1').on('change', function(){
   		var auxDate = new Date($('#calendar1').val());
   		$('#hiddenCalendar').val(auxDate.toISOString())
   });

   $('#calendar2').on('change', function(){
   		var auxDate = new Date($('#calendar2').val());
   		$('.hiddenCalendar2').val(auxDate.toISOString())
   });

   $('#calendar3').on('change', function(){
   		var auxDate = new Date($('#calendar3').val());
   		$('.hiddenCalendar3').val(auxDate.toISOString())
   });

    $('#calendar4').on('change', function(){
   		var auxDate = new Date($('#calendar4').val());
   		$('.hiddenCalendar2').val(auxDate.toISOString())
   });

   $('#calendar5').on('change', function(){
   		var auxDate = new Date($('#calendar5').val());
   		$('.hiddenCalendar3').val(auxDate.toISOString())
   });

 
  
});
</script>
</body>

<!-- END BODY -->
</html>