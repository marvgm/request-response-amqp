package com.wittest.api.bff.calculator.interactors;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ServiceGenUuidUseCase {

    public UUID getUuid(){
        return UUID.randomUUID();
    }
}
