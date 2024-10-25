package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * creates a new city
     * checks that new city is not in the list
     * adds it to the list
     * checks that new city is in list
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Red Deer", "AB");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * creates mock city
     * adds mock city to list
     * check that it exists in the list
     * delete the city
     * check that it does not exist in the list anymore
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Medicine Hat", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
    }

    /**
     * checks that list starts empty
     * adds city to list
     * checks that list size is 1
     * store a new city and create a pointer to it (variable) and add it to the list
     * check that new list size is 2
     * delete city pointed by variable
     * check that new list size is 1
     */
    @Test
    public void getCountTest() {
        list = MockCityList();
        assertEquals(0, list.getCount());
        list.addCity(new City("Ottawa", "ON"));
        assertEquals(1, list.getCount());
        City city = new City("Vancouver", "BC");
        list.addCity(city);
        assertEquals(2, list.getCount());
        list.deleteCity(city);
        assertEquals(1, list.getCount());
    }

}
