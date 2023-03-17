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

cd "$saveddir"


SERVICE_NAME=psbc-message-access

export MODE=service
export PID_FOLDER="${PSBC_COMPONENT_HOME}"/logs
export LOG_FOLDER="${PSBC_COMPONENT_HOME}"/logs
export identity=${SERVICE_NAME}
# export CONF_FOLDER="${PSBC_COMPONENT_HOME}"/conf

# If exists private jdk
if [ -d "${PSBC_COMPONENT_HOME}/jdk" ] || [ -h "${PSBC_COMPONENT_HOME}/jdk" ] || [ -L "${PSBC_COMPONENT_HOME}/jdk" ]; then
	export JAVA_HOME="${PSBC_COMPONENT_HOME}/jdk"
fi

BOOT_JAR=`echo "${PSBC_COMPONENT_HOME}"/*.jar`
if [ ! -x "${BOOT_JAR}" ]; then
  chmod + "${BOOT_JAR}"
fi

$BOOT_JAR stop "$@"



