package br.com.itau.desafioitau.core.repository.user.model;

import br.com.itau.desafioitau.core.repository.account.model.Account;
import br.com.itau.desafioitau.core.repository.address.model.Address;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

/**
 * Created by Francislin Dos Reis on 10/05/19.
 */
@Data
@Entity
@Table(name = "tab_user")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "cell")
    private String telefone;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "divida_ativa")
    private boolean dividaAtiva;

    @ManyToOne
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Tolerate
    public UserEntity() {
        // Default method for hibernate
    }

    @Builder
    public UserEntity(Long id, String name, String email, String telefone, String cpf, boolean dividaAtiva, Address address, Account account) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dividaAtiva = dividaAtiva;
        this.address = address;
        this.account = account;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dividaAtiva=" + dividaAtiva +
                '}';
    }
}
