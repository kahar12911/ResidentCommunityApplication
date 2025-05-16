//package com.example.residentcommunityapp.controller;
//
//import com.example.residentcommunityapp.exception.RoleAlreadyExistException;
//import com.example.residentcommunityapp.model.Role;
//import com.example.residentcommunityapp.model.User;
//import com.example.residentcommunityapp.service.RoleService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import static org.springframework.http.HttpStatus.FOUND;
//
//public class RoleController {
//    private final RoleService roleService;
//
//    public RoleController(RoleService roleService) {
//        this.roleService = roleService;
//    }
//
//    @GetMapping("/all-roles")
//    public ResponseEntity<List<Role>>  getAllRoles(){
//        return new ResponseEntity<>(roleService.getRoles(), FOUND);
//    }
//
//    @PostMapping("/create-new-role")
//    public ResponseEntity<String> createRole(@RequestBody Role theRole){
//        try{
//            roleService.createRole(theRole);
//            return  ResponseEntity.ok("Role created");
//
//        }catch (RoleAlreadyExistException e){
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body(e.getMessage());
//
//        }
//
//    }
//
//    @DeleteMapping("/delete/{roleId}")
//    public void deleteRole( @PathVariable("roleId") Long roleId){
//        roleService.deleteRole(roleId);
//    }
//
//    @PostMapping("/remove-all-users-from-role/{roleId}")
//    public Role removeAllUsersFromRole(@PathVariable Long roleId){
//        return roleService.removeAllUsersFromRole(roleId);
//    }
//
//
//    @PostMapping("/remove-user-from-role")
//    public User removeUserFromRole(@RequestParam("userId") Long userId,
//                                   @RequestParam("roleId") Long roleId){
//        return roleService.removeUserFromRole(userId, roleId);
//
//    }
//
//    @PostMapping("assign-user-to-role")
//    public User assignUserToRole(@RequestParam("userId") Long userId,
//                                 @RequestParam("roleId") Long roleId){
//        return roleService.assignRoleToUser(userId, roleId);
//
//    }
//
//
//
//}
