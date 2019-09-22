package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

public class StoneBotHardware {

    public DcMotor leftDrive = null; // declaring object
    public DcMotor rightDrive = null; // declaring object

    HardwareMap hwMap = null;

    public StoneBotHardware(){

    }

    public void init(HardwareMap ahwMap){
        //save Hardware Map
        hwMap = ahwMap;
        leftDrive = hwMap.get(DcMotor.class,"left_drive"); // initialize the left drive motor
        rightDrive = hwMap.get(DcMotor.class,"right_drive"); // initialize the right drive mot0r
        leftDrive.setDirection(DcMotor.Direction.FORWARD); //makes the robot go forward
        rightDrive.setDirection(DcMotor.Direction.REVERSE); //makes the robot go forward
        leftDrive.setPower(0); //puts power to the motors
        rightDrive.setPower(0); //puts power to the motors
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // give feedback
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // give feedback
    }
}
