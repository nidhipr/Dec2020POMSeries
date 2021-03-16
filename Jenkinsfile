pipeline{
    
    agent any
    
    stages{
        
        stage("Build"){
            steps{
                   echo("building")
                }
            }
        
         stage("Deploy on Dev"){
            steps{
                   echo("deploy on dev")
                 }
            }
         
         stage("Deploy on qa"){
             steps{
                  echo("deploy on qa")
                }
            }
         
          stage("Regression Test"){
             steps{
                   echo("running regression test")
                 }
            }
         
            stage("Deploy on stage"){
                 steps{
                      echo("deploy on stage")
                    }
            }
         
             stage("Sanity test on stage"){
                   steps{
                        echo("sanity test on stage")
                    }
            }
         
            stage("Deploy on prod"){
                 steps{
                     echo("Deploymentt on prod")
                 }
            }
         
         
        
        
    }
}