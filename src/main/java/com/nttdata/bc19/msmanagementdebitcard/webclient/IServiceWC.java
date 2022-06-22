package com.nttdata.bc19.msmanagementdebitcard.webclient;

import com.nttdata.bc19.msmanagementdebitcard.model.responseWC.*;
import reactor.core.publisher.Mono;

public interface IServiceWC {
    Mono<PersonClient> findPersonClientById(String id);

    Mono<BusinessClient> findBusinessClientById(String id);

    Mono<PasiveProduct> findPasiveProductById(String id);

    Mono<ActiveProduct> findActiveProductById(String id);

    Mono<CurrentAccountPerson> findCurrentAccountPersonById(String id);
    Mono<SavingAccountPerson> findSavingAccountPersonById(String id);
    Mono<FixedTermAccountPerson> findFixedTermAccountPersonById(String id);
    Mono<CurrentAccountBusiness> findCurrentAccountBusinessById(String id);
}
