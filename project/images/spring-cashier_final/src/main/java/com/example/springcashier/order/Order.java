package com.example.springcashier.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public
class Order {

    private String drink;
    private String milk;
    private String size;
    private String total;
    private String register;
    private String status;


    private static String[] DRINK_OPTIONS = {"Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino"};
    private static String[] MILK_OPTIONS = {"Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk"};
    private static String[] SIZE_OPTIONS = {"Tall", "Grande", "Venti"};
    private static Double[] Latte = {2.95, 3.65, 3.95};
    private static Double[] Americano = {2.25, 2.65, 2.95};
    private static Double[] Mocha = {3.45, 4.15, 4.45};
    private static Double[] Cappuccino = {2.95, 3.65, 3.95};
    private static Double[] Espresso = {1.75, 1.95};


    public static String generateOrder(String drink, String milk, String size) {
        return drink + "," + milk + "," + size;
    }

    public static double getPrice(String name) {
        double price = 0.00;
        String[] words = name.split(",");
        if (words[0].equals("Caffe Latte")) {
            if (words[2].equals("Tall")) {
                price = Latte[0];
            } else if (words[2].equals("Grande")) {
                price = Latte[1];
            } else {
                price = Latte[2];
            }
        }

        if (words[0].equals("Caffe Americano")) {
            if (words[2].equals("Tall")) {
                price = Americano[0];
            } else if (words[2].equals("Grande")) {
                price = Americano[1];
            } else {
                price = Americano[2];
            }
        }

        if (words[0].equals("Caffe Mocha")) {
            if (words[2].equals("Tall")) {
                price = Mocha[0];
            } else if (words[2].equals("Grande")) {
                price = Mocha[1];
            } else {
                price = Mocha[2];
            }
        }
        if (words[0].equals("Espresso")) {
            if (words[2].equals("Tall")) {
                price = Espresso[0];
            } else if (words[2].equals("Grande")) {
                price = Espresso[1];
            }

        }
        if (words[0].equals("Cappuccino")) {
            if (words[2].equals("Tall")) {
                price = Cappuccino[0];
            } else if (words[2].equals("Grande")) {
                price = Cappuccino[1];
            } else {
                price = Cappuccino[2];
            }
        }
        price = addTax(price);

        return price;
    }


    public static double addTax(double price) {
        double tax = 0.0725;
        double total = price + (price * tax);
        double scale = Math.pow(10, 2);
        double rounded = Math.round(total * scale) / scale;

        return rounded;
    }

    public static Order GetNewOrder(String drink, String milk, String size) {
        String orderGen = generateOrder(drink, milk, size);
        String[] orderInfo = orderGen.split(",");
        String price = Double.toString(getPrice(orderGen));
        Order o = new Order();
        o.drink = orderInfo[0];
        o.milk = orderInfo[1];
        o.size = orderInfo[2];
        o.status = "Ready for Payment";
        o.total = price;
//
//    	o.drink = "Caffe Americano" ;
//    	o.milk = "Soy Milk" ;
//    	o.size = "Venti" ;
//    	o.status = "Ready for Payment" ;
//    	o.total = "$3.16" ;

    	return o ;
    }

}


//}


/*

https://priceqube.com/menu-prices/%E2%98%95-starbucks

var DRINK_OPTIONS = [ "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" ];
var MILK_OPTIONS  = [ "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" ];
var SIZE_OPTIONS  = [ "Short", "Tall", "Grande", "Venti", "Your Own Cup" ];

Caffè Latte
=============
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Caffè Americano
===============
tall 	$2.25
grande 	$2.65
venti 	$2.95 (Your Own Cup)

Caffè Mocha
=============
tall 	$3.45
grande 	$4.15
venti 	$4.45 (Your Own Cup)

Cappuccino
==========
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Espresso
========
short 	$1.75
tall 	$1.95

 */



