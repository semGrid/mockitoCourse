package com.griddynamics.banksinfo.repositories;

import com.griddynamics.banksinfo.domain.BankInformation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanksInformationRepository extends JpaRepository<BankInformation, String> {
}
