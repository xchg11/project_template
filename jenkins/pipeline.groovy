#!groovy
// commit
import javax.mail.*
import javax.mail.internet.*

MAILER_HOST = "rmd5.ru"  // "smtp-relay.gmail.com"
RECIPIENT_EMAIL = "xchg11@rmd5.ru"
date_time = new Date().format("yyyy-MM-dd hh:mm")
props = new Properties()

private void sendMail() {
    props.put("mail.host", MAILER_HOST);
    Session session = Session.getDefaultInstance(props)
    session.setDebug(true);

    MimeMessage message = new MimeMessage(session)
    message.setFrom("no.reply@rmd5.ru")
    message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT_EMAIL))
    message.setSubject("A Test email ${date_time}")
    message.setText("tr!!")

    Transport.send(message)
}

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
        stage("Third step") {
            steps {
                sh 'uname -a'
                sendMail()
            }
        }
    }
}
