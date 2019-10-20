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
        robot.LeftDrive(-gamepad1.left_stick_y);
        robot.RightDrive(-gamepad1.right_stick_y);

        robot.slide(gamepad1.left_stick_x);

    }












}