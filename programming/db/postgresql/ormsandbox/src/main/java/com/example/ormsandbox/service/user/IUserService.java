package com.example.ormsandbox.service.user;

import com.example.ormsandbox.common.HTTPException;
import com.example.ormsandbox.common.RegistrationForm;
import org.springframework.stereotype.Service;


public interface IUserService {

    boolean createUser(RegistrationForm form) throws HTTPException;
}
