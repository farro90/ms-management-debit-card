package com.nttdata.bc19.msmanagementdebitcard.request;

import com.nttdata.bc19.msmanagementdebitcard.model.Account;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DebitCardPersonRequest {
    private String debitCardNumber;
    private String idPersonClient;
    private List<Account> accounts;
}
