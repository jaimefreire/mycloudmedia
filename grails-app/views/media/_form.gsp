<%@ page import="database.Media" %>



<div class="fieldcontain ${hasErrors(bean: mediaInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="media.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${database.Author.list()}" optionKey="id" required="" value="${mediaInstance?.author?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mediaInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="media.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${mediaInstance?.title}"/>
</div>

