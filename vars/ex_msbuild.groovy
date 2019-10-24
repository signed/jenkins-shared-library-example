import org.somecompany.DefaultStepExecutor
import org.somecompany.build.MsBuildStep
import org.somecompany.build.SomeFlag

/**
 * Example custom step for easy use of MsBuild inside Jenkinsfiles
 * @param solutionPath Path to .sln file
 * @return
 */
def call(Map args = [:]) {
    String solutionPath = args.solutionPath as String
    SomeFlag someFlag = args.someFlag as SomeFlag
    boolean strict = args.strict ? args.strict : true
    call(solutionPath, someFlag, strict)
}

def call(String solutionPath, SomeFlag someFlag, boolean strict = true) {
    new MsBuildStep(solutionPath, someFlag, strict).build(new DefaultStepExecutor(this))
}

