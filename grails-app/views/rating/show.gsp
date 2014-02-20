<%@ page import="mycloudmedia.Rating" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'rating.label', default: 'Rating')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-rating" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-rating" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list rating">

        <g:if test="${ratingInstance?.review}">
            <li class="fieldcontain">
                <span id="review-label" class="property-label"><g:message code="rating.review.label"
                                                                          default="Review"/></span>

                <span class="property-value" aria-labelledby="review-label"><g:link controller="review" action="show"
                                                                                    id="${ratingInstance?.review?.id}">${ratingInstance?.review?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${ratingInstance?.score}">
            <li class="fieldcontain">
                <span id="score-label" class="property-label"><g:message code="rating.score.label"
                                                                         default="Score"/></span>

                <span class="property-value" aria-labelledby="score-label"><g:fieldValue bean="${ratingInstance}"
                                                                                         field="score"/></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: ratingInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${ratingInstance}"><g:message code="default.button.edit.label"
                                                                                       default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
