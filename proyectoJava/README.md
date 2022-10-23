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

**Ejecutable**
```bash
<!-- Ejecutable inicio-->
        <plugin>
          <groupId>org.codehaus.mojo</groupId>
          <artifactId>exec-maven-plugin</artifactId>
          <version>3.1.0</version>
          <executions>
            <execution>
              <goals>
                <goal>java</goal>
              </goals>
            </execution>
          </executions>
          <configuration>
            <mainClass>com.curso.java.App</mainClass>
            <!--<arguments>
            </arguments>
            <systemProperties>
             <systemPrperty></systemPrperty>
            </systemProperties>-->
          </configuration>
        </plugin>
       <!-- Ejecutable fin-->
```

**Ejecutar aplicación**
```bash
mvn exec:java -Dexec.mainClass="com.curso.App"
```


