package com.tyandrerboldt.authbase.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyandrerboldt.authbase.domain.models.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
