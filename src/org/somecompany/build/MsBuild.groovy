package org.somecompany.build

import org.somecompany.IStepExecutor
import org.somecompany.ioc.ContextRegistry

/**
 * Example class (without proper implementation) for using the MsBuild tool for building .NET projects.
 */
class MsBuild implements Serializable {
    private final IStepExecutor stepExecutor
    private final String solutionPath

    MsBuild(String solutionPath, IStepExecutor stepExecutor) {
        this.stepExecutor = stepExecutor
        this.solutionPath = solutionPath
    }

    void build() {
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        int returnStatus = steps.sh("echo \"building ${this.solutionPath}...\"")
        if (returnStatus != 0) {
            steps.error("Some error")
        }
    }
}
