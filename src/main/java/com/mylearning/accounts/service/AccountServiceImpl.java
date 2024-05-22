package com.mylearning.accounts.service;

import com.mylearning.accounts.constants.ApplicationConstants;
import com.mylearning.accounts.dto.CustomerDto;
import com.mylearning.accounts.entity.Accounts;
import com.mylearning.accounts.entity.Customer;
import com.mylearning.accounts.exception.CustomerAlreadyExistsException;
import com.mylearning.accounts.mapper.CustomerMapper;
import com.mylearning.accounts.repository.AccountsRepository;
import com.mylearning.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     * @param customerDto-CustomerDto Object
     */

    @Override
    public void createAccount(CustomerDto customerDto) {
        Optional<Customer> existedCustomer =  customerRepository.findByMobileNumberOrEmail(customerDto.getMobileNumber(),customerDto.getEmail());
        if(existedCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer with the same mobile number or email already exists" + customerDto.getMobileNumber()+" "+customerDto.getEmail());
        }
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(ApplicationConstants.SAVINGS);
        newAccount.setBranchAddress(ApplicationConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }

}
