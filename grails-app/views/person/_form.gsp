<%@ page import="mycloudmedia.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'medias', 'error')} ">
	<label for="medias">
		<g:message code="person.medias.label" default="Medias" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.medias?}" var="m">
    <li><g:link controller="media" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="media" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'media.label', default: 'Media')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="person.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${personInstance?.name}"/>
</div>

