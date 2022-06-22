package com.nttdata.bc19.msmanagementdebitcard.request;

import com.nttdata.bc19.msmanagementdebitcard.model.Account;
import lombok.Data;

import java.util.List;

@Data
public class DebitCardBusinessRequest {
    private String debitCardNumber;
    private String idBusinessClient;
    private List<Account> accounts;
}
