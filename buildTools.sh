mkdir bt
cd bt
wget https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar
git config --global --unset core.autocrlf
java -jar BuildTools.jar --rev 1.8.8
#java -jar BuildTools.jar --rev 1.9
#java -jar BuildTools.jar --rev 1.9.4
#java -jar BuildTools.jar --rev 1.10
