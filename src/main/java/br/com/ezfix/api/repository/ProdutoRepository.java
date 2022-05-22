package br.com.ezfix.api.repository;

import br.com.ezfix.api.controller.response.ProdutoSimples;
import br.com.ezfix.api.model.Marca;
import br.com.ezfix.api.model.Modelo;
import br.com.ezfix.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select new br.com.ezfix.api.controller.response.ProdutoSimples(p.id, p.marca.id, p.tipo.id, p.modelo.id) from Produto p")
    List<ProdutoSimples> getProdutosids();

    @Query("select p.marca from Produto p where p.tipo.id = ?1")
    List<Marca> obterPorTodosTipo(Long id);

    @Query("select p.modelo from Produto p where p.tipo.id = ?1 and p.marca.id = ?2")
    List<Modelo> obterPorTodosTipoAndMarca(Long idTipo, Long idMarca);
}
