package br.com.fiap.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.fiap.challenge.model.Shopping;
import br.com.fiap.challenge.repository.ShoppingRepository;

@Controller
@RequestMapping("shopping")
public class ShoppingController {

	@Autowired
	private ShoppingRepository shoppingRepository;


	@GetMapping("buscar/")
    public String buscar(Long id, Model model) {
        model.addAttribute("Shoppings", shoppingRepository.findById(id).get());
        return "shopping/lista";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("Shoppings", shoppingRepository.findAll());
        return "shopping/lista";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Shopping pedido, Model model){
        model.addAttribute("Shoppings", shoppingRepository.findAll());
        return "shopping/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Shopping pedido, RedirectAttributes redirect){
        shoppingRepository.save(pedido);
        redirect.addFlashAttribute("msg", "Cadastrado!");
        return "redirect:/shopping/cadastrar";
    }

    @DeleteMapping("deletar/{id}")
    public String deletar(@PathVariable Long id,Model model) {
        shoppingRepository.deleteById(id);
        model.addAttribute("Shoppings",shoppingRepository.findAll());
        return "shopping/lista";
    }

    @PostMapping("editar")
    public String editBook(Long id, String nm_shopping, String endereco, Shopping shopping, RedirectAttributes redirect) {
        shopping.setId(id);
        shopping.setNm_shopping(nm_shopping);
        shopping.setEndereco(endereco);
        shoppingRepository.save(shopping);
        redirect.addFlashAttribute("msg", "Editado!");
        return "redirect:/";
    } 


    @GetMapping("editar/{id}")
    public String bookListUpdate(@PathVariable (value = "id") Long id, Model model) {
        model.addAttribute("Shoppings", shoppingRepository.findById(id).get());
        return "shopping/edit";
    } 
}
