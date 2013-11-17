<html>
<head>
    <title>Heroku Grails Test</title>
    <meta name='layout' content='main'/>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <style type="text/css" media="screen">

    #nav {
        margin-top: 20px;
        margin-left: 30px;
        width: 228px;
        float: left;

    }

    .homePagePanel * {
        margin: 0px;
    }

    .homePagePanel .panelBody ul {
        list-style-type: none;
        margin-bottom: 10px;
    }

    .homePagePanel .panelBody h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin-bottom: 10px;
    }

    .homePagePanel .panelBody {
        background: url(images/leftnav_midstretch.png) repeat-y top;
        margin: 0px;
        padding: 15px;
    }

    .homePagePanel .panelBtm {
        background: url(images/leftnav_btm.png) no-repeat top;
        height: 20px;
        margin: 0px;
    }

    .homePagePanel .panelTop {
        background: url(images/leftnav_top.png) no-repeat top;
        height: 11px;
        margin: 0px;
    }

    h2 {
        margin-top: 15px;
        margin-bottom: 15px;
        font-size: 1.2em;
    }

    #pageBody {
        margin-left: 280px;
        margin-right: 20px;
    }
    </style>
</head>

<body>
<div id='nav'>
    <div class='homePagePanel'>
        <div class='panelTop'></div>

        <div class='panelBody'>
            <h1>Application Status</h1>
            <ul>
                <li>App version: <g:meta name='app.version'/></li>
                <li>Grails version: <g:meta name='app.grails.version'/></li>
                <li>Groovy version: ${GroovySystem.version}</li>
                <li>JVM version: ${System.getProperty('java.version')}</li>
                <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
                <li>Domains: ${grailsApplication.domainClasses.size()}</li>
                <li>Services: ${grailsApplication.serviceClasses.size()}</li>
                <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
            </ul>

            <h1>Installed Plugins</h1>
            <ul>
                <g:each var='plugin' in='${applicationContext.pluginManager.allPlugins}'>
                    <li>${plugin.name} - ${plugin.version}</li>
                </g:each>
            </ul>
        </div>

        <div class='panelBtm'></div>
    </div>
</div>
<div id='pageBody'>
<g:if env="development">

    <table>
        <thead>
        <tr><th>Name</th><th>Value</th></tr>
        </thead>
        <tbody>
        <tr>
            <td>DATABASE_URL</td>
            <td>${env.DATABASE_URL}</td>
        </tr>
        <tr>
            <td>RABBITMQ_URL</td>
            <td>${env.RABBITMQ_URL}</td>
        </tr>
        <tr>
            <td>REDISTOGO_URL</td>
            <td>${env.REDISTOGO_URL}</td>
        </tr>
        <tr>
            <td>MONGOHQ_URL</td>
            <td>${env.MONGOHQ_URL}</td>
        </tr>
        <tr>
            <td>MONGOLAB_URI</td>
            <td>${env.MONGOLAB_URI}</td>
        </tr>
        <tr>
            <td>MEMCACHE_SERVERS</td>
            <td>${env.MEMCACHE_SERVERS}</td>
        </tr>
        <tr>
            <td>MEMCACHE_USERNAME</td>
            <td>${env.MEMCACHE_USERNAME}</td>
        </tr>
        <tr>
            <td>MEMCACHE_PASSWORD</td>
            <td>${env.MEMCACHE_PASSWORD}</td>
        </tr>
        </tbody>
    </table>

    <g:javascript library="jquery" plugin="jquery"/>

    <div id='controllerList' class='dialog'>
        <h2>Links:</h2>
        <ul>
            <li>Hibernate:
                <ul>
                    <li class='controller'>
                        <g:link controller='author'>Author Controller</g:link>
                    </li>
                    <li class='controller'>
                        <g:link controller='book'>Book Controller</g:link>
                    </li>
                </ul>
            </li>
            <li>Redis:
                <ul>
                    <li class='controller'>
                        <g:link controller='redisThing'>Redis Domain Class</g:link>
                    </li>
                </ul>
            </li>
            <li>Mongo:
                <ul>
                    <li class='controller'>
                        <g:link controller='mongoThing'>Mongo Domain Class</g:link>
                    </li>
                </ul>
            </li>
            <li>Rabbit:
                <ul>
                    <li class='controller'>
                        <g:link controller='message'>Send a message</g:link>
                    </li>
                    <li class='controller'>
                        <g:link controller='message' action='viewMessages'>View messages</g:link>
                    </li>
                </ul>
            </li>
            <li>Admin:
                <ul>
                    <li class='controller'>
                        <g:link controller='console'>Console</g:link>
                    </li>
                    <li class='controller'>
                        <g:link controller='dbconsole'>Database Console</g:link>
                    </li>
                    <li class='controller'>
                        <h:dbconsoleLink>Database Console (autologin)</h:dbconsoleLink>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</g:if>
</body>
</html>