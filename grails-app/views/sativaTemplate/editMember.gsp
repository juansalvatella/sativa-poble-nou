<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->	
	<div class="modal fade" id="deleteMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1>ELIMINAR SOCIO</h1>
				</div>
				<div class="modal-body">
						<p>¿Estas seguro que quieres eliminar al usuario?</p>
				</div>
				<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<a id="btnDeleteMember" href="${createLink(controller:'member', action:'delete', params:[memberId:member.id])}" class="btn btn-danger" >Eliminar</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>


	<div class="modal fade" id="admonished" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1>AMONESTAR SOCIO</h1>
				</div>
				<div class="modal-body">
						<p>¿Estas seguro que quieres amonestar a este socio?</p>
				</div>
				<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<a id="btnAmonished" href="${createLink(controller:'member', action:'amonished', params:[memberId:member.id])}" class="btn btn-danger" >Amonestar</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	
	<div class="page-content-wrapper">
		<div class="page-content">
				 <div class="container-fluid">
				 	<g:if test="${success}">
				 		<div class="alert alert-success">${success}</div>
				 	</g:if>
				 	  <g:if test="${error}">
                        <div class="alert alert-danger">${error}</div>
                    </g:if>
          
				 	<div class="row" id="divEditMember">
				 		<div class="col-lg-3">
				 			<g:if test="${member.image}">
				 			<img src="data:image/png;base64,${imagePerson}" width="200" height="180"/>
					 		</g:if>
					 		<g:else>
								<g:img dir="css/img" file="avatar.png" width="200"/>
					 		</g:else>
				 			<g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
				 			 	<a href="#disabledMember" class="btn center btn-warning" data-toggle="modal" class="config">Desactivar socio</a>
				 			</g:if>
				 			<g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
				 			 	<a href="#disabledMember" class="btn center btn-success" data-toggle="modal" class="config">Activar socio</a>
				 			</g:elseif>
				 			 	<a href="#admonished" class="btn center btnYellow " data-toggle="modal"  class="config">Amonestar socio</a>
				 			 	<a href="#deleteMember" class="btn center btn-danger" data-toggle="modal"  class="config">Eliminar socio</a>
				 			<p></p>
			 				<div class="form-group">
								<p><b>Numero de socio:</b><br />${member.code}</p>
							</div>
							<div class="form-group">
								<p><b>Fecha de inscripción:</b><br/> <g:formatDate timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy HH:mm" date="${member.dateCreated}"/></p>
							</div>
							<div class="form-group">
								<p><b>Última cuota:</b><br/> <g:formatDate timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy HH:mm" date="${member.dateRenovation}"/></p>
							</div>
							<div class="form-group">
								<p><b>Tarjeta:</b><br />${card?.code}</p>
							</div>
							<g:if test="${member.status.name() == 'PARTNER_STATUS__INVITE'}">
								<div class="form-group">
									<p><b>Invitado por:</b><br />${member.lastFriend().firstname} ${member.lastFriend().lastname}</p>
								</div>
							</g:if>
							<div class="showCards">
								<g:if test="${yellowCard > 0}">
						 			<g:each in="${1..yellowCard}">
						 				<div>
							 				<g:img dir="css/img" file="yellowCard.jpg" width="50"/>
							 				<a class="removeCardBtn" href="${createLink(controller:'member', action:'forgiveAmonished', params:[memberId:member.id])}">
							 				X</a>
						 				</div>
						 			</g:each>
					 			</g:if>
				 			</div>

				 		</div>
				 		<div class="col-lg-5">
				 			<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'edit',controller:'member']" >
					 			<input type="hidden" name="memberId" value="${member.id}" />
					 		
					 			 <div class="form-group">
    								<label  class="col-sm-2 control-label">Nombre:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control" value="${member.firstname}" name="firstname" placeholder="Nombre">
    								</div>
    							</div>
    							 <div class="form-group">
    								<label  class="col-sm-2 control-label">Apellidos:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control" value="${member.lastname}" name="lastname" placeholder="Apellidos">
    								</div>
    							</div>
    							 <div class="form-group">
    								<label  class="col-sm-2 control-label">DNI:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control" value="${member.identificationNumber}" name="identificationNumber" placeholder="XXXXXXXXA">
    								</div>
    							</div>
    							<div class="form-group">
    								<label  class="col-sm-2 control-label">Domicilio:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control"  value="${member.address}" name="address" placeholder="C\Anonimo 123">
    								</div>
    							</div>
    							<div class="form-group">
    								<label  class="col-sm-2 control-label">Teléfono:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control" value="${member.phone}" name="phone" >
    								</div>
    							</div>
    							<div id="selectConsum" class="form-group groupGuest">
                                    <label  class="col-sm-2 control-label">Tipo consumo:</label>
                                     <div class="col-sm-10">
                                        <select name="consum" class="form-control">
                                            <g:if test="${member.consum.name() == 'CONSUM_LUDIC'}">
                                            	<option value="CONSUM_LUDIC">Lúdico</option>
                                            </g:if>
                                             <g:else>
                                            	<option value="CONSUM_LUDIC">Lúdico</option>
                                            </g:else>
                                            <g:if test="${member.consum.name() == 'CONSUM_THERAPEUTIC'}">
                                            	<option selected value="CONSUM_THERAPEUTIC">Terapéutico</option>
                                            </g:if>
                                            <g:else>
                                            	<option value="CONSUM_THERAPEUTIC">Terapéutico</option>
                                            </g:else>
                                        </select>
                                    </div>
                                </div>
    							<div class="form-group">
    								<label  class="col-sm-2 control-label">Fecha nacimiento:</label>
    								 <div class="col-sm-10">
      									<div class="col-sm-10">


                                          <input name="birthday" type="date" id="calendarBirth"  class="form-control">
                                        </div>
    								</div>
    							</div>
					 			<input class="btn center pull-right btn-success" type="submit" id="updatePartner" value="Actualizar socio" />
				 			</g:form>
							<g:if test="${numInvitations >= 5}">
					 			<div class="row alert alert-warning showAlarmGuest">
										<h2>Este usuario ha sido invitado mas de 5 veces</h2>
										<g:img  id="imageAlertGuest" dir="images/imageSativa"  file="warning.png" width="80" height="80"/>
					 			</div>
				 			</g:if>
				 		</div>
				 		<div class="col-lg-4">
				 			<video id="video" width="300" height="225" class="gapPhoto videoWebcam" autoplay></video>
				 			<a id="snap" class="btn btn-block btn-warning">
				 				<i class="icon-camera"></i>
				 				 HACER FOTO
				 			</a>
				            <div id="divCanvas" class="hide">
				                <p><b>Imagen:</b></p>
				               <canvas name="snapshot" id="snapshot" width="300" height="225"></canvas>
				               <g:form name="myForm" id="formPhoto" role="form"  class="form-horizontal" url="[action:'photo',controller:'member']" >
				               		<input type="hidden" name="image" id="foto_canvas" value="">
				               		<input type="hidden" name="memberId" value="${member.id}" />
				               		<a id="savePhoto" class="btn btn-block btn-primary" >Guardar foto</a>
				           		</g:form>
				            </div>
				            <h2>Consumo</h2>
				            <p><b>Total mensual:</b> ${grams.monthly}g</p>
				            <p><strong>Estado actual:</strong>
				            	<g:if test="${member.status.name() == 'PARTNER_STATUS__ACTIVED'}">Activo</g:if>
				            	<g:elseif test="${member.status.name() == 'PARTNER_STATUS__DISABLED'}">Deshabilitado</g:elseif>
				            	<g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">Expulsado</g:elseif>
				            	<g:elseif test="${member.status.name() == 'PARTNER_STATUS__DETOXIFIED'}">No habitual</g:elseif>
				            	<g:elseif test="${member.status.name() == 'PARTNER_STATUS__UNKNOWN'}">Desconocido</g:elseif>
				            	<g:elseif test="${member.status.name() == 'PARTNER_STATUS__INVITE'}">Invitado</g:elseif>
				            	<g:elseif test="${member.status.name() == 'PARTNER_STATUS__REMOVED'}">Eliminado</g:elseif>
				            	<g:else>N/A</g:else>
				            </p>
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
					 		<input type="hidden" name="page" value="edit" />
					 		<input type="submit" class="btn btn-success" value="Publicar comentario" />
				 		</g:form>
				 		<table id="tableHistoric" class="table table-bordered table-condensed">
				 			<g:each in="${listEvents}">
				 				<tr><td class="center"><b>${it.writer}</b><br /><small><g:formatDate timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy HH:mm" date="${it.dateCreated}"/></small></td>

				 					<g:if test="${it.type.name() == 'EVENT_TYPE__ACTIVATE'}"><td class="textGreen"></g:if>
				 					<g:elseif test="${it.type.name() == 'EVENT_TYPE__DISABLED'}"><td class="textRed"></g:elseif>
				 					<g:elseif test="${it.type.name() == 'EVENT_TYPE__RENOVATE'}"><td class="textBlue"></g:elseif>
				 					<g:else><td></g:else>
				 					${it.observation}</td>
				 				</tr>
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

		
			<g:form name="myForm" role="form" id="formMemberEdit"  class="form-horizontal" url="[controller:'member', action:actionBtn ]" >
				<div class="modal-body">
					<input type="hidden" name="memberId" value="${member.id}" />
					<input type="hidden" name="page" value="edit" />
					 <g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
						 <p>¿Estas seguro que quieres desactivarlo?.<br /> Escribe el motivo de la baja</p>
						 <textarea name="observation" id="textareaDisabled"></textarea>
					 </g:if>
					 <g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
		 			 	 <p>¿Estas seguro que quieres reactivarlo?.</p>
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
				</div>
			</g:form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>



<div class="footer">
	<div class="footer-inner">
		 2017 &copy; Sativa
	</div>
</div>

<g:render template="/sativaTemplate/scriptsTemplate"  />
<script>
jQuery(document).ready(function() {

   $('#savePhoto').click(function() {
   		$('#formPhoto').submit();
   		$('#divCanvas').addClass('hide');

   });

   App.init(); // initlayout and core plugins
   ManagementMember.init();

   if ("${member.status.name()}" == 'PARTNER_STATUS__BANNED' || "${member.status.name()}" == 'PARTNER_STATUS__DISABLED') {
   		$('#divEditMember').css("border", "red solid 2px").css("padding", 20); 
   }

    $('#updatePartner').click(function() {
   		$('#divCanvas').addClass('hide');
   });

    var birthday = new Date("${member.birthday}");


    var showBirthday =  birthday.toLocaleDateString().split('/');
 	var month = ("0" + showBirthday[1]).slice(-2);
 	var day    =("0" + showBirthday[0]).slice(-2);

 	var stringShowDate = showBirthday[2]+'-'+month+'-'+day;

 	 $('#calendarBirth').val(stringShowDate);


var player = document.getElementById('video');
var snapshotCanvas = document.getElementById('snapshot');
var captureButton = document.getElementById('snap');

var handleSuccess = function(stream) {
// Attach the video stream to the video element and autoplay.
player.srcObject = stream;
};

captureButton.addEventListener('click', function(e) {
var context = snapshot.getContext('2d');
// Draw the video frame to the canvas.
context.drawImage(player, 0, 0, snapshotCanvas.width, snapshotCanvas.height);
$('#divCanvas').removeClass('hide');
var jpegUrl = snapshot.toDataURL("image/jpeg");
document.getElementById('foto_canvas').value = jpegUrl.split(',')[1];
e.preventDefault();

});

navigator.mediaDevices.getUserMedia({video: true}).then(handleSuccess);

});
</script>
</body>

<!-- END BODY -->
</html>
