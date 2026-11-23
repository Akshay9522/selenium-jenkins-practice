pipeline{
    agent any
    parameters{
        choice(
        name: 'TEST_SUITE',
        choices: ['smoke', 'regression'],
        description: 'Select Cucumber test suite'
    )
    }
    stages{
        stage('Checkout'){
            steps{
            echo 'SCM Polling Practical - GitHub change detected'
                git branch: 'master',
                    url: 'https://github.com/Akshay9522/selenium-jenkins-practice.git'
            }
        }
        stage('Execute Tests') {
            steps {
                echo 'Pipeline loaded from GitHub - Version 2'

                echo "Selected Test Suite: ${params.TEST_SUITE}"

                bat "mvn clean test -Dheadless=true -Dcucumber.filter.tags=@${params.TEST_SUITE}"
            }
        }
        stage('Execute Test'){
            steps{
               bat "mvn clean test -Dheadless=true -Dcucumber.filter.tags=@${params.TEST_SUITE}"
            }
        }
    }
    post{
        always{
            echo 'always'
            allure([
                includeProperties: false,
                jdk: '',
                results: [[path: 'target/allure-results']]
            ])
        }
        success{
            echo 'success'
        }
        failure{
            echo 'failure'
        }
    }
}