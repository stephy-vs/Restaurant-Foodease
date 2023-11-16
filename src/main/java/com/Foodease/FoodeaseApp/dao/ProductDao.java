package com.Foodease.FoodeaseApp.dao;

import com.Foodease.FoodeaseApp.POJO.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
