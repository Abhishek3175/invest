package org.example;

import org.example.requestread.Jsonreader;
import org.example.requestread.template.Customer;
import org.example.requestread.template.Root;
import org.example.requestread.template.Security;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");


        Jsonreader jr=new Jsonreader();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("Request.json");
        String result = new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));
        List<Root> rootList= jr.generateJsonFromText(result);

        for (Root root : rootList) {
            Customer customer = root.getCustomer();
            System.out.println("Customer Name: " + customer.getName());

            for (Security security : customer.getSecurity()) {
                System.out.println("Security Name: " + security.getSname());
                System.out.println("Quantity: " + security.getQuantity());
                System.out.println("Price: " + security.getPrice());
                System.out.println("Order: " + security.getOrder());
                System.out.println("Date: " + security.getDate());
            }
        }

    }
}