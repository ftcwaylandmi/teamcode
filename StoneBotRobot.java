package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.DemoBotHardware;
import com.qualcomm.robotcore.util.ElapsedTime;


public class StoneBotRobot {
    StoneBotHardware myself = new StoneBotHardware();
    boolean moving;

    double hookServoSpeed = 1;
    double winchServoSpeed = 1;

    double grabServoMax = 0.6;
    double grabServoMin = -1;

    private int elevatordistance = 1230; //Still need to work on.
    private int startingencodervalueE = 0;
    private int maxelevator = 0;

    private int slidedistance = 0; //not ready
    private int startingencodervalueS = 0;
    private int maxslide = 0;

    private int InchesPerSecond = 2;
    private int DegreesPerSecond = 1;

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
        startingencodervalueE = myself.eleMotor.getCurrentPosition();
        maxelevator = startingencodervalueE - elevatordistance;

        startingencodervalueS = myself.slideMotor.getCurrentPosition();
        maxslide = startingencodervalueS - slidedistance;

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

    public void eleServoIn(double Power) {

        if ((myself.eleMotor.getCurrentPosition() < maxelevator) && (Power < 0)){
            myself.eleMotor.setPower(0);
        } else if (( myself.eleMotor.getCurrentPosition() > startingencodervalueE) && (Power >0)){
            myself.eleMotor.setPower(0);
        } else {
            myself.eleMotor.setPower(Power/4);
        }

    }

    public void slideMotorMax(double Power) {

        if ((myself.slideMotor.getCurrentPosition() < maxslide) && (Power < 0)){
            myself.slideMotor.setPower(0);
        } else if (( myself.slideMotor.getCurrentPosition() > startingencodervalueS) && (Power >0)){
            myself.slideMotor.setPower(0);
        } else {
            myself.slideMotor.setPower(Power/2);
        }

    }

    public void grabServoGoToMax() {
        myself.grabServo.setPosition(grabServoMax);
    }

    public void grabServoGoToMin() {
        myself.grabServo.setPosition(grabServoMin);
    }

    /*public void slideMotor(double power) {
        if (myself.InMaxSensor.getState()==false && power>0) {
            power = 0;
        }
        if (myself.InMinSensor.getState()==false && power<0) {
            power = 0;
        }
        myself.slideMotor.setPower(power);
    }*/

    public void DriveByInches( int inches) {
        int waitTime = 0;
        if (inches > 0) {
            waitTime = inches * InchesPerSecond;
            myself.leftDrive.setPower(1);
            myself.leftrearDrive.setPower(1);
            myself.rightDrive.setPower(1);
            myself.rightrearDrive.setPower(1);
        } else {
               waitTime = -inches * InchesPerSecond;
            myself.leftDrive.setPower(-1);
            myself.leftrearDrive.setPower(-1);
            myself.rightDrive.setPower(-1);
            myself.rightrearDrive.setPower(-1);
        }
        ElapsedTime timer =  new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < waitTime) {

        }
        myself.leftDrive.setPower(0);
        myself.leftrearDrive.setPower(0);
        myself.rightDrive.setPower(0);
        myself.rightrearDrive.setPower(0);

    }

    public void TurnByDegrees( int degrees) {
        int waitTime = 0;
        if (degrees > 0) {
            waitTime = degrees * DegreesPerSecond;
            myself.leftDrive.setPower(1);
            myself.leftrearDrive.setPower(1);
            myself.rightDrive.setPower(1);
            myself.rightrearDrive.setPower(1);
        } else {
               waitTime = -degrees * DegreesPerSecond;
            myself.leftDrive.setPower(-1);
            myself.leftrearDrive.setPower(-1);
            myself.rightDrive.setPower(-1);
            myself.rightrearDrive.setPower(-1);
        }

        ElapsedTime timer =  new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < waitTime) {

        }
        myself.leftDrive.setPower(0);
        myself.leftrearDrive.setPower(0);
        myself.rightDrive.setPower(0);
        myself.rightrearDrive.setPower(0);

    }
}