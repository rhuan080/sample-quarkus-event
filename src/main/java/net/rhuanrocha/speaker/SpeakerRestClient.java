package net.rhuanrocha.speaker;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Path("speakers")
@RegisterRestClient
public interface SpeakerRestClient {
    @GET
    @Path("/event/{idEvent}")
    @Fallback(value = SpeakerFallbackHandler.class)
    @Timeout(value = 5, unit= ChronoUnit.SECONDS)
    @CircuitBreaker( requestVolumeThreshold = 4, failureRatio = 0.75, delay = 1000, successThreshold = 10)
    public Set<Speaker> listByEvent(@PathParam("idEvent") Long idEvent);

    @GET
    @Path("/event/{idEvent}")
    @Fallback(value = SpeakerFallbackHandler.class)
    @Timeout(value = 5, unit= ChronoUnit.SECONDS)
    @CircuitBreaker( requestVolumeThreshold = 4, failureRatio = 0.75, delay = 1000, successThreshold = 10)
    public Set<Speaker> listByEvent(@PathParam("idEvent") Long idEvent,
                                    @HeaderParam("my-custom-header") String myCustomHeader);

    @GET
    @Path("/event/{idEvent}")
    @Fallback(value = SpeakerFallbackHandler.class)
    @Timeout(value = 5, unit= ChronoUnit.SECONDS)
    @CircuitBreaker( requestVolumeThreshold = 4, failureRatio = 0.75, delay = 1000, successThreshold = 10)
    public Set<Speaker> listByEvent(@BeanParam SpeakerBean speakerBean);

}
