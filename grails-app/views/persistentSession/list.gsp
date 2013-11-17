
<%@ page import="grails.plugin.databasesession.PersistentSession" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'persistentSession.label', default: 'PersistentSession')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-persistentSession" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-persistentSession" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="creationTime" title="${message(code: 'persistentSession.creationTime.label', default: 'Creation Time')}" />
					
						<g:sortableColumn property="invalidated" title="${message(code: 'persistentSession.invalidated.label', default: 'Invalidated')}" />
					
						<g:sortableColumn property="lastAccessedTime" title="${message(code: 'persistentSession.lastAccessedTime.label', default: 'Last Accessed Time')}" />
					
						<g:sortableColumn property="maxInactiveInterval" title="${message(code: 'persistentSession.maxInactiveInterval.label', default: 'Max Inactive Interval')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${persistentSessionInstanceList}" status="i" var="persistentSessionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${persistentSessionInstance.id}">${fieldValue(bean: persistentSessionInstance, field: "creationTime")}</g:link></td>
					
						<td><g:formatBoolean boolean="${persistentSessionInstance.invalidated}" /></td>
					
						<td>${fieldValue(bean: persistentSessionInstance, field: "lastAccessedTime")}</td>
					
						<td>${fieldValue(bean: persistentSessionInstance, field: "maxInactiveInterval")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${persistentSessionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
