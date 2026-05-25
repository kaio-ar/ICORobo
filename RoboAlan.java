import robocode.*;
import robocode.util.Utils;

import java.awt.*;
import java.awt.geom.Point2D;
package robo_alan.ICORobo;
public class RoboAlan extends AdvancedRobot {

    double enemyEnergy = 100;

    int moveDirection = 1;

    double[] guessFactors = new double[31];

    public void run() {

        setBodyColor(Color.black);
        setGunColor(Color.red);
        setRadarColor(Color.cyan);
        setBulletColor(Color.yellow);

        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(true);

        while (true) {

            turnRadarRight(360);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {

        double absBearing =
                getHeadingRadians()
                + e.getBearingRadians();

        // =========================
        // WAVE SURFING SIMPLIFICADO
        // =========================

        double energyDrop =
                enemyEnergy - e.getEnergy();

        if (energyDrop > 0
                && energyDrop <= 3) {

            // inimigo atirou
            moveDirection *= -1;

            setAhead((150 + Math.random() * 100)
                    * moveDirection);

            setTurnRightRadians(
                    Utils.normalRelativeAngle(
                            absBearing
                            + (Math.PI / 2 * moveDirection)
                            - getHeadingRadians()));
        }

        enemyEnergy = e.getEnergy();

        // =========================
        // GUESS FACTOR SIMPLIFICADO
        // =========================

        int bestIndex = 15;

        for (int i = 0; i < guessFactors.length; i++) {

            if (guessFactors[i]
                    > guessFactors[bestIndex]) {

                bestIndex = i;
            }
        }

        double guessFactor =
                (double)(bestIndex - 15) / 15.0;

        double bulletPower = 2.0;

        double maxEscapeAngle =
                Math.asin(8.0
                        / (20 - 3 * bulletPower));

        double angleOffset =
                moveDirection
                * guessFactor
                * maxEscapeAngle;

        double gunAdjust =
                Utils.normalRelativeAngle(
                        absBearing
                        - getGunHeadingRadians()
                        + angleOffset);

        setTurnGunRightRadians(gunAdjust);

        // =========================
        // TIRO
        // =========================

        if (getGunHeat() == 0
                && Math.abs(getGunTurnRemaining())
                < 10) {

            setFire(bulletPower);
        }

        // =========================
        // RADAR LOCK
        // =========================

        double radarAdjust =
                Utils.normalRelativeAngle(
                        absBearing
                        - getRadarHeadingRadians());

        setTurnRadarRightRadians(radarAdjust * 2);

        // =========================
        // APRENDIZADO SIMPLES
        // =========================

        int index =
                (int)(15 + (Math.random() * 6 - 3));

        if (index >= 0
                && index < guessFactors.length) {

            guessFactors[index] += 1.0;
        }

        execute();
    }

    public void onHitWall(HitWallEvent e) {

        moveDirection *= -1;

        setAhead(150 * moveDirection);
    }

    public void onHitByBullet(HitByBulletEvent e) {

        moveDirection *= -1;

        setAhead((100 + Math.random() * 100)
                * moveDirection);
    }
}

