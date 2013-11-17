<%@ page import="database.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'medias', 'error')} ">
	<label for="medias">
		<g:message code="usuario.medias.label" default="Medias" />
		
	</label>
	<g:select name="medias" from="${database.Media.list()}" multiple="multiple" optionKey="id" size="5" value="${usuarioInstance?.medias*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="usuario.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${usuarioInstance?.name}"/>
</div>

