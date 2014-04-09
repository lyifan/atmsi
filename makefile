proj=atmsi
all:
	${CATALINA_HOME}/bin/shutdown.sh
	gradle -q clean build
	rm -rf ${CATALINA_HOME}/work ${CATALINA_HOME}/logs/* ${CATALINA_HOME}/webapps/${proj}*
	cp build/libs/${proj}.war ${CATALINA_HOME}/webapps/
	${CATALINA_HOME}/bin/startup.sh
