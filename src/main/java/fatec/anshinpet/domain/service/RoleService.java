package fatec.anshinpet.domain.service;

import fatec.anshinpet.domain.exception.RoleNotFoundException;
import fatec.anshinpet.domain.model.Role;
import fatec.anshinpet.domain.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findRoleByName(Role.Value.USER)
                .orElseThrow(() -> new RoleNotFoundException("USER"));
    }

    public Role getAdminRole() {
        return roleRepository.findRoleByName(Role.Value.ADMIN)
                .orElseThrow(() -> new RoleNotFoundException("ADMIN"));
    }
}
