
public class MenuBiblio {
	private Bibliotheque _bibliotheque;
	
	public MenuBiblio (Bibliotheque bibliotheque) {
	_bibliotheque = bibliotheque;
	}
	
	/*
	 * menuPrincipal permet � l'utilisateur de selectionner un type de sous menu (Reader, Ouvrage ou Exemplaire)
	 * o� il effectuera par la suite l'action d�sir�e. Si l'utilisateur a fini d'utiliuser le programme, il choisit l'option Quitter.
	*/
public void menuPrincipal() {
	Integer menu;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("|                   Menu Principal                       |");
		EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
		EntreesSorties.afficherMessage("| Menu Reader : 1                                       |");
		EntreesSorties.afficherMessage("| Menu Book : 2                                         |");
		EntreesSorties.afficherMessage("| Quitter : 0                                            |");
		EntreesSorties.afficherMessage(" ========================================================");
		menu = EntreesSorties.lireEntier();
			
			switch (menu){
				case 1 : {
					this.menuLecteur();
					break;
				}
				case 2:{
					this.menuBook();
				}
				
				default : {
					break;
				}
			}
	} while (menu != 0);	
}

	/* menuLect permet d'effectuer une s�rie d'action concernant les utilisateur (lecteurs) de la biblioth�que.
	 * Une fois une action effectu�e, l'utilisateur sera rediriger vers ce m�me menu afin de pouvoir selectionner
	 * une nouvelle fois une action concernant les lecteurs.
	 * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
	*/
public void menuLecteur() {
	Integer menuLect;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouveau Reader : 1                                    |");
		EntreesSorties.afficherMessage("| Consulter Reader : 2                                  |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuLect = EntreesSorties.lireEntier();
			
			switch (menuLect){
				case 1 : {
					_bibliotheque.newReader();
					break;
				}
				case 2 : {
					_bibliotheque.consulterReader();
					break;
				}
				default : {
					break;
				}
			}
	} while (menuLect != 0);	
}

	public void menuBook() {
		Integer menuBook;
		do {
			EntreesSorties.afficherMessage(" ========================================================");
			EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
			EntreesSorties.afficherMessage("| Ajout d'un livre : 1                                   |");
			EntreesSorties.afficherMessage("| Consulter nb exemplaire : 2                            |");
			EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
			EntreesSorties.afficherMessage(" ========================================================");
			menuBook = EntreesSorties.lireEntier();

			switch (menuBook){
				case 1 : {
					//quelquechose
					break;
				}
				case 2 : {
					//quelquechose
					break;
				}
				default : {
					break;
				}
			}
		} while (menuBook != 0);
	}
}

