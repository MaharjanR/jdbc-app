package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class User {

    private int id;
    private String userName;
    private String userPass;
    private Date createDate;
}
