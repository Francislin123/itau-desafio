package br.com.itau.desafioitau.core.repository.account.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tab_savings_account")
public class SavingsAccount {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private Double saudo;

    @OneToOne(mappedBy = "savingsAccount")
    private Account account;

    @Tolerate
    public SavingsAccount() {
        // Default method for hibernate
    }

    @Builder
    public SavingsAccount(Long id, Double saudo, Account account) {
        this.id = id;
        this.saudo = saudo;
        this.account = account;
    }
}
