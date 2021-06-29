package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository pr;

	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos() {
		return pr.findAll();
	}

	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return pr.findById(id);
	}

	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {// o RequestBody é pq é no corpo da requisição que envia
																// dados do formulário
		return pr.save(produto);
	}

	@DeleteMapping("/deleta")
	public void deletaProduto(@RequestBody Produto produto) {
		pr.delete(produto);
	}

	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return pr.save(produto);
	}

}
