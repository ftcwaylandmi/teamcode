  package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.SlideBotHardware;

public class SlideBotRobot {
    SlideBotHardware myself = new SlideBotHardware();
    boolean moving;

    public void  initrobot(){
        moving=false;
    }
    public void drive (double lpower, double rpower){
        myself.rightDrive.setPower(rpower);
        myself.rightrearDrive.setPower(rpower);
        myself.leftDrive.setPower(lpower);
        myself.leftrearDrive.setPower(lpower);
        moving=true;
    }

    public void initHW(HardwareMap ahwMap) {
        myself.init(ahwMap);

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

    public void RightDrive(double power){
        myself.rightDrive.setPower(power);
        myself.rightrearDrive.setPower(power);
    }

    public void LeftDrive(double power){
        myself.leftDrive.setPower(power);
        myself.leftrearDrive.setPower(power);
    }


    public void slide(double power){
        myself.rightrearDrive.setPower(-power);
        myself.rightDrive.setPower(power);
        myself.leftrearDrive.setPower(power);
        myself.leftDrive.setPower(-power);

    }
}
