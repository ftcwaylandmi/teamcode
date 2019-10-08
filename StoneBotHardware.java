package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class StoneBotHardware {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor leftrearDrive = null;
    public DcMotor rightrearDrive = null;

    public Servo hookServo = null;
    public Servo grabServo = null;

    HardwareMap hwMap = null;

    public StoneBotHardware() {

    }

    public void init (HardwareMap ahwMap){
        // saveHardware Map
        hwMap = ahwMap;
        leftDrive=hwMap.get(DcMotor.class,"lfd");
        rightDrive=hwMap.get(DcMotor.class,"rfd");
        leftrearDrive=hwMap.get(DcMotor.class, "lfd");
        rightrearDrive=hwMap.get (DcMotor.class, "rfd");

        hookServo = hwMap.get(Servo.class,"hook_servo");
        grabServo = hwMap.get(Servo.class,"grab_servo");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftrearDrive.setDirection(DcMotor.Direction.FORWARD);
        rightrearDrive.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        leftrearDrive.setPower(0);
        rightrearDrive.setPower(0);
        hookServo.setPosition(0);
        grabServo.setPosition(0);

        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftrearDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightrearDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

}