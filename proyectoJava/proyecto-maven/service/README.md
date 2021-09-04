Service

# Sub módulo maven 

**Listar dependencias compartidas, limpiar y construir**
```bash
$ mvn dependency:tree
$ mvn clean package
```

**Ejecutar proyecto** 
```bash
$ mvn compile exec:java -Dexec.mainClass="org.curso.maven.App" [-Dexec.args="argument1"] ...
```