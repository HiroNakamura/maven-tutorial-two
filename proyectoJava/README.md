Multi-módulos en Maven

# Proyecto Java con Maven

**Crear proyecto(módulo principal)**
```bash
$ mvn archetype:generate -DgroupId=org.curso.maven -DartifactId=proyecto-maven -DinteractiveMode=false
```
**Crear sub-módulos**
```bash
$ mvn archetype:generate -DgroupId=org.curso.maven -DartifactId=core -DinteractiveMode=false

$ mvn archetype:generate -DgroupId=org.curso.maven -DartifactId=service -DinteractiveMode=false

$ mvn archetype:generate -DgroupId=org.curso.maven -DartifactId=webapp -DinteractiveMode=false
```

**Empaquetamos**
```bash
$ mvn package
```