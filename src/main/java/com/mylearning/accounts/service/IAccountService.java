package com.mylearning.accounts.service;

import com.mylearning.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     * @param  customerDto-CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     * @param  mobileNumber-Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */

    public CustomerDto fetchAccount(String mobileNumber);


}
