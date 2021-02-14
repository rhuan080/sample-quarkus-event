package net.rhuanrocha.speaker;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;

public class SpeakerBean {

    @PathParam("idEvent")
    public Long idEvent;

    @HeaderParam("my-custom-header")
    public String myCustomHeader;

    public static SpeakerBean of (Long idEvent){
        SpeakerBean speakerBean = new SpeakerBean();
        speakerBean.idEvent = idEvent;
        return speakerBean;
    }

    public static SpeakerBean of (Long idEvent, String myCustomHeader){
        SpeakerBean speakerBean = new SpeakerBean();
        speakerBean.idEvent = idEvent;
        speakerBean.myCustomHeader = myCustomHeader;
        return speakerBean;
    }
}
