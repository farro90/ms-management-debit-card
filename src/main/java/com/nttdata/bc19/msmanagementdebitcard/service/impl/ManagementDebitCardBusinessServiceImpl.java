package com.nttdata.bc19.msmanagementdebitcard.service.impl;

import com.nttdata.bc19.msmanagementdebitcard.exception.ModelNotFoundException;
import com.nttdata.bc19.msmanagementdebitcard.model.DebitCardBusiness;
import com.nttdata.bc19.msmanagementdebitcard.repository.IDebitCardBusinessRepository;
import com.nttdata.bc19.msmanagementdebitcard.request.DebitCardBusinessRequest;
import com.nttdata.bc19.msmanagementdebitcard.service.IManagementDebitCardBusinessService;
import com.nttdata.bc19.msmanagementdebitcard.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ManagementDebitCardBusinessServiceImpl implements IManagementDebitCardBusinessService {

    @Autowired
    IDebitCardBusinessRepository debitCardBusinessRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<DebitCardBusiness> create(DebitCardBusinessRequest debitCardBusinessRequest) {
        return clientServiceWC.findBusinessClientById(debitCardBusinessRequest.getIdBusinessClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(businessClientResponse -> {
                        debitCardBusinessRequest.getAccounts().stream().forEach(accountItem -> {
                            clientServiceWC.findCurrentAccountBusinessById(accountItem.getIdAccount())
                                    .switchIfEmpty(Mono.error(new ModelNotFoundException(accountItem.getIdAccount() + " account does not exist.")));
                        });

                        DebitCardBusiness debitCardBusiness = new DebitCardBusiness();
                        debitCardBusiness.setId(new ObjectId().toString());
                        debitCardBusiness.setDebitCardNumber(debitCardBusinessRequest.getDebitCardNumber());
                        debitCardBusiness.setIdBusinessClient(debitCardBusinessRequest.getIdBusinessClient());
                        debitCardBusiness.setCreatedAt(LocalDateTime.now());
                        debitCardBusiness.setDeliveryDate(LocalDateTime.now());
                        debitCardBusiness.setAccounts(debitCardBusinessRequest.getAccounts());

                        return debitCardBusinessRepository.save(debitCardBusiness);
                    }
                );
    }

    @Override
    public Mono<DebitCardBusiness> update(DebitCardBusiness debitCardBusiness) {
        debitCardBusiness.setUpdatedAt(LocalDateTime.now());
        return debitCardBusinessRepository.save(debitCardBusiness);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return debitCardBusinessRepository.deleteById(id);
    }

    @Override
    public Mono<DebitCardBusiness> findById(String id) {
        return debitCardBusinessRepository.findById(id);
    }

    @Override
    public Flux<DebitCardBusiness> findAll() {
        return debitCardBusinessRepository.findAll();
    }

    @Override
    public Flux<DebitCardBusiness> findByIdBusinessClient(String idBusinessClient) {
        return debitCardBusinessRepository.findByIdBusinessClient(idBusinessClient);
    }

    @Override
    public Mono<Long> countByIdBusinessClient(String idBusinessClient) {
        return debitCardBusinessRepository.countByIdBusinessClient(idBusinessClient);
    }
}
