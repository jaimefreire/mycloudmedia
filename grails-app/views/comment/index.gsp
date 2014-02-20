<%@ page import="mycloudmedia.Comment" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'comment.label', default: 'Comment')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-comment" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-comment" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="texto" title="${message(code: 'comment.texto.label', default: 'Texto')}"/>

            <g:sortableColumn property="author" title="${message(code: 'comment.author.label', default: 'Author')}"/>

            <g:sortableColumn property="denunciado"
                              title="${message(code: 'comment.denunciado.label', default: 'Denunciado')}"/>

            <g:sortableColumn property="fecha" title="${message(code: 'comment.fecha.label', default: 'Fecha')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${commentInstanceList}" status="i" var="commentInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${commentInstance.id}">${fieldValue(bean: commentInstance, field: "texto")}</g:link></td>

                <td>${fieldValue(bean: commentInstance, field: "author")}</td>

                <td><g:formatBoolean boolean="${commentInstance.denunciado}"/></td>

                <td><g:formatDate date="${commentInstance.fecha}"/></td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${commentInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
