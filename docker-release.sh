sudo docker stop at_container
sudo docker rm at_container
sudo docker rmi at_template
sudo docker build -t at_template .
sudo docker run -t -d -p 80:80 --name at_container at_template
sudo docker start at_container
sudo docker exec -t -i at_container /bin/bash
