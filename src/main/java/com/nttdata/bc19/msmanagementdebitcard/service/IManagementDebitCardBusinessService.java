package com.nttdata.bc19.msmanagementdebitcard.service;

import com.nttdata.bc19.msmanagementdebitcard.model.DebitCardBusiness;
import com.nttdata.bc19.msmanagementdebitcard.request.DebitCardBusinessRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IManagementDebitCardBusinessService {

    Mono<DebitCardBusiness> create(DebitCardBusinessRequest debitCardBusinessRequest);
    Mono<DebitCardBusiness> update(DebitCardBusiness debitCardBusiness);
    Mono<Void>deleteById(String id);
    Mono<DebitCardBusiness> findById(String id);
    Flux<DebitCardBusiness> findAll();

    Flux<DebitCardBusiness> findByIdBusinessClient(String idBusinessClient);

    Mono<Long> countByIdBusinessClient(String idBusinessClient);

}
