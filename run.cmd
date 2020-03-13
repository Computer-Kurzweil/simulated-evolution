goto:MAIN

:BUILD
cmd /c  mvnw clean
cmd /c  mvnw install
cmd /c  mvnw dependency:resolve
cmd /c  mvnw dependency:resolve-plugins
cmd /c  mvnw dependency:tree
rem cmd /c  mvnw site
rem cmd /c  mvnw dependency:analyze
rem cmd /c  mvnw dependency:analyze-report
rem cmd /c  mvnw dependency:analyze-dept-mgt
cmd /c  mvnw dependency:analyze
cmd /c  mvnw dependency:analyze-dep-mgt
cmd /c  mvnw dependency:analyze-duplicate
cmd /c  mvnw dependency:analyze-only
cmd /c  mvnw dependency:analyze-report
cmd /c  mvnw dependency:build-classpath
cmd /c  mvnw dependency:collect
rem cmd /c  mvnw dependency:copy
cmd /c  mvnw dependency:copy-dependencies
cmd /c  mvnw dependency:display-ancestors
rem cmd /c  mvnw dependency:get
cmd /c  mvnw dependency:go-offline
cmd /c  mvnw dependency:help
cmd /c  mvnw dependency:list
cmd /c  mvnw dependency:list-repositories
cmd /c  mvnw dependency:properties
cmd /c  mvnw dependency:purge-local-repository
cmd /c  mvnw dependency:resolve
cmd /c  mvnw dependency:resolve-plugins
cmd /c  mvnw dependency:sources
cmd /c  mvnw dependency:tree
rem cmd /c  mvnw dependency:unpack
rem cmd /c  mvnw dependency:unpack-dependencies
goto:FINALE

:RUN
cmd /c  mvnw -e clean install exec:java
goto:FINALE

:MAIN
goto:BUILD
rem goto:BUILD

:FINALE
