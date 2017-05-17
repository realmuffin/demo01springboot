package pe.opm.springboot.demo01.repositories;

import org.springframework.data.repository.CrudRepository;

import pe.opm.springboot.demo01.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
}
