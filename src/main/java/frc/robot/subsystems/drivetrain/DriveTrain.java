package frc.robot.subsystems.drivetrain;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase{
    private final CANSparkMax frontRight = new CANSparkMax(Constants.frontRightPort, MotorType.kBrushless);
    private final CANSparkMax frontLeft = new CANSparkMax(Constants.frontLeftPort, MotorType.kBrushless);
    private final CANSparkMax rearLeft = new CANSparkMax(Constants.middleLeftPort, MotorType.kBrushless);
    private final CANSparkMax rearRight = new CANSparkMax(Constants.middleRightPort, MotorType.kBrushless);
    private final CANSparkMax backLeft = new CANSparkMax(Constants.backLeftPort, MotorType.kBrushless);
    private final CANSparkMax backRight = new CANSparkMax(Constants.backRightPort, MotorType.kBrushless);

    MotorControllerGroup leftMotors = new MotorControllerGroup(backLeft, rearLeft, backLeft);
    MotorControllerGroup rightMotors = new MotorControllerGroup(backRight, rearRight, backRight);
    public DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors, rightMotors); 
    
    public DriveTrain() {
        leftMotors.setInverted(false);
        rightMotors.setInverted(true);
        frontLeft.setIdleMode(IdleMode.kBrake);
        frontRight.setIdleMode(IdleMode.kBrake);
        rearLeft.setIdleMode(IdleMode.kBrake);
        rearRight.setIdleMode(IdleMode.kBrake);
        backLeft.setIdleMode(IdleMode.kBrake);
        backRight.setIdleMode(IdleMode.kBrake);
               
    }

    public void drive(double leftSpeed, double rightSpeed){
        differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }



 
}