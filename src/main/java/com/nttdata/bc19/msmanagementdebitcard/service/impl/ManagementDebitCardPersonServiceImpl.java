package com.nttdata.bc19.msmanagementdebitcard.service.impl;

import com.nttdata.bc19.msmanagementdebitcard.exception.ModelNotFoundException;
import com.nttdata.bc19.msmanagementdebitcard.model.DebitCardPerson;
import com.nttdata.bc19.msmanagementdebitcard.repository.IDebitCardPersonRepository;
import com.nttdata.bc19.msmanagementdebitcard.request.DebitCardPersonRequest;
import com.nttdata.bc19.msmanagementdebitcard.service.IManagementDebitCardPersonService;
import com.nttdata.bc19.msmanagementdebitcard.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ManagementDebitCardPersonServiceImpl implements IManagementDebitCardPersonService {

    @Autowired
    IDebitCardPersonRepository debitCardPersonRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<DebitCardPerson> create(DebitCardPersonRequest debitCardPersonRequest) {
        return null;
        /*return clientServiceWC.findPersonClientById(debitCardPersonRequest.getIdPersonClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(personClientResponse ->
                        clientServiceWC.findActiveProductById(debitCardPersonRequest.getIdActiveProduct())
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(creditCardResponse -> this.businessLogicCurrentAccountPerson(personClientResponse, creditCardResponse, creditCardPersonRequest))
                        );*/
    }

    @Override
    public Mono<DebitCardPerson> update(DebitCardPerson debitCardPerson) {
        debitCardPerson.setUpdatedAt(LocalDateTime.now());
        return debitCardPersonRepository.save(debitCardPerson);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return debitCardPersonRepository.deleteById(id);
    }

    @Override
    public Mono<DebitCardPerson> findById(String id) {
        return debitCardPersonRepository.findById(id);
    }

    @Override
    public Flux<DebitCardPerson> findByIdPersonClient(String idPersonClient) {
        return debitCardPersonRepository.findByIdPersonClient(idPersonClient);
    }

    @Override
    public Mono<Long> countByIdPersonClient(String idPersonClient) {
        return debitCardPersonRepository.countByIdPersonClient(idPersonClient);
    }

    @Override
    public Flux<DebitCardPerson> findAll() {
        return debitCardPersonRepository.findAll();
    }

/*    private Mono<DebitCardPerson> businessLogicCurrentAccountPerson(PersonClient personClient, ActiveProduct creditCard, CreditCardPersonRequest creditCardPersonRequest){
        CreditCardPerson creditCardPerson = new CreditCardPerson();
        creditCardPerson.setId(new ObjectId().toString());
        creditCardPerson.setCreatedAt(LocalDateTime.now());
        creditCardPerson.setCreditLine(creditCardPersonRequest.getCreditLine());
        creditCardPerson.setAnnualCommission(creditCardPersonRequest.getAnnualCommission());
        creditCardPerson.setCutoffDate(creditCardPersonRequest.getCutoffDate());
        creditCardPerson.setPayLimitDate(creditCardPersonRequest.getPayLimitDate());
        //creditCardPerson.setCreditCardNumber();
        creditCardPerson.setIdPersonClient(creditCardPersonRequest.getIdPersonClient());
        creditCardPerson.setIdActiveProduct(creditCardPersonRequest.getIdActiveProduct());
        creditCardPerson.setPersonClient(personClient);
        creditCardPerson.setActiveProduct(creditCard);

        if(creditCard.getName().equals(ActiveProductType.TARJETACREDITO.name())){
            return Mono.error(new ModelNotFoundException("The active is not CreditCard."));
        }
        if(!creditCard.getAllowPersonClient()) {
            return Mono.error(new ModelNotFoundException("Type of active not allowed for person client"));
        }
        else{
            return debitCardPersonRepository.save(creditCardPerson);
        }
    }*/
}
