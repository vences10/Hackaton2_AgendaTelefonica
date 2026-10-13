# Hackaton2_AgendaTelefonica
## Misión
Crear un sistema que permita gestionar una agenda telefónica con las siguientes características:

- Un **contacto** está definido por:
  - Nombre
  - Apellido
  - Teléfono (no es necesario validar el formato)

- Un contacto se considera igual a otro cuando tienen el mismo nombre y apellido (sin distinguir mayúsculas/minúsculas).

- La agenda puede crearse de dos formas:
  - Indicando un tamaño máximo.
  - Usando un tamaño por defecto de **10 contactos**.

### Validaciones importantes
- Los nombres y apellidos **no pueden estar vacíos**.  
- No se pueden añadir **contactos duplicados** (mismo nombre y apellido).  

---

##  Herramientas y Funcionalidades

El sistema cuenta con un menú por consola para probar todas las funcionalidades:

### `añadirContacto(Contacto c)`
- Añade un contacto a la agenda.  
- Si no hay espacio suficiente, se indica que la agenda está llena.  
- Antes de añadir, se comprueba que no exista ya en la agenda.  
- No se puede añadir si el nombre o apellido están vacíos.  

###  `existeContacto(Contacto c)`
- Verifica si un contacto ya existe en la agenda.  
- Los contactos se consideran iguales si tienen el mismo nombre y apellido, sin importar el teléfono.  

###  `listarContactos()`
- Muestra todos los contactos en el formato:  
  **Nombre Apellido - Teléfono**  
- Ordena los contactos alfabéticamente por nombre y apellido.  

###  `buscaContacto(String nombre, String apellido)`
- Permite buscar un contacto por nombre y apellido.  
- Si existe, muestra el teléfono.  
- Si no existe, muestra un mensaje indicando que no se encontró.  

###  `eliminarContacto(Contacto c)`
- Elimina un contacto de la agenda.  
- Muestra un mensaje indicando si la eliminación fue exitosa.  
- Si el contacto no existe, se informa al usuario.  

###  `modificarTelefono(String nombre, String apellido, String nuevoTelefono)`
- Permite modificar el teléfono de un contacto existente.  
- Si el contacto no existe, se muestra un mensaje de error.  

###  `agendaLlena()`
- Indica si la agenda está llena.  
- Muestra un mensaje cuando no hay espacio disponible para nuevos contactos.  

###  `espaciosLibres()`
- Muestra cuántos contactos más se pueden agregar.  
- Se basa en el tamaño máximo definido al crear la agenda.  

---

##  Estructura del Proyecto
src/
├── entities/
│    ├── Contacto.java
│    └── Directorio.java
├── exceptions/
│    ├── ContactNotExistException.java
│    ├── DuplicateContactException.java
│    └── NotSufficientSpaceException.java
├── interfaces/
│    ├── Addable.java
│    └── AgendaTelefonicaApp.java
README.md
LICENSE
.gitignore

## 👩‍💻 Autores
- **Lizeth Dorantes** 
- **Alma Vences**
- **Abraham Ortiz**
- **Gonzalo Vargas**
