package com.test.chatbot.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member {

    @Id
    private String id;

    @Column
    private String nickname;

    @Column
    private LocalDateTime added_dt;
}
