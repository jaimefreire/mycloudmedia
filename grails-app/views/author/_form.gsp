<%@ page import="database.Author" %>



<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'medias', 'error')} ">
	<label for="medias">
		<g:message code="author.medias.label" default="Medias" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${authorInstance?.medias?}" var="m">
    <li><g:link controller="media" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="media" action="create" params="['author.id': authorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'media.label', default: 'Media')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="author.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${authorInstance?.name}"/>
</div>

