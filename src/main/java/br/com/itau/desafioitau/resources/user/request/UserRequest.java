package br.com.itau.desafioitau.resources.user.request;

import lombok.Data;

import java.util.List;

/**
 * Created by Francislin Dos Reis on 2019-01-05
 */
@Data
public class UserRequest {

    private String name;

    private String email;

    private String telefone;

    private String cpf;

    private boolean dividaAtiva;
}
