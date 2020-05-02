package com.spiros.core.service;

import com.spiros.common.model.User;
import com.spiros.persistance.repository.UserRepo;
import com.spiros.persistance.transformer.UserTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserTransformer userTransformer;

    @Transactional
    public Optional<User> fetchById(final long id) {
        return userTransformer.fromEntityToTransfer(
                userRepo.findById(id).orElse(null));
    }

    @Transactional
    public Optional<User> fetchByUsername(final String username) {
        return userTransformer.fromEntityToTransfer(
                userRepo.findByUsername(username).orElse(null));
    }

}
