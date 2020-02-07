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

   }
   post {
     always {
       emailext body: '成功了', subject: 'Jenkins', to: '55186857@qq.com'
     }
   }
}