package pe.opm.springboot.demo01.services;


import pe.opm.springboot.demo01.domain.Usuario;

public interface UsuarioService {
    Iterable<Usuario> listAllUsuarios();

    Usuario getUsuarioById(Integer id);

    Usuario saveUsuario(Usuario usuario);

    void deleteUsuario(Integer id);
}
