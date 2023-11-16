package com.Foodease.FoodeaseApp.dao;

import com.Foodease.FoodeaseApp.POJO.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishDao extends JpaRepository<Dish,Integer> {
}
