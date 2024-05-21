package com.mylearning.accounts.controller;


import com.mylearning.accounts.constants.ApplicationConstants;
import com.mylearning.accounts.dto.CustomerDto;
import com.mylearning.accounts.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @PostMapping(path="/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(ApplicationConstants.STATUS_201,ApplicationConstants.MESSAGE_201));
    }



}