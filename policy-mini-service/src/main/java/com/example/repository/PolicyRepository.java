package com.example.repository;

import com.example.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Long> {

    Policy findByPolicyId(Long policyId);

    Policy findByStatus(String status);

}
