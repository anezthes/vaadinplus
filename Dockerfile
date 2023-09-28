# Allows you to run this app easily as a docker container.
# See README.md for more details.
#
# 1. Build the image with: docker build --no-cache -t test/vaadinplus:latest --build-arg offlinekey='key' .
# 2. Run the image with: docker run --rm -ti -p8080:8080 test/vaadinplus
#
# Uses Docker Multi-stage builds: https://docs.docker.com/build/building/multi-stage/

# The "Build" stage. Copies the entire project into the container, into the /app/ folder, and builds it.
FROM eclipse-temurin:17 AS BUILD
COPY . /app/
WORKDIR /app/
ARG offlinekey
ENV VAADIN_OFFLINE_KEY=$offlinekey
RUN ./mvnw clean test package -Pproduction -Dvaadin.skip.dev.bundle=true
# At this point, we have the app (executable jar file):  /app/target/vaadinplus-1.0-SNAPSHOT.jar

# The "Run" stage. Start with a clean image, and copy over just the app itself, omitting gradle, npm and any intermediate build files.
FROM eclipse-temurin:17
COPY --from=BUILD /app/target/vaadinplus-1.0-SNAPSHOT.jar /app/
WORKDIR /app/
EXPOSE 8080
ENTRYPOINT java -jar vaadinplus-1.0-SNAPSHOT.jar 8080

