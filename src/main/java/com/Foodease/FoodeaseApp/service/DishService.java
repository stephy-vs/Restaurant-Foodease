package com.Foodease.FoodeaseApp.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface DishService {
    ResponseEntity<String> addNewDish(Map<String,String> requestMap);
}
