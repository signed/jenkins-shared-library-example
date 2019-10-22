package org.somecompany

/**
 * Interface for calling any necessary Jenkins steps. This will be mocked in unit tests.
 */
interface StepExecutor {
    int sh(String command)
    void error(String message)
}
