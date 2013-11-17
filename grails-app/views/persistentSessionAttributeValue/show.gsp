
<%@ page import="grails.plugin.databasesession.PersistentSessionAttributeValue" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-persistentSessionAttributeValue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-persistentSessionAttributeValue" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list persistentSessionAttributeValue">
			
				<g:if test="${persistentSessionAttributeValueInstance?.serialized}">
				<li class="fieldcontain">
					<span id="serialized-label" class="property-label"><g:message code="persistentSessionAttributeValue.serialized.label" default="Serialized" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${persistentSessionAttributeValueInstance?.attribute}">
				<li class="fieldcontain">
					<span id="attribute-label" class="property-label"><g:message code="persistentSessionAttributeValue.attribute.label" default="Attribute" /></span>
					
						<span class="property-value" aria-labelledby="attribute-label"><g:link controller="persistentSessionAttribute" action="show" id="${persistentSessionAttributeValueInstance?.attribute?.id}">${persistentSessionAttributeValueInstance?.attribute?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${persistentSessionAttributeValueInstance?.id}" />
					<g:link class="edit" action="edit" id="${persistentSessionAttributeValueInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
