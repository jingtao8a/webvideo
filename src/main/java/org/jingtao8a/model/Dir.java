package org.jingtao8a.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dir {
    private String name;
    private List<Dir> children = new ArrayList<>();
    private List<String> file = new ArrayList<>();
}
