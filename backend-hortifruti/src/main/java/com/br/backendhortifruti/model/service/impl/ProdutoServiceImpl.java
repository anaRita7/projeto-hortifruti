package com.br.backendhortifruti.model.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.backendhortifruti.model.entity.Produto;
import com.br.backendhortifruti.model.repository.ProdutoRepository;
import com.br.backendhortifruti.model.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    Random random = new Random();

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto incluirProduto(Produto produto) {
        if (produto.getCodigo() == null) {
            Integer codigoGerado = (random.nextInt(1000000001) + 899999999);
            if (consultarProdutoPorCodigo(codigoGerado) == null) {
                produto.setCodigo(codigoGerado);
                return produtoRepository.save(produto);
            }
        }
        return null;
    }

    @Override
    public Page<Produto> consultarProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    @Override
    public Produto consultarProduto(Integer id) {
        Optional <Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    @Override
    public Produto alterarProduto(Produto produto, Integer id) {
        if (produtoRepository.findById(id).isPresent()) {
            Produto existingProduto = produtoRepository.findById(id).get();
            existingProduto.setNome(produto.getNome());
            existingProduto.setDescricao(produto.getDescricao());
            existingProduto.setUnidadeMedida(produto.getUnidadeMedida());
            existingProduto.setValorUnitario(produto.getValorUnitario());
            existingProduto.setStatus(produto.isStatus());

            produtoRepository.save(existingProduto);
            return existingProduto;
        }
        return null;
    }

    @Override
    public void excluirProduto(Integer id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public Produto consultarProdutoPorCodigo(Integer codigo) {
        Optional<Produto> Produto = produtoRepository.findByCodigo(codigo);
        return Produto.orElse(null);
    }

    @Override
    public Page<Produto> consultarProdutosAtivosPage(Pageable pageable) {
        return new PageImpl<>(produtoRepository.findByStatusTrue(), pageable, produtoRepository.findByStatusTrue().size());
    }

    @Override
    public List<Produto> consultarProdutosAtivos() {
        return produtoRepository.findByStatusTrue();
    }

    @Override
    public Produto consultarProdutoAtivoPorCodigo(Integer codigo) {
        Optional<Produto> produto = produtoRepository.findByStatusAndCodigo(true, codigo);
        return produto.orElse(null);
    }

    @Override
    public Produto alterarStatusProduto(Integer produtoId, boolean status) {
        if (produtoRepository.findById(produtoId).isPresent()) {
            Produto produto = produtoRepository.findById(produtoId).get();
            produto.setStatus(status);
            return produtoRepository.save(produto);
        }
        return null;
    }

    @Override
    public List<Produto> consultarProdutosInativos() {
        return produtoRepository.findByStatusFalse();
    }

}
