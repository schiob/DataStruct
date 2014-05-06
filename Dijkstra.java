/**
 * Algoritmo: Dijkstra
 * Basado en el código de: Jhosimar George Arias Figueroa
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Dijkstra {
	//Definimos constantes y variables globales
	static final int INF = 1000000000;
	static final int MAX = 10000;
	
	//Clase de cada vertice (parecido al pair de c++) con una implementación para poder utilizarla en el PRiority Queue
	static class Node implements Comparable<Node>{
		int first, second;
		//first representa el id de este nodo adyacente, el peso es el de la arista
		Node(int idAd, int peso){
			first = idAd;
			second = peso;
		}
		public int compareTo(Node otro){
			if(second > otro.second) return 1;
			if(second == otro.second) return 0;
			return -1;
		}
	}
	
	static List<List<Node>> ady = new ArrayList<List<Node>>(); //La lista de adyacecia
	static int distancia[] = new int[MAX]; 					   //distancia[i] = distancia de vertice inicial al vertice i
	static boolean visitado[] = new boolean[MAX];			   //lista de vertices vicitados
	static PriorityQueue<Node> Q = new PriorityQueue<Node>();  //cola ordenada con el compareTo que definimos
	static int V; 											   //numero de vertices
	static int previo[] = new int[MAX];						   //para imprimir
	static Scanner sc = new Scanner(System.in);
	
	
	//función de inicialización
	static void init(){
	    for(int i = 0 ; i <= V ; ++i){
	        distancia[i] = INF;  //inicializamos todas las distancias con valor infinito
	        visitado[i] = false; //inicializamos todos los vértices como no visitados
	        previo[i] = -1;      //inicializamos el previo del vertice i con -1
	    }
	}
	
	//Paso de comparación
	static void comparacion(int actual ,int adyacente ,int peso){
	    //Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al vertice adyacente
	    if( distancia[actual] + peso < distancia[adyacente]){
	        distancia[adyacente] = distancia[actual] + peso;    //relajamos el vertice actualizando la distancia
	        previo[adyacente] = actual;                         //a su vez actualizamos el vertice previo
	        Q.add(new Node(adyacente , distancia[adyacente]));  //agregamos adyacente a la cola de prioridad
	    }
	}
	
	//Impresion del camino mas corto desde el vertice inicial y final ingresados
	static void print( int destino ){
	    if(previo[destino] != -1)    			   //si aun poseo un vertice previo
	        print(previo[destino]);    			   //recursivamente sigo explorando
	    System.out.printf("%d " , destino);        //terminada la recursion imprimo los vertices recorridos
	}
	
	static void dijkstra(int inicial){
		init(); //iniciamos los arreglos
		Q.add(new Node(inicial, 0)); //Insertamos el primer nodo en la cola
		distancia[inicial] = 0; // inicializamos la distacia del nodo inicial a 0
		int actual, adyacente, peso;
		while(!Q.isEmpty()){ //mientras la cola no esté vacía
			actual = Q.element().first;
			Q.remove();
			if(visitado[actual]) continue;
			visitado[actual] = true;
			
			for(int i = 0 ; i < ady.get(actual).size() ; ++i){
				adyacente = ady.get(actual).get(i).first;
				peso = ady.get(actual).get(i).second;
				if(!visitado[adyacente]){
					comparacion(actual, adyacente, peso);
				}
			}
		}
		
		System.out.printf("Distancia más corta iniciando en el vertice %d\n", inicial);
		for(int i = 1 ; i <= V ; ++i){
	    	System.out.printf("Vertice %d , distancia mas corta = %d\n" , i , distancia[i] );
	    }
		System.out.println("\n----------------Ruta de camino más corto-----------------\n");
		System.out.println("vertice destino: ");
		int destino = sc.nextInt();
		print(destino);
		System.out.println();
	}
	
	public static void main(String[] args) {
		int E , origen, destino , peso , inicial;

		V = sc.nextInt();
		E = sc.nextInt();
		for(int i = 0 ; i <= V ; ++i){
			ady.add(new ArrayList<Node>()) ; //inicializamos lista de adyacencia
		}
		for(int i = 0 ; i < E ; ++i){
			origen = sc.nextInt(); destino = sc.nextInt(); peso = sc.nextInt();
			ady.get( origen ).add( new Node( destino , peso ) );    //grafo diridigo
			//ady.get( destino ).add( new Node( destino , peso ) ); //no dirigido
		}
		System.out.print("Ingrese el vertice inicial: ");
	    inicial = sc.nextInt();
	    dijkstra( inicial );
	}

}
