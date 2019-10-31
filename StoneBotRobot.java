package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.DemoBotHardware;
import com.qualcomm.robotcore.util.ElapsedTime;


public class StoneBotRobot {
    StoneBotHardware myself = new StoneBotHardware();
    private boolean moving;

    double hookServoSpeed = 1;
    double winchServoSpeed = 1;

    double grabServoMax = 1;
    double grabServoMin = -1;

    private int elevatordistance = 1230; //Still need to work on.
    private int startingencodervalueE = 0;
    private int maxelevator = 0;

    private int slideLoad = -45;
    private int slidedistance = -672;
    private int startingencodervalueS = 0;
    private int maxslide = 0;
    private int hookservoTime = 2050;

    private int eleheightClearBlock = -112;
    private int eleheightOnBlock = -36;

    private double InchesPerSecond = .33;
    private double DegreesPerSecond = .46;

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
        maxslide = startingencodervalueS + slidedistance;

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

    public void hookServoDown() {
        myself.hookServo.setPower(-1);

        ElapsedTime timer =  new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < hookservoTime) {

        }
        myself.hookServo.setPower(0);
    }


    public void hookServoUp() {
        myself.hookServo.setPower(1);

        ElapsedTime timer =  new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < hookservoTime) {

        }
        myself.hookServo.setPower(0);
    }

    public void wait(int sleeptime) {
        ElapsedTime timer =  new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < sleeptime) {

        }
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

    public void eleClearBlockHeight() {
        myself.eleMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        int tg = startingencodervalueE + eleheightClearBlock;
        myself.eleMotor.setTargetPosition(tg);
        myself.eleMotor.setPower(1);
        myself.eleMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void eleDropToBlock() {
        myself.eleMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        int tg = startingencodervalueE + eleheightOnBlock;
        myself.eleMotor.setTargetPosition(tg);
        myself.eleMotor.setPower(1);
        myself.eleMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
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

        if ((myself.slideMotor.getCurrentPosition() >= maxslide) && (Power > 0)){
            myself.slideMotor.setPower(0);
        } else if (( myself.slideMotor.getCurrentPosition() <= startingencodervalueS) && (Power <0)){
            myself.slideMotor.setPower(0);
        } else {
            myself.slideMotor.setPower(Power*0.75);
        }

    }

    public void slideToLoad() {

        myself.slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        int dest = myself.slideMotor.getCurrentPosition() + slideLoad;
        myself.slideMotor.setTargetPosition(dest);
        myself.slideMotor.setPower(1);
        myself.slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void slideToMax() {
        myself.slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        int dest = myself.slideMotor.getCurrentPosition() + slidedistance + 200;
        myself.slideMotor.setTargetPosition(dest);
        myself.slideMotor.setPower(1);
        myself.slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void slideToReset() {
        eleClearBlockHeight();
        wait(300);
        myself.slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        myself.slideMotor.setTargetPosition(startingencodervalueS);
        myself.slideMotor.setPower(1);
        myself.slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        wait(300);
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
        moving = true;
        double power = 1;
        double waitTime = 0.00;
        if (inches > 0) {
            power = power * -1;
            waitTime = inches * InchesPerSecond;
            myself.leftDrive.setPower(power);
            myself.leftrearDrive.setPower(power);
            myself.rightDrive.setPower(power);
            myself.rightrearDrive.setPower(power);
        } else {
            waitTime = -inches * InchesPerSecond;
            myself.leftDrive.setPower(power);
            myself.leftrearDrive.setPower(power);
            myself.rightDrive.setPower(power);
            myself.rightrearDrive.setPower(power);
        }
        ElapsedTime timer =  new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < (waitTime* 100)) {

        }
        myself.leftDrive.setPower(0);
        myself.leftrearDrive.setPower(0);
        myself.rightDrive.setPower(0);
        myself.rightrearDrive.setPower(0);
        moving = false;

    }

    public void ArcRight( int arc, boolean holdarmdown) {
        moving = true;
        double power = 1;

        double waitTime = 0;
        if (holdarmdown) {
            myself.hookServo.setPower(-0.15);
        }
            waitTime = arc * InchesPerSecond;
            myself.leftDrive.setPower(-power);
            myself.leftrearDrive.setPower(-power);
            myself.rightDrive.setPower(-power * 0.55);
            myself.rightrearDrive.setPower(-power * 0.55);
            moving = true;


        ElapsedTime timer =  new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < (waitTime*100)) {

        }
        myself.leftDrive.setPower(0);
        myself.leftrearDrive.setPower(0);
        myself.rightDrive.setPower(0);
        myself.rightrearDrive.setPower(0);
        moving = false;

    }

    public void ArcLeft( int arc, boolean holdarmdown) {
        moving = true;
        double power = 1;

        double waitTime = 0;
        if (holdarmdown) {
            myself.hookServo.setPower(-0.15);
        }
        waitTime = arc * InchesPerSecond;
        myself.leftDrive.setPower(-power * 0.35);
        myself.leftrearDrive.setPower(-power * 0.35);
        myself.rightDrive.setPower(-power);
        myself.rightrearDrive.setPower(-power);
        moving = true;


        ElapsedTime timer =  new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < (waitTime*100)) {

        }
        myself.leftDrive.setPower(0);
        myself.leftrearDrive.setPower(0);
        myself.rightDrive.setPower(0);
        myself.rightrearDrive.setPower(0);
        moving = false;

    }

    public void TurnByDegrees( int degrees) {
        moving = true;
        double power = 1;

        double waitTime = 0;
        if (degrees > 0) {
            waitTime = degrees * DegreesPerSecond;
            myself.leftDrive.setPower(-power);
            myself.leftrearDrive.setPower(-power);
            myself.rightDrive.setPower(power);
            myself.rightrearDrive.setPower(power);
        } else {
            waitTime = -degrees * DegreesPerSecond;
            myself.leftDrive.setPower(power);
            myself.leftrearDrive.setPower(power);
            myself.rightDrive.setPower(-power);
            myself.rightrearDrive.setPower(-power);
        }

        ElapsedTime timer =  new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < (waitTime*10)) {

        }
        myself.leftDrive.setPower(0);
        myself.leftrearDrive.setPower(0);
        myself.rightDrive.setPower(0);
        myself.rightrearDrive.setPower(0);
        moving = false;

    }

    public boolean IsMoving (){
        return moving;
    }

    public int CurrentEncoderVal(String encodername ) {
        switch (encodername.toLowerCase()) {
            case "elevator":
                return myself.eleMotor.getCurrentPosition();
            case "slide":
                return myself.slideMotor.getCurrentPosition();
            case "leftmotor":
                return myself.leftDrive.getCurrentPosition();
            case "rightmotor":
                return myself.rightDrive.getCurrentPosition();
            case "rightrear":
                return myself.rightrearDrive.getCurrentPosition();
            case "leftrear":
                return myself.leftrearDrive.getCurrentPosition();
            default:
                return 0;
        }
    }

    public int GetStoredValues(String storeval) {
        switch (storeval.toLowerCase()) {
            case "elevatormax":
                return maxelevator;
            case "elevatorstart":
                return startingencodervalueE;
            case "slidestart":
                return startingencodervalueS;
            case "slidemax":
                return maxslide;
            default:
                return 0;
        }
    }
}