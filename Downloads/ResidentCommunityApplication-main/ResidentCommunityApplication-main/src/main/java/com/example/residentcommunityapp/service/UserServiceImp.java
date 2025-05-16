//package com.example.residentcommunityapp.service;
//
//import com.example.residentcommunityapp.exception.UserAlreadyExistsException;
//import com.example.residentcommunityapp.model.Role;
//import com.example.residentcommunityapp.model.User;
//import com.example.residentcommunityapp.repository.RoleRepository;
//import com.example.residentcommunityapp.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImp implements UserService {
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    @Override
//    public User registerUser(User user) {
//        if(userRepository.existsByEmail(user.getEmail())){
//            throw  new UserAlreadyExistsException(user.getEmail() +
//                    "already exists");
//        }
//        //user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setPassword(user.getPassword());
//        Role userRole = roleRepository.findByName("ROLE_USER").get();
//        user.setRoles(Collections.singletonList(userRole));
//
//        return userRepository.save(user);
//    }
//
//    @Override
//    public List<User> getUsers() {
//        return null;
//    }
//
//    @Override
//    public void deleteUser(String email) {
//
//    }
//
//    @Override
//    public User getUser(String email) {
//        return null;
//    }
//}
