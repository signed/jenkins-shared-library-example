import org.somecompany.DefaultStepExecutor
import org.somecompany.build.MsBuild

/**
 * Example custom step for easy use of MsBuild inside Jenkinsfiles
 * @param solutionPath Path to .sln file
 * @return
 */
def call(String solutionPath) {
    def msbuilder = new MsBuild(solutionPath, new DefaultStepExecutor(this))
    msbuilder.build()
}
