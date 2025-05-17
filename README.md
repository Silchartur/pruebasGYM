<img src="./f9ae72cc-563b-4782-ab02-69e8f691b4ee.png" alt="Logo del proyecto" width="100"/>

# Soluciones de Desarrollo Dinamicas
## 🏋️ Aplicación de Gestión para Franquicias de Gimnasios
Sistema en desarrollo orientado a cubrir las necesidades de gestión integral en una cadena de gimnasios.

🧑‍💻 **IDE utilizado**: Visual Studio Code



## 📚 Índice

- [🔧 Funcionalidades](#funcionalidades)
- [🛠️ Tecnologías empleadas](#tecnologías-empleadas)
- [👥 Equipo de desarrollo](#equipo-de-desarrollo)
- [💡 Ejemplo de código Java](#ejemplo-de-código-java)
- [📌 Estado actual del proyecto](#estado_actual_del_proyecto)
- [📬 Contacto](#contacto)


## Funcionalidades

- Gestión y seguimiento de las clases impartidas.
- Administración de clientes y tipos de suscripción contratados.
- Consulta del estado y disponibilidad de las instalaciones.
- Control de horarios laborales, permisos y ausencias del personal.
- Panel de administración adaptable al rol del usuario.
- Interfaz visual moderna e interactiva con Bootstrap.


## Tecnologías empleadas

- **Java** ☕ – Lógica del sistema  
- **MySQL** 🌍 – Gestión de base de datos  
- **Bootstrap** 💻 – Estilo e interfaz  
- **Git** 🧑‍🤝‍🧑 – Control de versiones y trabajo en equipo


## Equipo de desarrollo

| Módulo | Responsable | GitHub |
|--------|-------------|--------|
| Clientes y suscripciones | Silvia | [silchartur](https://github.com/silchartur) |
| Entrenadores y personal | David | [dalloher](https://github.com/Dalloher) |
| Clases y programación horaria | Esther | [estherdiaz10](https://github.com/EstherDiaz10) |
| Equipamiento e instalaciones | Daniela | [daniela-matei](https://github.com/daniela-matei) |

> [!NOTE]
Cada miembro se encargó de una parte concreta del sistema y sus funcionalidades en el panel principal, codificadas en Java.


## Ejemplo de código Java

### Visualizar suscripciones activas
```java
public void mostrarSuscripciones() {
    boolean haySuscripciones = false;

    for (Cliente cliente : clientes) {
        if (cliente.getSuscripcion() != null) {
            System.out.println(cliente.getNombre() + " tiene contratada la suscripción: "
                + cliente.getSuscripcion().getNombre());
            haySuscripciones = true;
        }
    }

    if (!haySuscripciones) {
        System.out.println("Actualmente no hay suscripciones activas.");
    }
}

```


## Estado actual del proyecto

Este proyecto se encuentra en una **fase avanzada de desarrollo**. Los subsistemas están completados y funcionando de manera individual. Actualmente, se están realizando ajustes finales en el diseño del panel de administración.

Se espera que la versión final esté completamente operativa próximamente, incluyendo:

- Control total desde el panel de administración.
- Introducir datos dentro de nuestra base de datos para poder realizar consultas. 


## Contacto

Si deseas saber más sobre este proyecto o colaborar en su desarrollo, puedes ponerte en contacto con cualquiera de los miembros del equipo a través de sus perfiles de GitHub mencionados anteriormente.


🎓 Desarrollado como parte del módulo de **Proyecto Intermodular - 1º DAW**  
📍 **IES Font de Sant Lluís** — Valencia, España  
🌐 [portal.edu.gva.es/iesfontdesantlluis](https://portal.edu.gva.es/iesfontdesantlluis/)
