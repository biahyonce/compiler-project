mvn clean install;
mvn compile exec:java -Dexec.mainClass="LexicalAnalysis" -Dexec.arguments="input.txt"