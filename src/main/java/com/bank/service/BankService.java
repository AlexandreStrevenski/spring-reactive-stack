package com.bank.service;

import com.bank.entity.Account;
import com.bank.entity.AccountEvent;
import com.bank.repository.AccountRepository;
import com.bank.entity.EventType;
import com.bank.util.RandomUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class BankService {

    private final AccountRepository accountRepository;

    public BankService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Flux<AccountEvent> streamStreams(Account account){
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        Flux<AccountEvent> events = Flux.fromStream(Stream.generate(()-> new AccountEvent(account, new Date(), RandomUtil.randomEvent(), RandomUtil.randomAmount())));
        return Flux.zip(interval, events).map(Tuple2::getT2);
    }

    public Flux<Account> all() {
        return Flux.fromIterable(accountRepository.findAll());
    }

    public Mono<Account> byId(String id) {
        Optional<Account> movie = accountRepository.findById(id);
        return Mono.justOrEmpty(movie);
    }

}