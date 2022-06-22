package com.nttdata.bc19.msmanagementdebitcard.api;

import com.nttdata.bc19.msmanagementdebitcard.model.DebitCardPerson;
import com.nttdata.bc19.msmanagementdebitcard.request.DebitCardPersonRequest;
import com.nttdata.bc19.msmanagementdebitcard.service.IManagementDebitCardPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/debit-card/person")
public class ManagementDebitCardPersonApi {

    @Autowired
    private IManagementDebitCardPersonService managementDebitCardPersonService;

    @PostMapping()
    public Mono<DebitCardPerson> create(@RequestBody DebitCardPersonRequest creditCardPersonRequest){
        return managementDebitCardPersonService.create(creditCardPersonRequest);
    }

    @PutMapping()
    public Mono<DebitCardPerson> update(@RequestBody DebitCardPerson creditCardPerson){
        return managementDebitCardPersonService.update(creditCardPerson);
    }

    @GetMapping()
    public Flux<DebitCardPerson> findAll(){
        return managementDebitCardPersonService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<DebitCardPerson> findById(@PathVariable String id){ return managementDebitCardPersonService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return managementDebitCardPersonService.deleteById(id);
    }

    @GetMapping("findByIdPersonClient/{idPersonClient}")
    public Flux<DebitCardPerson> findByIdPersonClient(@PathVariable String idPersonClient){ return managementDebitCardPersonService.findByIdPersonClient(idPersonClient); }

    @GetMapping("countByIdPersonClient/{idPersonClient}")
    public Mono<Long> countByIdPersonClient(@PathVariable String idPersonClient){ return managementDebitCardPersonService.countByIdPersonClient(idPersonClient); }
}
