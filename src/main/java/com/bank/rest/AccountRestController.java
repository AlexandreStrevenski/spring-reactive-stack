package com.bank.rest;

import com.bank.entity.Account;
import com.bank.entity.AccountEvent;
import com.bank.service.BankService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

    private final BankService bankService;

    public AccountRestController(BankService bankService){
        this.bankService = bankService;
    }

    @GetMapping
    public Flux<Account> all(){
        return bankService.all();
    }

    @GetMapping(value = "/{id}")
    public Mono<Account> byId(@PathVariable String id) {
        System.out.println("Got the ID: "+id);
        return bankService.byId(id);
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<AccountEvent> events (@PathVariable String id){
        return bankService.byId(id)
                .flatMapMany(bankService::streamStreams);
    }
}