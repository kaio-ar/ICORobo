package kr;
import robocode.*;
import java.awt.Color;


<<<<<<< HEAD:nossorobo/SilvioSantos.java
/**
 * SilvioSantos - a robot by (your name here)
 */
public class SilvioSantos extends Robot
{
	
	// run: SilvioSantos's default behavior
	
	public void run() {
		// Initialization of the robot should be put here
=======
public class SilvioSantos extends Robot {
>>>>>>> alan:robokaio/SilvioSantos.java

    public void run() {

        // CORES DO ROBO
        setColors(Color.black, Color.red, Color.white);

<<<<<<< HEAD:nossorobo/SilvioSantos.java
		// Robot main loop
		while(true) {
						
			// robo anda para frente
			ahead(100 + (int)(Math.random() * 100));
=======
        // LOOP PRINCIPAL, EXECUTA OS COMANDO ABAIXO SEM PARAR
        while (true) {
>>>>>>> alan:robokaio/SilvioSantos.java

            // Anda para frente
            ahead(100);

            // Vira um pouco
            turnRight(90);

            // Procura inimigos
            turnGunRight(360);
        }
    }

   // QUANDO ENCONTRAR UM INIMIGO
   
    public void onScannedRobot(ScannedRobotEvent e) {

<<<<<<< HEAD:nossorobo/SilvioSantos.java
	
	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	
		

	public void onScannedRobot(ScannedRobotEvent e) {
		
		/** Caso inimigo a menos de 100 un, dispara tiro 2.
		* Senão, dispara um tiro 1 para economizar energia.
		*/
		if (e.getDistance() < 100) {
			fire(2);
		} else {
			fire(1);
		}
				
		// gira um pouco o canhão
		turnGunRight(15);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		
		// Evasão - anda para trás
		back(50);
		
		// Vira um pouco para mudar de direção
		turnRight(45);
	}
	
	/**
	 * onHitWall: Recua 100un, vira direita 120un, avança 50un
	 */
	public void onHitWall(HitWallEvent e) {

		// Recura para sair da parede
		back(80);
		
		// Vira para tentar encontrar outro caminho
		turnRight(90);
		
	
	}	
}
=======
        fire(1);
    }

    //QUANDO BATE NA PAREDE
	
    public void onHitWall(HitWallEvent e) {

        
        back(50);

        turnRight(90);
    }

    // QUANDO FOR ATINGIDO
    public void onHitByBullet(HitByBulletEvent e) {

        
        ahead(50);


        turnLeft(45);
    }
}
>>>>>>> alan:robokaio/SilvioSantos.java
