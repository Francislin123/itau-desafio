package br.com.itau.desafioitau.core.repository.account.model;

import br.com.itau.desafioitau.core.repository.agency.model.Agency;
import br.com.itau.desafioitau.core.repository.user.model.UserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

/**
 * Created by Francislin Dos Reis on 10/05/19.
 */
@Data
@Entity
@Table(name = "tab_account")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "account")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "checking_account_id", referencedColumnName = "id")
    private CheckingAccount checkingAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "savings_account_id", referencedColumnName = "id")
    private SavingsAccount savingsAccount;

    @Tolerate
    public Account() {
        // Default method for hibernate
    }

    @Builder
    public Account(Long id, UserEntity user, Agency agency, CheckingAccount checkingAccount, SavingsAccount savingsAccount) {
        this.id = id;
        this.user = user;
        this.agency = agency;
        this.checkingAccount = checkingAccount;
        this.savingsAccount = savingsAccount;
    }
}
