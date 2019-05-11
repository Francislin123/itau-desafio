package br.com.itau.desafioitau.core.repository.agency.model;

import br.com.itau.desafioitau.core.repository.account.model.Account;
import br.com.itau.desafioitau.core.repository.address.model.Address;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Francislin Dos Reis on 10/05/19.
 */
@Data
@Entity
@Table(name = "tab_agency")
public class Agency {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Account> account = new ArrayList<>();

    @ManyToOne
    private Address address;

    @Tolerate
    public Agency() {
        // Default method for hibernate
    }

    @Builder
    public Agency(Long id, List<Account> account, Address address) {
        this.id = id;
        this.account = account;
        this.address = address;
    }
}
