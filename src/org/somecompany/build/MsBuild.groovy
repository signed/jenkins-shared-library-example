package org.somecompany.build

import org.somecompany.IStepExecutor

/**
 * Example class (without proper implementation) for using the MsBuild tool for building .NET projects.
 */
class MsBuild implements Serializable {
    private final IStepExecutor steps
    private final String solutionPath

    MsBuild(String solutionPath, IStepExecutor steps) {
        this.steps = steps
        this.solutionPath = solutionPath
    }

    void build() {
        int returnStatus = steps.sh("echo \"building ${this.solutionPath}...\"")
        if (returnStatus != 0) {
            steps.error("Some error")
        }
    }
}
