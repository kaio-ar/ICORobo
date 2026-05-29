package kr;

import robocode.*;
import java.awt.Color;

/**
 * SilvioSantos - Robô integrado
 *
 * Robô híbrido que combina características de dois robôs:
 * - SilvioSantos (original)
 * - DORA_AVENTURADA_2
 *
 * Funcionalidades:
 * - Radar independente da arma, para melhor rastreamento
 * - Arma independente do corpo, permitindo atirar enquanto se move
 * - Movimento contínuo com alternância de direção para evasão
 * - Ajuste automático de potência de tiro com base na distância do inimigo
 * - Evita colisão com paredes e outros robôs
 * - Normalização de ângulos para facilitar cálculo de direção
 */
public class SilvioSantos extends AdvancedRobot {

    /**
     * Controla a direção atual do robô.
     * true = movendo para frente
     * false = movendo para trás
     */
    private boolean movingForward = true;

    /**
     * Método principal executado ao iniciar a batalha.
     * Configura cores, independência de radar e arma,
     * e entra em loop de movimento contínuo.
     */
    public void run() {

        // =========================
        // CONFIGURAÇÃO DAS CORES
        // =========================
        setColors(Color.black, Color.red, Color.white); // corpo, arma, radar

        // =========================
        // CONFIGURAÇÕES AVANÇADAS
        // =========================

        // Radar independente da arma
        setAdjustRadarForGunTurn(true);

        // Arma independente do corpo
        setAdjustGunForRobotTurn(true);

        // Radar girando continuamente para detectar inimigos
        setTurnRadarRight(Double.POSITIVE_INFINITY);

        // =========================
        // LOOP PRINCIPAL DE MOVIMENTO
        // =========================
        while (true) {

            // Alterna movimento entre frente e ré
            if (movingForward) {
                setAhead(150);
            } else {
                setBack(150);
            }

            // Executa todas as ações pendentes (movimento, giro de radar/arma)
            execute();
        }
    }

    /**
     * Executado quando o robô detecta um inimigo.
     * Controla radar, arma, potência de tiro e movimento tático.
     *
     * @param e Evento que contém informações do inimigo escaneado
     */
    public void onScannedRobot(ScannedRobotEvent e) {

        // =========================
        // TRAVAMENTO DO RADAR NO INIMIGO
        // =========================
        double radarTurn = getHeading() + e.getBearing() - getRadarHeading();
        setTurnRadarRight(radarTurn * 2); // Mantém radar focado no inimigo

        // =========================
        // ALINHAMENTO DA ARMA
        // =========================
        double absoluteBearing = getHeading() + e.getBearing();
        double gunTurn = absoluteBearing - getGunHeading();
        setTurnGunRight(normalizeBearing(gunTurn)); // Normaliza ângulo para evitar giros excessivos

        // =========================
        // POTÊNCIA DO TIRO
        // =========================
        double distance = e.getDistance();
        double firePower = Math.min(3, Math.max(1, 400 / distance)); // Ajusta força do tiro conforme distância

        if (getGunHeat() == 0) { // Só atira se a arma estiver pronta
            fire(firePower);
        }

        // =========================
        // MOVIMENTO TÁTICO
        // =========================
        if (distance < 150) { // Se o inimigo estiver muito próximo
            setBack(100); // Recuar para evasão
        } else {
            setAhead(100); // Aproxima ou mantém distância segura
        }
    }

    /**
     * Executado quando o robô é atingido por um tiro inimigo.
     * Alterna direção e realiza movimento evasivo.
     *
     * @param e Evento de recebimento de tiro
     */
    public void onHitByBullet(HitByBulletEvent e) {

        // Alterna direção para confundir o inimigo
        movingForward = !movingForward;

        // Giro evasivo
        setTurnRight(45);

        // Executa movimento de evasão
        if (movingForward) {
            setAhead(120);
        } else {
            setBack(120);
        }
    }

    /**
     * Executado quando o robô colide com uma parede.
     * Alterna direção e afasta-se da parede.
     *
     * @param e Evento de colisão com parede
     */
    public void onHitWall(HitWallEvent e) {

        // Alterna direção
        movingForward = !movingForward;

        // Recuo para evitar ficar preso
        setBack(100);

        // Giro para sair do canto
        setTurnRight(90);
    }

    /**
     * Executado quando o robô colide com outro robô.
     * Atira em curta distância e alterna direção para evitar bloqueio.
     *
     * @param e Evento de colisão com outro robô
     */
    public void onHitRobot(HitRobotEvent e) {

        // Disparo potente em curta distância
        fire(3);

        // Alterna direção para evitar ficar preso
        movingForward = !movingForward;

        // Afasta-se do inimigo
        setBack(80);
    }

    /**
     * Normaliza um ângulo para o intervalo entre -180 e 180 graus.
     * Útil para cálculos de giro da arma, radar e robô.
     *
     * @param angle Ângulo em graus a ser normalizado
     * @return Ângulo normalizado entre -180 e 180
     */
    private double normalizeBearing(double angle) {

        while (angle > 180) {
            angle -= 360;
        }

        while (angle < -180) {
            angle += 360;
        }

        return angle;
    }
}
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
