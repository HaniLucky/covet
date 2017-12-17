@echo off
setLocal enableDelayedExpansion
set cp=.
FOR %%i IN ("%~dp0libs\*.jar") DO set cp=!cp!;%%~fsi
start "com.covet.quartz.mail.shell.demo" java -server -cp %cp% com.covet.timer.shell.Shell
