package org.somecompany.build;

import org.somecompany.StepExecutor;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Example test class
 */
public class MsBuildTest {
    private StepExecutor steps = mock(StepExecutor.class);

    @Test
    public void build_callsShStep() {
        String solutionPath = "some/path/to.sln";
        MsBuild builder = new MsBuild(steps, solutionPath);

        builder.build();

        verify(steps).sh(anyString());
    }

    @Test
    public void build_shStepReturnsStatusNotEqualsZero_callsErrorStep() {
        String solutionPath = "some/path/to.sln";
        MsBuild builder = new MsBuild(steps, solutionPath);

        when(steps.sh(anyString())).thenReturn(-1);

        builder.build();

        verify(steps).error(anyString());
    }
}
