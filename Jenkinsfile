pipeline {
    agent any
    
    tools{
        maven "maven"
        jdk "jdk"
    }
     environment{
        SCANNER_HOME= tool 'sonar-scanner'
    }

    stages {
        stage('Git Checkout') {
            steps {
               git branch: 'ci_cd_pipeline', changelog: false, poll: false, url: 'https://github.com/17J/Spring-Curd-Full-Stack-Management-App.git' 
            }
        }
        stage('Trivy Repo Scan') {
            steps {
               sh 'trivy repo --format table -o repo-report.html https://github.com/17J/Spring-Curd-Full-Stack-Management-App.git '
            }
        }
        stage('Compile') {
            steps {
               sh 'mvn compile'
            }
        }
        stage('Test') {
            steps {
               sh 'mvn test'
            }
        }
        stage('Sonarqube Code Analysis') {
            steps {
              withSonarQubeEnv('sonarqube') {
              sh ''' $SCANNER_HOME/bin/sonar-scanner  -Dsonar.projectName=fullstackcurd \
                           -Dsonar.java.binaries=.\
                           -Dsonar.projectKey=fullstackcurd '''
              }
            }
        }
        stage('Quality Gate') {
            steps {
                script{
                    waitForQualityGate abortPipeline: false, credentialsId: 'sonar-cred'
               }
            }
        }
        stage('Build') {
            steps {
               sh 'mvn package'
            }
        }
        stage('docker deloy') {
            steps {
               sh 'docker-compose up -d'
            }
        }
        
    }
}
