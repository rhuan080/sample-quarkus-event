package net.rhuanrocha.speaker;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import java.util.Collections;
import java.util.Set;

public class SpeakerFallbackHandler implements FallbackHandler<Set<Speaker>> {
    @Override
    public Set<Speaker> handle(ExecutionContext executionContext) {
        return Collections.EMPTY_SET;
    }
}
