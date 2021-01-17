/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Tableau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String titre;
    
    @NonNull
    private String support;
    
    private int largeur;
    
    private int hauteur;
    
    @ManyToOne(optional = false)
    @NonNull
    private Artiste auteur;
    
    @ManyToMany(mappedBy = "accrochage")
    private List<Exposition> organisateur;
    
    @OneToOne
    private Transaction vendu;
}
