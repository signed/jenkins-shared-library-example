package org.somecompany.build;

import org.somecompany.StepExecutor;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Example test class
 */
public class MsBuildTest {
    private StepExecutor _steps = mock(StepExecutor.class);

    @Test
    public void build_callsShStep() {
        String solutionPath = "some/path/to.sln";
        MsBuild builder = new MsBuild(solutionPath, _steps);

        builder.build();

        verify(_steps).sh(anyString());
    }

    @Test
    public void build_shStepReturnsStatusNotEqualsZero_callsErrorStep() {
        String solutionPath = "some/path/to.sln";
        MsBuild builder = new MsBuild(solutionPath, _steps);

        when(_steps.sh(anyString())).thenReturn(-1);

        builder.build();

        verify(_steps).error(anyString());
    }
}
