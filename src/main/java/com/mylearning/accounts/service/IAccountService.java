package com.mylearning.accounts.service;

import com.mylearning.accounts.dto.CustomerDto;

public interface IAccountService {
    /*
     * @param  customerDto-CustomerDto Object
     * */
    void createAccount(CustomerDto customerDto);
}
