package org.example.account_manager.repository;

import org.example.account_manager.model.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface used for interacting with
 * the main user database table
 */
@Repository
public interface MainUserRepository extends JpaRepository<MainUser, Long> {
}
