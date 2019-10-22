package org.somecompany.build;

import org.junit.jupiter.api.Test;
import org.somecompany.StepExecutor;

import static org.mockito.Mockito.*;

class MsBuildTest {
    private StepExecutor steps = mock(StepExecutor.class);

    @Test
    void build_callsShStep() {
        String solutionPath = "some/path/to.sln";
        MsBuild builder = new MsBuild(steps, solutionPath, true);

        builder.build();

        verify(steps).sh(anyString());
    }

    @Test
    void build_shStepReturnsStatusNotEqualsZero_callsErrorStep() {
        String solutionPath = "some/path/to.sln";
        MsBuild builder = new MsBuild(steps, solutionPath, true);

        when(steps.sh(anyString())).thenReturn(-1);

        builder.build();

        verify(steps).error(anyString());
    }
}
