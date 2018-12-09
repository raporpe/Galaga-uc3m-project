package src;

import edu.uc3m.game.GameBoardGUI;

public class Commander extends Enemy{
	
	
	private int damageCount;
	
	
	public Commander(int id, GameBoardGUI board){
		
		super(id, board, "enemy1G0.png" , "enemy1G1.png");
		
	}
	
	
	

	//Getters and setters
	public int getDamageCount() {
		return damageCount;
	}
	
		@Override
		public void moveToNextPosition() {
		
		//crear variable random entre 50 for example, cada vez que se desplaza selecciona uno de esos 50. Si
		// coincide con un movimiento diferente se ejecuta ESE movimiento. Si no coincide con ninguno, usa el predeterminado.
		//WARNING: En el caso de ejecutar un mov. especial, no se podra escoger otro num hasta que no se haya acabado de ejecutar el movimiento.
		int numMovement=0;
		
		//4 tipos de movimiento:
		
		// SI NO COINCIDE
		// El predeterminado que es cuando se mueve la pandilla a la derecha, baja un escalon y vuelve a la izq.
		if(right==true) {
			x++;

		}
		if(getX()==Game.BOARD_WIDTH-55) {
			y+=5;
			right=false;

		}
		if(right==false) {
			x--;

		}
		if(getX()==25) {
			y+=5;
			right=true;
		}
		
		//SI COINCIDE CON 10, por ejemplo.
		//El ZIG ZAG. Moverse hacia abajo derecha hasta un bound y rebotar (usando las mismas x que en el anterior pero sentido opuesto).
		//Cambio de sprites dependiendo de su coordenada
		
		//--------   EN REMODELACIÓN    ------------
		
		
		//SI COINCIDE CON 20, por ejemplo.
		//LA VUELTA. Moverse en un circulo, luego seguir al frente. Sigue unas coordenadas especificas de CONSTANTS.
		//Cambio de sprites dependiendo de su coordenada

		//--------   EN REMODELACIÓN    ------------

		//SI COINCIDE CON 30, por ejemplo.
		//RECTO Y DISPARO. Moverse para adelante, el eje Y en el que esté y disparar en unas Y especificas.
		
		//LA VUELTA. Moverse en un circulo, luego seguir al frente. Sigue unas coordenadas especificas de CONSTANTS.
		//Se deja el cambio de sprite de defecto.
	}


	public void setDamageCount(int damageCount) {
		this.damageCount = damageCount;
	}
}
