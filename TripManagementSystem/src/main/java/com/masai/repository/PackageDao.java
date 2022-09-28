package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Package;

public interface PackageDao extends JpaRepository<Package, Integer> {

}
