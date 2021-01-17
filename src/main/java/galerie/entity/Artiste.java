/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author mjule
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = true)
@Entity // Une entité JPA
public class Artiste extends Personne {

    public Artiste(Integer id, String nom, String adresse) {
        super(id, nom, adresse);
    }

    @Column(unique = true)
    @NonNull
    private String biographie;
    
        
    @OneToMany(mappedBy = "auteur")
    private List<Tableau> oeuvres;
}
