package com.example.demo.Repository;

import com.example.demo.Entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {

}
