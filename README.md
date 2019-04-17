# nikolaiSimonov_Assignment3
I have created a normalized database schema (at least 5 tables), a data generation tool and finally an application to import the data. The database consists of 5 tables in 3NF. I used Java Faker for my data generation tool and exported the generated data to a csv file. Lastly, the program imports the unstructured data from the csv text file into the normalized database.

INSTRUCTIONS:
The project should already have fake data generated and the tables should already be created. Additionally, the unstructured data has already been parsed into the 5 tables. 

TO GENERATE FAKE DATA TO A CSV: GOTO StudentGenerator.java --> Uncomment lines 18 & 19 --> Run program
TO CREATE THE 5 TABLES: GOTO StudentGenerator.java --> Uncomment lines 34 & 35 --> Run program
TO PARSE DATA INTO TABLES: GOTO StudentGenerator.java --> Uncomment lines 38 & 39 --> Run program
TO VIEW ALL EXISTING TABLES IN DATABASE: GOTO StudentGenerator.java --> Uncomment lines 27 - 31 --> Run program

PLEASE ENSURE ALL PROPER DEPENDENCIES HAVE BEEN INSTALLED:
<dependencies>
    
    <dependency>
    
        <groupId>com.github.javafaker</groupId>
        
        <artifactId>javafaker</artifactId>
        
        <version>0.17.2</version>
        
    </dependency>
    
    <dependency>
    
        <groupId>mysql</groupId>
        
        <artifactId>mysql-connector-java</artifactId>
        
        <version>5.1.22</version>
        
    </dependency>
    
    <dependency>
    
        <groupId>org.apache.commons</groupId>
        
        <artifactId>commons-csv</artifactId>
        
        <version>1.6</version>
        
    </dependency>
    
</dependencies>
