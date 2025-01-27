class Solution {
    public int orangesRotting(int[][] grid) {
        // Edge case: Empty grid
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0; // Count of fresh oranges

        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all rotten oranges and count fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[] {r, c}); // Add rotten orange's position to the queue
                } else if (grid[r][c] == 1) {
                    freshCount++; // Count fresh oranges
                }
            }
        }

        // If there are no fresh oranges, return 0 (all are already rotten or empty)
        if (freshCount == 0) return 0;

        int minutesElapsed = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 4-directional movements

        // BFS to simulate the rotting process
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottingOccurred = false;

            // Process all oranges that will rot in the current minute
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // Check all 4 directions
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // If the neighboring cell is a fresh orange, rot it
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Mark as rotten
                        queue.add(new int[] {newRow, newCol}); // Add to queue for next minute
                        freshCount--; // Decrease count of fresh oranges
                        rottingOccurred = true;
                    }
                }
            }

            // If rotting occurred in this minute, increment the time
            if (rottingOccurred) {
                minutesElapsed++;
            }
        }

        // If there are still fresh oranges left, return -1
        return freshCount == 0 ? minutesElapsed : -1;
    }
}