package com.test.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.soap.model.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
}
