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
						  <li id="tableDivPeriod"><a href="#tablePerPeriod" role="tab" data-toggle="tab">Ventas por período</a></li>
						  <li id="tableDivGeneticPeriod"><a href="#tablePerGeneticPeriod" role="tab" data-toggle="tab">Ventas geneticas período</a></li>
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
					 								<td>${it.partner.code}</td>
					 								<td>${it.genetic.name}</td>
					 								<td>${it.genetic.type.grams*it.amount}gr</td>
					 								<td><g:formatDate  timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy HH:mm" date="${it.dateCreated}"/> </td>
					 								<td class="center"><g:img dir="css/img/geneticOrdersSigns" file="${it.id}.png" class="imageSign" base="${grailsApplication.config.grails.serverURL}" />
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
											    	
											     <input type="date"  value="${new Date().format('dd/MM/yyyy')}" class="calendar2 form-control">
											    </div>
											  </div>
											  <div class="col-lg-3">
											  	<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'periodic',controller:'geneticOrders']" >
												    <div class="input-group">
												    	<input type="hidden" name="start" value="" class="hiddenCalendar2">
												    	<input type="hidden" name="end" value="" class="hiddenCalendar3">
												     <input type="date"  value="${new Date().format('dd/MM/yyyy')}" class="calendar3 form-control">
												      <span class="input-group-btn">
												        <button type="submit" class="btn btn-default" >Filtrar</button>
												      </span>
												    </div>
												</g:form>
											</div>
							        </div>
							    </div>
							    <g:if test="${stadisticsPerPeriod}">									
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
						 								<td>${it.partner.id}</td>
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
											    	
											     <input type="date" value="${new Date().format('dd/MM/yyyy')}" class="form-control calendar2">
											    </div>
											  </div>
											  <div class="col-lg-3">
											  	<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'genetics',controller:'geneticOrders']" >
												    <div class="input-group">
												    	<input type="hidden" name="start" value="" class="hiddenCalendar2">
												    	<input type="hidden" name="end" value="" class="hiddenCalendar3">
												     <input type="date"  value="${new Date().format('dd/MM/yyyy')}" class="calendar3 form-control">
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
   var start = new Date("${start}")
   var end = new Date("${end}")



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
   } 


   $('#calendar1').val(today)
   $('.calendar2').val(auxStart)
   $('.calendar3').val(auxEnd)

 	if (now) {
   		$('#hiddenCalendar').val(now.toISOString())
   	}
   $('.hiddenCalendar2').val(start.toISOString())
   $('.hiddenCalendar3').val(end.toISOString())

   $('#calendar1').on('change', function(){
   		var auxDate = new Date($('#calendar1').val());
   		$('#hiddenCalendar').val(auxDate.toISOString())
   });

   $('.calendar2').on('change', function(){
   		var auxDate = new Date($('.calendar2').val());
   		$('.hiddenCalendar2').val(auxDate.toISOString())
   });

   $('.calendar3').on('change', function(){
   		var auxDate = new Date($('.calendar3').val());
   		$('.hiddenCalendar3').val(auxDate.toISOString())
   });

 
  
});
</script>
</body>

<!-- END BODY -->
</html>