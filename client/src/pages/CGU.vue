<template>
    <div class="cgu">
      <h1>Conditions Générales d'Utilisation du site <em>Citizen</em></h1>
  
      <section v-for="(article, index) in articles" :key="index">
        <h2>{{ article.title }}</h2>
        <p v-for="(paragraph, index) in article.content" :key="index">
          {{ paragraph }}
        </p>
        <ul v-if="article.list">
          <li v-for="(item, index) in article.list" :key="index">{{ item }}</li>
        </ul>
      </section>
      <a href="/client/src/pages/StreetlightPage.vue">Retour à l'accueil</a>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        articles: [
          {
            title: "Article 1: Objet",
            content: [
              "Les présentes CGU ou Conditions Générales d’Utilisation encadrent juridiquement l’utilisation des services du site Citizen. Constituant le contrat entre la société Citizen, l’Utilisateur, l’accès au site doit être précédé de l’acceptation de ces CGU. L’accès à cette plateforme signifie l’acceptation des présentes CGU."
            ]
          },
          {
            title: "Article 2 : Mentions légales",
            content: [
              "L'édition du site Citizen est assurée par la société Citizen."
            ]
          },
          {
            title: "Article 3 : Accès au site",
            content: [
              "Le site Citizen permet d'accéder gratuitement aux services suivants :"
            ],
            list: [
              "Accès aux services de transport en commun",
              "Création d'itinéraires et de trajets"
            ]
          },
          {
            title: "Article 4 : Collecte des données",
            content: [
              "Pour la création du compte de l’Utilisateur, la collecte des informations au moment de l’inscription sur le site est nécessaire et obligatoire. Conformément à la loi n°78-17 du 6 janvier relative à l’informatique, aux fichiers et aux libertés, la collecte et le traitement d’informations personnelles s’effectuent dans le respect de la vie privée.",
              "Suivant la loi Informatique et Libertés en date du 6 janvier 1978, articles 39 et 40, l’Utilisateur dispose du droit d’accéder, de rectifier, de supprimer et d’opposer ses données personnelles. L’exercice de ce droit s’effectue par :"
            ],
            list: ["Le formulaire de contact", "Son espace client"]
          },
          {
            title: "Article 5 : Propriété intellectuelle",
            content: [
              "Les marques, logos ainsi que les contenus du site Citizen (illustrations graphiques, textes…) sont protégés par le Code de la propriété intellectuelle et par le droit d’auteur.",
              "La reproduction et la copie des contenus par l’Utilisateur requièrent une autorisation préalable du site. Dans ce cas, toute utilisation à des usages commerciaux ou à des fins publicitaires est proscrite."
            ]
          },
          {
            title: "Article 6 : Cookies",
            content: [
              "Lors des visites sur le site, l’installation automatique d’un cookie sur le logiciel de navigation de l’Utilisateur peut survenir.",
              "Les cookies correspondent à de petits fichiers déposés temporairement sur le disque dur de l’ordinateur de l’Utilisateur. Ces cookies sont nécessaires pour assurer l’accessibilité et la navigation sur le site. Ces fichiers ne comportent pas d’informations personnelles et ne peuvent pas être utilisés pour l’identification d’une personne.",
              "L’information présente dans les cookies est utilisée pour améliorer les performances de navigation sur le site Citizen.",
              "En naviguant sur le site, l’Utilisateur accepte les cookies. Leur désactivation peut s’effectuer via les paramètres du logiciel de navigation. L'utilisateur peut refuser les cookies via un bandeau disponible lors de la première connexion au site Citizen."
            ]
          },
          {
            title: "Article 7 : Responsabilité",
            content: [
              "Bien que les informations publiées sur le site soient réputées fiables, le site se réserve la faculté d’une non-garantie de la fiabilité des sources.",
              "Les informations diffusées sur le site Citizen sont présentées à titre purement informatif et sont sans valeur contractuelle. En dépit des mises à jour régulières, la responsabilité du site ne peut être engagée en cas de modification des dispositions administratives et juridiques apparaissant après la publication. Il en est de même pour l’utilisation et l’interprétation des informations communiquées sur la plateforme.",
              "Le site décline toute responsabilité concernant les éventuels virus pouvant infecter le matériel informatique de l’Utilisateur après l’utilisation ou l’accès à ce site.",
              "Le site ne peut être tenu pour responsable en cas de force majeure ou du fait imprévisible et insurmontable d’un tiers.",
              "La garantie totale de la sécurité et la confidentialité des données n’est pas assurée par le site. Cependant, le site s’engage à mettre en œuvre toutes les méthodes requises pour le faire au mieux.",
              "Le site ne peut être tenu pour responsable en cas de retard causé par la force majeure ou en raison de catastrophes naturelles. Le site ne peut aussi être tenu pour responsable en cas de retard ou annulation dus à l'intervention d'un tiers."
            ]
          },
          {
            title: "Article 8 : Durée du contrat",
            content: [
              "Le présent contrat est valable pour une durée indéterminée. Le début de l’utilisation des services du site marque l’application du contrat à l’égard de l’Utilisateur.",
              "L'utilisateur peut à tout moment résilier son compte et ses données seront supprimées en fonction. L'utilisateur peut supprimer son compte en cliquant sur le bouton supprimer le profil situé dans l'onglet **Paramètres**"
            ]
          },
          {
            title: "Article 9 : Droit applicable et juridiction compétente",
            content: [
              "Le présent contrat est soumis à la législation française. La résolution du litige peut être accordée via une résolution à l'amible. L’absence de résolution à l’amiable des cas de litige entre les parties implique le recours aux tribunaux français compétents pour régler le contentieux."
            ]
          }
        ]
      };
    }
  };
  </script>
  
  <style scoped>
  .cgu {
    padding: 10px;
  }
  
  h1, h2 {
    display: inline;
    color: rgb(75 85 99);
    margin: 20px;
    font-weight: bolder;
    align-items: center;
  }
  
  ul {
    margin: 20px;
  }
  
  p {
    margin: 20px;
  }

  a{
    position: relative;
    background-color: rgb(75 85 99);
    padding: 8px 4px;
    border-radius: 8px;
    color: azure;
    bottom: 0;
    left: 870px;
  }

  </style>
  