package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.drivetrain.DriveTrain;

public class TaxiAuto extends SequentialCommandGroup{
    public TaxiAuto(DriveTrain driveTrain){ 
        addCommands(
            new ParallelCommandGroup(
                new RunCommand(()->{
                    driveTrain.drive(0.3,0.3); // NO CLUE 
                }, driveTrain),
                new WaitCommand(2.0)
            ),

            //hope is for code belows to turn,🤷
            
            new ParallelCommandGroup(
                new RunCommand(()->{
                    driveTrain.drive(0.3, 0);
                }, driveTrain),
                new WaitCommand(2.0)    
            )
                        
        );
        addRequirements(driveTrain);
    }
}
