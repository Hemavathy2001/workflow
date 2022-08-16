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
	stage("deploy") {
	steps{
	retry(3){
	   sh 'going to work'
	}
		
	timeout(time:3 , unit:'SECONDS'){
		sh' sleep 5'
	}
	echo 'deploying the application....'
	}
	}
	}
	}
