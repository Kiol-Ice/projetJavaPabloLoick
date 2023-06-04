# projet Java Pablo Neussaint et Loick Ramadier

## Utilisation du projet :
Le fichier csv prêt pour l'injection en base doivent être placé dans le dossier fileInput. 
Une fois traité ils seront déplacés dans fileOutput si le traitement a réussi, sinon dans fileRejected.

Utilisé la commande suivante pour executé le projet depuis un terminal de commande situé à la racine du projet :
java -jar target/projet-pablo-loick-0.0.1-SNAPSHOT-jar-with-dependencies.jar

## Réalisation du projet : 
Nous avons séparés le projet en 2 parties majeurs : 
- l'extration des données depuis les fichiers csv
- l'injection (ou mise à jour) des données en base

Pour se faire nous avons réalisé 2 classes qui permettent de gerer ces 2 parties. 
Ainsi que les classes de tests unitaires correspondantes.

## Base de données 
Nous avons utilisé un base mariaDb (avec docker). Pour se faire , nous avons créé un fichier nommé "docker-compose.yml".
Ce fichier contient les informations suivantes :

    version: '3.3'
    services:

        database:
        image: 'mariadb:latest'
        container_name: projet_java
        restart: always
        environment:
             - MYSQL_USER=user
            - MYSQL_PASSWORD=test
            - MYSQL_DATABASE=projet_java
            - MYSQL_ROOT_PASSWORD=test
        
        ports:
               - '3306:3306'
        
Il suffit ensuite d'ouvrir un terminal et de faire la commande "docker-compose up".
Ceci va permettre de créer notre base de données et de la mettre en marche.
Nous pouvons maintenant nous y connecter avec PostgreSQL afin de créer notre table.
Vous trouverez ci dessous la déclaration de la table dans laquelle le projet peut inserer des données.

Creation de la table users :
CREATE TABLE users (
Numero_Securite_Sociale VARCHAR(15) PRIMARY KEY,
Nom VARCHAR(50),
Prenom VARCHAR(50),
Date_Naissance DATE,
Numero_Telephone VARCHAR(12),
E_Mail VARCHAR(50),
ID_Remboursement VARCHAR(50),
Code_Soin VARCHAR(7),
Montant_Remboursement NUMERIC(10,2),
Timestamp_Fichier TIMESTAMP
);

## Dépendances et plugin

Afin de pouvoir gérer les testes unitaires, la connection et les insertions à la base de donnée, nous avons eu besoins des dépendances suivantes :
- junit version 4.12
- mariadb-java-client version 3.1.4
- slf4j-simple version 2.0.7
- slf4j-api version 2.0.7

Afin de pouvoir inclure nos dépendances dans le fichier jar généré, nous avons utilisé le plugin suivant :
- maven-assembly-plugin
