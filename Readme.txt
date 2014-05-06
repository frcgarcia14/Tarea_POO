Este es el readme para la tarea1 del ramo Elo329 (Programación orientada a objetos) del grupo conformado por
Marcela Polanco, Francisco Garcia y Bernardo Farías.
A traves de este readme se indica la forma de ejecutar los codigos para el desarrollo de un ambiente simulado
para los elementos FixeHook, Ball y Spring.
Pasos de ejecución.
1.- Descomprimir y abrir la Carpeta Tarea1_Elo329.rar 
2.- Abrir la carpeta Desarrollo por etapas
3.- buscar la etapa de interes que se desea observar y abrir su carpeta, estas pueden ser:
    a.- Etapa1: Colision de dos bolas
    b.- Etapa2: dos bolas unidas por un resorte
    c.- Etapa3: ganchofijo y bola unidos por resorte
    d.- Etapa4: ganchofijo y bola unidos por resorte en donde este ultimo colisiona con otra bola
    e-  Etapa5: Elementos fisicos unidos de la siguiente forma: ganchofijo-resorte-bola-resorte-bola
4.- Ejecutar el codigo PhysicsLab.java, dependiendo de por donde se ejecute se debe realizar de la siguiente manera:
    jGRASP: Seleccionar la opción Build, luego hacer click en Run Arguments, en el codigo aparecera una barra que dice
            Run Arguments, en donde se debe colocar  <IntervaloSimulacion> <TiempoTotalSimulacion> <Tiempodemuestreo>
    Consola: Compilar el codigo a traves de: javac PhysicsLab.java
             Ejecutar el codigo a traves de: java PhysicsLab <IntervaloSimulacion> <TiempoTotalSimulacion> <Tiempodemuestreo>
    make: Compilar el codigo a traves de: make
          Ejecutar el codigo a traves de: make run
5.- El codigo debe entregar una tabla con los distintos valores de los elementos pertenecientes al espacio fisico simulado.

.