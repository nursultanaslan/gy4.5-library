package com.example.library.service;

import com.example.library.dto.user.request.UpdateUserRequest;
import com.example.library.dto.user.response.DeletedUserResponse;
import com.example.library.dto.user.response.UpdatedUserResponse;
import com.example.library.dto.user.response.UserListResponse;
import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import com.example.library.rules.UserBusinessRules;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class UserService {

    private final UserRepository userRepository;
    private final UserBusinessRules userBusinessRules;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       UserBusinessRules userBusinessRules,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userBusinessRules = userBusinessRules;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserListResponse> getList(){
        List<User> users = userRepository.findAll();
        List<UserListResponse> responseList = new ArrayList<>();
        for (User user: users){
            UserListResponse response = new UserListResponse();
            response.setId(user.getId());
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setUsername(user.getUsername());
            response.setEmail(user.getEmail());
            response.setPhone(user.getPhone());
            responseList.add(response);
        }
        return responseList;
    }


    /**
     * kayıtlı username'lerden biri olamaz
     * email de aynı sekilde veritabanında bulunmayan bir username olacak
     * phone da aynı şekilde
     * kullanıcı membershipLevelini ve memberStatusunu değiştiremez
     * password alanı güncelledikten sonra şifrem hashlenmiş olmalı
     */
    public UpdatedUserResponse update(@Valid UpdateUserRequest request){
        User user = userBusinessRules.userShouldExistWithGivenId(request.getId());
        userBusinessRules.usernameMustBeUnique(request.getUsername());
        userBusinessRules.emailShouldBeUnique(request.getEmail());
        userBusinessRules.phoneMustBeUnique(request.getPhone());

        user.setId(request.getId());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        userRepository.save(user);

        return new UpdatedUserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone()
        );
    }

    public DeletedUserResponse delete(int id){
        User user = userBusinessRules.userShouldExistWithGivenId(id);
        userRepository.delete(user);

        return new DeletedUserResponse(
                user.getId()
        );
    }
}
