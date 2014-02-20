<%@ page import="mycloudmedia.Subscription" %>



<div class="fieldcontain ${hasErrors(bean: subscriptionInstance, field: 'type', 'error')} required">
    <label for="type">
        <g:message code="subscription.type.label" default="Type"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select name="type" from="${subscriptionInstance.constraints.type.inList}" required=""
              value="${subscriptionInstance?.type}" valueMessagePrefix="subscription.type"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subscriptionInstance, field: 'user', 'error')} required">
    <label for="user">
        <g:message code="subscription.user.label" default="User"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="user" name="user.name" from="${mycloudmedia.Usuario.list()}" optionKey="id" required=""
              value="${subscriptionInstance?.user?.name}" class="many-to-one"/>
</div>

