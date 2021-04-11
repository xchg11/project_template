
#!groovy
#ts 
properties([disableConcurrentBuilds()])
pipeline {
    agent { 
        label 'master'
        }
    options {
        buildDiscarder(logRotator(numToKeepStr: '2', artifactNumToKeepStr: '2'))
        timestamps()
    }
    stages {
        stage("First step") {
            steps {
                sh 'id -u'
            }
        }
        stage("Second step") {
            steps {
                sh 'hostname'
            }
        }
    }
}
