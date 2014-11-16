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
              	<div class="col-lg-4">
                  <div class="form-group">
                      <label class="col-lg-3 control-label">Nombre</label>
                      <div class="col-lg-9">
                        <input type="text" class="form-control" name="name" />
                       </div>
                      
                  </div>
                </div>
                <div class="col-lg-4">
                  <div class="form-group">
                      <label class="col-lg-3 control-label">Precios</label>
                      <div class="col-lg-9">
                       <input type="text" class="form-control" name="price" />
                     </div>
                  </div>
                </div>
                <div class="col-lg-4">
                  <div class="form-group">
                      <label class="col-lg-3 control-label">Gramos</label>
                      <div class="col-lg-9">
                       <input type="text" class="form-control" name="grams" />
                     </div>
                  </div>
                </div>
                <div class="col-lg-4 pull-right">
                  <div class="form-group pull-right" id="newGenetic">
                      <button class="btn btn-primary" type="submit" >Nueva genetica</button>
                  </div>
                </div>
          </g:form>
				</div>
        <hr />
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

<g:render template="/sativaTemplate/scriptsTemplate"  />
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
});
</script>
</body>

<!-- END BODY -->
</html>