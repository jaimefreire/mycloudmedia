
<%@ page import="grails.plugin.databasesession.PersistentSessionAttributeValue" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-persistentSessionAttributeValue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-persistentSessionAttributeValue" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="serialized" title="${message(code: 'persistentSessionAttributeValue.serialized.label', default: 'Serialized')}" />
					
						<th><g:message code="persistentSessionAttributeValue.attribute.label" default="Attribute" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${persistentSessionAttributeValueInstanceList}" status="i" var="persistentSessionAttributeValueInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${persistentSessionAttributeValueInstance.id}">${fieldValue(bean: persistentSessionAttributeValueInstance, field: "serialized")}</g:link></td>
					
						<td>${fieldValue(bean: persistentSessionAttributeValueInstance, field: "attribute")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${persistentSessionAttributeValueInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
