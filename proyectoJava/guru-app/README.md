Guru-App

# Guru Maven


**Limpiar y construir**
```bash
$ mvn clean package
```


**Listar dependencias**
```bash
$ mvn dependency:tree
```

**Ejecutar**
```bash
$ mvn compile exec:java -Dexec.mainClass="com.cursomaven.App" [-Dexec.args="argument1"] ...
```