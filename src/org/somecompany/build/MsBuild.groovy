package org.somecompany.build

import org.somecompany.StepExecutor

class MsBuild implements Serializable {
    private final StepExecutor steps
    private final String solutionPath
    private final boolean strict

    MsBuild(StepExecutor steps, String solutionPath, boolean strict) {
        this.strict = strict
        this.steps = steps
        this.solutionPath = solutionPath
    }

    void build() {
        int returnStatus = steps.sh("echo \"[updated] building ${this.solutionPath} strict=${strict}...\"")
        if (returnStatus != 0) {
            steps.error("Some error")
        }
    }
}
