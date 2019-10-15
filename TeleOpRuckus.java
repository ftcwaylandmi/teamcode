package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp(name = "Teleop Ruckus", group = "Test");

public class TeleOpRuckus extends OpMode {
    RuckusBotRobot robot = new RuckusBotRobot();

    @Override
    public void init() {
        robot.initHW(hardwareMap);


        @Override
        public void init_loop () {

        }

        @Override
        public void start () {

        }

        @Override
        public void loop () {
            double left = 0.00;
            double right = 0.00;
            double ArmUp = 0.00;
            double ArmDown = 0.00;
            double ElbowUp = 0.00;
            double ElbowDown = 0.00;
            left = -gamepad1.left_stick_y;
            right = -gamepad1.right_stick_y;
            ArmUp = -gamepad2.d_pad_up;
            ArmDown = -gamepad2.d_pad_down;
            ElbowUp = -gamepad2.d_pad_left;
            ElbowDown = -gamepad2.d_pad_right;
            robot.ArmDown(armDown);
            robot.ArmUp(armUp);
            robot.LeftDrive(left);
            robot.RightDrive(right);
            robot.ElbowDown(elbowDown);
            robot.ElbowUp(elbowUp);

            if (gamepad2.right_bumper) {
                robot.pinServoGoToMax();
            } else if (gamepad2.left_bumper) {
                robot.pinServoGoToMin();
            }


            telemetry.addData("left", left);
            telemetry.addData("right", right);
        }


    }