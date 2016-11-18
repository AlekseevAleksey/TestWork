

public class Robot implements RobotConnection {

    private int x;

    private int y;

    private Direction direction = Direction.UP;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void moveRobotTo(int x, int y) {
        x = x - this.x;
        y = y - this.y;
        if (x >= 0) {
            while (direction != Direction.RIGHT) {
                turnRight();
            }
        } else {
            while (direction == Direction.LEFT) {
                turnRight();
            }
        }
        while (Math.abs(x) > 0) {
            stepForward();
            if (x > 0) {
                x--;
            } else {
                x++;
            }
        }

        if (y >= 0) {
            while (direction != Direction.UP) {
                turnRight();
            }
        } else {
            while (direction != Direction.DOWN) {
                turnRight();
            }
        }
        while (Math.abs(y) > 0) {
            stepForward();
            if (y > 0) {
                y--;
            } else {
                y++;
            }
        }

        while (direction != Direction.UP) {
            turnRight();
        }

    }

    public void close() {
        if (this == null) {
            throw new RobotConnectionException("close exception");
        } else {
        }

    }

    private void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        if (direction == Direction.UP) {
            direction = Direction.LEFT;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.UP;
        } else if (direction == Direction.DOWN) {
            direction = Direction.RIGHT;
        } else {
            direction = Direction.DOWN;
        }
    }

    private void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        if (direction == Direction.UP) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.DOWN;
        } else if (direction == Direction.DOWN) {
            direction = Direction.LEFT;
        } else {
            direction = Direction.UP;
        }
    }

    private void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        if (direction == Direction.UP) {
            y += 1;
        } else if (direction == Direction.RIGHT) {
            x += 1;
        } else if (direction == Direction.DOWN) {
            y -= 1;
        } else {
            x -= 1;
        }
    }
}
