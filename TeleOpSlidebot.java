package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//import org.firstinspires.ftc.teamcode.StoneBotHardware;
//import org.firstinspires.ftc.teamcode.StoneBotRobot;

@TeleOp(name="Teleop Slidebot", group="Test")
public class TeleOpSlidebot extends OpMode{
    SlideBotRobot robot = new SlideBotRobot();

    @Override
    public void init(){
        robot.initHW(hardwareMap);
    }

    @Override
    public void init_loop(){

    }

    @Override
    public void start(){

    }

    @Override
    public void loop(){
        robot.drive(gamepad1.left_stick_y, gamepad1.right_stick_y);
        robot.slide(gamepad1.left_stick_x);

        if (gamepad1.a) {
            robot.HandServo(1);
        } else {
            robot.HandServo(0);
        }

        if (gamepad1.left_bumper) {
            robot.ArmMotor(1);
        } else if (gamepad1.right_bumper) {
            robot.ArmMotor(-1);
        } else {
            robot.ArmMotor(0);
        }


    }












}