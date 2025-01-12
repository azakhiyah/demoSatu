package com.demoSatu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoSatu.model.Member;

public interface MemberDao extends JpaRepository<Member, String> {
    
}
