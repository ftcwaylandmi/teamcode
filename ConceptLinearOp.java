/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;

@Autonomous(name="LR Block Grab2", group="Linear Opmode")

public class ConceptLinearOp extends LinearOpMode {

    VuforiaLocalizer vuforia;

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    private StoneBotRobot robot = new StoneBotRobot();

    @Override
    public void runOpMode() {

        /*int cameraMoniterViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id");
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMoniterViewId);

        parameters.vuforiaLicenseKey = "AaxVY3r/////AAAAGbyMA3eUvEA2q83CLpzVrelPW7cPUPzKsok3Iq+EKO4jDShw8YK9P/CxrfpNh7EQbsS8MfspG4ctHTT27mnwW62RW5WKw6e8a96Icl5tCWxuqy/bycKxeWra2nQoWC3AzwDhpYsuhUTjMkTss9TyVuXdW1KlIxqhTqUkIld4LA13l9xkQzgIS1eA4rlj3VPDWeIAIKepR5s7TKOmLTHDrMLSbjefzF2RAj73YAopvfi4heZNCHTyPLkVKW3AiAobToqX92ibMJTmgSIV0wvTYrxc6f6HQpC5AVRos11CYuYS95H4QEg9HqU8WkxipYMWZ8UGpu4BltPoqipA1lq04MCyxe/gvdW1gsewE63WXgz0";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables skystoneTrackables = this.vuforia.loadTrackablesFromAsset("SkyStoneVuMark");
        VuforiaTrackable skystoneTemplate = skystoneTrackables.get(0);
        skystoneTemplate.setName("skystoneVuMarkTemplate");
        */
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        robot.initHW(hardwareMap);
        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("curr_slide", robot.CurrentEncoderVal("slide"));
        telemetry.addData("curr_elevator", robot.CurrentEncoderVal("elevator"));

        waitForStart();

        /*skystoneTemplate.activate();

        while (opModeIsActive()) {

            skystoneVuMark vuMark = skystoneVuMark.from(skystoneTemplate);
            if (vuMark != skystoneVuMark.UNKNOWN){

                OpenGLMatrix pose = ((VuforiaTrackableDefaultListener) skystoneTemplate.getListener()).getPose();

            }

        }*/
        runtime.reset();

        robot.DriveByInches(24);
        robot.eleClearBlockHeight();
        robot.wait(300);
        robot.slideToMax();
        robot.grabServoGoToMax();
        robot.wait(300);

        robot.DriveByInches(6);

        robot.eleDropToBlock();
        robot.wait(400);
        //robot.grabServoGoToMin();
        robot.DriveByInches(-20);
        robot.TurnByDegrees(90);
        robot.DriveByInches(36);
        robot.eleClearBlockHeight();
        robot.DriveByInches(5);
        robot.grabServoGoToMin();
        robot.slideToReset();
        //robot.TurnByDegrees(-75);
        //robot.DriveByInches(48);
        //robot.TurnByDegrees(-90);
        //robot.DriveByInches(3);
        //robot.slideToLoad();














        telemetry.addData("Complete", "done");
        telemetry.update();

    }

    /*public void checkitems(){
        VuforiaTrackable stoneTarget = targetsSkyStone.get(0);
        stoneTarget.setName("Stone Target");
        VuforiaTrackable blueRearBridge = targetsSkyStone.get(1);
        blueRearBridge.setName("Blue Rear Bridge");
        VuforiaTrackable redRearBridge = targetsSkyStone.get(2);
        redRearBridge.setName("Red Rear Bridge");
        VuforiaTrackable redFrontBridge = targetsSkyStone.get(3);
        redFrontBridge.setName("Red Front Bridge");
        VuforiaTrackable blueFrontBridge = targetsSkyStone.get(4);
        blueFrontBridge.setName("Blue Front Bridge");
        VuforiaTrackable red1 = targetsSkyStone.get(5);
        red1.setName("Red Perimeter 1");
        VuforiaTrackable red2 = targetsSkyStone.get(6);
        red2.setName("Red Perimeter 2");
        VuforiaTrackable front1 = targetsSkyStone.get(7);
        front1.setName("Front Perimeter 1");
        VuforiaTrackable front2 = targetsSkyStone.get(8);
        front2.setName("Front Perimeter 2");
        VuforiaTrackable blue1 = targetsSkyStone.get(9);
        blue1.setName("Blue Perimeter 1");
        VuforiaTrackable blue2 = targetsSkyStone.get(10);
        blue2.setName("Blue Perimeter 2");
        VuforiaTrackable rear1 = targetsSkyStone.get(11);
        rear1.setName("Rear Perimeter 1");
        VuforiaTrackable rear2 = targetsSkyStone.get(12);
        rear2.setName("Rear Perimeter 2");
    }*/
}

