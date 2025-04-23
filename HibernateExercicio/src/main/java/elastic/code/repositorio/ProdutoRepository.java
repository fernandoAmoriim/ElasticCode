package elastic.code.repositorio;

import elastic.code.modelos.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ProdutoRepository {
    EntityManagerFactory emf;
    EntityManager em;

    public ProdutoRepository() {
        emf = Persistence.createEntityManagerFactory("cursoPCV");
        em = emf.createEntityManager();
    }

    public void salvar(Produto produto){
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
    }

    public void fecharConexao(){
        em.close();
    }

    public List<Produto> listarTodos() {
        em.getTransaction().begin();
        // Corrigido: Passando Produto.class como parâmetro para mapear a consulta para a entidade Produto
        List<Produto> produtos = em.createNativeQuery("SELECT * FROM produto", Produto.class).getResultList();
        em.getTransaction().commit();
        return produtos;
    }


    public Produto buscarPorId(Integer id){
        em.getTransaction().begin();
        Produto p = em.find(Produto.class, id);
        em.getTransaction().commit();
        return p;
    }

    public void removerPorId(Integer id){
        Produto p = buscarPorId(id);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public void atualizar(Produto produto) {
        Produto p = buscarPorId(produto.getId());
        if (p != null) {
            p.setNome(produto.getNome());
            p.setPreco(produto.getPreco());

            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    public void limparTabela(){
        em.getTransaction().begin();
        em.createNativeQuery("TRUNCATE TABLE produto").executeUpdate();
        em.getTransaction().commit();
    }
}
