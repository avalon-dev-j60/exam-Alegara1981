
package ru.klinika.vet.entities;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    
         @NamedQuery(
         name = "find-all-publications",
                 query = "SELECT item "
                         + "FROM Publication AS item"),
    @NamedQuery(
     name = "find-publication-by-id",
                 query = "SELECT item "
                         + "FROM Publication AS item "
                         + "WHERE item.id = :id "
    )

})


@Entity
public class Publication implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "LONG VARCHAR")  
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private User author;

    protected Publication() {
    }
    
    

    public Publication(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
        this.author = author;
    }
    
    
    
    public long getId(){
        return id;
    
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User getAuhtor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setAuhtor(User auhtor) {
        this.author = author;
    }
    
}
