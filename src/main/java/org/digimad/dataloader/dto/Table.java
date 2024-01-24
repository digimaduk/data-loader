package org.digimad.dataloader.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Table {
    private String name;
    private List<String> columns;
}
