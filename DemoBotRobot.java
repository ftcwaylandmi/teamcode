package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.DemoBotHardware;

public class DemoBotRobot{
    DemoBotHardware myself = new DemoBotHardware();
    boolean moving;
    public void  initrobot(){
        moving=false;
}
    public void drive (double lpower, double rpower){
    myself.rightDrive.setPower(rpower);
    myself.leftDrive.setPower(lpower);
    moving=true;
    }
    public void DriveReverse(double power) {
        drive(-power, -power);
    }
    public void DriveForward(double power) {
        drive(power, power);
    }

    public void DriveLeft(double power) {
        drive(-power, power);
    }

    public void DriveRight(double power) {
        drive(power, -power);
    }

    public void DriveStop() {
        myself.leftDrive.setPower(0);
        myself.rightDrive.setPower(0);
        moving = false;
    }

    public boolean ISMoving() {
        return moving;
    }
}
