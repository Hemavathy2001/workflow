pipeline{	
	agent any
	 environment {
		DISABLE_AUTH = 'true'
		DB_ENGINE    = 'sqlite'
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
		 echo "Database engine is ${DB_ENGINE}"
                 echo "DISABLE_AUTH is ${DISABLE_AUTH}"
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
