package org.digimad.dataloader.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DataLoadRequest {
    private List<Table> tables;
    private Boolean isFullLoadRequired;
    private LocalDateTime from;
    private LocalDateTime to;
}
