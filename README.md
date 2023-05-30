# projetJavaPabloLoick
Creation de la table users :
CREATE TABLE users (
Numero_Securite_Sociale NUMERIC(15,0) PRIMARY KEY,
Nom VARCHAR(50),
Prenom VARCHAR(50),
Date_Naissance DATE,
Numero_Telephone VARCHAR(12),
E_Mail VARCHAR(50),
ID_Remboursement VARCHAR(50),
Code_Soin VARCHAR(7),
Montant_Remboursement NUMERIC(10,2),
Timestamp_Fichier TIMESTAMP
)
