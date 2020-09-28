package com.test.atm.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.test.atm.exception.AtmApiException;
import com.test.atm.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/atm")
public class AtmController {

    @Autowired
    AtmService atmService;

    @RequestMapping(value = "/withdraw", method = GET)
    public Double withDraw(
            @RequestParam(value = "userId") Long userId,
            @RequestParam(value = "amount") Double amount
    ) throws AtmApiException {
        return atmService.withdraw(userId, amount);
    }


    @RequestMapping(value = "/inquiry", method = GET)
    public Double inquiry(
            @RequestParam(value = "userId") Long userId
    ) throws AtmApiException {
        return atmService.inquiry(userId);
    }

}
