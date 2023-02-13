package com.berk.controller;

import com.berk.repository.entity.Arac;
import com.berk.repository.entity.ECinsiyet;
import com.berk.repository.entity.Kisi;
import com.berk.service.KisiService;

import java.util.Scanner;

public class KisiController {
private Scanner scanner;
private KisiService kisiService;

    public KisiController() {
        this.kisiService= new KisiService();
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

    public void registerKisi() {
        System.out.println("************************");
        System.out.println("   Kisi Ekleme Ekrani   ");
        System.out.println();
        System.out.println("Kisinin Adi...........: ");
        String ad = ifade();
        System.out.println("Kisinin Soyadi........: ");
        String soyad = ifade();
        System.out.println("Kisinin Yasi..........: ");
        int yas=secim();
        System.out.println("Kisinin Cinsiyeti.....: ");
        String cinsiyet = ifade();
        Kisi kisi = Kisi.builder().ad(ad).soyad(soyad)
                .yas(yas).cinsiyet(ECinsiyet.valueOf(cinsiyet.trim().toUpperCase())).build();
        kisiService.save(kisi);
        System.out.println("Kisi basariyla eklendi.");
    }
}
