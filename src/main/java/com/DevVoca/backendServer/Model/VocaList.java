package com.DevVoca.backendServer.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class VocaList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int v_no;
    String vocaname;
    String howtoRead; //발음기호
    String translate;
    String example;
    String exampleTranslate;
    int dev_type;



}
