pipeline {
    agent {
        docker {
            image 'hashicorp/terraform:latest'
            // This shares the Docker socket so Terraform inside the container can talk to Docker Desktop
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    environment {
        TF_IN_AUTOMATION = 'true'
    }

    stages {
        stage('Terraform Init') {
            steps {
                sh 'terraform init'
            }
        }

        stage('Terraform Plan') {
            steps {
                sh 'terraform plan'
            }
        }

        stage('Terraform Apply') {
            steps {
                sh 'terraform apply -auto-approve'
            }
        }
    }
}