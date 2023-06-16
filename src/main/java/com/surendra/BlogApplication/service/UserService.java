package com.surendra.BlogApplication.service;

import com.surendra.BlogApplication.dto.UserDto;
import com.surendra.BlogApplication.model.User;
import com.surendra.BlogApplication.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(UserDto userDto) throws Exception {
        if (emailExists(userDto.getEmail())) {
            throw new RuntimeException();
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userInfoRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userInfoRepository.findByEmail(email).isPresent();
    }
}
