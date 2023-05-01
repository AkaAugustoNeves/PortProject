package br.com.augusto.PortProject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.augusto.PortProject.model.dto.ProjetoDTO;
import br.com.augusto.PortProject.model.entity.Empresa;
import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.model.entity.Projeto;
import br.com.augusto.PortProject.model.enuns.Acao;
import br.com.augusto.PortProject.model.enuns.Cargo;
import br.com.augusto.PortProject.model.enuns.Risco;
import br.com.augusto.PortProject.model.enuns.Status;
import br.com.augusto.PortProject.model.form.ProjetoEditForm;
import br.com.augusto.PortProject.model.form.ProjetoForm;
import br.com.augusto.PortProject.service.EmpresaService;
import br.com.augusto.PortProject.service.PessoaService;
import br.com.augusto.PortProject.service.ProjetoService;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

	private ProjetoService projetoService;
	private EmpresaService empresaService;
	private PessoaService pessoaService;	
	
	public ProjetoController(ProjetoService projetoService, EmpresaService empresaService, PessoaService pessoaService) {
		this.pessoaService = pessoaService;
		this.projetoService = projetoService;
		this.empresaService = empresaService;
	}	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, true));
	}
	
	@GetMapping("")
    public String telaListar(Model model) {
		List<Projeto> projetos = projetoService.buscarTodos();
        model.addAttribute("projetos", projetos);
        model.addAttribute("riscos", Risco.valores());
        return "projetos/listar";
    }
	
	@GetMapping("/filtro")
    public String tabelaProjetos(Model model, @RequestParam(name = "filtro-risco", required = false) Risco risco) {
		List<Projeto> projetos;
		if (risco != null) {
			projetos = projetoService.buscarPorRisco(risco);
		} else {
			projetos = projetoService.buscarTodos();
		}
		model.addAttribute("projetos", projetos);
		return "projetos/tabelaProjetos";
	}
	
	@GetMapping("/novo")
    public String telaCadastro(Model model) {
		List<Empresa> empresas = empresaService.buscarTodos();
		List<Pessoa> gerentes = pessoaService.buscarPorCargo(Cargo.GERENTE);
        model.addAttribute("empresas", empresas);
        model.addAttribute("gerentes", gerentes);
        model.addAttribute("riscos", Risco.valores());
		return "projetos/novo";
    }
	
	@GetMapping("/{id}/editar")
    public String telaEditar(@PathVariable("id") Long id, Model model) {
		projetoService.buscarPorId(id);
		List<Empresa> empresas = empresaService.buscarTodos();
		List<Pessoa> gerentes = pessoaService.buscarPorCargo(Cargo.GERENTE);
		model.addAttribute("empresas", empresas);
        model.addAttribute("gerentes", gerentes);
        model.addAttribute("riscos", Risco.valores());
        model.addAttribute("status", Status.valores());
        model.addAttribute("projeto", new ProjetoDTO(projetoService.buscarPorId(id).get()));
        return "projetos/editar";
    }
	
	@GetMapping("/{id}/deletar")
    public String telaConfirmacaoDeletar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("projeto", projetoService.buscarPorId(id).get());
        return "projetos/confirmacaoDeletar";
    }
		
	@GetMapping("/{id}/funcionarios")
	public String telaAtribuirFuncionarios(@PathVariable("id") Long id, Model model) {
		Projeto projeto = projetoService.buscarPorId(id).get();
		model.addAttribute("projeto", projeto);
		model.addAttribute("funcionarios", projetoService.buscarNaoIntegrantes(id));
		model.addAttribute("integrantes", projeto.getIntegrantes());
		return "projetos/atribuirFuncionarios";
	}
	
	@GetMapping("/{id}/{acao}/{idPessoa}")
	public String telaConfirmarAcaoIntegrante(@PathVariable("id") Long id, @PathVariable("acao") Acao acao,	@PathVariable("idPessoa") Long idPessoa, Model model) {
		model.addAttribute("projeto", projetoService.buscarPorId(id).get());
		model.addAttribute("pessoa", pessoaService.buscarPorId(idPessoa).get());
		model.addAttribute("acao", acao);
		return "projetos/confirmarAlocarDesalocar";
	}
	
	@PostMapping("/novo")
	public String criarNovoProjeto(@ModelAttribute("projeto") ProjetoForm projeto) throws ParseException  {
	    projetoService.salvar(projeto);
	    return "redirect:/projetos";
	}
	
	@PostMapping("/{id}/editar")
	public String editarProjeto(@PathVariable("id") Long id, @ModelAttribute("projeto") ProjetoEditForm projeto) throws ParseException {
	   projetoService.editar(id, projeto);
		return "redirect:/projetos";
	}
	
	@PostMapping("/{id}/deletar")
	public String deletarProjeto(@PathVariable("id") Long id) {
		projetoService.excluir(id);
		return "redirect:/projetos";
	}
	
	@PostMapping("/{id}/{acao}/{idPessoa}")
	public String acaoIntegrante(@PathVariable("id") Long id, @PathVariable("acao") Acao acao,	@PathVariable("idPessoa") Long idPessoa, Model model) {
		projetoService.acaoIntegrante(id, acao, idPessoa);
		return "redirect:/projetos/"+id+"/funcionarios";
	}

}