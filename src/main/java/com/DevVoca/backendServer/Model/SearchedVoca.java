package com.DevVoca.backendServer.Model;


import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
public class SearchedVoca {

    @Id @GeneratedValue
    int no;

    @JoinColumn(name = "vocaNo")
    @ManyToOne
    VocaList vocaList;

    @CreationTimestamp
    LocalDateTime createTime;

}
