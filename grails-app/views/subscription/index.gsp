<%@ page import="mycloudmedia.Subscription" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'subscription.label', default: 'Subscription')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-subscription" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                   default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>

<div id="list-subscription" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="type" title="${message(code: 'subscription.type.label', default: 'Type')}"/>

            <th><g:message code="subscription.user.label" default="User"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${subscriptionInstanceList}" status="i" var="subscriptionInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${subscriptionInstance.id}">${fieldValue(bean: subscriptionInstance, field: "type")}</g:link></td>

                <td>${fieldValue(bean: subscriptionInstance, field: "user")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${subscriptionInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
