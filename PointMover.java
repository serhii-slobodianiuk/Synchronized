public class PointMover implements Runnable {
    private final Point point;

    PointMover(Point point) {
        this.point = point;
    }

    @Override
    public void run() {
        synchronized (point) {
            point.x++;
        }
    }
}
