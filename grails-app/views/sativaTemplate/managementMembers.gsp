<!DOCTYPE html>
	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
		<div class="modal fade" id="deleteMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1>ELIMINAR USUARIO</h1>
				</div>
				<div class="modal-body">
						<p>¿Estas seguro que quieres eliminar al usuario?</p>
				</div>
				<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<a id="btnDeleteMember" class="btn btn-danger" >Eliminar</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="container-fluid">
				 <div class="row well">
				 		<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'all',controller:'member']" >
	                            <div class="row">
	                            	<div class="col-lg-4">
	                            		<div class="form-group">
	                              			<label class="col-lg-3 control-label">Nombre</label>
	                              			<div class="col-lg-9">
	                               	 			<input type="text" class="form-control" name="firstname" />
	                              			 </div>
	                               			
	                            		</div>
	                            	</div>
	                            	<div class="col-lg-4">
	                             		<div class="form-group">
	                              			<label class="col-lg-3 control-label">Apellidos</label>
	                              			<div class="col-lg-9">
			                               	 <input type="text" class="form-control" name="lastname" />
			                               </div>
			                               
			                            </div>
	                            	</div>
	                            	 <div class="col-lg-4">
		                             	<div class="form-group">
	                            			<input type="submit" class="btn btn-success" value="Buscar" />
										</div>
		                            </div>
	                              	<div class="col-lg-4">
	                              		<div class="form-group">
	                              		   <label class="col-lg-3 control-label">DNI</label>
	                              		   <div class="col-lg-9">
		                               		 <input type="text" class="form-control" name="identificationNumber" />
		                               		</div>
		                               		
		                               	</div>
		                             </div>
		                             <div class="col-lg-4">
	                              		<div class="form-group">
	                              		   <label class="col-lg-3 control-label">Nº Socio</label>
	                              		   <div class="col-lg-9">
		                               		 <input type="text" class="form-control" name="code" />
		                               		</div>
		                               		
		                               	</div>
		                             </div>
		                            
	                            </div>
	                            
			              </g:form>
			        </div>
			        <div class="row">
				 		<table class="table table-bordered table-condensed">
				 			<thead>
				 				<tr>
					 				<th>Nº de Socio</th>
					 				<th>Nombre</th>
					 				<th>DNI</th>
					 				<th>Estado</th>
					 				<th>Acciones</th>
				 				</tr>
				 			</thead>
				 			<tbody>
				 				<g:if test="${listMembers}">
				 						<g:each in="${listMembers}">
				 							<tr>
				 								<td style="vertical-align:middle">${it.code}</td>
				 								<td style="vertical-align:middle">${it.firstname} ${it.lastname}</td>
				 								<td style="vertical-align:middle">${it.identificationNumber}</td>
				 								<td style="vertical-align:middle">
				 									<g:if test="${it.status.name() == 'PARTNER_STATUS__ACTIVED'}">
				 										<g:img dir="css/img" file="semaforoVerde.jpg"/>
				 									</g:if>
				 									<g:elseif test="${it.status.name() == 'PARTNER_STATUS__DISABLED'}">
				 										<g:img dir="css/img" file="semaforoAzul.jpg "/>
				 									</g:elseif>
				 									<g:elseif test="${it.status.name() == 'PARTNER_STATUS__BANNED'}">
				 										<g:img dir="css/img" file="semaforoRojo.jpg"/>
				 									</g:elseif>
				 									<g:elseif test="${it.status.name() == 'PARTNER_STATUS__DETOXIFIED'}">
				 										<g:img dir="css/img" file="semaforoNaranja.jpg"/>
				 									</g:elseif>
				 									<g:elseif test="${it.status.name() == 'PARTNER_STATUS__UNKNOWN'}">
				 										<g:img dir="css/img" file="semaforoAmarillo.jpg"/>
				 									</g:elseif>
				 									<g:elseif test="${it.status.name() == 'PARTNER_STATUS__INVITE'}">
				 										<g:img dir="css/img" file="semaforoLila.jpg"/>
				 									</g:elseif>
				 								</td>
				 								<td>
				 									<a class="btn btn-primary" href="${createLink(controller:'member', action:'showEdit', params:[memberId:it.id])}">
				 										Editar
				 									</a>
				 									<a class="btn btn-danger deleteMember" id="${it.id}" >
				 										Eliminar
				 									</a>
				 								</td>
				 							</tr>
				 						</g:each>
				 				</g:if>
				 				<g:else>
				 					
				 				</g:else>
				 			</tbody>
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

<g:render template="/sativaTemplate/scriptsTemplate"  />
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   ManagementMember.init();

});
</script>
</body>

<!-- END BODY -->
</html>