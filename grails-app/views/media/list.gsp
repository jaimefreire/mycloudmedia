
<%@ page import="mycloudmedia.Media" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'media.label', default: 'Media')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-media" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-media" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="ISBN" title="${message(code: 'media.ISBN.label', default: 'ISBN')}" />
					
						<th><g:message code="media.people.label" default="People" /></th>
					
						<th><g:message code="media.rating.label" default="Rating" /></th>
					
						<g:sortableColumn property="releaseDate" title="${message(code: 'media.releaseDate.label', default: 'Release Date')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'media.title.label', default: 'Title')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mediaInstanceList}" status="i" var="mediaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mediaInstance.id}">${fieldValue(bean: mediaInstance, field: "ISBN")}</g:link></td>
					
						<td>${fieldValue(bean: mediaInstance, field: "people")}</td>
					
						<td>${fieldValue(bean: mediaInstance, field: "rating")}</td>
					
						<td><g:formatDate date="${mediaInstance.releaseDate}" /></td>
					
						<td>${fieldValue(bean: mediaInstance, field: "title")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mediaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
