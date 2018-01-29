package com.demo.Utility;

import com.demo.Model.Inventory;
import com.demo.Repository.InventoryRepo;
import com.demo.Service.InventoryService;

import java.util.List;

/**
 * Created by gsati on 1/17/2018.
 */
public class CommandUtility {
    public void processCommand(String command) {
        InventoryService inventoryService=new InventoryService();
        String[] tokens = command.split(" ");
        tokens[0]=tokens[0].toLowerCase();
        if(tokens[0].equals("create")){
            if(tokens.length==4) {
                if (!inventoryService.addInventory(tokens[1], tokens[2], tokens[3])) {
                    System.out.println("Creating inventory failed");
                }
            }
            else
                System.out.println("Creating inventory failed");
        }
        else if(tokens[0].equals("delete")){
            if(tokens.length==2) {
                if(!inventoryService.delete(tokens[1]))
                    System.out.println("Deleteing inventory failed");
            }
            else
                System.out.println("Deleteing inventory failed");
        }
        else if(tokens[0].equals("updatebuy")){
            if(tokens.length==3) {
                if(!inventoryService.updateBuyInventory(tokens[1],tokens[2]))
                    System.out.println("Upadatebuy inventory failed");
            }
            else
                System.out.println("updatebuy inventory failed");
        }
        else if(tokens[0].equals("updatesell")){
            if(tokens.length==3) {
                if(!inventoryService.updateSellInventory(tokens[1],tokens[2]))
                    System.out.println("Upadatesell inventory failed");
            }
            else
                System.out.println("updatesell inventory failed");
        }
        else if(tokens[0].equals("updatesellprice")){
            if(tokens.length==3){
                if(!inventoryService.updateSellPriceInventory(tokens[1],tokens[2]))
                    System.out.println("UpdatedSellPrice inventory failed");
            }
            else
                System.out.println("updatesellprice inventory failed");
        }
        else if(tokens[0].equals("report")){
            if(!inventoryService.report())
                System.out.println("Report Printing failed");

        }
        else{
            System.out.println("invalid command");
        }
    }

}
