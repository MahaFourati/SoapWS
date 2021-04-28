# SoapWS


Développement de trois endpoints Soap qui permet de: 
 

- Ajout/modification/suppression d’un marchand
- Ajout/modification/suppression d’un produit
- Associer un marchand à un produit

## URL SOAP



```bash
http://localhost:8080/soapws/soap-api/MerchantService?wsdl
http://localhost:8080/soapws/soap-api/ProductService?wsdl
http://localhost:8080/soapws/soap-api/AssociateService?wsdl
```

## Configuration

Il faut configurer la base de données PostgreSQL dans le fichier : 

```bash
database.properties
```
Pour créer les tables de la base de données il suffit de démarrer le serveur, les tables seront crées automatiquement avec la propriété hibernate 
```bash
hibernate.hbm2ddl.auto=update
```

## Librairies Utilisées

- Java : Version 1.8 
- Doser : pour mapping entre dto et les entity. 
- Apache CXF : pour la création des WS SOAP. 
- Hibernate : pour le mapping entre les entity et les tables dans la BD. 
- Spring : pour les injections des Beans 
- JUnit + Mokito : pour les tests unitaires

## Deployement

Serveur apache tomcat version 8.5


## License
[MIT](https://choosealicense.com/licenses/mit/)