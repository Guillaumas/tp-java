# Guillaume Gillet

## Projet basé sur JPA et non Spring

### Objectif :

-Savoir mapper et manipuler des entités JPA et se renforcer dans la
modélisation JPA et notamment l’utilisation des relations d’héritage

### Travail à faire :

- **Projet** : Création d’un projet « multi-couches » avec une bonne isolation (package, …)


- **Base de données** : Création d’une base de données appelée : petstore
    - Créer une nouvelle persistence-unit dans persistence.xml pour y accéder
    - Mettre en place le paramétrage nécessaire pour que l’application prenne la main sur
      la création du schéma de base de données


- **Mapping** <u>10pts</u> : Mettre en place le mapping des entités JPA à l’aide des annotations vues
    - Créer les entités JPA du diagramme de classes fourni (mapper tous les champs de
      toutes les classes avec les tables correspondantes en base de données sans oublier
      les types énumérés)
    - Mettre en place les annotations relationnelles (@OneToMany, @ManyToMany et
      @ManyToOne) sur les entités concernées
    - Mettre en place les annotations d’héritage en choisissant la stratégie « 1 table par
      classe / Joined »


- **Manipulation** <u>5pts</u> : Mettre en place une série d’instructions pour créer et requêter les
  éléments en base de données
    - Insérer au moins trois enregistrements dans chacune des tables via EntityManager
    - Réaliser une requête qui permet d’extraire tous les animaux d’une animalerie
      donnée


- **Qualité du livrable** <u>5pts</u> :
    - Commentaires, absence de codes morts, consignes d’éxécution, etc
    - Ajouter le compte @ssylla en tant que collaborateur sur votre dépôt Git sur GitHub,
      GitLab ou Bitbucket
    - Pensez à ajouter un readMe pour les éventuelles consignes.