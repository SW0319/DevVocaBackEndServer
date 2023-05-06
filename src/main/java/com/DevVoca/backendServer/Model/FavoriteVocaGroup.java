package com.DevVoca.backendServer.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Getter
@Setter
public class FavoriteVocaGroup {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int group_No;

    @JoinColumn(name = "userInfo") //foreign key
    @ManyToOne  //FavoriteVocaGroup 은 많고, userinfo는 하나.
    private UserInfo userInfo;


    @Column(name = "favoriteGroupName", nullable = false)
    String favoriteGroupName;

    String favoriteVocaListArray = "";

}
