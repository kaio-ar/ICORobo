package kr;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * SilvioSantos - a robot by (your name here)
 */
public class SilvioSantos extends Robot
{
	/**
	 * run: SilvioSantos's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.black,Color.red,Color.white); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			
			// robo anda para frente
			ahead(150);

			// robo para a esquerda
			turnRight(90);

			// robo gira canhao procurando inimigos
			turnGunRight(360);

			// robo anda para tras
			back(100);

			// robo vira para a esquerda
			turnLeft(45);
			
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	
	// 
	public void onScannedRobot(ScannedRobotEvent e) {
		
		// dispara um tiro 1 para economizar energia
		fire(1);
		
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
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {

		// Recura para sair da parede
		back(80);
		
		// Vira para tentar encontrar outro caminho
		turnRight(90);
	}	
}
