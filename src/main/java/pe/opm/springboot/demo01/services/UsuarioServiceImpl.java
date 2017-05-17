package pe.opm.springboot.demo01.services;

import pe.opm.springboot.demo01.domain.Usuario;
import pe.opm.springboot.demo01.repositories.UsuarioRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository ;


    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Iterable<Usuario> listAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findOne(id);
    }
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Integer id) {
    	usuarioRepository.delete(id);
    }

}
