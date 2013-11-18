<%@ page import="mycloudmedia.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'nombre', 'error')} required">
    <label for="nombre">
        <g:message code="usuario.nombre.label" default="Nombre"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="nombre" maxlength="50" required="" value="${usuarioInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'apellidos', 'error')} required">
    <label for="apellidos">
        <g:message code="usuario.apellidos.label" default="Apellidos"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="apellidos" maxlength="50" required="" value="${usuarioInstance?.apellidos}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'username', 'error')} required">
    <label for="username">
        <g:message code="usuario.username.label" default="Username"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="username" maxlength="50" required="" value="${usuarioInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} ">
    <label for="password">
        <g:message code="usuario.password.label" default="Password"/>

    </label>
    <g:textField name="password" maxlength="50" value="${usuarioInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'correo', 'error')} required">
    <label for="correo">
        <g:message code="usuario.correo.label" default="Correo"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field type="email" name="correo" maxlength="50" required="" value="${usuarioInstance?.correo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'fecha_nacimiento', 'error')} required">
    <label for="fecha_nacimiento">
        <g:message code="usuario.fecha_nacimiento.label" default="Fechanacimiento"/>
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="fecha_nacimiento" precision="day" value="${usuarioInstance?.fecha_nacimiento}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'activo', 'error')} ">
    <label for="activo">
        <g:message code="usuario.activo.label" default="Activo"/>

    </label>
    <g:checkBox name="activo" value="${usuarioInstance?.activo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'medias', 'error')} ">
    <label for="medias">
        <g:message code="usuario.medias.label" default="Medias"/>

    </label>
    <g:select name="medias" from="${mycloudmedia.Media.list()}" multiple="multiple" optionKey="id" size="5"
              value="${usuarioInstance?.medias*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'subscription', 'error')} required">
    <label for="subscription">
        <g:message code="usuario.subscription.label" default="Subscription"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="subscription" name="subscription.id" from="${mycloudmedia.Subscription.list()}" optionKey="id"
              required="" value="${usuarioInstance?.subscription?.id}" class="many-to-one"/>
</div>

