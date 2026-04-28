package org.example.account_manager.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A MainUser DTO class that's used
 * for interacting with the frontend for
 * the main user
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainUserDto {
    @Nullable
    private Long  id;

    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String password;
}
