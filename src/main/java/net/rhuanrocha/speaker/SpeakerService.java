package net.rhuanrocha.speaker;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Set;

@ApplicationScoped
public class SpeakerService {

    @Inject
    @RestClient
    SpeakerRestClient speakerRestClient;

    public Set<Speaker> listByEvent(Long idEvent){
        return speakerRestClient.listByEvent(idEvent);
    }

    @Fallback(value = SpeakerFallbackHandler.class)
    public Set<Speaker> listByEvent(Long idEvent, String myCustomHeader){
        return speakerRestClient.listByEvent(idEvent);
    }

    public Set<Speaker> listByEvent(SpeakerBean speakerBean){
        return speakerRestClient.listByEvent(speakerBean);
    }
}
