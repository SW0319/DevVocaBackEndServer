package com.DevVoca.backendServer.Model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Voca_List")
public class VocaList {

    @Id
    @GeneratedValue
    int v_no;

    @Column(nullable = false)
    String vocaname;
    @Column(nullable = false)

    String howtoRead; //발음기호
    @Column(nullable = false)
    String translate;
    @Column(nullable = false)
    String example;
    @Column(nullable = false)
    String exampleTranslate;
    @Column(nullable = false)
    int dev_type;



}
