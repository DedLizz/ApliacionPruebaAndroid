package com.example.primeraaplicacion.controller;

import com.example.primeraaplicacion.interfaces.IUsuarioController;
import com.example.primeraaplicacion.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController implements IUsuarioController {
    private List<Usuario> usuarios;  // Lista para almacenar los usuarios
    private int nextId;

    // Constructor para inicializar la lista de usuarios
    public UsuarioController() {
        this.usuarios = new ArrayList<>();  // Inicialización de la lista de usuarios
        this.nextId = 1;  // Inicializar el contador del ID
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        // Asignar un ID al usuario antes de agregarlo a la lista
        usuario.setId(nextId++);
        usuarios.add(usuario);  // Agregar el usuario a la lista
    }

    @Override
    public List<Usuario> getUsuarios() {
        // Devolver la lista de usuarios
        return usuarios;
    }

    @Override
    public void eliminarUsuario(int id) {
        // Eliminar el usuario de la lista mediante el ID
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuarios.remove(usuario);
                break;
            }
        }
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        // Buscar y actualizar el usuario en la lista
        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId()) {
                u.setNombre(usuario.getNombre());
                u.setApellido(usuario.getApellido());
                u.setEmail(usuario.getEmail());
                break;
            }
        }
    }
}

