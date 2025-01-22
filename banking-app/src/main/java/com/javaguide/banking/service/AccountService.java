package com.javaguide.banking.service;

import com.javaguide.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {
    // Create a new account
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();
}
