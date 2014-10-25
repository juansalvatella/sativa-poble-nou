<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	
	<div class="page-content-wrapper">
		<div class="page-content">
				 <div class="container-fluid">
				 	<g:if test="${success}">
				 		<div class="alert alert-success">${success}</div>
				 	</g:if>
				 	<div class="row">
				 		<div class="col-lg-3">
				 			<g:if test="${member.image}">
				 			<g:img dir="css/img/partners" file="${member.image}" width="200" height="180"/>
					 		</g:if>
					 		<g:else>
								<g:img dir="css/img" file="avatar.png" width="200"/>
					 		</g:else>
				 			<g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
				 			 	<a href="#disabledMember" class="btn center btn-danger" data-toggle="modal" class="config">Desactivar socio</a>
				 			</g:if>
				 			<g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
				 			 	<a href="#disabledMember" class="btn btn-success" data-toggle="modal" class="config">Activar socio</a>
				 			</g:elseif>
				 			<g:elseif test="${member.status.name() == 'PARTNER_STATUS__DISABLED'}">
				 			 	<a href="#disabledMember" class="btn btn-primary" data-toggle="modal" class="config">Renovar socio</a>
				 			</g:elseif>
				 			<p></p>
			 				<div class="form-group">
								<p><b>Numero de socio:</b><br />${member.code}</p>
							</div>
								<div class="form-group">
								<p><b>Fecha de inscripción:</b><br/> <g:formatDate format="dd-MM-yyyy HH:mm" date="${member.dateCreated}"/></p>
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
    								<label  class="col-sm-2 control-label">Email:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control" value="${member.email}" name="email" placeholder="algo@algo.com">
    								</div>
    							</div>
    							<input type="hidden" name="image" id="foto_canvas" value="">
					 			<input type="submit" class="btn center pull-right btn-success" value="Actualizar socio" />
					 			
				 			</g:form>
				 		</div>
				 		<div class="col-lg-4">
				 			<video id="video" width="200" height="150" class="gapPhoto videoWebcam" autoplay></video>
				 			<a id="snap" class="btn btn-block btn-warning">
				 				<i class="icon-camera"></i>
				 				 HACER FOTO
				 			</a>
				            <div id="divCanvas">  
				                <p><b>Imagen:</b></p>
				               <canvas name="canvas" id="canvas" class="hide" width="300" height="200"></canvas>
				            </div>
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


    // Put event listeners into place
    window.addEventListener("DOMContentLoaded", function() {
        // Grab elements, create settings, etc.
        var canvas = document.getElementById("canvas"),
            context = canvas.getContext("2d"),
            video = document.getElementById("video"),
            videoObj = { "video": true },
            errBack = function(error) {
                console.log("Video capture error: ", error.code); 
            };
    
        // Put video listeners into place
        if(navigator.getUserMedia) { // Standard
            navigator.getUserMedia(videoObj, function(stream) {
                video.src = stream;
                video.play();
            }, errBack);
        } else if(navigator.webkitGetUserMedia) { // WebKit-prefixed
            navigator.webkitGetUserMedia(videoObj, function(stream){
                video.src = window.webkitURL.createObjectURL(stream);
                video.play();
            }, errBack);
        } else if(navigator.mozGetUserMedia) { // WebKit-prefixed
            navigator.mozGetUserMedia(videoObj, function(stream){
                video.src = window.URL.createObjectURL(stream);
                video.play();
            }, errBack);
        }
    
        document.getElementById("snap").addEventListener("click", function() {
        	$('#canvas').removeClass('hide');
            context.drawImage(video, 0, 0, 310, 200);
            var jpegUrl = canvas.toDataURL("image/jpeg");
            document.getElementById('foto_canvas').value = jpegUrl.split(',')[1];
            cevent.preventDefault(); 
        });
    }, false);
});
</script>
</body>

<!-- END BODY -->
</html>