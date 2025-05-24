package com.example.residentcommunityapp.service;

import com.example.residentcommunityapp.model.Role;
import com.example.residentcommunityapp.model.RoleType;
import com.example.residentcommunityapp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRoleByName(RoleType roleType) {
        return roleRepository.findByName(roleType)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleType));
    }

    public Set<Role> getDefaultUserRoles() {
        return Set.of(getRoleByName(RoleType.ROLE_USER));
    }

    public Set<Role> getAdminRoles() {
        return Set.of(getRoleByName(RoleType.ROLE_ADMIN));
    }
}
