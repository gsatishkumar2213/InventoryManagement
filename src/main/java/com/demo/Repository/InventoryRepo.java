package com.demo.Repository;

import com.demo.Model.Inventory;
import com.demo.Model.Report;

import java.util.*;

/**
 * Created by gsati on 1/17/2018.
 */
public class InventoryRepo {

    private static Set<Inventory> inventories=new TreeSet<Inventory>();
    // create a inventory
    public boolean addInventory(Inventory inv){

        if(inv == null || inv.getItemName()==null)
            return false;
        else {
            inventories.add(inv);
            return true;
        }
    }
    //update a inventory
    public boolean updateInventory(Inventory inv){

        if(!delete(inv))
            return false;
        if(!addInventory(inv))
            return false;
        return true;
    }
    public boolean delete(Inventory inv){

        if(inv == null)
            return false;
        else {
            inventories.remove(inv);
            return true;
        }

    }

    public Set<Inventory> getAllInventories(){
        return inventories;
    }
    public Inventory getInventoryByName(String itemName){

        for(Inventory inv : inventories){
            if(inv.getItemName().equals(itemName))
                return inv;
        }
        return null;
    }

}
