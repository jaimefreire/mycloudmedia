<%@ page import="mycloudmedia.Comment" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'comment.label', default: 'Comment')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-comment" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-comment" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list comment">

        <g:if test="${commentInstance?.texto}">
            <li class="fieldcontain">
                <span id="texto-label" class="property-label"><g:message code="comment.texto.label"
                                                                         default="Texto"/></span>

                <span class="property-value" aria-labelledby="texto-label"><g:fieldValue bean="${commentInstance}"
                                                                                         field="texto"/></span>

            </li>
        </g:if>

        <g:if test="${commentInstance?.author}">
            <li class="fieldcontain">
                <span id="author-label" class="property-label"><g:message code="comment.author.label"
                                                                          default="Author"/></span>

                <span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${commentInstance}"
                                                                                          field="author"/></span>

            </li>
        </g:if>

        <g:if test="${commentInstance?.comments}">
            <li class="fieldcontain">
                <span id="comments-label" class="property-label"><g:message code="comment.comments.label"
                                                                            default="Comments"/></span>

                <g:each in="${commentInstance.comments}" var="c">
                    <span class="property-value" aria-labelledby="comments-label"><g:link controller="comment"
                                                                                          action="show"
                                                                                          id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

        <g:if test="${commentInstance?.denunciado}">
            <li class="fieldcontain">
                <span id="denunciado-label" class="property-label"><g:message code="comment.denunciado.label"
                                                                              default="Denunciado"/></span>

                <span class="property-value" aria-labelledby="denunciado-label"><g:formatBoolean
                        boolean="${commentInstance?.denunciado}"/></span>

            </li>
        </g:if>

        <g:if test="${commentInstance?.fecha}">
            <li class="fieldcontain">
                <span id="fecha-label" class="property-label"><g:message code="comment.fecha.label"
                                                                         default="Fecha"/></span>

                <span class="property-value" aria-labelledby="fecha-label"><g:formatDate
                        date="${commentInstance?.fecha}"/></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: commentInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${commentInstance}"><g:message code="default.button.edit.label"
                                                                                        default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
