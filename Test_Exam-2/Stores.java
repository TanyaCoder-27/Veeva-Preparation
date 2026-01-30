package Stores;

import java.util.*;

public class Stores
{
    static Scanner sc = new Scanner(System.in);

    // storeId: (product: price)
    static HashMap<String, HashMap<String, Integer>> storeData = new HashMap<>();

    public static void main(String[] args)
    {
        int ch =0;

        while (ch!= 5)
        {
            System.out.println("MENU:");
            System.out.println("1.enter details");
            System.out.println("2.display products");
            System.out.println("3.highest price produc");
            System.out.println("4.findin stores containing product");
            System.out.println("5. exit");
            System.out.print("Enter choice:");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1:enterData();break;
                case 2:displayData();break;
                case 3:highestPriceProd();break;
                case 4:findStoresByProd();break;
                case 5:System.out.println("exit!");break;
                default:System.out.println("invalid");
            }
        }
    }

    // 1 -- entering data
    static void enterData()
    {
        System.out.print("enter store id:");
        String stId = sc.next();

        HashMap<String, Integer> prodMap;
        if (storeData.containsKey(stId))
        {
            prodMap = storeData.get(stId);   
            System.out.println("store exists");
        }
        else
        {
            prodMap = new HashMap<>();
            System.out.println("new store created");
        }

        System.out.print("enter no of prodcts:");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++)
        {
            System.out.print("enter prodcut name:");
            String prodName = sc.next();

            System.out.print("enter price:");
            int price = sc.nextInt();

            prodMap.put(prodName, price);
        }

        storeData.put(stId, prodMap);   
        System.out.println("detaisl entered successfuly");
    }

    // 2 -- displays all details
    static void displayData()
    {
        System.out.print("enter store id:");
        String stId = sc.next();

        if (storeData.containsKey(stId))
        {
            HashMap<String, Integer> prods = storeData.get(stId);

            System.out.println("products:");
            for (String prod : prods.keySet())
            {
                System.out.println(prod +":"+ prods.get(prod)); 
            }
        }
        else
        {
            System.out.println("not found");
        }
    }

    // 3 -- highest price produt
    static void highestPriceProd()
    {
        System.out.print("Enter store id: ");
        String stId = sc.next();

        if (storeData.containsKey(stId))
        {
            HashMap<String,Integer> prods = storeData.get(stId);

            String res = "";
            int highest_price = 0;

            for (String prod : prods.keySet())
            {
                int price = prods.get(prod);

                if (price > highest_price)
                {
                    highest_price = price;
                    res = prod;
                }
            }

            System.out.println("highest proce product:" + res);
        }
        else
        {
            System.out.println("not found");
        }
    }

    // 4 -- finding stores by prod
    static void findStoresByProd()
    {
        System.out.print("enter product:");
        String prod = sc.next();

        boolean found = false;

        System.out.println("stores:");
        for (String stId : storeData.keySet())
        {
            HashMap<String, Integer> prods = storeData.get(stId);
            if (prods.containsKey(prod))
            {
                System.out.println(stId);
                found = true;
            }
        }
        if (!found)
        {
           System.out.println("not found");
        }
    }
}

