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
        double left = 0.00;
        double right = 0.00;
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;
        robot.LeftDrive(left);
        robot.RightDrive(right);

        if (gamepad2.y) {
            robot.hookServoGoToMax();
        } else if (gamepad2.a) {
            robot.hookServoGoToMin();
        } else {
            robot.hookServoStop();
        }

        if (gamepad2.right_bumper) {
            robot.grabServoGoToMax();
        } else if (gamepad2.left_bumper) {
                robot.grabServoGoToMin();
        }

        double EIn = -1.00;
        double EOut = 1.00;
        EIn = gamepad2.left_stick_y;
        EOut = -gamepad2.left_stick_y;
        robot.eleServoIn(EIn);
        robot.eleServoOut(EOut);

        double SIn = 0.00;
        double SOut = 0.00;
        SIn = -gamepad2.right_stick_x;
        //SOut = gamepad2.right_stick_x;
        robot.slideServoIn(SIn);
        robot.slideServoOut(SOut);


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