import org.somecompany.DefaultStepExecutor
import org.somecompany.build.MsBuildStep

/**
 * Example custom step for easy use of MsBuild inside Jenkinsfiles
 * @param solutionPath Path to .sln file
 * @return
 */
def call(String solutionPath, boolean strict = true) {
    new MsBuildStep(new DefaultStepExecutor(this), solutionPath, strict).build()
}
