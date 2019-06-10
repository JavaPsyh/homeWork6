package tasks.robot;

public class TryRobotWithResources {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        boolean isConnection = false;
        for (int i = 0; i < 3 && !isConnection; i++) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                isConnection = true;
            } catch (RobotConnectionException rce) {
                if (i == 2) {
                    throw new RobotConnectionException("Ups! Three connections were failed.");
                }
            }
        }
    }
}
