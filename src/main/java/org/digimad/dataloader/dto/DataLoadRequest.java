package org.digimad.dataloader.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DataLoadRequest {
    private List<Table> tables;
    private Boolean isFullLoadRequired;
    private Date from;
    private Date to;
}
