package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private Boolean is_active; // подтвердил ли почту

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="user_profile_id")
    private UserProfile userProfile;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="role_id")
    @JsonIgnore
    private Role role;
    @Column(insertable = false, updatable = false)
    private Long role_id;
}
