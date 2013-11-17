<%@ page import="grails.plugin.databasesession.PersistentSessionAttribute" %>



<div class="fieldcontain ${hasErrors(bean: persistentSessionAttributeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="persistentSessionAttribute.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${persistentSessionAttributeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: persistentSessionAttributeInstance, field: 'session', 'error')} required">
	<label for="session">
		<g:message code="persistentSessionAttribute.session.label" default="Session" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="session" name="session.id" from="${grails.plugin.databasesession.PersistentSession.list()}" optionKey="id" required="" value="${persistentSessionAttributeInstance?.session?.id}" class="many-to-one"/>
</div>

