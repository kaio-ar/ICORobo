package kr;

import robocode.*;
import java.awt.Color;

/**
 * SilvioSantos - Robô integrado
 */
public class SilvioSantos extends Robot {

    public void run() {

        // CORES DO ROBÔ
        setColors(Color.black, Color.red, Color.white);

        // LOOP PRINCIPAL
        while (true) {

            // Anda para frente com pequena variação
            ahead(100 + (int)(Math.random() * 100));

            // Vira um pouco
            turnRight(90);

            // Procura inimigos
            turnGunRight(360);
        }
    }

    /**
     * Executado quando encontra um inimigo
     */
    public void onScannedRobot(ScannedRobotEvent e) {

        // Se inimigo estiver perto, usa tiro mais forte
        if (e.getDistance() < 100) {

            fire(2);

        } else {

            // Senão economiza energia
            fire(1);
        }

        // Gira um pouco o canhão
        turnGunRight(15);
    }

    /**
     * Executado quando leva tiro
     */
    public void onHitByBullet(HitByBulletEvent e) {

        // Movimento evasivo simples
        back(50);

        // Muda direção
        turnRight(45);
    }

    /**
     * Executado quando bate na parede
     */
    public void onHitWall(HitWallEvent e) {

        // Recua
        back(80);

        // Vira para sair da parede
        turnRight(90);
    }
}
