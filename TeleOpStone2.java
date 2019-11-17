package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

//import org.firstinspires.ftc.teamcode.StoneBotHardware;
//import org.firstinspires.ftc.teamcode.StoneBotRobot;

@TeleOp(name="Teleop Stone2", group="Test")
public class TeleOpStone2 extends OpMode{
    StoneBotRobot robot = new StoneBotRobot();
    Navigation nav = new Navigation();
    double speedinc = 0.001;
    boolean held = false;
    boolean bp = false;
    double slideoutspeed = 0.00;

    private static final float mmPerInch        = 25.4f;
    private static final float mmTargetHeight   = (6) * mmPerInch;

    @Override
    public void init(){
        robot.initHW(hardwareMap);
        nav.InitNavigation(hardwareMap);
    }

    @Override
    public void init_loop(){

    }

    @Override
    public void start(){
        nav.NavigationActivate();
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
        if (!robot.holdenabled) {
            robot.eleServoIn(gamepad2.left_stick_y);
        }
        if (gamepad1.y) {
            robot.slideMotorGoNoSafety(gamepad2.right_stick_x);
        } else {
            robot.slideMotorMax(gamepad2.right_stick_x);
        }
        if (gamepad1.left_bumper) {
            robot.DropCapstone();
        } else {
            robot.StopCapstone();
        }

        if (gamepad1.b) {
            robot.OpenCapHand();
        }

        if (gamepad1.x) {
            robot.CloseCapHand();
        }

        if (gamepad2.a) {
            robot.holdElevator();
        }
        if (gamepad2.b) {
            robot.unHoldElevator();
        }
        if (gamepad2.dpad_up) {
            robot.BrakeServoUp();
        }
        if (gamepad2.dpad_down) {
            robot.BrakeServoDown();
        }
     /*   telemetry.addData("eleEncoderCP", robot.myself.eleMotor.getCurrentPosition());
        telemetry.addData("slideEncoderCP", robot.myself.slideMotor.getCurrentPosition());
        telemetry.addData("slide power", gamepad2.right_stick_x);
        //telemetry.addData("maxslide", robot.maxslide);
        //telemetry.addData("base", robot.startingencodervalueS);
        telemetry.addData("elePower", gamepad2.left_stick_y);
*/
     LocationTelemetry();
    }

    public void LocationTelemetry() {
        if (nav.IsVisible()) {
            VectorF translation = nav.GetVector();
            telemetry.addData("Pos (in)", "{X, Y, Z} = %.1f, %.1f, %.1f",
                    translation.get(0) / mmPerInch, translation.get(1) / mmPerInch, translation.get(2) / mmPerInch);
            Orientation rotation = nav.GetOrientation();
            telemetry.addData("Rot (deg)", "{Roll, Pitch, Heading} = %.0f, %.0f, %.0f", rotation.firstAngle, rotation.secondAngle, rotation.thirdAngle);

            telemetry.update();

        }
    }










}