package com.cm.alice.financial.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Loggable {

    @Column(name = "created_by")
    private String createBy;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;
}
