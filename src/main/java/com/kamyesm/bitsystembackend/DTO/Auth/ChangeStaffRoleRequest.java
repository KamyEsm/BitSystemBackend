package com.kamyesm.bitsystembackend.DTO.Auth;

import jakarta.validation.constraints.NotBlank;

public class ChangeStaffRoleRequest {

    @NotBlank
    private String newRoleName;

    @NotBlank
    private String username;
}
