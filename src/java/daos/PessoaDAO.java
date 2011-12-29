package daos;

import entidades.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import jpa.ApplicationService;

public class PessoaDAO {

    private EntityManager em;
    
    public PessoaDAO() {
        // Outro teste
        this.em = new ApplicationService().entityManager;
    }
    
    public List<Pessoa> list() {
        String select = "SELECT e FROM Pessoa e";
        try {
            List<Pessoa> lista = em.createQuery(select).getResultList();
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Pessoa find(Integer id) {
        try {
            Pessoa e = em.find(Pessoa.class, id);
            return e;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void persist(Pessoa p) {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void merge(Pessoa p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void remove(Pessoa p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
