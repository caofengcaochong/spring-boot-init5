pipeline {
   agent any

   stages {
      stage('pull code') {
         steps {
           checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'git@github.com:caofengcaochong/spring-boot-init5.git']]])
         }
      }
      stage('build code') {
         steps {
             sh label: '', script: 'mvn clean package'
         }
      }
      stage('deploy code') {
         steps {
             sh label: '', script: '''cd  /var/lib/jenkins/workspace/test03/target
                java -jar ./*.jar'''
         }
      }
   }
}