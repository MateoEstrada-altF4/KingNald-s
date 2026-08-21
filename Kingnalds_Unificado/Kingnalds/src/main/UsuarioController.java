package main;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private final List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController() {
        cargarDatosDemo();
    }

    private void cargarDatosDemo() {

        usuarios.add(new Usuario(
                "001",
                "Carlos Mendoza",
                "5555-1234",
                "Zona 1, Guatemala",
                "23/01/2024",
                "Administrador"
        ));

        usuarios.add(new Usuario(
                "002",
                "Ana López",
                "5555-2345",
                "Zona 10, Guatemala",
                "24/01/2024",
                "Cajero"
        ));

        usuarios.add(new Usuario(
                "003",
                "Mario Pérez",
                "5555-3456",
                "Zona 7, Guatemala",
                "25/01/2024",
                "Empleado"
        ));

        usuarios.add(new Usuario(
                "004",
                "Sofía Ramírez",
                "5555-4567",
                "Zona 12, Guatemala",
                "26/01/2024",
                "Cajero"
        ));

        usuarios.add(new Usuario(
                "005",
                "Luis González",
                "5555-5678",
                "Mixco, Guatemala",
                "27/01/2024",
                "Empleado"
        ));

        usuarios.add(new Usuario(
                "006",
                "Daniel Castillo",
                "5555-6789",
                "Villa Nueva",
                "28/01/2024",
                "Empleado"
        ));

        usuarios.add(new Usuario(
                "007",
                "María Torres",
                "5555-7890",
                "Zona 3, Guatemala",
                "29/01/2024",
                "Administrador"
        ));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario obtenerUsuario(int indice) {

        if (indice >= 0 && indice < usuarios.size()) {
            return usuarios.get(indice);
        }

        return null;
    }

    public static class Usuario {

        private String nombre;
        private String telefono;
        private String direccion;
        private String fecha;
        private String rol;
        private final String id;

        public Usuario(
                String id,
                String nombre,
                String telefono,
                String direccion,
                String fecha,
                String rol
        ) {
            this.id = id;
            this.nombre = nombre;
            this.telefono = telefono;
            this.direccion = direccion;
            this.fecha = fecha;
            this.rol = rol;
        }

        public String getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public String getDireccion() {
            return direccion;
        }

        public String getFecha() {
            return fecha;
        }

        public String getRol() {
            return rol;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }
    }
}
