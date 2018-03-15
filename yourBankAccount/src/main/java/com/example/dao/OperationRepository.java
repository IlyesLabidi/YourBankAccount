package com.example.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
	@Query(value="SELECT o FROM Operation o WHERE o.compte.codeCompte=:x ORDER BY o.dateOperation DESC")
	public Page<Operation> listOpertation(@Param("x")String codeCpte, Pageable pageable );

}
