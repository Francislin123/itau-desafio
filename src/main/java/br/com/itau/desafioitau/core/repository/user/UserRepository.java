package br.com.itau.desafioitau.core.repository.user;

import br.com.itau.desafioitau.core.repository.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Francislin Dos Reis on 10/05/19.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
