pipeline{	
	agent any
	environment{
		NAME = 'Tom'
		AGE = '21'
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
		sh ' echo this is $NAME $AGE... '
	}
	}
	stage("deploy") {
	steps{
	retry(3){
	   sh 'echo going to work'
	}
		
	timeout(time:3 , unit:'SECONDS'){
		sh' sleep 5'
	}
	echo 'deploying the application....'
	}
	}
	}
	}
