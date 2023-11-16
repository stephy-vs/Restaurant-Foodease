package com.Foodease.FoodeaseApp.serviceImpl;

import com.Foodease.FoodeaseApp.JWT.JwtFilter;
import com.Foodease.FoodeaseApp.POJO.Category;
import com.Foodease.FoodeaseApp.POJO.Dish;
import com.Foodease.FoodeaseApp.POJO.User;
import com.Foodease.FoodeaseApp.constant.RestaurantConstants;
import com.Foodease.FoodeaseApp.dao.DishDao;
import com.Foodease.FoodeaseApp.service.DishService;
import com.Foodease.FoodeaseApp.utils.RestaurantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    JwtFilter jwtFilter;
    @Autowired
    DishDao dishDao;



    @Override
    public ResponseEntity<String> addNewDish(Map<String, String> requestMap) {
        try {
            if (jwtFilter.isAdmin()){
                if (validateDishMap(requestMap,false)){
                    dishDao.save(getDishFromMap(requestMap,false));
                    return RestaurantUtils.getResponseEntity("Dish Added Successfully",HttpStatus.OK);

                }


            }else {
                return RestaurantUtils.getResponseEntity(RestaurantConstants.Invalid_Data,HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return RestaurantUtils.getResponseEntity(RestaurantConstants.Something_Went_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    private boolean validateDishMap(Map<String, String> requestMap, boolean validateId) {
        if (requestMap.containsKey("name")){
            if (requestMap.containsKey("id") && validateId){
                return true;
            } else if (!validateId) {
                return true;
            }
        }
        return false;
    }

    private Dish getDishFromMap(Map<String, String> requestMap, boolean isAdd) {
        Category category1 = new Category();
        category1.setId(Integer.parseInt(requestMap.get("categ_Id")));

        User user1 = new User();
        user1.setId(Integer.parseInt(requestMap.get("rest_Id")));



        Dish dish = new Dish();
        if (isAdd){
            dish.setId(Integer.parseInt(requestMap.get("id")));
        }else {
            dish.setAvailability("true");
        }
        dish.setCategory(category1);
        dish.setUser(user1);
        dish.setName(requestMap.get("name"));
        dish.setDescription(requestMap.get("description"));
        dish.setPrice(new BigDecimal(requestMap.get("price")));
        dish.setAvailability(requestMap.get("availability"));

        //dish.setImageData(requestMap.get("imageData").getBytes());
        return dish;

    }
}
