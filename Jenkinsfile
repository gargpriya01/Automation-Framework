node {

    // Parameters for environment selection
    properties([
        parameters([
            choice(name: 'ENVIRONMENT', choices: ['staging', 'production'], description: 'Select target environment')
        ])
    ])

    def mvnHome

    try {
        stage('Checkout') {
            echo "Checking out source code..."
            checkout scm   // assumes Jenkins job is linked with Git repo
        }

        stage('Setup Tools') {
            echo "Setting up Maven..."
            mvnHome = tool name: 'Maven Project', type: 'maven'
        }

        stage('Build & Unit Test') {
            echo "Running build and unit tests..."
            sh "${mvnHome}/bin/mvn clean test"
        }

        stage('Static Analysis') {
            echo "Running code quality checks..."
            // example: if sonar plugin integrated
            // sh "${mvnHome}/bin/mvn sonar:sonar"
            sh "${mvnHome}/bin/mvn checkstyle:checkstyle"
        }

        stage('Package') {
            echo "Packaging application..."
            sh "${mvnHome}/bin/mvn package"
        }

        stage('Archive Reports') {
            echo "Archiving test reports and artifacts..."
            junit '**/target/surefire-reports/*.xml'   // publish test results
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }

        stage('Deploy') {
            if (params.ENVIRONMENT == 'staging') {
                echo "Deploying to Staging..."
                sh "./deploy.sh staging"
            } else if (params.ENVIRONMENT == 'production') {
                echo "Deploying to Production..."
                sh "./deploy.sh production"
            } else {
                echo "Skipping deployment..."
            }
        }

    } catch (Exception err) {
        echo "Build failed: ${err}"
        currentBuild.result = 'FAILURE'
        throw err
    } finally {
        stage('Post-Build') {
            if (currentBuild.result == 'SUCCESS') {
                echo "✅ Build and Deployment successful for ${params.ENVIRONMENT}"
            } else {
                echo "❌ Build failed for ${params.ENVIRONMENT}"
            }
        }
    }
}
