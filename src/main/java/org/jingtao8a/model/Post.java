package org.jingtao8a.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    Integer id;
    String title;
    String desc;
    String img;
    @DateTimeFormat(pattern="YYYY-MM-DD")
    Date date;
    Integer uid;
    String cat;
    User user;
}
