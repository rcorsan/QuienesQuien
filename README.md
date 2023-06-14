---------------------------------INSTRUCCIONES DE USO----------------------------------------------

1)Clonar el repositorio o descargarlo y importarlo en eclipse

2)Se necesita la libreria: json-simple-1.1.1.jar. Sus intrucciones de instalacion son las siguientes:
  -Ir a MAVEN REPOSITORY y buscar json simple, clickear en la primera opcion
  -Seleccionar la version 1.1.1 y descargar el bundle (jar)
  -Se te proporcionara el jar en el blackboard de la universidad
  -Para importar el jar, ir a las propiedades del proyecto, java build path, librerias, eliminas el anterior y añades el tuyo dandole a "ADD EXTERNAL JAR"

3)Para ejecutar el juego simplemente ejecutar la clase "QuienesQuien.java"

4)Al crearse los ususarios, se crea un archivo llamado "users.json" en el mismo proyecto, probablemente en el momento de creacion no lo veras, tendras que darle boton derecho al proyecto y refresh.

5)Las clases de test se ejecutan antes del juego, ya que tienen un metodo que elimina el archivo "users.json" ya que se usa para las pruebas.
