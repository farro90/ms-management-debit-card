package com.nttdata.bc19.msmanagementdebitcard.service;

import com.nttdata.bc19.msmanagementdebitcard.model.DebitCardPerson;
import com.nttdata.bc19.msmanagementdebitcard.request.DebitCardPersonRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IManagementDebitCardPersonService {

    Mono<DebitCardPerson> create(DebitCardPersonRequest debitCardPersonRequest);
    Mono<DebitCardPerson> update(DebitCardPerson debitCardPerson);
    Mono<Void>deleteById(String id);
    Mono<DebitCardPerson> findById(String id);
    Flux<DebitCardPerson> findAll();

    Flux<DebitCardPerson> findByIdPersonClient(String idPersonClient);

    Mono<Long> countByIdPersonClient(String idPersonClient);

}
