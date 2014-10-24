<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="container-fluid">
				<div class="row well">
			 		<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'create',controller:'genetic']" >
              <div class="row">
              	<div class="col-lg-8">
              		<div class="form-group">
                			<label class="col-lg-3 control-label">Nombre</label>
                			<div class="col-lg-9">
                 	 			<input type="text" class="form-control" name="name" />
                			 </div>
                		</div>
                	</div>
                	<div class="col-lg-4">
              		<div class="form-group">
                			<input type="submit" class="btn btn-success" value="Crear nueva genética" />
                		</div>
                	</div>
               </div>
          </g:form>
				</div>
				<div class="row">
					<h4><b>Genéticas</b></h4>
          <g:set var="count" value="${1}" />
					<table id="tableGenetics" class="table">
            	<tr>
                  <g:each in="${listGenetics}">
                    <td>

                      <g:if test="${it.status.name()=='GENETIC_STATUS__ENABLED'}">
                        <a href="${createLink(controller:'genetic', action:'disabled', params:[geneticId:it.id])}">
                          <g:img dir="css/img" file="publicado.png" />
                        </a>
                      </g:if>
                      <g:elseif test="${it.status.name()=='GENETIC_STATUS__DISABLED'}">
                        <a href="${createLink(controller:'genetic', action:'enabled', params:[geneticId:it.id])}">
                          <g:img dir="css/img" file="despublicado.png" />
                        </a>
                      </g:elseif>
                      ${it.name}</td>                   
                      <g:if test="${count % 3 == 0 && count!=0}">
                        </tr><tr>
                      </g:if>
                    <g:set var="count" value="${count + 1}" />
                 </g:each>
              </tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->

<div class="footer">
	<div class="footer-inner">
		 2014 &copy; Sativa
	</div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<script src="${resource(dir: 'js/pluginsSativa', file: 'jquery-1.11.0.min.js')}" type="text/javascript"></script>
<script src="${resource(dir: 'js/pluginsSativa', file: 'jquery-migrate-1.2.1.min.js')}" type="text/javascript"></script>

<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${resource(dir: 'js/pluginsSativa/jquery-ui', file: 'jquery-ui-1.10.3.custom.min.js')}" type="text/javascript"></script>

<script src="${resource(dir: 'js/pluginsSativa/bootstrap/js', file: 'bootstrap.min.js')}" type="text/javascript"></script>



<script src="${resource(dir:'js/pluginsSativa/bootstrap-hover-dropdown', file:'bootstrap-hover-dropdown.min.js')}" type="text/javascript"></script>


<script src="${resource(dir:'js/pluginsSativa/jquery-slimscroll', file:'jquery.slimscroll.min.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa', file:'jquery.blockui.min.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/uniform', file: 'jquery.uniform.min.js')}" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<!--

<script src="${resource(dir:'js/pluginsSativa/jqvmap/jqvmap', file: 'jquery.vmap.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/jqvmap/jqvmap/maps', file: 'jquery.vmap.russia.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/jqvmap/jqvmap/maps', file: 'jquery.vmap.world.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/jqvmap/jqvmap/maps', file: 'jquery.vmap.europe.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/jqvmap/jqvmap/maps', file: 'jquery.vmap.germany.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/jqvmap/jqvmap/maps', file: 'jquery.vmap.usa.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/jqvmap/jqvmap/data', file:'jquery.vmap.sampledata.js')}" type="text/javascript"></script>

-->
<script src="${resource(dir:'js/pluginsSativa', file:'jquery.peity.min.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa', file: 'jquery.pulsate.min.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/jquery-knob/js', file:'jquery.knob.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/flot', file:'jquery.flot.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/flot', file: 'jquery.flot.resize.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/bootstrap-daterangepicker', file: 'moment.min.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/bootstrap-daterangepicker', file:'daterangepicker.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/gritter/js', file:'jquery.gritter.js')}" type="text/javascript"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
<script src="${resource(dir:'js/pluginsSativa/fullcalendar/fullcalendar', file: 'fullcalendar.min.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa/jquery-easypiechart', file:'jquery.easypiechart.min.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/pluginsSativa', file:'jquery.sparkline.min.js')}" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${resource(dir:'js/scriptsSativa', file:'app.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/scriptsSativa', file:'index.js')}" type="text/javascript"></script>
<script src="${resource(dir:'js/scriptsSativa', file: 'tasks.js')}" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   Index.init();
   //Index.initJQVMAP(); // init index page's custom scripts
   Index.initCalendar(); // init index page's custom scripts
   Index.initCharts(); // init index page's custom scripts
   Index.initChat();
   Index.initMiniCharts();
   Index.initPeityElements();
   Index.initKnowElements();
   Index.initDashboardDaterange();
   Tasks.initDashboardWidget();
});
</script>
</body>

<!-- END BODY -->
</html>