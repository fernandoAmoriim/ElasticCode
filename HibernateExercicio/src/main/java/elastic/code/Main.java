package elastic.code;

import elastic.code.modelos.Produto;
import elastic.code.repositorio.ProdutoRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProdutoRepository repository = new ProdutoRepository();

        // LIMPANDO TABEL
        repository.limparTabela();

        Produto prop1 = new Produto("Panela", "Panela de Pressão 10 Litros", 56.80);
        Produto prop2 = new Produto("Cama", "Panela de Pressão 10 Litros", 450.68);
        Produto prop3 = new Produto("Caixa Som", "Panela de Pressão 10 Litros", 160.00);

        // INSERINDO PRODUTOS
        repository.salvar(prop1);
        repository.salvar(prop2);
        repository.salvar(prop3);

        // LISTANDO
        List<Produto> produtos = repository.listarTodos();
        System.out.println(produtos);

        repository.removerPorId(1);

        produtos = repository.listarTodos();

        // LISTANDO COM ALTERAÇÃO
        System.out.println(produtos);

        // PRODUTO ANTES DE ALTERAR
        System.out.println(repository.buscarPorId(2));

        Produto novoProduto = new Produto("Mouse", "Ultra mouser gamer", 21.99);
        novoProduto.setId(2);

        repository.atualizar(novoProduto);

        // PRODUTO DEPOIS DE ALTERAR
        System.out.println(repository.buscarPorId(2));

        repository.fecharConexao();

    }
}