
<%@ page import="mycloudmedia.Subscription" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'subscription.label', default: 'Subscription')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-subscription" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label"
                                                                   args="[entityName]"/></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-subscription" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list subscription">

                <g:if test="${subscriptionInstance?.type}">
                    <li class="fieldcontain">
                        <span id="type-label" class="property-label"><g:message code="subscription.type.label"
                                                                                default="Tipo:"/></span>

                        <span class="property-value" aria-labelledby="type-label"><g:fieldValue
                                bean="${subscriptionInstance}" field="type"/></span>

                    </li>
                </g:if>

                <g:if test="${subscriptionInstance?.user}">
                    <li class="fieldcontain">
                        <span id="user-label" class="property-label"><g:message code="subscription.user.label"
                                                                                default="Mostrar usuario:"/></span>

                        <span class="property-value" aria-labelledby="user-label"><g:link controller="usuario"
                                                                                          action="show"
                                                                                          id="${subscriptionInstance?.user?.id}">Usuario</g:link></span>

                    </li>
                </g:if>
                <br>
                Puedes elegir el que más te convenga entre varios tipos de subscripción.
                <br>
                Si decides alquilar una o cinco películas tendrás hasta dos semanas para verlas.
                <br>
                <br>

                <g:message code="default.buy.one.movie" default="Alquila una película"/>
                <br>
                <paypal:button
                        itemName="Subscripción 1 película"
                        itemNumber="MYMED1"
                        transactionId="${payment?.transId}"
                        amount="99,00"
                        discountAmount="0"
                        buyerId="${subscriptionInstance.user.id}"
                        buy="NO"/>
                <br>

                <g:message code="default.buy.five.movies" default="Alquila cinco películas"/>
                <br>

                <paypal:button
                        itemName="Subscripción 5 películas"
                        itemNumber="MIMED5"
                        transactionId="${payment?.transId}"
                        amount="99,00"
                        discountAmount="0"
                        buyerId="${subscriptionInstance.user.id}"
                        buy="NO"/>
                <br>

                <g:message code="default.buy.week" default="Toda una semana!"/>

                <paypal:button
                        itemName="Subscripción tarifa plana semanal"
                        itemNumber="MYMEDFLATW"
                        transactionId="${payment?.transId}"
                        amount="99,00"
                        discountAmount="0"
                        buyerId="${subscriptionInstance.user.id}"
                        buy="YES"/>
                <br>

                <g:message code="default.buy.month" default="Un mes completo"/>

                <paypal:button
                        itemName="Subscripción tarifa plana mensual"
                        itemNumber="MYMEDFLATM"
                        transactionId="${payment?.transId}"
                        amount="99,00"
                        discountAmount="0"
                        buyerId="${subscriptionInstance.user.id}"
                        buy="YES"/>
            </ol>
            <g:form url="[resource: subscriptionInstance, action: 'delete']" method="DELETE">
                <fieldset class="buttons">
                    <!--<g:link class="edit" action="edit" resource="${subscriptionInstance}"><g:message
                            code="default.button.edit.label" default="Edit"/></g:link>-->
                    <!--<g:actionSubmit class="delete" action="delete"
                                        value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>-->
                </fieldset>
			</g:form>

        </div>

    </body>
</html>
