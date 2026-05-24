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