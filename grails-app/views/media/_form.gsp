<%@ page import="mycloudmedia.Media" %>



<div class="fieldcontain ${hasErrors(bean: mediaInstance, field: 'ISBN', 'error')} ">
	<label for="ISBN">
		<g:message code="media.ISBN.label" default="ISBN" />
		
	</label>
	<g:textField name="ISBN" value="${mediaInstance?.ISBN}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mediaInstance, field: 'people', 'error')} required">
	<label for="people">
		<g:message code="media.people.label" default="People" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="people" name="people.id" from="${mycloudmedia.Person.list()}" optionKey="id" required="" value="${mediaInstance?.people?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mediaInstance, field: 'rating', 'error')} required">
	<label for="rating">
		<g:message code="media.rating.label" default="Rating" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="rating" name="rating.id" from="${mycloudmedia.Rating.list()}" optionKey="id" required="" value="${mediaInstance?.rating?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mediaInstance, field: 'releaseDate', 'error')} required">
	<label for="releaseDate">
		<g:message code="media.releaseDate.label" default="Release Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="releaseDate" precision="day"  value="${mediaInstance?.releaseDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: mediaInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="media.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${mediaInstance?.title}"/>
</div>

