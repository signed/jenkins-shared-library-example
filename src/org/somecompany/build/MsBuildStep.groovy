package org.somecompany.build

import org.somecompany.StepExecutor

class MsBuildStep implements Serializable {
    private final StepExecutor steps
    private final String solutionPath
    private final boolean strict
    private final SomeFlag someFlag

    MsBuildStep(String solutionPath, SomeFlag someFlag, boolean strict) {
        this.someFlag = someFlag
        this.strict = strict
        this.steps = steps
        this.solutionPath = solutionPath
    }

    void build(StepExecutor steps) {

        int returnStatus = steps.sh("echo \"[updated] building ${this.solutionPath} strict=${strict} ...\"")
        steps.echo("some flag ${this.someFlag}")
        if (returnStatus != 0) {
            steps.error("Some error")
        }
    }
}
