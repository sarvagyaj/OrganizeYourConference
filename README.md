OrganizeYourConference
======================
Helps in organizing a conference.

How to run the application? (LocalHost MongoDB)
=============================
Step 1: Download and install mongoDB from http://www.mongodb.org/downloads.
Step 2: Create a folder c:\data\db.
Step 3:	Run the command prompt. Go to the project folder.
		mvn clean package
Step 4: Run the command prompt in administrative mode.
        Go to installed mongoDB/bin folder.
		Run the executable: mongod.exe
		(You will notice the port listening)
		OR
		Run ../../bin/mongod.exe from the home directory.
Step 5: Switch to the command prompt containing project folder path.
		Run the command: mvn tomcat:run
Step 6: Browse the link http://localhost:8080/organize-your-conference.
		

How to run the application? (MongoLab AWS MongoDB)
=============================
Step 1: Enable the respective code in MongoConfig.java and disable the code related to localhost server
Step 2: Download and install mongoDB from http://www.mongodb.org/downloads.
Step 3:	Run the command prompt. Go to the project folder.
		mvn clean package
Step 4: Run the command: mvn tomcat:run
Step 5: Browse the link http://localhost:8080/organize-your-conference.

How to check the database in MongoLab?
======================================
1. Download the tool http://mongoexplorer.com/
2. Open it and click on Connect.
3. Enter the below details and press on Save(for the first time, otherwise press OK).
	ConnectionName: MongoLab_Deatils
	Host: ds051788.mongolab.com
	Port: 51788
	User Name: conference
	Password: test123
	Database: organize-your-conference


