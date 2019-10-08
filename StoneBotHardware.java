package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class StoneBotHardware {


    public DcMotor leftfrontDrive = null; // declaring object
    public DcMotor leftbackDrive = null; // declaring object
    public DcMotor rightfrontDrive = null; // declaring object
    public DcMotor rightbackDrive = null; // declaring object

    public Servo hookServo = null; // declaring servo
    public Servo grabServo = null; // declaring servo

    double hookServoMax = 1;
    double hookServoMin = 0;
    double grabServoMax = 1;
    double grabServoMin = 0;
    HardwareMap hwMap = null;

    public StoneBotHardware(){

    }

    public void init(HardwareMap ahwMap){
        //save Hardware Map
        hwMap = ahwMap;
        leftfrontDrive = hwMap.get(DcMotor.class,"left_front_drive"); // initialize the left front drive motor
        leftbackDrive = hwMap.get(DcMotor.class,"left_back_drive"); // initialize the left back drive motor
        rightfrontDrive = hwMap.get(DcMotor.class,"right_front_drive"); // initialize the right front drive motor
        leftbackDrive = hwMap.get(DcMotor.class,"left_back_drive"); // initialize the left back drive motor
        hookServo = hwMap.get(Servo.class, "hook_servo");
        grabServo = hwMap.get(Servo.class, "grab_servo");
        leftfrontDrive.setDirection(DcMotor.Direction.FORWARD); //makes the robot go forward
        rightfrontDrive.setDirection(DcMotor.Direction.REVERSE); //makes the robot go forward
        leftbackDrive.setDirection(DcMotor.Direction.FORWARD); //makes the robot go forward
        rightbackDrive.setDirection(DcMotor.Direction.REVERSE); //makes the robot go forward
        leftfrontDrive.setPower(0); //puts power to the motors
        rightfrontDrive.setPower(0); //puts power to the motors
        leftbackDrive.setPower(0); //puts power to the motors
        rightbackDrive.setPower(0); //puts power to the motors
        leftfrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // give feedback
        rightfrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // give feedback
        leftfrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // give feedback
        rightfrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // give feedback
        hookServo.setPosition(0);
        grabServo.setPosition(0);



    }
}
