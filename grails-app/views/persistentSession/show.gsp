
<%@ page import="grails.plugin.databasesession.PersistentSession" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'persistentSession.label', default: 'PersistentSession')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-persistentSession" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-persistentSession" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list persistentSession">
			
				<g:if test="${persistentSessionInstance?.creationTime}">
				<li class="fieldcontain">
					<span id="creationTime-label" class="property-label"><g:message code="persistentSession.creationTime.label" default="Creation Time" /></span>
					
						<span class="property-value" aria-labelledby="creationTime-label"><g:fieldValue bean="${persistentSessionInstance}" field="creationTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${persistentSessionInstance?.invalidated}">
				<li class="fieldcontain">
					<span id="invalidated-label" class="property-label"><g:message code="persistentSession.invalidated.label" default="Invalidated" /></span>
					
						<span class="property-value" aria-labelledby="invalidated-label"><g:formatBoolean boolean="${persistentSessionInstance?.invalidated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${persistentSessionInstance?.lastAccessedTime}">
				<li class="fieldcontain">
					<span id="lastAccessedTime-label" class="property-label"><g:message code="persistentSession.lastAccessedTime.label" default="Last Accessed Time" /></span>
					
						<span class="property-value" aria-labelledby="lastAccessedTime-label"><g:fieldValue bean="${persistentSessionInstance}" field="lastAccessedTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${persistentSessionInstance?.maxInactiveInterval}">
				<li class="fieldcontain">
					<span id="maxInactiveInterval-label" class="property-label"><g:message code="persistentSession.maxInactiveInterval.label" default="Max Inactive Interval" /></span>
					
						<span class="property-value" aria-labelledby="maxInactiveInterval-label"><g:fieldValue bean="${persistentSessionInstance}" field="maxInactiveInterval"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${persistentSessionInstance?.id}" />
					<g:link class="edit" action="edit" id="${persistentSessionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
