<%@ page import="mycloudmedia.Rating" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'rating.label', default: 'Rating')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-rating" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-rating" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <th><g:message code="rating.review.label" default="Review"/></th>

            <g:sortableColumn property="score" title="${message(code: 'rating.score.label', default: 'Score')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${ratingInstanceList}" status="i" var="ratingInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${ratingInstance.id}">${fieldValue(bean: ratingInstance, field: "review")}</g:link></td>

                <td>${fieldValue(bean: ratingInstance, field: "score")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${ratingInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
