package org.somecompany.build

import org.somecompany.StepExecutor

/**
 * Example class (without proper implementation) for using the MsBuild tool for building .NET projects.
 */
class MsBuild implements Serializable {
    private final StepExecutor steps
    private final String solutionPath

    MsBuild(String solutionPath, StepExecutor steps) {
        this.steps = steps
        this.solutionPath = solutionPath
    }

    void build() {
        int returnStatus = steps.sh("echo \"[updated] building ${this.solutionPath}...\"")
        if (returnStatus != 0) {
            steps.error("Some error")
        }
    }
}
