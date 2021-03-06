package com.company.application.service.impl;

import com.company.application.co.RegistrationDetailsCO;
import com.company.application.entity.UserDetail;
import com.company.application.repository.UserRepository;
import com.company.application.service.RegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerNewUser(RegistrationDetailsCO registrationDetailsCO) {
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(registrationDetailsCO, userDetail);
        userDetail.setPassword(passwordEncoder.encode(userDetail.getPassword()));
        userRepository.save(userDetail);
    }
}
