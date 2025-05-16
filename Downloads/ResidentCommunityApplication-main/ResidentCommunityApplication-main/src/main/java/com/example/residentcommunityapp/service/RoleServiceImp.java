//package com.example.residentcommunityapp.service;
//
//import com.example.residentcommunityapp.exception.RoleAlreadyExistException;
//import com.example.residentcommunityapp.exception.UserAlreadyExistsException;
//import com.example.residentcommunityapp.model.Role;
//import com.example.residentcommunityapp.model.User;
//import com.example.residentcommunityapp.repository.RoleRepository;
//import com.example.residentcommunityapp.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class RoleServiceImp implements RoleService{
//    private final RoleRepository roleRepository;
//    private final UserRepository userRepository;
//    @Override
//    public List<Role> getRoles() {
//        return roleRepository.findAll();
//    }
//
//    @Override
//    public Role createRole(Role theRole) {
//        String roleName = "Role_"+theRole.getName().toUpperCase();
//        Role role = new Role(roleName);
//        if(roleRepository.existsByName(roleName)){
//            throw new RoleAlreadyExistException(theRole.getName() + "role already exists ");
//        }
//        return roleRepository.save(role);
//    }
//
//    @Override
//    public void deleteRole(Long id) {
//        this.removeAllUsersFromRole(id);
//        roleRepository.deleteById(id);
//    }
//
//    @Override
//    public Role findByName(String name) {
//        return roleRepository.findByName(name).get();
//    }
//
//    @Override
//    public User removeUserFromRole(Long userId, Long roleId) {
//        Optional<User> user = userRepository.findById(userId);
//        Optional<Role>  role = roleRepository.findById(roleId);
//        if( role.isPresent() && role.get().getUsers().contains(user.get())){
//            role.get().removeUserfromRole(user.get());
//            roleRepository.save(role.get());
//            return user.get();
//        }
//        throw new UsernameNotFoundException("User not found");
//    }
//
//    @Override
//    public User assignRoleToUser(Long userId, Long roleId) {
//        Optional<Role> role = roleRepository.findById(roleId);
//        Optional<User> user = userRepository.findById(userId);
//        if (user.isPresent() && user.get().getRoles().contains(role.get())){
//            throw new UserAlreadyExistsException
//                    (user.get().getPassword() + "is already assigned to role "
//                            + role.get().getName());
//
//        }
//        return user.get();
//    }
//
//    @Override
//    public Role removeAllUsersFromRole(Long roleId) {
//        Optional<Role> role = roleRepository.findById(roleId);
//        role.get().removeAllUserFromRole();
//        return roleRepository.save(role.get());
//    }
//}
