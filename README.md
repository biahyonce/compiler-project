# Compiler Project

## Project Structure

```
├── compiler-project
│   ├── lexical-analysis
│   │   └── pom.xml
│   ├── syntax-analysis
│   │   └── pom.xml
│   └── pom.xml

```

## Basic Usage

### Command Line

To run this project, execute the following commands:

```
mvn clean install
java -jar lexical-analysis/target/lexical-analysis-1.0-SNAPSHOT-jar-with-dependencies.jar (path of input file)
```

Where the path of input file is the path of the file with the code to be compiled. Such a file can be structured as:

```
int main() {
    int a;
    while(a<>b) {
        printf("Hello World!");
    }
}
```

### IDE

To run this project using IDE, just import the pom.xml file from the source root (compiler-project) and configure it as
maven dependency.