
# THIS DATABASE IS NOT USED in the curent implementation of the application.

 This database ins not used in the current implementation. You do not need to setup this inventory DB. The following setup steps are only for referencce from the original implementation that used this Inventory DB. 

# setup DB2 database "cos-inv" for the cos application running in WAS Tradional VM. The database will run in Docker on the local Desktop VM in the environment. 


## Clone the workshop git repo
```
git clone https://github.com/IBMTechSales/openshift-workshop-was
```

## change to the db2-docker directory
```
cd /home/ibmuser/openshift-workshop-was/db2-docker/invdb
```


## Build the database image using the Dockerfile in the current directory. It copies all of the scripts that will run when the docker run command is executes 
```
docker build . -t cos-invdb
```

## Create the docker container. The command creates the INV database, sets the db2inst1 password, and the scripts that were copied to the /var/customm folder on the image automatically run (when using the IBM DB2 11 Docker image. The scripts create the tables and populate the DB. It also stores the DATA on the local VM in the locateion specified by the -v option. And it maps to the /database directory in the docker container. 
```
docker run -itd --name cos-invdb --privileged -p 55000:50000 -e DBNAME=INVDB -e LICENSE=accept -e DB2INST1_PASSWORD=db2inst1 -v /home/ibmuser/invdb/database:/database  cos-invdb:latest
```

## Repeat checking of the db2 logs to ensure DB is setup and running. 
### Note: The .sql file sand the .sh files get executed. The .swl files will show errors, but the PopulateDB.sh script should run, and successfull create the table and populate the DB, using the same .sql files. 
```
docker logs cos-invdb
```




## Start and stop the db2 container as needed 

### Start DB2
```
docker start cos-invdb
```

### Stop DB2
```
docker stop cos-invdb
```


### Inside the docker container, commands to verify all is OK 
```
docker exec -it cos-invdb /bin/sh
```

### Inside the container 
```
su db2inst1
db2 list database directory
db2 connect to invdb
db2 list tables
```

### check data
```
db2    (get to the DB2 command processor) 

select * from product
select * from supplier
quit
```

### check the /database dorectory at the root of the filesystem. The Data folder should have the database content. 
```
cd /database
```











