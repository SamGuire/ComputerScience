package com.example.ormsandbox.repository;

import com.example.ormsandbox.Entity.Root;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRootRepository  extends JpaRepository<Root,Integer> {
    Root findRootById(int id);
}
