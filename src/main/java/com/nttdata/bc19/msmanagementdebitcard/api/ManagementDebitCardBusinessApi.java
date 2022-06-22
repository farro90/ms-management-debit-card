package com.nttdata.bc19.msmanagementdebitcard.api;

import com.nttdata.bc19.msmanagementdebitcard.model.DebitCardBusiness;
import com.nttdata.bc19.msmanagementdebitcard.request.DebitCardBusinessRequest;
import com.nttdata.bc19.msmanagementdebitcard.service.IManagementDebitCardBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/debit-card/business")
public class ManagementDebitCardBusinessApi {

    @Autowired
    private IManagementDebitCardBusinessService managementDebitCardBusinessService;

    @PostMapping()
    public Mono<DebitCardBusiness> create(@RequestBody DebitCardBusinessRequest debitCardBusinessRequest){
        return managementDebitCardBusinessService.create(debitCardBusinessRequest);
    }

    @PutMapping()
    public Mono<DebitCardBusiness> update(@RequestBody DebitCardBusiness debitCardBusiness){
        return managementDebitCardBusinessService.update(debitCardBusiness);
    }

    @GetMapping()
    public Flux<DebitCardBusiness> findAll(){
        return managementDebitCardBusinessService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<DebitCardBusiness> findById(@PathVariable String id){ return managementDebitCardBusinessService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteSA(@PathVariable String id){
        return managementDebitCardBusinessService.deleteById(id);
    }

    @GetMapping("findByIdBusinessClient/{idBusinessClient}")
    public Flux<DebitCardBusiness> findByIdBusinessClient(@PathVariable String idBusinessClient){ return managementDebitCardBusinessService.findByIdBusinessClient(idBusinessClient); }

    @GetMapping("countByIdBusinessClient/{idBusinessClient}")
    public Mono<Long> countByIdBusinessClient(@PathVariable String idBusinessClient){ return managementDebitCardBusinessService.countByIdBusinessClient(idBusinessClient); }

}
