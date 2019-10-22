package org.somecompany

class DefaultStepExecutor implements StepExecutor {
    private steps

    DefaultStepExecutor(steps) {
        this.steps = steps
    }

    @Override
    int sh(String command) {
        this.steps.sh returnStatus: true, script: "${command}"
    }

    @Override
    void error(String message) {
        this.steps.error(message)
    }
}
