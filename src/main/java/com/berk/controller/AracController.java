package com.berk.controller;

import com.berk.repository.entity.Arac;
import com.berk.service.AracService;

import java.util.Scanner;

public class AracController {

    private Scanner scanner;
    private AracService aracService;

    public AracController() {
        this.aracService = new AracService();

    }
    private Long bilgi(){
        this.scanner = new Scanner(System.in);
        return scanner.nextLong();
    }
    private int secim(){
        this.scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    private String ifade(){
        this.scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void register() {
        System.out.println("*******************");
        System.out.println("Arac Olusturma Ekrani");
        System.out.println();
        System.out.println("Arac markasi.......: ");
        String marka = ifade();
        System.out.println("Arac modeli........: ");
        String model = ifade();
        System.out.println("Arac hasar kaydi...: ");
        String hasarkaydi=ifade();
        System.out.println("Arac kac km'de.....: ");
        int kmbilgisi=secim();
        Arac arac = Arac.builder().marka(marka).model(model).hasarKaydi(hasarkaydi)
                .km(kmbilgisi).kiralikmi(false).build();
            aracService.save(arac);
            System.out.println("Arac basarıyla eklendi");
    }

    public void findByAracMarka() {
        System.out.println("******************");
        System.out.println("ARAC ARAMA EKRANI");
        System.out.println();
        System.out.println("Aradiginiz aracin markasini yaziniz..: ");
        String marka = ifade();
        aracService.findByAracMarka(marka);
    }
}
