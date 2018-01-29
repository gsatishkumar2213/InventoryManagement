package com.demo.Repository;

import com.demo.Model.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by gsati on 1/18/2018.
 */
public class InventoryRepoTest {

    InventoryRepo inventoryRepo;
    @Before
    public void setUp(){
        inventoryRepo=new InventoryRepo();
    }

    @Test
    public void addInventoryPositiveTest(){
        boolean result=inventoryRepo.addInventory(new Inventory("potato",3,4,6));
        Assert.assertTrue(result);
    }
    @Test
    public void addInventoryNegativeTest(){
        boolean result=inventoryRepo.addInventory(new Inventory(null,3,4,6));
        Assert.assertFalse(result);
    }
    @Test
    public void updateInventoryValidInventoryTest(){
        inventoryRepo.addInventory(new Inventory("potato1",3,4,6));
        boolean result=inventoryRepo.updateInventory(new Inventory("potato1",4,4,6));
        Assert.assertTrue(result);
    }
    @Test
    public void updateInventoryNullInventoryTest(){
        boolean result=inventoryRepo.updateInventory(null);
        Assert.assertFalse(result);
    }
    @Test
    public void getAllInventoriesTest(){
        inventoryRepo.addInventory(new Inventory("potato2",3,4,6));
        Set<Inventory> inventories=inventoryRepo.getAllInventories();
        Inventory result=null;
        for (Inventory inv : inventories){
            if(inv.getItemName().equals("potato2"))
                result=inv;
        }
        assertEquals("potato2",result.getItemName());
        assertEquals((Double)(double)3,(Double)result.getBuyPrice());
        assertEquals((Double)(double)4,(Double)result.getSellingPrice());
        assertEquals((Integer)6,(Integer)result.getQuantity());
    }
    @Test
    public void getInventoryByNamePositiveTest(){
        inventoryRepo.addInventory(new Inventory("potato3",3,4,6));
        Inventory result=inventoryRepo.getInventoryByName("potato3");
        assertEquals("potato3",result.getItemName());
        assertEquals((Double)(double)3,(Double)result.getBuyPrice());
        assertEquals((Double)(double)4,(Double)result.getSellingPrice());
        assertEquals((Integer)6,(Integer)result.getQuantity());
    }
    @Test
    public void getInventoryByNameNegativeTest(){
        Inventory result=inventoryRepo.getInventoryByName("potato4");
        assertNull(result);
    }

}
