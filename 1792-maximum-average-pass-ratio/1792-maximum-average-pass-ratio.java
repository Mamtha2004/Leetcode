

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(b[0], a[0]) // sort by gain, biggest first
        );

        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double gain = gain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1], total = (int) top[2];

            pass++;
            total++;

            double newGain = gain(pass, total);
            pq.offer(new double[]{newGain, pass, total});
        }

        double totalRatio = 0;
        while (!pq.isEmpty()) {
            double[] cls = pq.poll();
            int pass = (int) cls[1], total = (int) cls[2];
            totalRatio += (double) pass / total;
        }

        return totalRatio / classes.length;
    }

    private double gain(int pass, int total) {
        double current = (double) pass / total;
        double withExtra = (double) (pass + 1) / (total + 1);
        return withExtra - current;
    }
}
