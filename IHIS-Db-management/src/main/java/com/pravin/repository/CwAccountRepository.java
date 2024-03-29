package com.pravin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.entity.CwAccount;

@Repository
public interface CwAccountRepository extends JpaRepository<CwAccount, Long> {

	Optional<CwAccount> findByEmail(String mail);

	Optional<CwAccount> findByEmailAndPwd(String mail, String pwd);

}
