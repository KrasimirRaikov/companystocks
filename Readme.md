##Companies prices extraction, storage and retrieval

 1. Using IEX Developer Platform Api 
 to retrieve companies information and prices
 2. Using Google Cloud Platform for hosting the application
 and datastorage
 
 ##Development
 ###Prerequisites:
 - Java jdk-8
 - Maven 3.6.0
 - Google cloud sdk 229
 ### Running the application locally:
 - mvn clean install spring-boot:run
 
 ###ToDo before production:
 
 - connect to actual datastorage
 - write tests
 - write UI
 - refactor application to work per user
 - write cron job and make it configurable
 