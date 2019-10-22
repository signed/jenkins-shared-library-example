import org.somecompany.StepExecutor
import org.somecompany.build.MsBuild
import org.somecompany.ioc.ContextRegistry

/**
 * Example custom step for easy use of MsBuild inside Jenkinsfiles
 * @param solutionPath Path to .sln file
 * @return
 */
def call(String solutionPath) {
    def msbuilder = new MsBuild(solutionPath, new StepExecutor(this))
    msbuilder.build()
}
