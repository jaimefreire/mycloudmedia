<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Bienvenido a MyMedia</title>
    <style type="text/css" media="screen">
    #status {
        background-color: #eee;
        border: .2em solid #fff;
        margin: 2em 2em 1em;
        padding: 1em;
        width: 12em;
        float: left;
        -moz-box-shadow: 0px 0px 1.25em #ccc;
        -webkit-box-shadow: 0px 0px 1.25em #ccc;
        box-shadow: 0px 0px 1.25em #ccc;
        -moz-border-radius: 0.6em;
        -webkit-border-radius: 0.6em;
        border-radius: 0.6em;
    }

    .ie6 #status {
        display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
    }

    #status ul {
        font-size: 0.9em;
        list-style-type: none;
        margin-bottom: 0.6em;
        padding: 0;
    }

    #status li {
        line-height: 1.3;
    }

    #status h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin: 0 0 0.3em;
    }

    #page-body {
        margin: 2em 1em 1.25em 18em;
    }

    h2 {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    p {
        line-height: 1.5;
        margin: 0.25em 0;
    }

    #controller-list ul {
        list-style-position: inside;
    }

    #controller-list li {
        line-height: 1.3;
        list-style-position: inside;
        margin: 0.25em 0;
    }

    @media screen and (max-width: 480px) {
        #status {
            display: none;
        }

        #page-body {
            margin: 0 1em 1em;
        }

        #page-body h1 {
            margin-top: 0;
        }
    }
    </style>
</head>

<body>
<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div id="status" role="complementary">
    <h1>Qué quieres hacer?</h1>
    <ul>
        <li><a href="util/info.html">Qué es MyMedia?</a></li>
        <li><g:link action="create" controller="usuario">Crear usuario</g:link></li>
        <li>Iniciar sesión: <g:meta name="app.version"/></li>
        <li><g:link action="index" controller="usuario">Mostrar usuarios</g:link></li>

        <li><g:link action="list" controller="movie">Últimas novedades!</g:link></li>
    </ul>
</div>

<div id="page-body" role="main">
    <h1>Bienvenido a MyMedia</h1>

    <p>Enhorabuena! Acabas de entrar en tu nueva mediateca, donde podrás:
        <br>
    <ul>
        <li>Disfrutar de las mejors pelis y series y encontrar tus próximos favoritos.</li>
        <br>
        <li>Encontrar gente con quien compartir tus mismas aficiones.</li>
        <br>
        <li>Consultar los últimos estrenos y sus valoraciones.</li>
        <br>
        <li>Mucho más!</li>

    </ul>
</p>
</div>
</body>
</html>
