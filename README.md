# sell-system-bed

## eureka server
  1. simpley start using idea or using command : 
    
    nohup java -jar target/demo-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &
    
  this command will constantly running this server as long as your computer keep alive
  
  2. to check current running thread:
  
    ps -ef | grep demo
    
  3. to kill command:
    
    kill -9 4681
    
## Docker and Devops
  after install docker, run command to install rabbit MQ into docker:
  
    docker run -d --hostname my-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3.8.0-beta.4-management
  
  run below command to instal and run redis

    docker run -d -p 6379:6379 redis:4.0.8

    
