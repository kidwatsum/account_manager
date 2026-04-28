package org.example.account_manager.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A Profile DTO class used for interacting
 * with the frontend for the profile
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    @NotNull
    String profileName;

    @NotNull
    String username;

    @NotNull
    String password;

}
