package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Blog {

    private int userId;
    private String blogName;
    private int blogCategory;
    private String blogTest;
}
