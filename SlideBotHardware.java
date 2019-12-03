package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;

public class SlideBotHardware {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor leftrearDrive = null;
    public DcMotor rightrearDrive = null;

    public CRServo armMotor = null;
    public CRServo handServo = null;
    HardwareMap hwMap = null;

    public SlideBotHardware() {

    }

    public void init (HardwareMap ahwMap) {

        hwMap = ahwMap;
        leftDrive = hwMap.get(DcMotor.class, "lfd");
        rightDrive = hwMap.get(DcMotor.class, "rfd");
        leftrearDrive = hwMap.get(DcMotor.class, "lrd");
        rightrearDrive = hwMap.get(DcMotor.class, "rrd");

        armMotor = hwMap.get(CRServo.class, "armservo");
        handServo = hwMap.get(CRServo.class, "handservo");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftrearDrive.setDirection(DcMotor.Direction.FORWARD);
        rightrearDrive.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        leftrearDrive.setPower(0);
        rightrearDrive.setPower(0);

        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftrearDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightrearDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Set power to 0 so the motor isn't running.
        handServo.setPower(0);
        armMotor.setPower(0);



    }

}
