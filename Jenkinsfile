
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
             sh "docker tag spring-boot-init5:latest 192.168.77.139:88/test001/springboot:v2"
withCredentials([usernamePassword(credentialsId: 'cf1c7203-7e9c-4630-be09-8c2aa42d3e39', passwordVariable: 'password', usernameVariable: 'username')]) {
        docker login -u ${usename} -p ${password} 192.168.77.139:88
        docker push 192.168.77.139:88/test001/springboot:v2
}
         }
      }


   }
   post {
     always {
       emailext body: '成功了', subject: 'Jenkins', to: '55186857@qq.com'
     }
   }
}