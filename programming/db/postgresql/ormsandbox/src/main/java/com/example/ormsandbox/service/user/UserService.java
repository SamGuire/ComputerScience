package com.example.ormsandbox.service.user;


import com.example.ormsandbox.Entity.User;
import com.example.ormsandbox.common.HTTPException;
import com.example.ormsandbox.common.RegistrationForm;
import com.example.ormsandbox.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService  implements IUserService{

    @Autowired
    IUserRepository repository;

    @Autowired
    BCryptPasswordEncoder encoder;

    public UserService(){}
    @Override
    public boolean createUser(RegistrationForm form) throws HTTPException{
        if (repository.existsByEmail(form.getEmail())) {
            throw  new HTTPException(404,"User already exists");
        } else if (!form.getPassword().equals(form.getRetypePassword())) {
            throw new HTTPException(404, "Password not the same as retyped");
        } else {
            User newUser =new User();

            newUser.setUser_id(UUID.randomUUID());

            String hashedPassword = encoder.encode(form.getPassword());
            newUser.setHashed_password(hashedPassword);

            newUser.setEmail(form.getEmail());

            repository.save(newUser);
            return true;
        }
    }
}
