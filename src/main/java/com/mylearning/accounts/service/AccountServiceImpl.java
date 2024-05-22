package com.mylearning.accounts.service;

import com.mylearning.accounts.dto.CustomerDto;
import com.mylearning.accounts.repository.AccountsRepository;
import com.mylearning.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /*
     * @param  customerDto-CustomerDto Object
     * */

    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
