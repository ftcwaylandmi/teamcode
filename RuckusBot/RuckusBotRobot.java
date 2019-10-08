package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.RuckusBotHardware;

public class RuckusBotRobot {
    RuckusBotHardware myself = new RuckusBotHardware();
    boolean moving;

    public void initRobot() {
        moving = false;
    }

    private void drive(double lpower, double rpower) {
        myself.rightDrive.setPower(rpower);
        myself.leftDrive.setPower(lpower);
        moving = true;

    }

    public void DriveRerverse(double power) {
        drive(-power, -power);
    }

    public void DriveForward(double power) {
        drive(power, power);
    }

    public void DriveLeft(double power) {
        drive(-power, power);

    }

    public void DriveRight( double power){
        drive(power, -power);
    }


    public void DriveStop() {
        myself.rightDrive.setPower(0);
        myself.leftDrive.setPower(0);
        moving = false;
    }


    public boolean IsMoving() {
        return moving;
    }
    public void ServoyeetgotoMax(){
        myself.yeetServo.setPosition(myself.servoyeetMax);

    }
    public void servopingotoMax(){
        myself.pinServo.setPosition(myself.servopinMax);

    }
    public void servowinchgotoMax() {
        myself.winchServo.setPosition(myself.servowinchMax);
    }

       public void Servoyeetgotoposition(double position) {
       }
       public void servoyeetgotoMin(){

       }
       public void servopingotoposition(double postition) {

       }
       public void servopingotoMin() {

       }
       public void servowinchgotoposition(double postition) {

       }
       public void servowinchgotoMin() {
         
       }






}

