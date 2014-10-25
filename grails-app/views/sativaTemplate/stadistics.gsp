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
						  <li><a href="#tablePerPeriod" role="tab" data-toggle="tab">Ventas por período</a></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content">
						  <div class="tab-pane active" id="tablePerDay">
						  		<div class="row">
						  			<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'day',controller:'geneticOrders']" >
							        <div class='col-lg-4'>
							            <div class="form-group">
							                <div class='input-group date' id='dateFilter'>
							                		
								                    <input id="calendar" type='text' class="form-control" data-date-format="dd/mm/yyyy"/>
								                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
								                    </span>
								                    <button type="submit" class=" form-control btn btn-primary" >Filtrar</button>
								                    <input type="hidden" id="currentDate" name="currentDate" />
							                </div>
							            </div>
							        </div>
							        </g:form>
							    </div>

						  		<table class="tableStadistic table table-bordered table-condensed">
						 			<thead>
						 				<tr>
							 				<th>Numero de socio</th>
							 				<th>Genética</th>
							 				<th>Cantidad</th>
							 				<th>Fecha</th>
							 				<th>Firma</th>
						 				</tr>
						 			</thead>
						 			<tbody>
						 				<g:if test="${stadisticsPerDay}">
					 						<g:each in="${stadisticsPerDay}">
					 							<tr>
					 								<td>${it.partner.code}</td>
					 								<td>${it.genetic.name}</td>
					 								<td>${it.amount}</td>
					 								<td><g:formatDate format="dd-MM-yyyy HH:mm" date="${it.dateCreated}"/> </td>
					 								<td>${it.partner.signature}</td>
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
							        <div class='col-lg-8'>
						        		<div class="row">
								            <div class="col-lg-6">
									            <div id="dashboard-report-range" class="btn btn-default selectbox pull-right">
													 <i class="fa fa-calendar"></i>
													<span>September 26, 2014 - October 25, 2014</span> <b class="caret"></b>
												</div>
											</div>
											<div class="col-lg-2">
												<button type="submit" class=" form-control btn btn-primary" >Filtrar</button>
											</div>
										</div>
							        </div>
							    </div>
							    <g:if test="${listGenetics}">
									<h4>Resumen genéticas</h4>
									<table class="table table-condensed">
										<g:set var="count" value="${1}" />
				 						<g:each in="${listGenetics}">
				 							<tr>
				 								<td><b>${it.name}</b>: ${it.amount}</td>
				 								 <g:if test="${count % 3 == 0 && count!=0}">
							                        </tr><tr>
							                      </g:if>
							                    <g:set var="count" value="${count + 1}" />
				 							</tr>
				 						</g:each>
					 				</table>						  		

							  		<table class="table table-bordered table-condensed">
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
						 								<td>${it.code}</td>
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
 

   var startAux = new Date() - 30
   var endAux   = new Date()
   if (currentDate) {
   		console.dir(currentDate)
   		var aux = new Date(currentDate)
   		$('#currentDate').val(aux.toISOString());   	
   }
   else {
		$('#currentDate').val(new Date().toISOString());   	
		currentDate = new Date()
   }



     $('#dateFilter').datepicker({language:'es', format:"dd-mm-yyyy", startDate:currentDate}).on('changeDate', function(ev) {
		$('#currentDate').val(ev.date.toISOString());
  	});

   $('#calendar').val(new Date().toLocaleDateString());


	

   
   $('#dashboard-report-range').daterangepicker(
		{
			opens: 'right',
			format: 'DD-MM-YYYY',
			startDate: startAux,
			endDate:  endAux,
			language: 'es',
			locale: {applyLabel:"Aplicar", cancelLabel:"Cancelar", fromLabel:"Desde",toLabel:"Hasta"}		

		}, 
		function(start, end) {
			$('#dashboard-report-range span').html(start.format('D MMMM, YYYY') + ' - ' + end.format('D MMMM, YYYY'));
		}
	);



});
</script>
</body>

<!-- END BODY -->
</html>