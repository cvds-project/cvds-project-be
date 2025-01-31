# 🔐 Sistema de Gestión de Usuarios y Autenticación con JWT  

## 📌 Descripción  
Este proyecto implementa un **sistema de gestión de usuarios** para una institución educativa, permitiendo la **autenticación segura** de estudiantes y bibliotecarios mediante **JSON Web Tokens (JWT)**.  

Utiliza **Spring Boot** para el backend, **MongoDB** para la persistencia de datos y un sistema basado en **roles y permisos**. Además, el sistema está **desplegado en Azure**, garantizando disponibilidad y escalabilidad.  

---

## 🚀 Características Principales  

✅ **Autenticación JWT Segura**  
- Los usuarios (Estudiantes y Bibliotecarios) se autentican mediante un **token JWT** que permite acceder a recursos protegidos.  

✅ **Manejo de Roles y Permisos**  
- Diferencia entre **Estudiantes y Bibliotecarios**, asignando permisos específicos según su rol.  

✅ **Persistencia con MongoDB**  
- Almacenamiento en una base de datos **NoSQL MongoDB**, facilitando la escalabilidad.  

✅ **Despliegue en Azure**  
- El backend está **desplegado en Azure**, utilizando **Azure App Service** para su ejecución y **Azure Cosmos DB (MongoDB API)** como base de datos.  

✅ **Seguridad Mejorada**  
- Uso de **Spring Security + JWT** para manejar la autenticación sin sesiones tradicionales.  

---

## 🛠️ Tecnologías Utilizadas  

- **🌱 Spring Boot** → Framework principal para el backend.  
- **🛡️ Spring Security** → Gestión de autenticación y autorización.  
- **🔑 JWT (JSON Web Tokens)** → Seguridad en la autenticación.  
- **💾 MongoDB / Azure Cosmos DB** → Base de datos NoSQL para la persistencia.  
- **☁️ Azure App Service** → Plataforma de despliegue.  
- **🐳 Docker** → Contenedorización opcional para despliegue.  
- **✅ JUnit & Mockito** → Pruebas unitarias y cobertura de código.  

---

## ⚙️ Estructura del Proyecto  

📌 **Backend en Spring Boot**  
- Gestiona autenticación y autorización con **Spring Security** y **JWT**.  
- Expone una **API REST** con endpoints protegidos.  

📌 **Base de Datos en Azure Cosmos DB**  
- Se utiliza **MongoDB API** para almacenar usuarios y roles.  

📌 **Usuarios y Roles**  
- **Estudiantes**: Tienen atributos como **nombre, código de estudiante, curso y año académico**.  
- **Bibliotecarios**: Poseen permisos administrativos para la gestión del sistema.  

---

## 🔧 Instalación y Ejecución  

### 1️⃣ **Clonar el Repositorio**  
```bash
git clone https://github.com/tu_usuario/gestion-usuarios-jwt.git
cd gestion-usuarios-jwt
```
2️⃣ Configurar la Base de Datos (MongoDB en Azure Cosmos DB)
Si usas una base de datos local, asegúrate de tener MongoDB en ejecución:

```bash
Copiar
Editar
docker run -d --name mongo -p 27017:27017 mongo
```
Si usas Azure Cosmos DB, configura la cadena de conexión en el .env:

properties
Copiar
Editar
SPRING_DATA_MONGODB_URI=mongodb+srv://<usuario>:<password>@<cluster>.mongo.cosmos.azure.com/<database>?ssl=true
JWT_SECRET=tuClaveSecretaJWT
3️⃣ Compilar y Ejecutar el Backend
```bash
Copiar
Editar
mvn clean install
mvn spring-boot:run
```
☁️ Despliegue en Azure
El backend está desplegado en Azure App Service. Puedes probarlo en la siguiente URL:

🔗 API en Producción: https://tu-api.azurewebsites.net

📌 Pasos para desplegar en Azure:

Configurar Azure App Service
Crear un App Service en el portal de Azure.
Seleccionar Java 17 y Tomcat 9+ como entorno de ejecución.
Subir el Backend a Azure
Construir el .jar y desplegar en Azure:
```bash
Copiar
Editar
mvn package
az webapp deploy --resource-group tu-grupo --name tu-api --src-path target/tu-api.jar
Configurar Base de Datos en Azure Cosmos DB
Crear un Azure Cosmos DB con API MongoDB.
```
Configurar la cadena de conexión en las variables de entorno de Azure.
🔑 Endpoints Principales
📌 Registro de usuario

http
Copiar
Editar
POST /api/auth/register
📌 Inicio de sesión

http
Copiar
Editar
POST /api/auth/login
📌 Verificación de sesión

http
Copiar
Editar
GET /api/auth/me
📌 Acceso a recursos protegidos

http
Copiar
Editar
GET /api/protegido
Authorization: Bearer {JWT_TOKEN}
🔐 Seguridad y Configuración
✅ Protección de Rutas

Todas las rutas protegidas requieren JWT en el encabezado de la solicitud.
✅ Validación de Roles

Se asegura que solo los usuarios con el rol adecuado accedan a ciertos endpoints.
✅ Manejo de Sesiones

No se almacenan sesiones en el servidor, mejorando rendimiento y escalabilidad.
📚 Referencias
Guía JWT con Spring Boot
Repositorio Base en GitHub
Documentación de Azure App Service
📩 Contacto
Si tienes preguntas o sugerencias, ¡estaremos encantados de escucharte!
