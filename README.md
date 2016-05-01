# Model View Service

Description:
--------------
Backend service of ViewModel(Nodejs frontend webapp)
Project set up in Intellij idea, Jetty can be used to start the service by running
```bash
jetty:run
```

API Overview:
---------------
**GET**    
```html
GET http://localhost:8085/entities        
GET http://localhost:8085/entity/{entityName}         
GET http://localhost:8085/entity/parentes     
GET http://localhost:8085/entitycolumn/{entityId}  

GET http://localhost:8085/topics    
GET http://localhost:8085/topic/{topicName}   
```

**POST**   
```html
POST http://localhost:8085/entity
POST http://localhost:8085/entitycolumn
POST http://localhost:8085/popularity
POST http://localhost:8085/contributor

POST http://localhost:8085/topic   
POST http://localhost:8085/topicstep  
```

API Payload
----------------
*POST entity*
```json
{
  "entityName": "SC_Job",
  "businessValue": "**For Policy perspective**, we offer many more built-in car insurance discounts",
  "entityBuilder": "<pre><code class='java'>public class ClassLazyTypeResolver {  \r abc...  \r   }</code></pre>",
  "parentEntity": null
}
```

*POST entitycolumn*   
```json
[
  {
    "columnDescription": "Claim",
    "columnName": "Claim",
    "columnType": "Claim",
    "coreEntity_Id": 2,
    "foreignKey_Id": null
  },
  {
    "columnDescription": "CreateTime",
    "columnName": "AAA14",
    "columnType": "DATETIME",
    "coreEntity_Id": 2,
    "foreignKey_Id": null
  }
]
```

*POST popularity*   
```json
{
  "views": 200,
  "likes": 28,
  "modelType": 0,
  "modelPublicId": 1
}
```

*POST contributor*   
```json
{
  "createUserName": "Bernie Xie",
  "lastModifiedUserName": "Will Hu",
  "modelType": 0,
  "modelPublicId": 1
}
```

*POST topic*
```json
{
  "description": "How to do the payment?",
  "name": "how_to_do_the_payment",
  "title": "How to do the payment?",
  "userCase": "Having an a nice weekend!!!!"
}
```

*POST topicStep*
```json
[
  {
    "stepId": 0,
    "shortDescription": "Short Go to menu and open Ready to pay.",
    "description": "Long Go to menu and open Ready to pay.",
    "screenShotUrl": "../javascripts/sample2/1.jpg",
    "topic_Id": 1
  },
  {
    "stepId": 1,
    "shortDescription": "12Short Go to menu and open Ready to pay.",
    "description": "13Long Go to menu and open Ready to pay.",
    "screenShotUrl": "../javascripts/sample2/2.jpg",
    "topic_Id": 1
  }
]
```

Table schema
-------------
*MV_COREENTITY*    

COLUMN_NAME         |TYPE_NAME|DEC&|NUM&|COLUM&|COLUMN_DEF|CHAR_OCTE&|IS_NULL&
--------------------|---------|----|----|------|----------|----------|--------
ID                  |INTEGER  |0   |10  |10    |GENERATED&|NULL      |NO      
BUSINESSVALUE       |VARCHAR  |NULL|NULL|5000  |NULL      |10000     |YES     
ENTITYBUILDER       |VARCHAR  |NULL|NULL|5000  |NULL      |10000     |YES     
ENTITYNAME          |VARCHAR  |NULL|NULL|255   |NULL      |510       |YES     
PARENTENTITY        |INTEGER  |0   |10  |10    |NULL      |NULL      |YES 

*MV_ENTITYCOLUMN*     

COLUMN_NAME         |TYPE_NAME|DEC&|NUM&|COLUM&|COLUMN_DEF|CHAR_OCTE&|IS_NULL&
--------------------|---------|----|----|------|----------|----------|--------
ID                  |INTEGER  |0   |10  |10    |GENERATED&|NULL      |NO      
DESCRIPTION         |VARCHAR  |NULL|NULL|255   |NULL      |510       |YES     
ENTITYTYPE          |VARCHAR  |NULL|NULL|255   |NULL      |510       |YES     
NAME                |VARCHAR  |NULL|NULL|255   |NULL      |510       |YES     
FOREIGNKEY          |INTEGER  |0   |10  |10    |NULL      |NULL      |YES     
COREENTITY_ID       |INTEGER  |0   |10  |10    |NULL      |NULL      |NO  


*MV_CONTRIBUTOR*     

COLUMN_NAME         |TYPE_NAME|DEC&|NUM&|COLUM&|COLUMN_DEF|CHAR_OCTE&|IS_NULL&
--------------------|---------|----|----|------|----------|----------|--------
ID                  |INTEGER  |0   |10  |10    |GENERATED&|NULL      |NO      
CREATEUSERNAME      |VARCHAR  |NULL|NULL|255   |NULL      |510       |YES     
LASTMODIFIEDUSERNAME|VARCHAR  |NULL|NULL|255   |NULL      |510       |YES     
MODELPUBLICID       |INTEGER  |0   |10  |10    |NULL      |NULL      |NO      
MODELTYPE           |INTEGER  |0   |10  |10    |NULL      |NULL      |YES 

*MV_POPULARITY*     

COLUMN_NAME         |TYPE_NAME|DEC&|NUM&|COLUM&|COLUMN_DEF|CHAR_OCTE&|IS_NULL&
--------------------|---------|----|----|------|----------|----------|--------
ID                  |INTEGER  |0   |10  |10    |GENERATED&|NULL      |NO      
MODELPUBLICID       |INTEGER  |0   |10  |10    |NULL      |NULL      |NO      
MODELTYPE           |INTEGER  |0   |10  |10    |NULL      |NULL      |YES     
LIKES               |INTEGER  |0   |10  |10    |NULL      |NULL      |YES     
VIEWS               |INTEGER  |0   |10  |10    |NULL      |NULL      |YES   
