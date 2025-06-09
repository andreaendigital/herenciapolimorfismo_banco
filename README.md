# Sistema de Banco

Proyecto Academico desarrollado en el que se solicita implementar clases y los atributos, deberás generar los constructores, accesadores y mutadores y los métodos necesarios que cumplan con los requerimientos y reglas de negocio solicitadas. Además, deberás utilizar herencia y aplicar superclase, subclases, modificación de métodos y clases anexas. Además de la estructuración de paquetes y directorios con el uso de las clases.

## Descripción del Proyecto :scroll:

Caso planteado: 
Bank Europe se encuentra en proceso de crecimiento y posicionamiento, tanto a nivel operacional como estructural; sus servicios ofrecidos se encuentran en continuas etapas de perfeccionamiento, como por ejemplo, su servicio de gestión de cuentas bancarias, donde: 
1.	Cada cuenta tiene un número de cuenta de 9 dígitos y saldo.  
2.	Cada cliente puede tener una sola cuenta contratada, y realizar operaciones como registrar y ver sus datos, depositar y girar dinero y consultar saldo.  
3.	Cada cliente tiene sus características personales, y 
4.	Toda cuenta corriente tiene las siguientes características:   
•	Número: Ej: 123456789   
•	Saldo: Ej: 1550900

A partir de aquí, deberás aplicar lo aprendido en las semanas 1 y 2 y así poder entregar una solución final al caso planteado. Para ello, tendrás que seguir los siguientes pasos: 

## Sobre el proyecto 🚀

### ✨ Requerimientos ✨

👌 1. Creación de la clase base abstracta

•	Crea un nuevo proyecto en Java llamado "Bank_Europe".
•	Dentro del proyecto, crea una clase base abstracta llamada ‘CuentaBancaria’.
•	En la clase ‘CuentaBancaria’, define al menos dos atributos como saldo y número de cuenta, encapsulándolos adecuadamente.
•	Crea un constructor en la clase ‘CuentaBancaria’ para inicializar estos atributos.
•	Declara un método abstracto llamado ‘calcularInteres’ que representará el cálculo de intereses. Esta será una característica común a todas las cuentas bancarias.

👌 2.  Creación de subclases
•	Crea tres subclases: ‘CuentaCorriente’, ‘CuentaAhorros’ y ‘CuentaDigital’. Todas estas subclases heredarán de la clase ‘CuentaBancaria’.
•	En cada subclase, implementa el método abstracto ‘calcularInteres’ de acuerdo con el tipo de cuenta, ya que el cálculo de intereses puede variar.
•	Puedes aplicar la sobrecarga de métodos en la clase base para tener varios constructores con diferentes parámetros, lo que permitirá crear subclases de diferentes maneras.

👌 3. Implementación de la interfaz
•	Crea una interfaz llamada ‘InfoCliente’ que defina un método ‘mostrarInformacionCliente’.
•	Las clases que necesiten mostrar información del cliente deberán implementar esta interfaz y proporcionar su propia implementación del método según sus necesidades.

 👌 4. Sobreescritura en la clase abstracta
•	En la clase abstracta ‘CuentaBancaria’, declara el método abstracto ‘calcularInteres’.
•	Cada subclase, como ‘CuentaCorriente’, ‘CuentaAhorros’ y ‘CuentaDigital’, deberá sobrescribir este método para adaptarlo a su comportamiento específico.

En el siguiente paso, deberás aplicar lo aprendido en esta semana, es decir:

👌 5. Aplicación de jerarquía de paquetes y dominios
Para realizar este paso, tendrás que realizar lo siguiente: 
•	Identifica al menos dos dominios en tu proyecto. 
•	Crea paquetes principales para cada uno de los dominios.
•	Organiza las clases con cada dominio en su respectivo paquete. 
•	Crea dentro de un dominio dos paquetes internos.
•	Utiliza importaciones adecuadas en tus clases para acceder a clases de otros paquetes (‘import’).



## Visuales :mage_woman:

Estructuración de carpetas:

![Captura de pantalla 2025-06-09 140922](https://github.com/user-attachments/assets/a52303b1-090e-4550-afa0-70d74328f01c)

Menú inicial con manejo de errores: 

![Captura de pantalla 2025-06-09 140859](https://github.com/user-attachments/assets/57754464-31ca-4f2a-b76c-951c8ba1d7cd)


Manejo de errores y validaciones en el registro de clientes: 
Numero de cuenta autogenerativo

![Captura de pantalla 2025-06-09 141734](https://github.com/user-attachments/assets/de2fe9a9-f01f-4a95-9cb9-43aff906cc53)

Al ver la información y consultar saldo: 

![Captura de pantalla 2025-06-09 142015](https://github.com/user-attachments/assets/e549254c-0690-4c39-b634-f588d2dde995)

Se realiza depósito y giro y una consulta nueva de saldo

![Captura de pantalla 2025-06-09 142126](https://github.com/user-attachments/assets/f51c4e7f-7bde-4486-98d1-df3c6c536922)

Al listar los clientes: 

![Captura de pantalla 2025-06-09 142152](https://github.com/user-attachments/assets/7f8c7918-3941-4fa6-95c9-616ef6ec43a9)



## Autora ⚡ 

- **Andrea Rosero** ⚡  - [Andrea Rosero](https://github.com/andreaendigital)
