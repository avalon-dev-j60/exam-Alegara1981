
package ru.klinika.vet.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import ru.klinika.vet.entities.Review;


@Stateless
public class ReviewService {
    
    @PersistenceContext(unitName = "Blog-PU")
    EntityManager em;

    public void create(Review review) {
        em.persist(review);
        
    }
    
     public void update(Review review) {
        em.merge(review);
        
    }
    
     public void delete(Review review) {
        em.remove(review);
        
    }
     public Review find(long id){
     try{
         return em
                 .createNamedQuery("find-review-by-id", Review.class)
                 .setParameter("id", id)
                 .getSingleResult();
     }   catch (NoResultException e){
         return null;
     } 
     }
     
     public List<Review> all() {
          try{
              return em
                      .createNamedQuery("find-all-review", Review.class)
                      .getResultList();
         
     }   catch (NoResultException e){
         return Collections.emptyList();
     } 
     
     }
     
}
