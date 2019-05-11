package br.com.itau.desafioitau.core.repository.user.model;

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

    @Tolerate
    public UserEntity() {
        // Default method for hibernate
    }

    @Builder
    public UserEntity(Long id, String name, String email, String telefone, String cpf, boolean dividaAtiva) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dividaAtiva = dividaAtiva;
    }
}
