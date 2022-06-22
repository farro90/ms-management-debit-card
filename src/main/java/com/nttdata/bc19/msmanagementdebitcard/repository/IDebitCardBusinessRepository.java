package com.nttdata.bc19.msmanagementdebitcard.repository;

import com.nttdata.bc19.msmanagementdebitcard.model.DebitCardBusiness;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IDebitCardBusinessRepository extends ReactiveMongoRepository<DebitCardBusiness, String> {
    Flux<DebitCardBusiness> findByIdBusinessClient(String id);

    Mono<Long> countByIdBusinessClient(String id);

    Flux<DebitCardBusiness> findByIdBusinessClientAndIdActiveProduct(String idBusinessClient, String idPasiveProduct);

    Mono<Long> countByIdBusinessClientAndIdActiveProduct(String idBusinessClient, String idPasiveProduct);
}
