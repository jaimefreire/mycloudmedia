<%@ page import="mycloudmedia.Subscription; mycloudmedia.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'email', 'error')} required">
    <label for="email">
        <g:message code="usuario.email.label" default="Email"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field type="email" name="email" required="" value="${usuarioInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} required">
    <label for="password">
        <g:message code="usuario.password.label" default="Password"/>
        <span class="required-indicator">*</span>
    </label>
    <g:passwordField name="password" maxlength="50" required="" value="${usuarioInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} required">
    <label for="password">
        <g:message code="usuario.confirm.label" default="Confirmar password"/>
        <span class="required-indicator">*</span>
    </label>
    <g:passwordField name="confirm" maxlength="50" required="" value="${usuarioInstance?.confirm}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'birthDate', 'error')} required">
    <label for="birthDate">
        <g:message code="usuario.birthDate.label" default="Fecha de nacimiento"/>
        <span class="required-indicator">*</span>
    </label>

    <body onload="document.getElementById('birthDate').value = document.getElementById('birthDate_value').value;">
    <calendar:datePicker name="birthDate" defaultValue="${new Date(333367200046)}" years="1930,2011"
                         dateFormat="%d/%m/%Y" showReset="false" singleClick="true"
                         value="${Date.parse("dd/MM/yy", "25/06/80")}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'creditcard', 'error')} ">
    <label for="creditcard">
        <g:message code="usuario.creditcard.label" default="Creditcard"/>
    </label>
    <g:textField name="creditcard" value="${usuarioInstance?.creditcard}" maxlength="16"/>

    <label for="CVV">
        <g:message code="usuario.cvv.label" default="CVV"/>
    </label>
    <g:textField name="cvv" value="${usuarioInstance?.cvv}" maxlength="4"/>
</div>

<!--<g:hiddenField name="fechaAlta" value="${new Date().getDateTimeString()} )"/>-->
<!-- Default subscription -->
<!--<g:hiddenField name="subscripcion" value="${new Subscription('blank')}"/>-->

