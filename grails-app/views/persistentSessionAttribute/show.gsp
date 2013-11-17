
<%@ page import="grails.plugin.databasesession.PersistentSessionAttribute" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'persistentSessionAttribute.label', default: 'PersistentSessionAttribute')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-persistentSessionAttribute" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-persistentSessionAttribute" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list persistentSessionAttribute">
			
				<g:if test="${persistentSessionAttributeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="persistentSessionAttribute.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${persistentSessionAttributeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${persistentSessionAttributeInstance?.session}">
				<li class="fieldcontain">
					<span id="session-label" class="property-label"><g:message code="persistentSessionAttribute.session.label" default="Session" /></span>
					
						<span class="property-value" aria-labelledby="session-label"><g:link controller="persistentSession" action="show" id="${persistentSessionAttributeInstance?.session?.id}">${persistentSessionAttributeInstance?.session?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${persistentSessionAttributeInstance?.id}" />
					<g:link class="edit" action="edit" id="${persistentSessionAttributeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
