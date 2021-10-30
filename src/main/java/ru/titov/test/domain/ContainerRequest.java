package ru.titov.test.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ContainerRequest {
    private static boolean count = true;
    private List<String> listResults;

    // add to list
    public void addResult(String value) {
        if(count){count =false; listResults.clear();}
        listResults.add(value);
    }
}
