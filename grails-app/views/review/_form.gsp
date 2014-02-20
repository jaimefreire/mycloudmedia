<%@ page import="mycloudmedia.Review" %>



<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'comments', 'error')} ">
    <label for="comments">
        <g:message code="review.comments.label" default="Comments"/>

    </label>
    <g:select name="comments" from="${mycloudmedia.Comment.list()}" multiple="multiple" optionKey="id" size="5"
              value="${reviewInstance?.comments*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'movieId', 'error')} required">
    <label for="movieId">
        <g:message code="review.movieId.label" default="Movie Id"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="movieId" type="number" value="${reviewInstance.movieId}" required=""/>
</div>

