package net.rhuanrocha.event;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Event extends PanacheEntity {
    public String name;
    public String description;
    public LocalDateTime beginDate;
    public LocalDateTime endDate;
}
