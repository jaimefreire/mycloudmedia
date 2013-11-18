
<%@ page import="mycloudmedia.Media" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'media.label', default: 'Media')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-media" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-media" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list media">
			
				<g:if test="${mediaInstance?.ISBN}">
				<li class="fieldcontain">
					<span id="ISBN-label" class="property-label"><g:message code="media.ISBN.label" default="ISBN" /></span>
					
						<span class="property-value" aria-labelledby="ISBN-label"><g:fieldValue bean="${mediaInstance}" field="ISBN"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mediaInstance?.people}">
				<li class="fieldcontain">
					<span id="people-label" class="property-label"><g:message code="media.people.label" default="People" /></span>
					
						<span class="property-value" aria-labelledby="people-label"><g:link controller="person" action="show" id="${mediaInstance?.people?.id}">${mediaInstance?.people?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${mediaInstance?.rating}">
				<li class="fieldcontain">
					<span id="rating-label" class="property-label"><g:message code="media.rating.label" default="Rating" /></span>
					
						<span class="property-value" aria-labelledby="rating-label"><g:link controller="rating" action="show" id="${mediaInstance?.rating?.id}">${mediaInstance?.rating?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${mediaInstance?.releaseDate}">
				<li class="fieldcontain">
					<span id="releaseDate-label" class="property-label"><g:message code="media.releaseDate.label" default="Release Date" /></span>
					
						<span class="property-value" aria-labelledby="releaseDate-label"><g:formatDate date="${mediaInstance?.releaseDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mediaInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="media.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${mediaInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${mediaInstance?.id}" />
					<g:link class="edit" action="edit" id="${mediaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
