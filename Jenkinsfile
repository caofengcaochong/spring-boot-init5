pipeline {
   agent any

   stages {
      stage('pull code') {
         steps {
           checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'git@github.com:caofengcaochong/spring-boot-init5.git']]])
         }
      }
       stage('check code') {
                           steps {
                               script{
                                    scannerHome=tool 'sonar-scanner'
                               }
                               withSonarQubeEnv('sonarqube'){
                                    sh "${scannerHome}/bin/sonar-scanner"
                               }
                           }
                        }

      stage('build code') {
         steps {
             sh label: '', script: 'mvn clean package dockerfile:build'
         }
      }


   }
   post {
     always {
       emailext body: '成功了', subject: 'Jenkins', to: '55186857@qq.com'
     }
   }
}