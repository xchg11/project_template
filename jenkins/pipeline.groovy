#!groovy
/* commit
properties([disableConcurrentBuilds()])
pipeline {
    agent any
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
        stage("Third step") {
            steps {
                sh 'uname -a'
                //sendMail()
            }
        }
    }
}
*/
pipeline {
    agent {
        docker { image 'node:15-alpine' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'node --version'
            }
        }
    }
}
