# RBA - RAND

## Installation instructions
The current version of the project uses PostgreSQL as its backing database.   
The building process assumes that you have build requirements installed system-wide.

### Build requirements
* Maven 3.x
* Java 17

### Building project
From the project root run the following command:
```shell 
$ mvn package  
```

This will generate a distribution package `dist` inside the `target` directory for the `rand-generator` and `rand-tokenizer-application` modules.

### Building and Running Docker images

From the project root:
```shell  
$ docker-compose --env-file=docker.env up
```  

### Accessing the container API from the host system

Use the `docker ps` or `docker-compose ps` command to identify the container name.

Then in the case of `rand-generator`:

```bash
$ docker exec -t rand-generator-1 curl -XGET http://localhost:8080/random/int
```
Example output:
```text
-> 179694814
```

or in case of `rand-tokenizer`:

```bash
$ docker exec -t rand-tokenizer-1 curl -XGET http://localhost:8080/tokens/RBA/count -d 'from=2022-10-06T00:00:00' -d 'to=2023-11-06T13:20:24'
```

Example output:
```text
-> {"success":true,"token":"RBA","count":115}
```
