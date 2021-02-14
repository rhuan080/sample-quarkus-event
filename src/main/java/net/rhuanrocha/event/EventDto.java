package net.rhuanrocha.event;

import net.rhuanrocha.speaker.Speaker;

import java.time.LocalDateTime;
import java.util.Set;

public class EventDto {

    public Long id;
    public String name;
    public String description;
    public LocalDateTime beginDate;
    public LocalDateTime endDate;
    public Set<Speaker> speakers;

    public static EventDto of(Event event,
                              Set<Speaker> speakers){
        EventDto eventDto = new EventDto();
        eventDto.id = event.id;
        eventDto.name = event.name;
        eventDto.description = event.description;
        eventDto.beginDate = event.beginDate;
        eventDto.endDate = event.endDate;
        eventDto.speakers = speakers;
        return  eventDto;

    }
}
