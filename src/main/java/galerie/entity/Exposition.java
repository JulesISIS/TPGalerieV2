/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity // Une entité JPA
public class Exposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private Date debut;

    private String intitule;

    private int duree;

    @ManyToOne(optional = false)
    @NonNull
    private Galerie organisateur;

    @OneToMany(mappedBy = "lieuDeVente")
    private List<Transaction> ventes;

    @ManyToMany
    @JoinTable(name="accrochage",joinColumns = @JoinColumn(name="exposition_id"),inverseJoinColumns = @JoinColumn(name="tableau_id"))
    private List<Tableau> accrochage;

    public float CA() {
        float calculCA = 0;
        for (Transaction t : ventes) {
            calculCA += t.getPrixVente();
        }
        return calculCA;
    }

}
