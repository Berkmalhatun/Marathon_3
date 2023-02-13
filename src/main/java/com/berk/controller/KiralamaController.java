package com.berk.controller;


import com.berk.repository.entity.Arac;
import com.berk.repository.entity.Kiralama;
import com.berk.repository.entity.Kisi;
import com.berk.service.AracService;
import com.berk.service.KiralamaService;
import com.berk.service.KisiService;

import java.util.List;
import java.util.Scanner;

public class KiralamaController {

    private Scanner scanner;
    Arac arac;
    Kisi kisi;
    private KiralamaService kiralamaService;
    private KisiService kisiService;
    private AracService aracService;

    public KiralamaController() {
        this.kiralamaService= new KiralamaService();
        this.kisiService=new KisiService();
        this.aracService=new AracService();
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
    public void kirala() {
        System.out.println("Kisi id'sini giriniz.: ");
        long kisiid=secim();
        if (!kisiService.existById(kisiid)){
            System.out.println("Girdiginiz id de kisi bulunmamaktadir.");
        }else {
            System.out.println("Arac id'sini giriniz..: ");
            long aracid=secim();
            if(!aracService.existById(aracid)){
                System.out.println("Girdiginiz id de arac bulunmamaktadir. ");
            }else {
                kiralamaService.save(Kiralama.builder().aracid(aracid).
                        kisiid(kisiid).build());
                aracService.findById(aracid).get().setKiralikmi(true);
                System.out.println("Kiralama islemi gerceklesmistir.");
            }
        }
    }
    public void reportPage(){
        System.out.println("****************************");
        System.out.println("****     Report Page       ***");
        System.out.println("****************************");
        int secim;
        do{
            System.out.println("");
            System.out.println("1- Su an kirada olan araclar");
            System.out.println("2- Bosta olan araclar");
            System.out.println("3- Herhangi musterinin kiraladigi araclar");
            System.out.println("0- <<< Geri Dön");
            System.out.println("Seçiniz......: ");
            secim = secim();
            switch (secim){
                case 1:  forRentNow();break;
                case 2:  availableRentCar();break;
                case 3: forRentedCar();break;
            }
        }while(secim!=0);
    }
    public List<Kiralama> forRentNow(){
        List<Kiralama> result = kiralamaService.findAll();
        result.forEach(x->{
            System.out.println(x.getAracid()+"id ye sahip arac"+
                    " --> "+x.getKisiid()+" ye sahip kisi tarafindan kiralanmistir.");
        });
        return result;
    }
    public void forRentedCar(){
        System.out.println("Kiralayan kisinin id'sini giriniz.: ");
        long kisiid=secim();
        List<Kiralama> kiralayanKisi = kiralamaService.forRentedCar(kisiid);
        for (Kiralama kira : kiralayanKisi){
            System.out.println(kira.getAracid());
        }
    }
    public void availableRentCar(){
        System.out.println("Bosta olan arac listesi...: ");
        aracService.findAll().forEach(x->{
            if(!x.isKiralikmi()){
                System.out.println(x.getId()+" --> "+x.getMarka()+" --> "+x.getModel());
            }
        });
    }
}
