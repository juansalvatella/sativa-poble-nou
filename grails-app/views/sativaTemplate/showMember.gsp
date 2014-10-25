<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
				 <div class="container-fluid">
				 	<div class="row">
				 		<div class="col-lg-3">
				 			<g:if test="${member.image}">
				 			<g:img dir="css/img/partners" file="${member.image}" width="225" height="180"/>
					 		</g:if>
					 		<g:else>
								<g:img dir="css/img" file="avatar.png" width="200"/>
					 		</g:else>
					 		<g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
				 			 	<a href="#disabledMember" class="btn btn-block btn-danger" data-toggle="modal" class="config">Desactivar socio</a>
				 			</g:if>
				 			<g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
				 			 	<a href="#disabledMember" class="btn btn-block  btn-success" data-toggle="modal" class="config">Activar socio</a>
				 			</g:elseif>
				 			<g:elseif test="${member.status.name() == 'PARTNER_STATUS__DISABLED'}">
				 			 	<a href="#disabledMember" class="btn  btn-block btn-primary" data-toggle="modal" class="config">Renovar socio</a>
				 			</g:elseif>
				 		</div>
				 		<div class="col-lg-5">
				 			<p><b>Nombre:</b> ${member.firstname}</p>
				 			<p><b>Apellidos:</b> ${member.lastname}</p>
				 			<p><b>DNI:</b>  ${member.identificationNumber}</p>
				 			<p><b>Domicilio:</b>  ${member.address}</p>
				 			<p><b>Email:</b>  ${member.email}</p>
				 			<p><b>Numero de socio:</b>  ${member.code}</p>
				 			<p><b>Fecha de inscripción:</b> <g:formatDate format="dd-MM-yyyy HH:mm" date="${member.dateCreated}"/> </p>
				 		</div>
				 		<div class="col-lg-4">
				 			<!--<video id="video" width="200" height="150" class="gapPhoto videoWebcam" autoplay></video>
				 			<a id="snap" class="btn btn-block btn-warning">
				 				<i class="icon-camera"></i>
				 				 HACER FOTO
				 			</a>
				            <div id="divCanvas">  
				                <p><b>Imagen:</b></p>
				               <canvas name="canvas" id="canvas" width="300" height="200"></canvas>
				            </div>-->
								 		
				 		</div>
				 	</div>
				 	<div class="row" id="listActiveGenetics">
				 		<g:each in="${listGenetics}">
				 			<a class="geneticAdd btn btn-success btn-lg"> ${it.name}</a>
				 		</g:each>
				 	</div>
				 	<hr />
				 	<div class="row">
				 		<g:cookie name="myCookie" />
				 		<h3>Historial del usuario</h3>
				 		<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'create',controller:'event']" >
					 		<textarea  name="observation" class="textareaHistoric"></textarea>
					 		<input type="hidden" name="partnerId" value="${member.id}" />
					 		<input type="submit" class="btn btn-success" value="Publicar comentario" />
				 		</g:form>
				 		<table id="tableHistoric" class="table table-bordered table-condensed">
				 			<g:each in="${listEvents}">
				 				<tr><td class="center"><b>${it.writer}</b><br /><small><g:formatDate format="dd-MM-yyyy HH:mm" date="${it.dateCreated}"/></small></td><td>${it.observation}</td></tr>
				 			</g:each>
				 		</table>
				 	</div>
				 </div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->

<div class="modal fade" id="disabledMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED'}">
					<h4 class="modal-title">DESACTIVAR SOCIO</h4>
				</g:if>
				<g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
	 			 	<h4 class="modal-title">ACTIVAR SOCIO</h4>
	 			</g:elseif>
	 			<g:elseif test="${member.status.name() == 'PARTNER_STATUS__DISABLED'}">
	 			 	<h4 class="modal-title">RENOVAR SOCIO</h4>
	 			</g:elseif>
			</div>
			
			<g:set var="controllerBtn" value="" />
			<g:set var="actionBtn" value="" />
			<g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
				<g:set var="actionBtn" value="remove" />
			</g:if>
			<g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
				<g:set var="actionBtn" value="activate" />
			</g:elseif>
			<g:elseif test="${member.status.name() == 'PARTNER_STATUS__DISABLED'}">
				<g:set var="actionBtn" value="renovation" />
			</g:elseif>

		
			<g:form name="myForm" role="form"  class="form-horizontal" url="[controller:'member', action:actionBtn ]" >
				<div class="modal-body">
					<input type="hidden" name="memberId" value="${member.id}" />
					 <g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
						 <p>¿Estas seguro que quieres desactivarlo?.<br /> Escribe el motivo de la baja</p>
						 <textarea name="observation" id="textareaDisabled"></textarea>
					 </g:if>
					 <g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
		 			 	 <p>¿Estas seguro que quieres reactivarlo?.</p>
		 			</g:elseif>
		 			<g:elseif test="${member.status.name() == PARTNER_STATUS__DISABLED}">
		 			 	 <p>¿Estas seguro que quieres renovarlo?.</p>
		 			</g:elseif>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
						<input type="submit" class="btn btn-danger" value="Desactivar" />
					</g:if>
					<g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
						<input type="submit" class="btn btn-success" value="Activar" />
					</g:elseif>
					<g:elseif test="${member.status.name() == 'PARTNER_STATUS__DISABLED'}">
						<input type="submit" class="btn btn-primary" value="Renovar" />
					</g:elseif>
				</div>
			</g:form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>



<div class="footer">
	<div class="footer-inner">
		 2014 &copy; Sativa
	</div>
</div>

<g:render template="/sativaTemplate/scriptsTemplate"  />
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins

});
</script>
</body>

<!-- END BODY -->
</html>