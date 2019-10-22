library 'jenkins-shared-library-example'

pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                ex_msbuild 'some/path/to.sln'
                ex_msbuild 'some/path/to.sln', false
                ex_msbuild 'some/path/to.sln', true
            }
        }
    }
}
