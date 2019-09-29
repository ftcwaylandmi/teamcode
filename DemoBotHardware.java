package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;



public class DemoBotHardware {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;

    HardwareMap hwMap = null;

    public DemoBotHardware() {

    }

    public void init (HardwareMap ahwMap){
        // saveHardware Map
        hwMap = ahwMap;
        leftDrive=hwMap.get(DcMotor.class,"left_drive");
        rightDrive=hwMap.get(DcMotor.class,"right_drive");
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE );
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

}