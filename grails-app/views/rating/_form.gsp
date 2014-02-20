<%@ page import="mycloudmedia.Rating" %>



<div class="fieldcontain ${hasErrors(bean: ratingInstance, field: 'review', 'error')} required">
    <label for="review">
        <g:message code="rating.review.label" default="Review"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="review" name="review.id" from="${mycloudmedia.Review.list()}" optionKey="id" required=""
              value="${ratingInstance?.review?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ratingInstance, field: 'score', 'error')} required">
    <label for="score">
        <g:message code="rating.score.label" default="Score"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="score" type="number" value="${ratingInstance.score}" required=""/>
</div>

