import java.awt.*;

public class Ball {
    private int x, y;
    private int startX, startY;
    private int radius;
    private int dx, dy;
    private Color color;
    private final static double friction = 0.95;
    private boolean isTouchingBall;
    private boolean isTouchingWall;
    private boolean inPocket;
    private boolean onBoard;
    private Double angle, velocity;
    private Image img;
    private PoolGame game;

    public Ball(int startX, int startY, int radius, Color color, PoolGame game) {
        this.startX = startX;
        this.startY = startY;
        x = startX;
        y = startY;
        this.radius = radius;
        this.dx = 0;
        this.dy = 0;
        this.color = color;
        this.game = game;
        inPocket = false;
        angle = 0.0;
        velocity = 0.0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }


    public boolean isTouchingBall() {
        return isTouchingBall;
    }

    public void setTouchingBall(boolean touchingBall) {
        isTouchingBall = touchingBall;
    }

    public boolean isTouchingWall() {
        return isTouchingWall;
    }

    public void setTouchingWall(boolean touchingWall) {
        isTouchingWall = touchingWall;
    }

    public boolean isInPocket() {
        return inPocket;
    }

    public void setInPocket(boolean inPocket) {
        this.inPocket = inPocket;
    }

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Double getVelocity() {
        return velocity;
    }

    public void setVelocity(Double velocity) {
        this.velocity = velocity;
    }

    public void move() {

        x += dx;
        y += dy;
////        dx -= Math.round(dx * friction);
////        dy -= Math.round(y * friction);
        dx = (int) (dx * friction);
        dy = (int) (dy * friction);
        //game.getTable().checkBallCollisions();
        // get hypotanuse of distance
//        double dist = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
//        dist *= friction;
//        double tempDx = 0, tempDy = 0;
//        if (dx != 0) {
//            tempDx = dist * Math.cos(Math.atan(dy/dx) + Math.toRadians(180));
//            tempDy = dist * Math.sin(Math.atan(dy/dx) + Math.toRadians(180));
////            dx = (int) tempDx;
////            dy = (int) tempDy;
//        }
//
//        dx = dx >= 0 ? (int) tempDx : (int) tempDx * -1;
//        dy = dy >= 0 ? (int) tempDy : (int) tempDy * -1;

    }

    public void move(double velocity, double angle) {
        dx = (int) (velocity * Math.cos(angle)) * -1;
        dy = (int) (velocity * Math.sin(angle)) * -1;
        x += (int) (dx * friction + 0.5);
        y += (int) (dy * friction + 0.5);
        System.out.println("X: " + dx * friction);
        System.out.println("Y: " + dy * friction);
    }

    public void bounceWall() {
        if ((x <= 0 && dx < 0) || (x >= game.WINDOW_WIDTH - radius * 2 && dx > 0)) {
            dx = -dx;
        }
        if ((y <= 50 && dy < 0) || (y >= game.WINDOW_HEIGHT - radius * 2 && dy > 0)) {
            dy = -dy;
        }
    }

//    public void bounceBall(Ball other) {
//        // need to apply physics equation
////        other.dx = dx;
////        other.dy = dy; // swap these
//        if (calcVelocity() > other.calcVelocity()) {
//            other.dx = (int) (dx * 0.8);
//            other.dy = (int) (dy * 0.8);
//            dx = (int) (dx * 0.2);
//            dy = (int) (dy * 0.2);
//        }
//        else {
//            dx = (int) (other.dx * 0.8);
//            dy = (int) (other.dy * 0.8);
//            other.dx = (int) (dx * 0.2);
//            other.dy = (int) (dy * 0.2);
//        }
//    }
    public void bounceBall(Ball other) {
        int xDiff = other.x - x;
        int yDiff = other.y - y;
        int distance = (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        int overlap = radius + other.radius - distance;

        // Check if the balls are touching
        if (overlap > 0) {
            isTouchingBall = true;
            other.isTouchingBall = true;

            // Calculate the normal and tangent vectors
            double nx = xDiff / distance;
            double ny = yDiff / distance;
            double tx = -ny;
            double ty = nx;

            // Calculate the dot products of the velocity vectors with the normal and tangent vectors
            double dpTan1 = dx * tx + dy * ty;
            double dpTan2 = other.dx * tx + other.dy * ty;
            double dpNorm1 = dx * nx + dy * ny;
            double dpNorm2 = other.dx * nx + other.dy * ny;

            // Calculate the new tangent velocity components
            double m1 = (dpTan1 * (radius - other.radius) + 2 * other.radius * dpTan2) / (radius + other.radius);
            double m2 = (dpTan2 * (other.radius - radius) + 2 * radius * dpTan1) / (radius + other.radius);

            // Calculate the new normal velocity components (after conservation of momentum)
            double v1n = dpNorm1 * (radius - other.radius) + 2 * other.radius * dpNorm2;
            double v2n = dpNorm2 * (other.radius - radius) + 2 * radius * dpNorm1;
            v1n = v1n / (radius + other.radius);
            v2n = v2n / (radius + other.radius);

            // Set the new velocity vectors
            dx = (int) (tx * m1 + nx * v1n);
            dy = (int) (ty * m1 + ny * v1n);
            other.dx = (int) (tx * m2 + nx * v2n);
            other.dy = (int) (ty * m2 + ny * v2n);

//            // Move the balls away from each other so they're not overlapping
//            x -= (int) (overlap * nx / 2);
//            y -= (int) (overlap * ny / 2);
//            other.x += (int) (overlap * nx / 2);
//            other.y += (int) (overlap * ny / 2);
        }
    }


    public double calcVelocity() {
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }


    public boolean isTouching(Ball other) {
        // check if distance between the two centers = radius * 2
        double dist = Math.hypot(x - other.x, y - other.y);
        if (dist <= radius * 2) {
            return true;
        }
        return false;
    }

    public void reset() {
        x = startX;
        y = startY;
        dx = 0;
        dy = 0;
        game.getCue().resetPosition();
        inPocket = false;
    }

    public void draw(Graphics g) {
        if(!inPocket) {
            g.setColor(color);
            g.fillOval(x, y, 2 * radius, 2 * radius);
        }
    }
}
