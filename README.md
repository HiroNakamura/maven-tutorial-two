Tutorial Maven

# Programando en Java con Maven


**Crear proyecto Maven**
```bash
$ mkdir pruebasJava && cd pruebasJava
$ mvn archetype:generate -DgroupId=com.cursomaven -DartifactId=guru-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

**Empaquetar**
```bash
$ mvn package
```

**Ejecutar**
```bash
$ java -cp target/guru-app-1.0-SNAPSHOT.jar com.cursomaven.App
```