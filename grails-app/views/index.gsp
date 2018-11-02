<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>
    <content tag="nav">
        <li class="nav-item"><a href="/user">Users</a></li>
        <li class="nav-item"><a href="/event">Events</a></li>
                %{--<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">--}%
                    %{--<li><a href="#">${plugin.name} - ${plugin.version}</a></li>--}%
                %{--</g:each>--}%
    </content>

    <div class="svg" role="presentation">
        <div class="grails-logo-container">
            <asset:image src="centroLeonLogo.jpg" class="grails-logo"/>
        </div>
    </div>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Centro León</h1>

            %{--<div id="controllers" role="navigation">--}%
                %{--<h2>Available Controllers:</h2>--}%
                %{--<ul>--}%
                    %{--<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">--}%
                        %{--<li class="controller">--}%
                            %{--<g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>--}%
                        %{--</li>--}%
                    %{--</g:each>--}%
                %{--</ul>--}%
            %{--</div>--}%
        </section>
    </div>

</body>
</html>
