package br.com.itau.desafioitau.core.repository.address.model;

import br.com.itau.desafioitau.core.repository.agency.model.Agency;
import br.com.itau.desafioitau.core.repository.user.model.UserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tab_address")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "public_place")
    private String logradouro;

    @Column(name = "locality")
    private String localidade;

    @Column(name = "neighborhood")
    private String bairro;

    @Column(name = "uf")
    private String uf;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<UserEntity> client;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Agency> agencies;

    @Tolerate
    public Address() {
        // Method default for hibernate
    }

    @Builder
    public Address(Long id, String cep, String logradouro, String localidade, String bairro, String uf, List<UserEntity> client, List<Agency> agencies) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.bairro = bairro;
        this.uf = uf;
        this.client = client;
        this.agencies = agencies;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", uf='" + uf + '\'' +
                ", client=" + client +
                '}';
    }
}