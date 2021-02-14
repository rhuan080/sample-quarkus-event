package net.rhuanrocha.event;

import net.rhuanrocha.speaker.SpeakerBean;
import net.rhuanrocha.speaker.SpeakerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class EventResource {

    @Inject
    SpeakerService speakerService;

    @GET
    public List<EventDto> list(){
        return Event
                .listAll()
                .stream()
                .map( event -> EventDto.of((Event)event,speakerService.listByEvent(((Event)event).id, "valueTest")))
                .collect(Collectors.toList());
    }

    @POST
    public Response save(Event event){
        event.id= null;
        event.persist();
        return Response
                .created(URI.create(String.format("/events/%d", event.id)))
                .build();
    }
}
