package com.demo;

import com.demo.Utility.CommandUtility;


import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {
        CommandUtility commandUtility = new CommandUtility();
        Scanner console = new Scanner(System.in);
        String command = null;
        System.out.println("Enter Input");
        while (true){
            command = console.nextLine();
            if(command.equals("#"))
                break;
            else {
                commandUtility.processCommand(command);
            }
        }
    }

}
