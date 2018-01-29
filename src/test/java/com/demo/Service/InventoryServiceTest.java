package com.demo.Service;

import com.demo.Model.Inventory;
import com.demo.Repository.InventoryRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by gsati on 1/18/2018.
 */
public class InventoryServiceTest {

    InventoryService inventoryService;

    @Before
     public void setUp(){
        inventoryService=new InventoryService();
     }
    @Test
     public void addInventoryPositiveTest(){
        boolean result=inventoryService.addInventory("Car","0","0");
        Assert.assertTrue(result);

     }
     @Test
     public void addInventoryNegativeTest(){
         boolean result=inventoryService.addInventory(null,null,null);
         Assert.assertFalse(result);
     }

     @Test
     public void updateBuyInventoryPositiveTest(){
         inventoryService.addInventory("aero","12","3");
         boolean result=inventoryService.updateBuyInventory("aero","4");
         Assert.assertTrue(result);

     }
    @Test
    public void updateBuyInventoryNegativeTest(){
        boolean result=inventoryService.updateBuyInventory("bike","4");
        Assert.assertFalse(result);

    }
    @Test
    public void updateSellInventoryPositiveTest(){
        inventoryService.addInventory("laptop","12","3");
        inventoryService.updateBuyInventory("laptop","5");
        boolean result=inventoryService.updateSellInventory("laptop","4");
        Assert.assertTrue(result);

    }
    @Test
    public void updateSellInventoryNegativeTest(){
        boolean result=inventoryService.updateSellInventory("mobile","4");
        Assert.assertFalse(result);

    }
    @Test
    public void updateSellInventoryNoQuantityTest(){
        inventoryService.addInventory("laptop2","12","3");
        boolean result=inventoryService.updateSellInventory("laptop2","3");
        Assert.assertFalse(result);

    }
    @Test
    public void reportTest(){

        inventoryService.addInventory("laptop3","12","3");
        boolean result=inventoryService.report();
        Assert.assertTrue(result);
    }

    @Test
    public void deletePositiveTest(){
        inventoryService.addInventory("mobile2","12","3");
        boolean result=inventoryService.delete("mobile2");
        Assert.assertTrue(result);
    }
    @Test
    public void deleteNegativeTest(){
        boolean result=inventoryService.delete("mobile2");
        Assert.assertFalse(result);
    }



}
