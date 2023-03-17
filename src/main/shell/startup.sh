#!/bin/bash

#
# Copyright (c) 2001-2019 Primeton Technologies, Ltd.
# All rights reserved.
#
# author: ZhongWen Li (mailto:lizw@primeton.com)
#

## resolve links
PRG="$0"

# need this for relative symlinks
while [ -h "$PRG" ] ; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG="`dirname "$PRG"`/$link"
  fi
done

saveddir=`pwd`

PSBC_COMPONENT_HOME=`dirname "$PRG"`/..

# make it fully qualified
PSBC_COMPONENT_HOME=`cd "$PSBC_COMPONENT_HOME" && pwd`

# cd "$saveddir"

# If you start multiple instances on a single host, you need to modify this service name to avoid conflicts.
SERVICE_NAME=psbc-message-access

export MODE=service
export PID_FOLDER="${PSBC_COMPONENT_HOME}"/logs
export LOG_FOLDER="${PSBC_COMPONENT_HOME}"/logs
export LOG_FILENAME="${SERVICE_NAME}.out"
export identity=${SERVICE_NAME}

if [ "x$PSBC_HEAP_OPTS" = "x" ]; then
    PSBC_HEAP_OPTS="-Xms1024M -Xmx2048M"
fi

mkdir -p $LOG_FOLDER
ln -s /dev/null $LOG_FOLDER/$LOG_FILENAME 2>/dev/null 
# JAVA_OPTS="$JAVA_OPTS -Djava.rmi.server.hostname=20.5.192.149 -Dcom.sun.management.jmxremote  -Dcom.sun.management.jmxremote.port=1234  -Dcom.sun.management.jmxremote.authenticate=false  -Dcom.sun.management.jmxremote.ssl=false -Dproject.name=message-access"
JAVA_OPTS="$JAVA_OPTS -Dlogging.file=$LOG_FOLDER/$SERVICE_NAME.log"
JAVA_OPTS="$JAVA_OPTS -Djava.net.preferIPv4Stack=true -Duser.timezone=Asia/Shanghai -Dclient.encoding.override=UTF-8 -Dfile.encoding=UTF-8 -Djava.security.egd=file:/dev/./urandom"
JAVA_OPTS="$JAVA_OPTS $PSBC_HEAP_OPTS"
JAVA_OPTS="$JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:-OmitStackTraceInFastThrow"
JAVA_OPTS="$JAVA_OPTS -XX:+UseParNewGC -XX:ParallelGCThreads=4 -XX:MaxTenuringThreshold=9 -XX:+UseConcMarkSweepGC "
# JAVA_OPTS="$JAVA_OPTS -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCApplicationConcurrentTime -XX:+PrintHeapAtGC -Xloggc:$LOG_FOLDER/heap_trace.txt -XX:HeapDumpPath=$LOG_FOLDER/HeapDumpOnOutOfMemoryError/"
JAVA_OPTS="$JAVA_OPTS -Dlog.path=$LOG_FOLDER"

# if debug enabled
if [ 'trueX' == "${PSBC_DEBUG_ENABLE}X" ]; then
  if [ -z "${PSBC_DEBUG_PORT}" ]; then
    PSBC_DEBUG_PORT=8787
  fi
  JAVA_OPTS="${JAVA_OPTS} -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=${PSBC_DEBUG_PORT}"
fi

export JAVA_OPTS

# If exists private jdk
if [ -d "${PSBC_COMPONENT_HOME}/jdk" ] || [ -h "${PSBC_COMPONENT_HOME}/jdk" ] || [ -L "${PSBC_COMPONENT_HOME}/jdk" ]; then
  export JAVA_HOME="${PSBC_COMPONENT_HOME}/jdk"
fi


BOOT_JAR=`echo "${PSBC_COMPONENT_HOME}"/*.jar`
if [ ! -x "${BOOT_JAR}" ]; then
  chmod + "${BOOT_JAR}"
fi
cd "${PSBC_COMPONENT_HOME}"
if [ "x$FOREGROUND" = "xtrue" ]; then
  export MODE=run
  $BOOT_JAR "$@"
else
  $BOOT_JAR start "$@"
fi


