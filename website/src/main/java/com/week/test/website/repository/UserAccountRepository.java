package com.week.test.website.repository;

import com.week.test.website.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {
}
