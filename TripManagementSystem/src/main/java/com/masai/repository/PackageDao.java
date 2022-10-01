package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Packages;

public interface PackageDao extends JpaRepository<Packages, Integer> {

}
