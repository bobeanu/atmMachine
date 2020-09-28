package com.test.atm.service;

import com.test.atm.exception.AtmApiException;
import com.test.atm.repository.AccountRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtmService {
    private static final Logger LOG = LoggerFactory.getLogger(AtmService.class);

    @Autowired
    private AccountRepository accountRepository;

    public Double withdraw(Long userId, Double amount) throws AtmApiException {
        LOG.debug("Withdraw for user: " + userId);

        return Optional.ofNullable(accountRepository.findAccountById(userId)
                .orElseThrow(() -> new AtmApiException("Account not found")))
                .filter((account) -> account.getAmount().compareTo(amount) > -1)
                .map((account) -> {
                    account.setAmount(account.getAmount() - amount);
                    accountRepository.save(account);
                    return account.getAmount();
                })
                .orElseThrow(() -> new AtmApiException("Please insert a lower amount!"));

    }

    public Double inquiry(Long userId) throws AtmApiException {
        LOG.debug("Inquiry for user: " + userId);

        return accountRepository.findAccountById(userId)
                .orElseThrow(() -> new AtmApiException("Account not found"))
                .getAmount();
    }
}
