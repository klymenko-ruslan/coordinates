package parnikrb.repositories;

import org.springframework.stereotype.Repository;
import parnikrb.entities.Coordinate;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by klymenko.ruslan on 16.05.2015.
 */
@Repository
public class CoordinateRepository {

    public static final String UNIT_NAME = "MAIN_UNIT";

    private EntityManager em = Persistence.createEntityManagerFactory(UNIT_NAME).createEntityManager();

    public Coordinate add(Coordinate coordinate){
        em.getTransaction().begin();
        Coordinate addedCoordinate = em.merge(coordinate);
        em.getTransaction().commit();
        return addedCoordinate;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Coordinate get(long id){
        return em.find(Coordinate.class, id);
    }

    public List<Coordinate> getAll(){
        Query query = em.createQuery("SELECT c FROM Coordinate c");
        return (List<Coordinate>) query.getResultList();
    }
}
