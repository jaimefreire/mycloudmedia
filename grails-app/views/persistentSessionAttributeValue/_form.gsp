<%@ page import="grails.plugin.databasesession.PersistentSessionAttributeValue" %>



<div class="fieldcontain ${hasErrors(bean: persistentSessionAttributeValueInstance, field: 'serialized', 'error')} required">
	<label for="serialized">
		<g:message code="persistentSessionAttributeValue.serialized.label" default="Serialized" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="serialized" name="serialized" />
</div>

<div class="fieldcontain ${hasErrors(bean: persistentSessionAttributeValueInstance, field: 'attribute', 'error')} required">
	<label for="attribute">
		<g:message code="persistentSessionAttributeValue.attribute.label" default="Attribute" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="attribute" name="attribute.id" from="${grails.plugin.databasesession.PersistentSessionAttribute.list()}" optionKey="id" required="" value="${persistentSessionAttributeValueInstance?.attribute?.id}" class="many-to-one"/>
</div>

