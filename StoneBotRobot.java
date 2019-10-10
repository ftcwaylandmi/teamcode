package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.DemoBotHardware;

public class StoneBotRobot {
    StoneBotHardware myself = new StoneBotHardware();
    boolean moving;
    double hookServoMax = 1;
    double hookServoSpeed = 1;
    double slideServoSpeed = 0.5;
    double grabServoMax = 1;
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

    double ServoGoToMIN = 0;

    public void ServoGoToMIN() {
        double ServoGoToMIN = 0;
    }

    public void ServoGoToMAX() {
        double ServoGotoMax = 0;
    }

    public void hookServoGoToMax(){
        //myself.hookServo.setPosition(hookServoMax);
        myself.hookServo.setPower(hookServoSpeed);

    }
    public void hookServoStop() {
        myself.hookServo.setPower(0);
    }

    public void hookServoGoToMin() {
        myself.hookServo.setPower(-hookServoSpeed);
    }

    public void slideServoIn() {
        myself.slideServo.setPower(slideServoSpeed);
    }

    public void slideServoOut()  {
        myself.slideServo.setPower(-slideServoSpeed);
    }

    public void slideServoStop() {
        myself.slideServo.setPower(0);
    }

    public void grabServoGoToMax(){
        myself.grabServo.setPosition(grabServoMax);
    }

    public void hookServoGoToPosition(double pos){
        //myself.hookServo.setPosition(pos);
    }

    public void grabServoGoToPosition(double pos){
        myself.grabServo.setPosition(pos);
    }
}