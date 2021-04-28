package com.test.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.soap.model.AffectationProduit;
import com.test.soap.model.AffectationProduitId;

public interface AssociateRepository extends JpaRepository<AffectationProduit, AffectationProduitId> {

}
