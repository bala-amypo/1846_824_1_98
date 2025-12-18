package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Micro;

public interface MicroRepository extends JpaRepository<Micro, Long> {
}
