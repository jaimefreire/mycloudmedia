<%@ page import="mycloudmedia.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-usuario" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="email" title="${message(code: 'usuario.email.label', default: 'Email')}"/>

            <g:sortableColumn property="password"
                              title="${message(code: 'usuario.password.label', default: 'Contraseña')}"/>

            <g:sortableColumn property="creditcard"
                              title="${message(code: 'usuario.creditcard.label', default: 'Tarjeta')}"/>

            <g:sortableColumn property="fechaAlta"
                              title="${message(code: 'usuario.fechaAlta.label', default: 'Fecha de Alta')}"/>

            <th><g:message code="usuario.subscripcion.label" default="Subscripcion"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${usuarioInstanceList}" status="i" var="usuarioInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${usuarioInstance.id}">${fieldValue(bean: usuarioInstance, field: "email")}</g:link></td>

                <td><g:passwordField
                        bean="${usuarioInstance}" name="password" field="password" disabled="true"/></td>

                <td><g:formatCC number="${usuarioInstance.creditcard}"/></td>

                <td><g:formatDate date="${usuarioInstance.fechaAlta}" format="dd/MM/yyyy HH:mm:ss"/></td>

                <td>${fieldValue(bean: usuarioInstance.subscripcion, field: "type")}<g:link
                        controller="subscription" action="show"
                        id="${usuarioInstance?.subscripcion?.id}">Modificar</g:link></td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${usuarioInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
