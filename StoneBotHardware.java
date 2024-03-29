package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class StoneBotHardware {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor leftrearDrive = null;
    public DcMotor rightrearDrive = null;
    public DcMotor eleMotor = null;
    public DcMotor slideMotor = null;


    public DigitalChannel InMaxSensor;
    public DigitalChannel InMinSensor;

    public CRServo hookServo = null;
    public Servo grabServo = null;
    public Servo capServo = null;
    public CRServo capoutServo = null;
    public Servo brakeServo = null;


    public int elevatormin;
    public int slidemin;

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

        hookServo = hwMap.get(CRServo.class, "hook_servo");
        //hookServo = hwMap.get(Servo.class,"hook_servo");
        grabServo = hwMap.get(Servo.class,"grab_servo");
        capServo = hwMap.get(Servo.class, "cap_grab");
        capoutServo = hwMap.get(CRServo.class, "cap_out");
        brakeServo = hwMap.get(Servo.class, "brake_servo");

        slideMotor = hwMap.get(DcMotor.class, "slide_motor");
        eleMotor = hwMap.get(DcMotor.class, "ele_motor");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftrearDrive.setDirection(DcMotor.Direction.FORWARD);
        rightrearDrive.setDirection(DcMotor.Direction.REVERSE);

        slideMotor.setDirection(DcMotor.Direction.FORWARD);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        leftrearDrive.setPower(0);
        rightrearDrive.setPower(0);
        //hookServo.setPosition(0);
        grabServo.setPosition(0);
        eleMotor.setPower(0);
        slideMotor.setPower(0);
        capServo.setPosition(0.4);
        brakeServo.setPosition(0);

        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftrearDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightrearDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        eleMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        elevatormin = eleMotor.getCurrentPosition();

        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slidemin = slideMotor.getCurrentPosition();


    }

}