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
                    <g:if test="${error}">
                        <div class="alert alert-danger">${error}</div>
                    </g:if>
          
				 	<div class="row">
				 		<div class="col-lg-4">
				      <video id="video" width="200" height="150" class="gapPhoto videoWebcam" autoplay></video>
				 			<a id="snap" class="btn btn-block btn-warning">
				 				<i class="icon-camera"></i>
				 				 HACER FOTO
				 			</a>
              <div id="divCanvas">  
                  <p><b>Imagen:</b></p>
                 <canvas name="canvas" id="snapshot" width="300"    height="200"></canvas>
              </div>
				 		</div>
				 		<div class="col-lg-8">
				 			<g:form name="myForm" role="form" class="form-horizontal" url="[action:'create',controller:'member']" >
					 			 <div class="form-group">
    								<label  class="col-sm-2 control-label">Nombre:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control" name="firstname" placeholder="Nombre">
    								</div>
    							</div>
    							 <div class="form-group">
    								<label  class="col-sm-2 control-label">Apellidos:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control" name="lastname" placeholder="Apellidos">
    								</div>
    							</div>
    							 <div class="form-group">
    								<label  class="col-sm-2 control-label">DNI:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control" name="identificationNumber" placeholder="XXXXXXXXA">
    								</div>
    							</div>
    							<div class="form-group groupGuest">
    								<label  class="col-sm-2 control-label">Domicilio:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control" name="address" placeholder="C\Anonimo 123">
    								</div>
    							</div>
    							<div class="form-group groupGuest">
    								<label  class="col-sm-2 control-label">Teléfono:</label>
    								 <div class="col-sm-10">
      									<input type="text" class="form-control" name="phone">
    								</div>
                                    <input type="hidden" name="image" id="foto_canvas" value="">
                                    <input type="hidden" name="codeCard" id="codeCard" value="">
                                    <input type="hidden" name="friend" id="friend" value="${memberId}">
    							</div>
                                <div class="form-group">
                                         <label  class="col-sm-2 control-label">Fecha de nacimiento:</label>
                                        <div class="col-sm-10">
                                          <input name="birthday" type="date" id="calendar1" class="form-control">
                                        </div>
                                </div>
                                <div id="selectConsum" class="form-group groupGuest">
                                    <label  class="col-sm-2 control-label">Tipo consumo:</label>
                                     <div class="col-sm-10">
                                        <select name="consum" class="form-control">
                                            <option value="CONSUM_LUDIC">Lúdico</option>
                                            <option value="CONSUM_THERAPEUTIC">Terapéutico</option>
                                            
                                        </select>
                                    </div>
                                </div>
                                <div id="selectMember" class="form-group groupGuest">
                                    <label  class="col-sm-2 control-label">Seleccionar miembro:</label>
                                     <div class="col-sm-10">
                                        <select name="oldPartner" class="form-control">
                                            <option  value="">Seleccinar socio</option>
                                            <g:each in="${listMembers}">
                                                <option value="${it.id}">${it.firstname} ${it.lastname}</option>
                                            </g:each>
                                        </select>
                                    </div>
                                </div>
					 			<g:if test="${memberId != null}">
                                    
                                    <input type="submit" class="btn center  pull-right btn-success" value="Nuevo invitado" />
                                </g:if>
                                <g:else>
                                    <input type="submit" class="btn center  pull-right btn-success" value="Nuevo socio" />
                                </g:else>
				 			</g:form>
				 		</div>
				 		
				 	</div>
				 	<div class="row" id="listActiveGenetics">
				 		<g:each in="${listGenetics}">
				 			<a class="geneticAdd btn btn-success btn-lg"> ${it.name}</a>
				 		</g:each>
				 	</div>
				 	<hr />	
			 </div>
		</div>
	</div>

	<!-- END CONTENT -->
</div>

</div>



<div class="footer">
	<div class="footer-inner">
		 2017 &copy; Sativa
	</div>
</div>
<g:render template="/sativaTemplate/scriptsTemplate"  />
<script>

jQuery(document).ready(function() {    
    
   App.init(); // initlayout and core plugins
   $('#codeCard').val("${numCard}")

   if ("${memberId}" != "" &&  "${memberId}" != null)  {
    
        $('.groupGuest').addClass('hide');
   }


    $('#calendar1').val("");

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