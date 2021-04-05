package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class UserProfile {
    @Id
    @OneToOne(targetEntity = User.class)
    private User user;

    private String first_name;
    private String last_name;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthday;

    private String city;
    private String street;
    private String house;
    private String floor;
    private String flat;

}
