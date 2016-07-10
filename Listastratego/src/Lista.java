import java.util.Random;

//Lista di nodi che rappresentano ciascuno una mossa possibile. 
public class Lista {

	Nodo start;
	int size;
	Nodo iter; // L' iter riparte dall' ultimo nodo messo. è un risparmio di
				// costi. tanto i nodi si mettono sempre in fondo.

	public Lista() { // Si inizializza una lista vuota
		start = null;
		size = 0;
	}

	// Il calcolo delle mosse possibili si fa sempre ad inizio turno,
	// richiamando tot volte il metodo add
	public void add(int piece, int direction, int x, int y, int nFoot) {
		Nodo newNodo = new Nodo(); // Ad ogni nodo si setta gli attributi della
									// mossa (vedi classe nodo)
		newNodo.setPiece(piece);
		newNodo.setDirection(direction);
		newNodo.setX(x);
		newNodo.setY(y);
		newNodo.setCountFoot(nFoot);
		iter = start; // iter è il puntatore che percorre ogni volta la lista al
						// fine di inserire nell' ultima posizione una mossa.
		if (iter == null) { //Condizione se la lista è vuota
			start = newNodo;
			start.next = null;
			size++;
		} else if (start.next == null) { //Condizione se la lista ha un solo elemento
			start.next = newNodo;
			newNodo.next = null;
			size++;
		} else { //Condizione esclusa dalle altre due
			for (iter = start.next; iter.next != null; iter = iter.next) //ciclo per arrivare in fondo alla lista
				;
			iter.next = newNodo;
			size++; //size rappresenta la lunghezza della lista. è un attributo utile.
		}
	}

	public int[] randomSearch() { //Ricerca random usando la classe random
		Random R = new Random();
		int randomNum = R.nextInt(size - 1); // Restituisce un numero tra 0 e size
		iter = start;
		while (randomNum != 0) { //iter scorre la lista finchè non raggiungiamo l' elemento "randomNum"
			randomNum--;
			iter = iter.next;
		}
		int[] v = { iter.getX(), iter.getY(), iter.getCountFoot(), iter.getDirection() };
		return v;

	}

	public int[] searchBestMove(int piece, int destination) // destination serve
															// per l' algoritmo
															// di pathfinding.
	// Rappresenta la destinazione del pezzo che abbiamo deciso in base alla
	// strategia.
	{
		iter = start;
		for (iter = start; iter.next != null; iter = iter.next) {
			if (iter.getPiece() == piece)
				// Qui bisogna richiamare l' algoritmo di pathfinding che
				// ritorna il vettore con la mossa migliore
				// int v[] = path.calcolaMossaMigliore(iter.getX, iter.getY,
				// destination)
				// non essendoci ancora il metodo ne la classe pathfinding metto
				// un break per riempire
				break; // Nel caso di due percorsi migliori allo stesso modo L'
						// ALGORITMO usa un math random per decidersi
		}
		return null;// Alla fine si restituisce il vettore con la mossa da fare,
					// come nel randomSearch
	}

	// La funzione print serve solo per verificare se fo errori durante la
	// scrittura del codice
	// verrà poi eliminata per la consegna finale del progetto (RICORDIAMOCENE)

	/*
	 * public void print() { Nodo iter2 = new Nodo(); iter2 = start; if (iter2
	 * == null) { System.out.println("Lista vuota"); } else if (iter2.next ==
	 * null) { System.out.println(iter2.getPiece());
	 * System.out.print(iter2.getDirection()); } else { while (iter2 != null) {
	 * System.out.print(iter2.getPiece());
	 * System.out.print(iter2.getDirection()); iter2 = iter2.next; } }
	 * System.out.println(size); }
	 */

}
