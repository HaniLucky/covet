@echo off
setLocal enableDelayedExpansion
set cp=.
FOR %%i IN ("%~dp0libs\*.jar") DO set cp=!cp!;%%~fsi
start "quartz.sendmailjob" java -server -cp %cp% com.covet.timer.shell.Shell
