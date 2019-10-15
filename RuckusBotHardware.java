package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;



    public class RuckusBotHardware {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor armDrive = null;
    public DcMotor elbowDrive = null;
    public Servo pinServo = null;

    HardwareMap hwMap = null;

    public RuckusBotHardware() {

    }

    public void init (HardwareMap ahwMap){
        // saveHardware Map
        hwMap = ahwMap;
        leftDrive=hwMap.get(DcMotor.class,"lfd");
        rightDrive=hwMap.get(DcMotor.class,"rfd");
        armDrive=hwMap.get(DcMotor.class,"ad");
        elbowDrive=hwMap.get(DcMotor.class,"ed")
        pinServo=hwMap.get(Servo.class,"pin_servo")
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        armDrive.setDirection(DcMotor.Direction.FORWARD);
        elbowDrive.setDirection(DcMotor.Direction.REVERSE);
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        armDrive.setPower(0);
        elbowDrive.setPower(0);
        pinServo.setPosition(0);
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        elbowDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }


}