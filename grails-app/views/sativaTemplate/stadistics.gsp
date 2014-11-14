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
											    	<input type="hidden" name="currentDate" id="hiddenCalendar2">
											     <input type="date" id="calendar2" value="${new Date().format('dd/MM/yyyy')}" class="form-control">
											    </div>
											  </div>
											  <div class="col-lg-3">
												    <div class="input-group">
												    	<input type="hidden" name="currentDate" id="hiddenCalendar3">
												     <input type="date" id="calendar3" value="${new Date().format('dd/MM/yyyy')}" class="form-control">
												      <span class="input-group-btn">
												        <a class="btn btn-default" >Filtrar</a>
												      </span>
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
   var now = new Date("${daySelected}")
   var end = new Date("${end}")
   

   var day = ("0" + now.getDate()).slice(-2);
   var month = ("0" + (now.getMonth() + 1)).slice(-2);
   var today 	 = now.getFullYear()+"-"+(month)+"-"+(day) ;

   day = ("0" + end.getDate()).slice(-2);
   month = ("0" + (end.getMonth() + 1)).slice(-2);
   var auxEnd 	 = end.getFullYear()+"-"+(month)+"-"+(day) ;


   

   $('#calendar1').val(today)

   $('#calendar1').on('change', function(){
   		var auxDate = new Date($('#calendar1').val());
   		$('#hiddenCalendar').val(auxDate.toISOString())
   });

   $('#calendar2').on('change', function(){
   		var auxDate = new Date($('#calendar2').val());
   		$('#hiddenCalendar2').val(auxDate.toISOString())
   });

   $('#calendar3').on('change', function(){
   		var auxDate = new Date($('#calendar3').val());
   		$('#hiddenCalendar3').val(auxDate.toISOString())
   });

   $('#calendar3').val(today)
   $('#calendar2').val(auxEnd)
   
   $('#tableDivPeriod').click(function() {

   })

});
</script>
</body>

<!-- END BODY -->
</html>