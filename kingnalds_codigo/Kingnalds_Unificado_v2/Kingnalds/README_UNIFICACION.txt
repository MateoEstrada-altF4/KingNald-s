KINGNALD'S - PROYECTO UNIFICADO

Este proyecto integra:
1. Login + conexión MySQL.
2. Gestión de usuarios (módulo administrador).
3. Pantalla de Inicio de Kingnald's.

Flujo actual:
main.Main -> LoginFrame -> kingnalds.InicioFrame

La clase GestionUsuariosFrame se conserva dentro del proyecto para conectar
posteriormente la navegación de administrador según el rol del usuario.

IMPORTANTE:
El proyecto usa MySQL Connector/J. Si NetBeans marca una referencia rota,
vuelve a agregar el archivo mysql-connector-j-*.jar desde Libraries.
