package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.StoneBotHardware;

public class StoneBotRobot {
    StoneBotHardware myself = new StoneBotHardware();
    boolean moving;
    public void initRobot() {
        moving = false;
    }

    public void drive (double lpower, double rpower) {
        myself.rightDrive.setPower(rpower);
        myself.leftDrive.setPower(lpower);
        moving = true;
    }

    public void DriveReverse(double power) {
        drive(-power, -power);
    }

    public void DriveForward(double power) {
        drive(power, power);
    }

    public void DriveLeft(double power) {
        drive(-power,power);
    }

    public void DriveRight(double power) {
        drive(power,-power);
    }

    public void DriveStop() {
        myself.leftDrive.setPower(0);
        myself.rightDrive.setPower(0);
        moving = false;
    }

    public boolean IsMoving() {
        return moving;
    }


}
