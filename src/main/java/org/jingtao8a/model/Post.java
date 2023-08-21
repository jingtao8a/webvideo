package org.jingtao8a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    Integer id;
    String title;
    String desc;
    String img;
    Date datetime;
    Integer uid;
}
