package com.Foodease.FoodeaseApp.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CategoryService {
    ResponseEntity<String> addNewCategory(Map<String,String> requestMap);
}