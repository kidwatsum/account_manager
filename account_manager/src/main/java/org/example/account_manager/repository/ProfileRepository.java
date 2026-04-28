package org.example.account_manager.repository;

import org.example.account_manager.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository used for interacting with
 * the profile database table
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
