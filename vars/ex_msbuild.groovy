import org.somecompany.DefaultStepExecutor
import org.somecompany.build.MsBuild

/**
 * Example custom step for easy use of MsBuild inside Jenkinsfiles
 * @param solutionPath Path to .sln file
 * @return
 */
def call(String solutionPath, boolean strict = true) {
    def msBuilder = new MsBuild(new DefaultStepExecutor(this), solutionPath, strict)
    msBuilder.build()
}
