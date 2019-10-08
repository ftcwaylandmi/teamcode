package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class RuckusBotHardware {

    public DcMotor leftDrive = null; 
    public DcMotor rightDrive = null;
    public DcMotor liftDrive = null;
    public DcMotor armDrive = null;
    public Servo yeetServo = null;
    public Servo pinServo = null;
    public Servo winchServo = null;

    HardwareMap hwMap = null;

    public RuckusBotHardware() {
    }
    public void init(HardwareMap ahwMap){
    // SaveHardwareMap
         hwMap=ahwMap;
         leftDrive = hwMap.get(DcMotor.class, "left_front_drive");
         rightDrive = hwMap.get(DcMotor.class,"right_front_drive");
         liftDrive = hwMap.get(DcMotor.class,"lift_drive");
         armDrive = hwMap.get(DcMotor.class,  "arm_drive");
         yeetServo = hwMap.get(Servo.class, "yeet_servo");
         pinServo = hwMap.get(Servo.class, "pin_servo");
         winchServo = hwMap.get(Servo.class, "winch_servo");
         leftDrive.setDirection(DcMotor.Direction.FORWARD);
         rightDrive.setDirection(DcMotor.Direction.REVERSE);
         liftDrive.setDirection(DcMotor.Direction.FORWARD);
         armDrive.setDirection(DcMotor.Direction.FORWARD);
         yeetServo.setPosition(0);
         pinServo.setPosition(0);
         winchServo.setPosition(0);
         leftDrive.setPower(0);
         rightDrive.setPower(0);
         liftDrive.setPower(0);
         armDrive.setPower(0);
         leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         liftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         armDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    double servoyeetMax = 1;
    double servoyeetMin = 1;
    double servopinMax = 1;
    double servopinMin = 1;
    double servowinchMax = 1;
    double servowinchMin = 1;
}