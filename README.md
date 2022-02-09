# CronExpressionParser
 cron expression parser

---------------Steps to Run the project ----------------
Step1 : switch to directory src of the project

Step2 : compile the project using below command
javac <path-to-all-java-files>
Here run " javac  .\com\company\cron\*.java .\com\company\cron\model\*.java .\com\company\cron\services\*.java"

Step3 : run the parser using below command
java com.company.cron.CronExpressionParser <expression>
Here, run " java com.company.cron.CronExpressionParser "1/15 0 */3 6-7 1-5 /usr/bin/find" "
--------------------------------------------------