package pe.opm.springboot.demo01.controllers;

import pe.opm.springboot.demo01.domain.Usuario;
import pe.opm.springboot.demo01.services.UsuarioService;
import pe.opm.springboot.demo01.services.UsuarioServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {

	@Autowired
    private UsuarioService usuarioService;
    
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("usuarios", usuarioService.listAllUsuarios());
        return "usuarios";
    }

    @RequestMapping("usuario/{id}")
    public String showUsuario(@PathVariable Integer id, Model model){
        model.addAttribute("usuario", usuarioService.getUsuarioById(id));
        return "usuarioshow";
    }

    @RequestMapping("usuario/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("usuario", usuarioService.getUsuarioById(id));
        return "usuarioform";
    }

    @RequestMapping("usuario/new")
    public String newUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        
        
        
        return "usuarioform";
    }

    @RequestMapping(value = "usuario", method = RequestMethod.POST)
    public String saveUsuario(Usuario usuario){
    	usuarioService.saveUsuario(usuario);
        return "redirect:/usuario/" + usuario.getId();
    }

    @RequestMapping("usuario/delete/{id}")
    public String delete(@PathVariable Integer id){
    	usuarioService.deleteUsuario(id);
        return "redirect:/usuarios";
    }
    
    

}
