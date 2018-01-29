package com.demo.Service;

import com.demo.Model.Inventory;
import com.demo.Model.Report;
import com.demo.Repository.InventoryRepo;
import com.demo.Utility.PrintUtility;

import java.util.Set;

/**
 * Created by gsati on 1/17/2018.
 */
public class InventoryService {
    InventoryRepo repo=new InventoryRepo();
    PrintUtility printUtility=new PrintUtility();

    public boolean addInventory(String itemName, String sellingPrice, String buyPrice) {

        return repo.addInventory(new Inventory(itemName,convertToDouble(sellingPrice),convertToDouble(buyPrice),0));
    }

    public boolean updateBuyInventory(String itemName, String boughtQuantity) {

        Inventory inv= repo.getInventoryByName(itemName);
        int quantity=convertToInt(boughtQuantity);
        if(inv==null)
            return false;
        else {
            quantity += inv.getQuantity();
            inv.setQuantity(quantity);
            repo.updateInventory(inv);
            return true;
        }
    }

    public boolean updateSellInventory(String itemName, String soldQuantity){

        Inventory inv =repo.getInventoryByName(itemName);
        int quantity=convertToInt(soldQuantity);
        //update profit
        if(inv == null)
            return false;
        else {
            quantity = inv.getQuantity() - quantity;
            if(quantity<0){
                return false;
            }
            else {
                Report.profit += (inv.getSellingPrice() - inv.getBuyPrice()) * (inv.getQuantity()-quantity);
                inv.setQuantity(quantity);
                repo.updateInventory(inv);
                return true;
            }
        }
    }

    public boolean updateSellPriceInventory(String itemName, String newSellPrice) {
        Inventory inv =repo.getInventoryByName(itemName);
        double sellPrice = convertToDouble(newSellPrice);
        if(inv==null)
            return false;
        else
            inv.setSellingPrice(sellPrice);
            repo.updateInventory(inv);
        return true;
    }

    private double convertToDouble(String num){
        double d=0;
        if(num!=null) {
            d = Double.parseDouble(num);
        }
        return d;
    }

    public boolean report() {

        //print inventory
        Set<Inventory> inventories=repo.getAllInventories();
        printUtility.printReport(inventories);
        //reset profit
        Report.profit = 0;
        return true;
    }

    public boolean delete(String itemName) {
        Inventory inv = repo.getInventoryByName(itemName);
        if(inv==null)
            return false;
        else {
            //update profit
            Report.profit -= inv.getBuyPrice() * inv.getQuantity();
            repo.delete(inv);
            return true;
        }
    }
    private int convertToInt(String num){
        int i=0;
        try {
            i= Integer.parseInt(num);
        }catch(NumberFormatException e){
            System.out.println("Invalid number format");
        }
        return i;
    }


}
