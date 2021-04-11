
#!groovy
#ts 
properties([disableConcurrentBuilds()])
pipeline {
    agent { 
        label 'master'
        }
    options {
        buildDiscarder(logRotator(numToKeepStr: '15', artifactNumToKeepStr: '15'))
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
        stage("Second step") {
            steps {
                sh 'hostname'
            }
        }
    }
}
