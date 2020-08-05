#!/bin/bash

function usage(){
  echo "Usage: $0 (start|stop|restart) xxx.jar"
}

function isAlive(){
    echo `ps --no-headers -p $1 | wc -l`
}

CMD=$1
JAR_NAME=$2
SERVICE_NAME=""

THIS_DIR="$( cd "$( dirname "$0"  )" && pwd )"
PARENT_DIR=`dirname "${this_dir}"`
PID_FILE="${PARENT_DIR}/${SERVICE_NAME}/run.pid"
LOG_DIR="${PARENT_DIR}/${SERVICE_NAME}/logs"
JAR_FILE="${PARENT_DIR}/${SERVICE_NAME}/${JAR_NAME}"
# Parse the command line arguments.

# Set the default value.
if [ -z "${CMD}" ]
then
    echo "miss one of (start|stop|restart)."
    usage
    exit 1
fi
# Make sure the LOG DIR exists.
if [ ! -d "${LOG_DIR}" ]
then
    echo "Log dir ${LOG_DIR} do not exist, create it."
    mkdir -p ${LOG_DIR}
fi

JAVA_OPTS="-server -Dfile.encoding=UTF8 -Dsun.jnu.encoding=UTF8
-Xmx1344M -Xms1344M -Xmn448M -XX:MaxMetaspaceSize=192M -XX:MetaspaceSize=192M -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses -XX:+CMSClassUnloadingEnabled -XX:+ParallelRefProcEnabled -XX:+CMSScavengeBeforeRemark -XX:ErrorFile=./logs/hs_err_pid%p.log   -Xloggc:./logs/gc.log -XX:HeapDumpPath=./logs -XX:+PrintGCDetails -XX:+PrintGCDateStamps -verbose:class -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintClassHistogramBeforeFullGC -XX:+PrintClassHistogramAfterFullGC -XX:+PrintCommandLineFlags -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCApplicationStoppedTime -XX:+PrintTenuringDistribution -XX:+PrintHeapAtGC"

function start() {
    nohup java ${JAVA_OPTS} -jar ${JAR_FILE} 1>/dev/null &
    echo $! > ${PID_FILE}
    pid=`cat ${PID_FILE}`
    echo "Starting Java process with pid ${pid}: "
    alive=`isAlive ${pid}`
    if [ ${alive} -eq 1 ]
    then
        echo "Succeed."
    else
        echo "Failed."
        exit 1
    fi
    echo "PID FILE: ${pid}"
}

function stop() {
    if [ -f "${PID_FILE}" ]
    then
        pid=`cat ${PID_FILE}`
        if [ -n "${pid}" -a ${pid} -gt 0 ]
        then
            alive=`isAlive ${pid}`
            if [ ${alive} -eq 1 ]
            then
                # Print Thread Dump First(HotSpot VM).
                # SIGQUIT
                kill -3 ${pid}
                # Kill the process normally and wait for 3 seconds give the application a chance to quit gracefully.
                # SIGTERM
                kill ${pid} && sleep 3

                alive=`isAlive ${pid}`
                if [ ${alive} -eq 1 ]
                then
                    # Force Kill if the process is still there alive.
                    # SIGKILL

                    kill -9 ${pid}
                fi #
            fi #Process is alive.
        fi # PID exists
        # Remove the pid file.
        /bin/rm ${PID_FILE}
    fi
}

function restart(){
    stop
    #sleep 3 seconds to wait process close sucessfully
    sleep 3
    start
}
# Run the command.
${CMD}
