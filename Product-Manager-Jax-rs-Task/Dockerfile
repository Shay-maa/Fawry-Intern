FROM quay.io/wildfly/wildfly:26.1.2.Final
COPY target/jakartaee-hello-world.war /opt/jboss/wildfly/standalone/deployments/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-c","standalone-full.xml"]
