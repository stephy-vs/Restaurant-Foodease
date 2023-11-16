package com.Foodease.FoodeaseApp.restImpl;

import com.Foodease.FoodeaseApp.constant.RestaurantConstants;
import com.Foodease.FoodeaseApp.rest.DishRest;
import com.Foodease.FoodeaseApp.service.DishService;
import com.Foodease.FoodeaseApp.utils.RestaurantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DishRestImpl implements DishRest {
    @Autowired
    DishService dishService;
    @Override
    public ResponseEntity<String> addNewDish(Map<String, String> requestMap) {
        try {
            return dishService.addNewDish(requestMap);

        }catch (Exception e){
            e.printStackTrace();
        }
        return RestaurantUtils.getResponseEntity(RestaurantConstants.Something_Went_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
