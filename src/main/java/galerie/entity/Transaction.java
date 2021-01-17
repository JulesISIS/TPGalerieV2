/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NonNull
    private Date venduLe;

    private float prixVente;
    
    @ManyToOne
    @NonNull
    private Exposition lieuDeVente;
    
    @ManyToOne
    @NonNull
    private Personne client;
    
    @OneToOne(mappedBy = "vendu")
    private Tableau oeuvre;
}
