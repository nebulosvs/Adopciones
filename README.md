# 🐾 Pet Adoption System

Aplicación web desarrollada con **Spring Boot** para la gestión de adopciones de mascotas, implementando autenticación mediante **JWT**, arquitectura en **3 capas** y buenas prácticas de seguridad y calidad de software.

Este proyecto fue desarrollado como parte de la asignatura **Seguridad y Calidad en el Desarrollo (CDY2203)**.

---

## 📌 Características

- Inicio de sesión con autenticación JWT.
- Visualización de mascotas disponibles para adopción.
- Gestión de solicitudes de adopción.
- Arquitectura en tres capas.
- Base de datos H2 embebida.
- Vistas desarrolladas con Thymeleaf.
- Seguridad mediante Spring Security.
- Pruebas unitarias con JUnit 5 y Mockito.
- Cobertura de código utilizando JaCoCo.
- Análisis de seguridad con:
  - OWASP ZAP
  - SonarQube
  - SpotBugs
  - OWASP Dependency-Check

---

# 🏗️ Arquitectura

El proyecto sigue una arquitectura en **3 capas**, permitiendo una correcta separación de responsabilidades.

```
Frontend (Thymeleaf)
        │
        ▼
Controllers
        │
        ▼
Services
        │
        ▼
Repositories
        │
        ▼
Base de datos H2
```

---

# 📂 Estructura del proyecto

```
src
 ├── main
 │   ├── java
 │   │     ├── adoption
 │   │     ├── pet
 │   │     ├── security
 │   │     ├── controllers
 │   │     └── config
 │   └── resources
 │         ├── templates
 │         ├── static
 │         └── application.properties
 │
 └── test
```

---

# 🚀 Tecnologías utilizadas

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Thymeleaf
- Maven
- H2 Database

---

# 🔐 Seguridad implementada

La aplicación incorpora distintos mecanismos de seguridad:

- Autenticación mediante JWT.
- Spring Security.
- Protección de rutas.
- Control de acceso.
- Gestión de sesiones.
- Validación de peticiones.

---

# 🧪 Calidad del software

Durante el desarrollo se realizaron distintos procesos de validación.

## Pruebas unitarias

Se utilizaron:

- JUnit 5
- Mockito
- MockMvc
- JaCoCo

Se alcanzó una cobertura aproximada del **60%** del código fuente.

---

## Análisis estático

Se utilizó **SpotBugs** para detectar:

- Bugs potenciales
- Problemas de encapsulamiento
- Buenas prácticas
- Riesgos de seguridad

Las advertencias críticas fueron corregidas antes de la entrega.

---

## Análisis con SonarQube

El proyecto fue analizado mediante SonarQube para evaluar:

- Seguridad
- Confiabilidad
- Mantenibilidad
- Cobertura
- Code Smells

El proyecto superó satisfactoriamente el **Quality Gate**.

---

## OWASP Top 10

Se realizó un análisis dinámico utilizando **OWASP ZAP**.

Resultados principales:

- No se detectaron vulnerabilidades críticas.
- No se detectaron inyecciones SQL.
- No se detectó Cross Site Scripting explotable.
- No se detectaron fallos de autenticación.
- Se identificaron únicamente recomendaciones relacionadas con encabezados HTTP y políticas CSP.

---

## Software Composition Analysis (SCA)

Se utilizó:

- OWASP Dependency-Check

El análisis permitió identificar vulnerabilidades conocidas en dependencias externas sin encontrarse vulnerabilidades críticas en el código desarrollado.

---

# ▶️ Ejecución del proyecto

## Clonar repositorio

```bash
git clone https://github.com/usuario/repositorio.git
```

## Entrar al proyecto

```bash
cd Adopciones-main
```

## Ejecutar

```bash
./mvnw spring-boot:run
```

O desde Windows:

```bash
mvnw.cmd spring-boot:run
```

---

# 📊 Herramientas utilizadas

| Herramienta | Propósito |
|-------------|-----------|
| Spring Boot | Framework principal |
| Spring Security | Seguridad |
| JWT | Autenticación |
| Thymeleaf | Frontend |
| H2 Database | Persistencia |
| JUnit 5 | Pruebas unitarias |
| Mockito | Mocking |
| JaCoCo | Cobertura |
| SpotBugs | Análisis estático |
| SonarQube | Calidad del código |
| OWASP ZAP | Análisis dinámico |
| Dependency-Check | Análisis SCA |

---

# 📄 Evidencias

El proyecto incluye reportes generados durante el proceso de validación:

- Reporte OWASP ZAP
- Reporte SpotBugs
- Reporte SonarQube
- Reporte JaCoCo
- Reporte Dependency-Check
