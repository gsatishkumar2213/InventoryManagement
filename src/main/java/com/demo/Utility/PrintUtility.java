package com.demo.Utility;

import com.demo.Model.Inventory;
import com.demo.Model.Report;

import java.util.Set;

/**
 * Created by gsati on 1/17/2018.
 */
public class PrintUtility {

    public void printReport(Set<Inventory> inventories){

        double totalValue=0;
        System.out.println(appendSpaces("")+appendSpaces("INVENTORY REPORT")+appendSpaces("")+appendSpaces("")+appendSpaces(""));
        System.out.println(appendSpaces("Item Name")+appendSpaces("Bought At")+appendSpaces("Sold At")+appendSpaces("AvailableQty")+appendSpaces("Value"));
        System.out.println(appendSpaces("---------")+appendSpaces("---------")+appendSpaces("-------")+appendSpaces("------------")+appendSpaces("-----"));
        for(Inventory inv: inventories) {
            System.out.println(appendSpaces(inv.getItemName()) + appendSpaces(String.valueOf(round(inv.getBuyPrice()))) + appendSpaces(String.valueOf(round(inv.getSellingPrice()))) + appendSpaces(String.valueOf(inv.getQuantity())) + appendSpaces(String.valueOf(round(inv.getBuyPrice() * inv.getQuantity()))));
            totalValue+=inv.getBuyPrice() * inv.getQuantity();
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println(appendSpaces("Total Value")+appendSpaces("")+appendSpaces("")+appendSpaces("")+appendSpaces(String.valueOf(round(totalValue))));
        System.out.println(appendSpaces("Profit since previous report            ")+appendSpaces("")+appendSpaces("")+appendSpaces(String.valueOf(round(Report.profit))));
        System.out.println();
        System.out.println();

    }

    String appendSpaces(String token){

        int lengthOfToken=token.length();
        for(int i=0;i<20-lengthOfToken;i++){
            token+=" ";
        }
        return token;
    }
     double round(double value) {

        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
