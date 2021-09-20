# Trabajo Integrador-Java-springBoot

## Para ejecutar localmente
Para ejecutar el proyecto, asegúrese de haber instalado MySQL y de crear
una base de datos llamada: ** dbproyecto**


## Referencia de API
##Odontologos
#### Get Odontologos
```
  GET localhost:8080/odontologos
```

#### Post Odontologos
```
  POST localhost:8080/odontologos
```
```json
 {
    "nombre":"Daniela",
    "apellido":"Morales",
    "matricula":"sdsad3"
 }
```

##Domicilios

#### Get Domicilios
```
  GET localhost:8080/domicilios
```

#### Post Domicilios
```
  POST localhost:8080/domicilios
```
```json
 {
     "calle":"23",
     "numero":"96J",
     "localidad":"Fontibon",
     "provincia":"Bogota"
 }
```

##Pacientes

#### Get Pacientes
```
  GET localhost:8080/pacientes
```

#### Post Pacientes
```
  POST localhost:8080/pacientes
```
```json
 {
     "nombre":"Daniela",
     "apellido":"Morales",
     "dni":"1124s",
     "domicilio":{
       "id":1
      },
     "fechaDeAlta":"2021-09-30"
 }
```