package br.com.itau.desafioitau.resources.user.response;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Francislin Dos Reis on 10/05/19.
 */
@Data
@Builder
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private String telefone;

    private String cpf;

    private boolean dividaAtiva;
}
