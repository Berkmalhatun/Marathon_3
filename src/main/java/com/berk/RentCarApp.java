package com.berk;

import com.berk.controller.AracController;
import com.berk.controller.KiralamaController;
import com.berk.controller.KisiController;

import java.util.Scanner;

public class RentCarApp {
    public static void main(String[] args) {
        int secim;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("****************************************************");
            System.out.println("*******    ARAC KIRALAMA UYGULAMASI          *******");
            System.out.println("****************************************************");
            System.out.println();
            System.out.println("1- Arac Ekleme");
            System.out.println("2- Arac Arama");
            System.out.println("3- Kisi Ekleme");
            System.out.println("4- Kiralama");
            System.out.println("5- Rapor");
            System.out.print("Seçiniz....: ");
            secim = scanner.nextInt();
            switch (secim){
                case 1: new AracController().register(); break;
                case 2: new AracController().findByAracMarka(); break;
                case 3: new KisiController().registerKisi();break;
                case 4: new KiralamaController().kirala();break;
                case 5 : new KiralamaController().reportPage();break;
            }
        }while (secim!=0);
        System.out.println("TEKRAR GÖRÜSMEK ÜZERE");

    }
}