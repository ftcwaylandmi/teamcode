package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RuckusBotHardware;

public class RuckusBotRobot {
    RuckusBotHardware myself = new RuckusBotHardware();
    boolean moving;
    public double pinServoMax = 1;
    public double pinServoMin = 0;
    public void  initrobot(){
        moving=false;
    }
    public void drive (double lpower, double rpower){
        myself.rightDrive.setPower(rpower);
        myself.leftDrive.setPower(lpower);
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

    public void ArmUp() {
        myself.armDrive.setPower(1);
        moving = false;
    }

    public void ArmDown(){
        myself.armDrive.setPower(-1);
        moving = false;
    }


    public boolean ISMoving() {
        return moving;
    }

    public void RightDrive(double power){
        myself.rightDrive.setPower(power);
    }

    public void LeftDrive(double power){
        myself.leftDrive.setPower(power);
    }

}