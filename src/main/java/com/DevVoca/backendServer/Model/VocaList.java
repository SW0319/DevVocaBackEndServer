package com.DevVoca.backendServer.Model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class VocaList {

    @Id
    int v_no;

    @Column(nullable = true)
    String vocaname;
    @Column(nullable = true)

    String howtoRead; //발음기호
    @Column(nullable = true)
    String translate;
    @Column(nullable = true)
    String example;
    @Column(nullable = true)
    String exampleTranslate;
    @Column(nullable = true)
    int dev_type;



}
