# selenium-grid-standalone-docker

An approach to run selenium UI tests on a standalone grid, using docker image specific to a browser e.g. chrome, firefox etc.

Uses image: https://hub.docker.com/r/selenium/standalone-firefox

## Pre-requisites:
- Docker
- Docker Desktop (not mandatory, but recommended to start stop the daemon engine)
- Start the docker engine

Refer: https://docs.docker.com/engine/install/

## Steps to run:
### Approach 1 (recommended):
#### A single command to download an image from docker hub, create a container, start the container with port mapping.

`docker run -d -p 4444:4444 selenium/standalone-firefox`

`-d` to run container in detached mode </br>
`-p 4444:4444` port mapping of local port to docker port </br>
`selenium/standalone-firefox` name of the image to use to run the container, for chrome use `selenium/standalone-chrome` <br>

To use a custome name for the container: `docker run -d -p 4444:4444 --name selgrid selenium/standalone-firefox`

### Approach 2 (multi-step, for learning purposes):
#### Step by step approach to download image, create container, start container.

`docker pull selenium/standalone-firefox`

`docker create selenium/standalone-firefox` 

`docker start <name or id of container>`


Use approach 1 or 2 to spin up the containers and then go to [MainTest](src/test/java/tests/MainTest.java) to run the sample tests. Add more tests, edit browser configs in [DriverSetup](src/test/java/config/DriverSetup.java). Following dependencies are already included:
- Selenium 4
- TestNG 7

#### After execution:
`docker stop <name or id of container>`

`docker rm <name or id of container>`

> Note: all above steps can also be done from Docker Desktop client.

### Other useful docker commands:

`docker container ps` - list running containers </br>

`docker container ps -a` - list running and stopped containers </br>

`docker container logs <name or id of container>` - when running in detached mode, to see container logs </br>

`docker exec -ti <name or id of container> /bin/bash` - shell into running container to run commands on container's terminal.
`-t` - allocates pseudo tty (unix terminology)
`-i` - keeps std in open
