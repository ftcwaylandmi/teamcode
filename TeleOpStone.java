package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

//import org.firstinspires.ftc.teamcode.StoneBotHardware;
//import org.firstinspires.ftc.teamcode.StoneBotRobot;

@TeleOp(name="Teleop Stone", group="Test")
public class TeleOpStone extends OpMode{
    StoneBotRobot robot = new StoneBotRobot();
    double speedinc = 0.001;
    boolean held = false;
    boolean bp = false;
    double slideoutspeed = 0.00;

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
    public void loop() {
        if (gamepad1.right_bumper) {
            robot.LeftDrive(gamepad1.left_stick_y/2);
            robot.RightDrive(gamepad1.right_stick_y/2);

        } else {
            robot.LeftDrive(gamepad1.left_stick_y);
            robot.RightDrive(gamepad1.right_stick_y);
        }
        if (gamepad2.y) {
            robot.hookServoGoToMax();
        } else if (gamepad2.x) {
            robot.hookServoGoToMin();
        } else {
            robot.hookServoStop();
        }

        if (gamepad2.right_bumper) {
            robot.grabServoGoToMax();
        } else if (gamepad2.left_bumper) {
                robot.grabServoGoToMin();
        }

        robot.eleServoIn(-gamepad2.left_stick_y);
        telemetry.addData("eleEncoderCP", robot.myself.eleMotor.getCurrentPosition());
        telemetry.addData("slideEncoderCP", robot.myself.slideMotor.getCurrentPosition());
        telemetry.addData("elePower", gamepad2.left_stick_y);
        robot.slideMotorMax(gamepad2.right_stick_x);

        /*if (gamepad2.right_stick_x  != 0.00) {
            if (!held) {
                slideoutspeed += speedinc;
            } else if (slideoutspeed == 1) {
                bp = true;
                slideoutspeed -= speedinc;
            } else if (bp) {
                slideoutspeed = -speedinc;
            } else {
                slideoutspeed = +speedinc;
            }
        } else {
            held = false;
            slideoutspeed = 0;
        }
        robot.slideServoOut(slideoutspeed);*/

        /*telemetry.addData("left", left);
        telemetry.addData("right", right);*/
    }












}