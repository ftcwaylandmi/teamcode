package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

public class demo3hardware {
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    HardwareMap hwmap = null;

    public demo3hardware() {
    }

    public void init(HardwareMap ahwmap) {
        // save hardware map
        hwmap = ahwmap;
        leftDrive = hwmap.get(DcMotor.class, "leftdrive");
        rightDrive = hwmap.get(DcMotor.class, "rightdrive");
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }
}