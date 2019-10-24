package org.somecompany.build;

import org.junit.jupiter.api.Test;
import org.somecompany.StepExecutor;

import static org.mockito.Mockito.*;

class MsBuildStepTest {
    private StepExecutor steps = mock(StepExecutor.class);

    @Test
    void build_callsShStep() {
        String solutionPath = "some/path/to.sln";
        MsBuildStep builder = new MsBuildStep(solutionPath, true);

        builder.build(steps);

        verify(steps).sh(anyString());
    }

    @Test
    void build_shStepReturnsStatusNotEqualsZero_callsErrorStep() {
        String solutionPath = "some/path/to.sln";
        MsBuildStep builder = new MsBuildStep(solutionPath, true);

        when(steps.sh(anyString())).thenReturn(-1);

        builder.build(steps);

        verify(steps).error(anyString());
    }
}
