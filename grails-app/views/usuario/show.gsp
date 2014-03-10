<%@ page import="mycloudmedia.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label"
                                                           args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-usuario" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list usuario">

        <g:if test="${usuarioInstance?.email}">
            <li class="fieldcontain">
                <span id="email-label" class="property-label"><g:message code="usuario.email.label"
                                                                         default="Email"/></span>

                <span class="property-value" aria-labelledby="email-label"><g:fieldValue
                        bean="${usuarioInstance}" field="email"/></span>

            </li>
        </g:if>

        <g:if test="${usuarioInstance?.password}">
            <li class="fieldcontain">
                <span id="password-label" class="property-label"><g:message code="usuario.password.label"
                                                                            default="Password"/></span>
                <span class="property-value" aria-labelledby="password-label"><g:passwordField
                        bean="${usuarioInstance}" name="password" field="password" disabled="true"/></span>
            </li>
        </g:if>

        <g:if test="${usuarioInstance?.creditcard}">
            <li class="fieldcontain">
                <span id="creditcard-label" class="property-label"><g:message code="usuario.creditcard.label"
                                                                              default="Creditcard"/></span>

                <span class="property-value" aria-labelledby="creditcard-label"><g:formatCC
                        number="${usuarioInstance.creditcard}"/>
                </span>

            </li>
        </g:if>

        <g:if test="${usuarioInstance?.comentarios}">
            <li class="fieldcontain">
                <span id="comentarios-label" class="property-label"><g:message code="usuario.comentarios.label"
                                                                               default="Comentarios"/></span>

                <g:each in="${usuarioInstance.comentarios}" var="c">
                    <span class="property-value" aria-labelledby="comentarios-label"><g:link
                            controller="comment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

        <g:if test="${usuarioInstance?.fechaAlta}">
            <li class="fieldcontain">
                <span id="fechaAlta-label" class="property-label"><g:message code="usuario.fechaAlta.label"
                                                                             default="Fecha Alta"/></span>

                <span class="property-value" aria-labelledby="fechaAlta-label"><g:formatDate
                        date="${usuarioInstance?.fechaAlta}" format="dd/MM/yyyy HH:mm:ss"/></span>

            </li>
        </g:if>

        <g:if test="${usuarioInstance?.ratings}">
            <li class="fieldcontain">
                <span id="ratings-label" class="property-label"><g:message code="usuario.ratings.label"
                                                                           default="Ratings"/></span>

                <g:each in="${usuarioInstance.ratings}" var="r">
                    <span class="property-value" aria-labelledby="ratings-label"><g:link controller="rating"
                                                                                         action="show"
                                                                                         id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

        <g:if test="${usuarioInstance?.reviews}">
            <li class="fieldcontain">
                <span id="reviews-label" class="property-label"><g:message code="usuario.reviews.label"
                                                                           default="Reviews"/></span>

                <g:each in="${usuarioInstance.reviews}" var="r">
                    <span class="property-value" aria-labelledby="reviews-label"><g:link controller="review"
                                                                                         action="show"
                                                                                         id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

        <g:if test="${usuarioInstance?.subscripcion}">
            <li class="fieldcontain">
                <span id="subscripcion-label" class="property-label"><g:message
                        code="usuario.subscripcion.label" default="Subscripcion: "/><g:fieldValue
                        bean="${usuarioInstance.subscripcion}" field="type"/></span>

                <span class="property-value" aria-labelledby="subscripcion-label"><g:link
                        controller="subscription" action="show"
                        id="${usuarioInstance?.subscripcion?.id}">Modificar Subscripción</g:link></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: usuarioInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${usuarioInstance}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
