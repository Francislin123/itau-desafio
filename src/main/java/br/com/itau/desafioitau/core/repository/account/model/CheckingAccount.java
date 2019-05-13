package br.com.itau.desafioitau.core.repository.account.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tab_checking_account")
public class CheckingAccount {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private Double saudo;

    @OneToOne(mappedBy = "checkingAccount")
    private Account account;

    @Tolerate
    public CheckingAccount() {
        // Default method for hibernate
    }

    @Builder
    public CheckingAccount(Long id, Double saudo, Account account) {
        this.id = id;
        this.saudo = saudo;
        this.account = account;
    }
}
