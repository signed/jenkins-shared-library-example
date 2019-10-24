package org.somecompany.build

import org.somecompany.StepExecutor

class MsBuildStep implements Serializable {
    private final StepExecutor steps
    private final String solutionPath
    private final boolean strict

    MsBuildStep(String solutionPath, boolean strict) {
        this.strict = strict
        this.steps = steps
        this.solutionPath = solutionPath
    }

    void build(StepExecutor steps) {
        int returnStatus = steps.sh("echo \"[updated] building ${this.solutionPath} strict=${strict}...\"")
        if (returnStatus != 0) {
            steps.error("Some error")
        }
    }
}
