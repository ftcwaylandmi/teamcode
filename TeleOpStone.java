package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.StoneBotHardware;
import org.firstinspires.ftc.teamcode.StoneBotRobot;

@TeleOp(name="Teleop Stone", group="Test")
public class TeleOpStone extends OpMode{
    StoneBotRobot robot = new StoneBotRobot();

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
        double left = 0.00;
        double right = 0.00;
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;
        robot.LeftDrive(left);
        robot.RightDrive(right);

        telemetry.addData("left", left);
        telemetry.addData("right", right);
    }












}