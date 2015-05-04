<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->

	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="container-fluid">
				 <div class="row well">
				 		<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'searchInvitate',controller:'member']" >
	                            <div class="row">
	                            	<div class="col-lg-3">
	                            		<div class="form-group">
	                              			<label class="col-lg-3 control-label">Nombre</label>
	                              			<div class="col-lg-9">
	                               	 			<input type="text" class="form-control" name="firstname" />
	                              			 </div>
	                               			
	                            		</div>
	                            	</div>
	                            	<div class="col-lg-3">
	                             		<div class="form-group">
	                              			<label class="col-lg-3 control-label">Apellidos</label>
	                              			<div class="col-lg-9">
			                               	 <input type="text" class="form-control" name="lastname" />
			                               </div>
			                               
			                            </div>
	                            	</div>
	                              	<div class="col-lg-3">
	                              		<div class="form-group">
	                              		   <label class="col-lg-3 control-label">DNI</label>
	                              		   <div class="col-lg-9">
		                               		 <input type="text" class="form-control" name="identificationNumber" />
		                               		</div>
		                               		
		                               	</div>
		                             </div>
		                             <div class="col-lg-2">
		                             	<div class="form-group">
	                            			<input type="submit" class="btn btn-success" value="Buscar" />
										</div>
		                            </div>
	                            </div>
	                            
			              </g:form>
			        </div>
			        <h4><b>TOTAL DE USUARIOS INVITADOS, SIN DERECHO A CONSUMIR: ${listInvitates?.size()}</b></h4>
			        <div class="row">
				 		<table id="tableGuests" class="table table-bordered table-condensed" >
				 			<thead>
				 				<tr>
				 					<th>#</th>
				 					<th></th>
					 				<th>Nombre</th>
					 				<th>DNI</th>
					 				<th>Fecha de entrada</th>
					 				<th>Invitado por</th>
					 				<th>#Veces invitado</th>
				 				</tr>
				 			</thead>
				 			<tbody>
				 				<g:if test="${listInvitates}">
				 						<g:each in="${listInvitates}" var="mem" status="i">
				 							<tr > 
				 								<td class="valignInvitate">${i+1} ${mem.code}</td>
				 								<td style="text-align:center">
				 									<g:if test="${mem.image}">
										 				<g:img dir="css/img/partners" id="${mem.image}" class="seeImage" file="${mem.image}" width="50" height="50"/></a>
											 		</g:if>
											 		<g:else>
														<g:img dir="css/img" id="avatar.png" class="seeImage" file="avatar.png" width="200"/>
								 					</g:else>
				 								</td>
				 								<td class="valignInvitate"> ${mem.firstname} ${mem.lastname}</td>
				 								<td class="valignInvitate">${mem.identificationNumber}</td>
				 								<td class="valignInvitate">${mem.dateCreated}</td>
				 								<td class="valignInvitate">${mem.friend.firstname} ${mem.friend.lastname}</td>
				 								<td class="valignInvitate">${mem.numInvitations}
				 									<g:if test="${mem.numInvitations >= 5}">
				 										<g:img dir="images/imageSativa"  file="warning.png" width="20" height="20"/>
				 									</g:if>
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
   $('.seeImage').mouseover(function(){
   		var image = $(this).attr('id')
  		$("#showImageTop").html('<img src="/css/img/partners/'+image+'" />');
  		$('#showImageTop').removeClass('hide');
	});
   $('.seeImage').mouseout(function(){
   		$('#showImageTop').addClass('hide');
	});


});
</script>
</body>

<!-- END BODY -->
</html>
<div id="showImageTop" class="hide">
	
</div>