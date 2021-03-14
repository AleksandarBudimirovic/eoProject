package com.app.eoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {

}
