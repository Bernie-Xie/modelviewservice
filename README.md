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
GET http://localhost:8085/entityy/parentes     
GET http://localhost:8085/entitycolumn/{entityId}      

```

**POST**   
```html
POST http://localhost:8085/entity
POST http://localhost:8085/entitycolumn
POST http://localhost:8085/popularity
POST http://localhost:8085/contributor
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
    "description": "FFF",
    "name": "Claim",
    "entityType": "VARCHAR",
    "coreEntity_Id": 10,
    "foreignKey": null
  },
  {
    "description": "CreateTime",
    "name": "Claim",
    "entityType": "DATETIME",
    "coreEntity_Id": 10,
    "foreignKey": null
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
