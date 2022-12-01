package frc.robot.commands;

import java.lang.reflect.GenericArrayType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain.DriveTrain;

public class TaxiAuto extends SequentialCommandGroup{
       

    public TaxiAuto(DriveTrain driveTrain){ 
        addCommands(
            new ParallelCommandGroup(
                new RunCommand(()->{
                    driveTrain.drive(0.3,0.3);  
                }, driveTrain),
                new WaitCommand(2.0)

                
            ),

            //hope is for code belows to turn,🤷
            
            new ParallelCommandGroup(
                //turn code
                TurnToAngle(90, driveTrain)
                
                        
        ));
        addRequirements(driveTrain);
    }
    ;

    
public Command[] TurnToAngle(double targetAngleDegrees, DriveTrain drive) {
    super(
        new PIDController(Constants.P, Constants.I, Constants.D),
        // Close loop on heading
        drive::getHeading,
        // Set reference to target
        targetAngleDegrees,
        // Pipe output to turn robot
        output () -> {
            if (output > 0) {
                drive.arcadeDrive(output+F, output + F);
            } else if (output < 0) {
                drive.arcadeDrive(output-F, output - F);
            } else {
                drive.drive(output, output);
            }
        },
        // Require the drive
        drive);

 }
}
