<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
				 <div class="row">
				 	<div class="col-lg-4"></div>
				 	<div class="col-lg-4 well">
				 		<g:if test="${error}">
				 			<div class="alert alert-danger">${error}</div>
				 		</g:if>
				 		<form class="form-vertical" method="POST" name="formPrescriptors" action="/j_spring_security_check" id="1">
						 
	                            <div class="form-group">
	                              <label>Colaborador</label>
	                                <input type="text" class="form-control" name="j_username" />
	                                <div class="wsperror firstname_error hide"></div>
	                            </div>
	                            <div class="form-group">
	                              <label>Contraseña</label>
	                                <input type="password" class="form-control"  name="j_password">
	                                <div class="wsperror lastname_error hide"></div>
	                            </div>
	                            <div class="form-group">
	                            	<input type="submit" class="pull-right btn btn-success" value="Entrar" />
									
	                            </div>
			              </form>
	                </div>
	                <div class="col-lg-4"></div>
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