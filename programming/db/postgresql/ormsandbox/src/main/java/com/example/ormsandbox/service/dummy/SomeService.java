package com.example.ormsandbox.service.dummy;


import org.springframework.stereotype.Service;

@Service
public class SomeService implements ISomeService {

    public SomeService(){}
    @Override
    public int protectedService() {
        return 100;
    }
}
