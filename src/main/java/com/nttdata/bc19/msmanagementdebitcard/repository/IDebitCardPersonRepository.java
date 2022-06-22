package com.nttdata.bc19.msmanagementdebitcard.repository;

import com.nttdata.bc19.msmanagementdebitcard.model.DebitCardPerson;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IDebitCardPersonRepository extends ReactiveMongoRepository<DebitCardPerson, String> {
    Flux<DebitCardPerson> findByIdPersonClient(String id);

    Mono<Long> countByIdPersonClient(String id);
}
