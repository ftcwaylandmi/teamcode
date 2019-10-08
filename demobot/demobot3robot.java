package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.demo3hardware;


public class demobot3robot {

    boolean moving;
    demo3hardware myself = new demo3hardware();

    public void initrobot() {
        moving = false;
    }

    private void drive(double lpower, double rpower) {
        myself.rightDrive.setPower(rpower);
        myself.leftDrive.setPower(lpower);
        moving = true;
    }

    public void DriveReverse(double power) {
        drive(-power, -power);
    }

    public void driveStop() {
        myself.leftDrive.setPower(0);
        myself.leftDrive.setPower(0);

    }

    public void DriveForward(double power) {
        drive(power, power);
    }

    public void DriveLeft(double power) {
        drive(-power, power);
    }

    public void Driveright(double power) {
        drive(power, -power);
    }

    public boolean IsMoving() {
        return moving;
    }

}
