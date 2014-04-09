package com.epam.training.jp.jdbc.excercises.dao;

import com.epam.training.jp.jdbc.excercises.domain.Food;


public interface FoodDao {

	Food findFoodByName(String name);
	
	void updateFoodPriceByName(String name, int newPrice);	
	
}
