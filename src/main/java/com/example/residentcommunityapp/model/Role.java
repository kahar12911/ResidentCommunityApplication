//package com.example.residentcommunityapp.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//
//@Entity
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
//
//    @ManyToMany
//    private Collection<User> users = new HashSet<>();
//
//    public Role(String roleName) {
//    }
//
//    public void assiignRoleToUser(User user){
//        user.getRoles().add(this);
//        this.getUsers().add(user);
//    }
//
//    public void removeUserfromRole(User user){
//        user.getRoles().remove(this);
//        this.getUsers().remove(user);
//    }
//
//    public void removeAllUserFromRole(){
//        if( this.getUsers() != null){
//            List<User> roleUsers = this.getUsers().stream().toList();
//            roleUsers.forEach(this::removeUserfromRole);
//        }
//    }
//}
