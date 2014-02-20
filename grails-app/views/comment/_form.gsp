<%@ page import="mycloudmedia.Comment" %>



<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'texto', 'error')} ">
    <label for="texto">
        <g:message code="comment.texto.label" default="Texto"/>

    </label>
    <g:textArea name="texto" cols="40" rows="5" maxlength="999999" value="${commentInstance?.texto}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'author', 'error')} ">
    <label for="author">
        <g:message code="comment.author.label" default="Author"/>

    </label>
    <g:textField name="author" maxlength="30" value="${commentInstance?.author}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'comments', 'error')} ">
    <label for="comments">
        <g:message code="comment.comments.label" default="Comments"/>

    </label>
    <g:select name="comments" from="${mycloudmedia.Comment.list()}" multiple="multiple" optionKey="id" size="5"
              value="${commentInstance?.comments*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'denunciado', 'error')} ">
    <label for="denunciado">
        <g:message code="comment.denunciado.label" default="Denunciado"/>

    </label>
    <g:checkBox name="denunciado" value="${commentInstance?.denunciado}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'fecha', 'error')} required">
    <label for="fecha">
        <g:message code="comment.fecha.label" default="Fecha"/>
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="fecha" precision="day" value="${commentInstance?.fecha}"/>
</div>

