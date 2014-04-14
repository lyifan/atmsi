proj=atmsi

all: stopTomcat build cleanTomcat deploy startTomcat
	
stopTomcat:
	${CATALINA_HOME}/bin/shutdown.sh
	
build:
	gradle -q clean :web:build
	
cleanTomcat:
	rm -rf ${CATALINA_HOME}/work ${CATALINA_HOME}/logs/* ${CATALINA_HOME}/webapps/${proj}*
	
deploy:	
	cp web/build/libs/${proj}.war ${CATALINA_HOME}/webapps/

startTomcat:
	${CATALINA_HOME}/bin/startup.sh
