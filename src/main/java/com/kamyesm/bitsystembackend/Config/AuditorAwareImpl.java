package com.kamyesm.bitsystembackend.Config;

import com.kamyesm.bitsystembackend.Entity.Auth.Staff;
import com.kamyesm.bitsystembackend.Repo.StaffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AuditorAwareImpl implements AuditorAware<Staff> {

    private final StaffRepo repo;

    @Override
    public Optional<Staff> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.empty();
        }

        String username = authentication.getName();

        return repo.findByUserName(username);
    }
}
