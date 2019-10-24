import org.somecompany.DefaultStepExecutor
import org.somecompany.build.MsBuildStep
import org.somecompany.build.SomeFlag

/**
 * Example custom step for easy use of MsBuild inside Jenkinsfiles
 * @param solutionPath Path to .sln file
 * @return
 */
def call(Map map = [:], String solutionPath, SomeFlag someFlag, boolean strict = true) {
    new MsBuildStep(solutionPath, someFlag, strict).build(new DefaultStepExecutor(this))
}
