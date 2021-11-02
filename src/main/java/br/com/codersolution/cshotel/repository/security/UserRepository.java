package br.com.codersolution.cshotel.repository.security;

import br.com.codersolution.cshotel.model.security.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

    Optional<User> findByEmail(String email);

}