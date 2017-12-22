#!/bin/bash

#Usage: java -jar fitnesse.jar [-vpdrlfeoaicb]
#	-p <port number> {80}
#	-d <working directory> {.}
#	-r <page root directory> {FitNesseRoot}
#	-l <log directory> {no logging}
#	-f <config properties file> {plugins.properties}
#	-e <days> {14} Number of days before page versions expire
#	-o omit updates
#	-a {user:pwd | user-file-name} enable authentication.
#	-i Install only, then quit.
#	-c <command> execute single command.
#	-b <filename> redirect command output.
#	-v {off} Verbose logging

java -jar fitnesse-standalone.jar -f plugins.properties -d work -r FitNesseRoot -p 8888
# java -jar fitnesse-standalone.jar -d work -r FitNesseRoot -p 8888
