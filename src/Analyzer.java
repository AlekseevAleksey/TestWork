import java.lang.*;

public class Analyzer {

    public static void main(String[] args) {
        RobotConnectionManager robotConnectionManager = new RobotConnectionManagerImpl(null);
        moveRobot(robotConnectionManager, 1, 1);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        // your implementation here
        boolean success = false;

        for (int i=0; i<3;i++) {
            if (!success) {
                try (RobotConnection connection = robotConnectionManager.getConnection()) {
                    connection.moveRobotTo(toX,toY);
                    success = true;
                } catch (RobotConnectionException e){
                    if (i ==2 ) {
                        throw e;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            } else {
                return;
            }
        }

    }

}
