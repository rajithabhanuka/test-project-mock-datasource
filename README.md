## I'm adding this additional thing just to knowing about this

Open the application using JIdea or Eclipse
After that clean the project
After that run the "TestBitbucketApplication"

> **Next you can the access H2 database using this [url](http://localhost:8080/database/)**

Then it will display a UI please enter below values accordingly

```bash
Saved Settings = Generic H2 (Embedded)
Setting Name = Generic H2 (Embedded)
Driver Class = org.h2.Driver
JDBC URL = jdbc:h2:mem:test_db
User Name = root
Password = root
```

After that select the **test_db database and query for test_user** table

```bash
SELECT * FROM test_db.test_user 
```

 