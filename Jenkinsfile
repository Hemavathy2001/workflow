pipeline{	
	agent any
	 environment {
		NAME = 'Tom'
		AGE    = '12'
        }
	tools{
		maven 'Jenkins-maven'
	}
	stages{
		stage("build") {
			steps{
			echo 'building the application....'
			sh 'mvn -B -DskipTests clean package' 
			}
		}
		stage("test") {
			steps{
				echo 'testing the application.... '
				echo " Name is ${NAME} " 
				echo "Age is ${AGE}"
				 sh 'mvn test'
			}
		}
		stage("deploy") {
			steps{
				echo 'deploying the application....'
				sh './jenkins/scripts/deliver.sh'
			     }
		   }
       }
}
