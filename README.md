# SoapWS

Demande : 
Développer trois endpoints Soap permettant de mener les actions suivantes :
✓ Ajout/modification/suppression d’un marchand
	URL : http://localhost:8080/soapws/soap-api/MerchantService?wsdl
✓ Ajout/modification/suppression d’un produit
	URL : http://localhost:8080/soapws/soap-api/ProductService?wsdl
✓ Associer un marchand à un produit
	URL : http://localhost:8080/soapws/soap-api/AssociateService?wsdl
	
Il faut configurer la base de données PostgreSQL dans le fichier : *database.properties*


Pour créer les tables de la base de données il suffit de démarrer le serveur,
les tables seront crées automatiquement avec la propriété hibernate 
*hibernate.hbm2ddl.auto=update*

Librairies Utilisées :
	- Java : Version 1.8
 	- Doser : pour mapping entre dto et les entity.
 	- Apache CXF : pour la création des WS SOAP.
 	- Hibernate : pour le mapping entre les entity et les tables dans la BD.
 	- Spring : pour les injections des Beans
 	- JUnit + Mokito : pour les tests unitaires
