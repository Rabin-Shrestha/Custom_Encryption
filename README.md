## Custom Encryption Web APP
This web app allows us to encrypt and decrypt the given string using a provided key.
## Application Requirements
- JDK 8
- Maven 

## JDK Setup
 * Download and install [Open JDK8](https://openjdk.java.net/install/)
 * You can update `.bash_profile` for java environment variables to select JDK8 as a default version.  
   ```
   export JAVA_HOME8='/Library/Java/JavaVirtualMachines/java_home --version 8/Contents/Home
   export JAVA_HOME=$JAVA_HOME8
   export PATH=$JAVA_HOME/bin:$PATH
   ```
 * You can also use [jEnv](https://www.jenv.be/) or [SDKMan](https://sdkman.io/) if you wish to manage your Java version that way. 
   
## Running the Application
* Now Execute following command from the root directory:
`mvn jetty:run`

## Push app to the PCF
* Execute following command: `cf push -f manifest/dev.manifest.yml --vars-file manifest/vars.yml` 

## Push app to the Google Cloud
* login to the Gcloud:  `gcloud auth login`
* Execute maven command to deploy the app: `mvn appengine:deploy`
* For more detail: [Gcloud Documentation](https://cloud.google.com/appengine/docs/flexible/java/using-maven)
## API Documentation
* [Swagger API](http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs&validatorUrl=)
