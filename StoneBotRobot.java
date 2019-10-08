package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.StoneBotHardware;

public class StoneBotRobot {
    StoneBotHardware myself = new StoneBotHardware();

    boolean moving;

    public void initHW(HardwareMap ahwMap) {
        myself.init(ahwMap);
        moving = false;
    }

    public void RightDrive(double power){
        myself.rightfrontDrive.setPower(power);
        myself.rightbackDrive.setPower(power);
    }

    public void LeftDrive(double power){
        myself.leftfrontDrive.setPower(power);
        myself.leftbackDrive.setPower(power);
    }

    public void DriveStop() {
        myself.leftfrontDrive.setPower(0);
        myself.rightfrontDrive.setPower(0);
        myself.leftbackDrive.setPower(0);
        myself.rightbackDrive.setPower(0);
        moving = false;
    }

    public boolean IsMoving() {
        return moving;
    }

    public void hookServoGotoPosition(double position){
        myself.hookServo.setPosition(position);
    }
    public void hookServoGotoMin(){
        myself.hookServo.setPosition(myself.hookServoMin);
    }
    public void hookServoGotoMax() {
        myself.hookServo.setPosition(myself.hookServoMax);
    }
    public void grabServoGotoPosition(double position){
        myself.hookServo.setPosition(position);
    }
    public void grabServoGotoMin(){
        myself.grabServo.setPosition(myself.grabServoMin);
    }
    public void grabServoGotoMax(){
        myself.grabServo.setPosition(myself.grabServoMax);
    }


}
