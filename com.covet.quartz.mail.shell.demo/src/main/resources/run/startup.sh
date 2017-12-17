#!/bin/sh
baseDir=$(cd "$(dirname "$0")"; pwd)
cp=.
for file in $baseDir/libs/*.jar
do
   cp=$cp:$file
done
java -server -Xmx1024m -Xss256k -cp $cp com.covet.timer.shell.Shell >> $baseDir/stdout.out 2>&1 &
