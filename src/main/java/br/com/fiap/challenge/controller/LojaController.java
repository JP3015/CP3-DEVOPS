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

import br.com.fiap.challenge.model.Loja;
import br.com.fiap.challenge.repository.LojaRepository;

@Controller
@RequestMapping("loja")
public class LojaController {

	@Autowired
	private LojaRepository lojaRepository;
	
    
	@GetMapping("buscar")
    public String buscar(String nomeBusca, Model model ){
        model.addAttribute("Lojas", lojaRepository.findByNomeContainsIgnoreCase(nomeBusca));
        return "loja/lista";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("Lojas", lojaRepository.findAll());
        return "loja/lista";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Loja loja, Model model){
        model.addAttribute("Lojas", lojaRepository.findAll());
        return "loja/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Loja loja, RedirectAttributes redirect){
        lojaRepository.save(loja);
        redirect.addFlashAttribute("msg", "Cadastrado!");
        return "redirect:/loja/cadastrar";
    }	

    @DeleteMapping("deletar/{id}")
    public String deletar(@PathVariable Long id,Model model) {
        lojaRepository.deleteById(id);
        model.addAttribute("Lojas",lojaRepository.findAll());
        return "loja/lista";
    }

    @PostMapping("editar")
    public String editBook(Long id, String nome, Double aluguel, int shopping, Loja loja, RedirectAttributes redirect) {
        loja.setId(id);
        loja.setNome(nome);
        loja.setAluguel(aluguel);
        loja.setShopping(shopping);
        lojaRepository.save(loja);
        redirect.addFlashAttribute("msg", "Editado!");
        return "redirect:/";
    } 


    @GetMapping("editar/{id}")
    public String bookListUpdate(@PathVariable (value = "id") Long id, Model model) {
        model.addAttribute("Lojas", lojaRepository.findById(id).get());
        return "loja/edit";
    } 
}