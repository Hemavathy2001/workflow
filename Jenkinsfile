pipeline{	
	agent any
	environment {
	NAME = 'Tom'
	AGE    = '12'
	}
	stages{
	stage("build") {
	steps{
	echo 'building the application....'
	sh '''
	echo 'hello world'
	'''
	}
	}
	stage("test") {
	steps{
	echo 'testing the application.... '
	echo " Name is ${NAME} "
	echo "Age is ${AGE}"
	}
	}
	stage("deploy") {
	steps{
	echo 'deploying the application....'
	}
	}
	}
	}
