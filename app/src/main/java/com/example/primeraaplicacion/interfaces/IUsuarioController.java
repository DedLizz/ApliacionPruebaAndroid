package com.example.primeraaplicacion.interfaces;


import com.example.primeraaplicacion.model.Usuario;
import java.util.List;

public interface IUsuarioController {

    // ! Método para agregar un usuario (ahora recibiendo el objeto Usuario)
    void agregarUsuario(Usuario usuario);

    // ! Método para obtener la lista de usuarios
    List<Usuario> getUsuarios();

    // ! Método para eliminar un usuario por ID
    void eliminarUsuario(int id);

    // ! Método para editar un usuario (ahora recibiendo el objeto Usuario)
    void editarUsuario(Usuario usuario);
}
