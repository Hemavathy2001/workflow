pipeline{	
	agent any
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
	echo 'testing the application....'
	}
	}
	stage("Timeout"){
	steps{
	retry(3){
	sh ' not going to work :c '
	}
	timeout(time:3 unit:'SECONDS'){
		sh' sleep 5'
	}
	}
	}
	stage("deploy") {
	steps{
	echo 'deploying the application....'
	}
	}
	}
	}
