<%@ page import="grails.plugin.databasesession.PersistentSession" %>



<div class="fieldcontain ${hasErrors(bean: persistentSessionInstance, field: 'creationTime', 'error')} required">
	<label for="creationTime">
		<g:message code="persistentSession.creationTime.label" default="Creation Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="creationTime" type="number" value="${persistentSessionInstance.creationTime}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: persistentSessionInstance, field: 'invalidated', 'error')} ">
	<label for="invalidated">
		<g:message code="persistentSession.invalidated.label" default="Invalidated" />
		
	</label>
	<g:checkBox name="invalidated" value="${persistentSessionInstance?.invalidated}" />
</div>

<div class="fieldcontain ${hasErrors(bean: persistentSessionInstance, field: 'lastAccessedTime', 'error')} required">
	<label for="lastAccessedTime">
		<g:message code="persistentSession.lastAccessedTime.label" default="Last Accessed Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="lastAccessedTime" type="number" value="${persistentSessionInstance.lastAccessedTime}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: persistentSessionInstance, field: 'maxInactiveInterval', 'error')} required">
	<label for="maxInactiveInterval">
		<g:message code="persistentSession.maxInactiveInterval.label" default="Max Inactive Interval" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxInactiveInterval" type="number" value="${persistentSessionInstance.maxInactiveInterval}" required=""/>
</div>

