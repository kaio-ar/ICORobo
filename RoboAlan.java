package kr;
import robocode.*;
import java.awt.Color;


public class SilvioSantos extends Robot {

    public void run() {

        // CORES DO ROBO
        
        setColors(Color.black, Color.red, Color.white);

        // LOOP PRINCIPAL, EXECUTA OS COMANDO ABAIXO SEM PARAR
        
        while (true) {

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

       // Se estiver perto, atira com força maxima para causar maior dano
       
	if (e.getDistance() < 150) {
    		fire(3);
	} 

	// Senão, dá um tiro fraco para economizar energia	

	else {
    		fire(1);
   	 }

    //QUANDO BATE NA PAREDE
	
    public void onHitWall(HitWallEvent e) {

        
        back(80);

        turnRight(120);
    }

    // QUANDO FOR ATINGIDO
    public void onHitByBullet(HitByBulletEvent e) {

        // Movimenta para escapar dos tiros
        
        ahead(50);


        turnLeft(45);
        
        // Contra-ataca com um disparo forte
        
        fire(2);
    }
}
