package com.aixel.training.concurrency.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Data
@Entity
public class Log {

    @Id
    @SequenceGenerator(
            name = "log_sequence",
            sequenceName = "log_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "log_sequence"
    )
    private long id;

    private Calendar started;

    private Calendar captured;

    private Calendar ended;

    private String identifier;

    private long sum;

}
