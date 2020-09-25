package com.test.atm.repository;

import com.test.atm.model.Account;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

    Optional<Account> findAccountById(Long userId);

}
