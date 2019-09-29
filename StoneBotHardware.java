package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class StoneBotHardware {

    public DcMotor leftDrive = null; // declaring object
    public DcMotor rightDrive = null; // declaring object
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
        leftDrive = hwMap.get(DcMotor.class,"left_drive"); // initialize the left drive motor
        rightDrive = hwMap.get(DcMotor.class,"right_drive"); // initialize the right drive motor
        hookServo = hwMap.get(Servo.class, "hook_servo");
        grabServo = hwMap.get(Servo.class, "grab_servo");
        leftDrive.setDirection(DcMotor.Direction.FORWARD); //makes the robot go forward
        rightDrive.setDirection(DcMotor.Direction.REVERSE); //makes the robot go forward
        leftDrive.setPower(0); //puts power to the motors
        rightDrive.setPower(0); //puts power to the motors
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // give feedback
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // give feedback
        hookServo.setPosition(0);
        grabServo.setPosition(0);
        double hookServoMAX = 1;
        double hookServoMIN = 1;
        double grabServoMAX = 1;
        double grabServoMIN = 1;

    }
}
