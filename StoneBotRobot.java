package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.DemoBotHardware;

public class StoneBotRobot {
    StoneBotHardware myself = new StoneBotHardware();
    boolean moving;

    double hookServoSpeed = 1;

    double grabServoMax = 0.6;
    double grabServoMin = -1;

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

    public void hookServoGoToMax(){
        myself.hookServo.setPower(hookServoSpeed);
    }
    public void hookServoStop() {
        myself.hookServo.setPower(0);
    }

    public void hookServoGoToMin() {
        myself.hookServo.setPower(-hookServoSpeed);
    }

    public void slideServoIn(double Power) {
        myself.slideServo.setPower(Power);
    }

    public void slideServoOut(double Power)  {
        myself.slideServo.setPower(Power);
    }

    public void eleServoIn(double Power) {
        myself.eleServo.setPower(Power);
    }

    public void eleServoOut(double Power) {
        myself.eleServo.setPower(-Power);
    }

    public void grabServoGoToMax() {
        myself.grabServo.setPosition(grabServoMax);
    }

    public void grabServoGoToMin() {
        myself.grabServo.setPosition(grabServoMin);
    }

    public void grabServoStop() {
        myself.grabServo.setPosition(0);
    }

}