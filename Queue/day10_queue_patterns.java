import java.util.*;

// Day 10: Queue Patterns
public class Day10QueuePatterns {

    // 1) 933. Number of Recent Calls (Queue + sliding window)
    static class RecentCounter {
        private Queue<Integer> q = new LinkedList<>();

        public int ping(int t) {
            q.offer(t);
            // keep only [t-3000, t]
            while (!q.isEmpty() && q.peek() < t - 3000) {
                q.poll();
            }
            return q.size();
        }
    }

    // 2) 239. Sliding Window Maximum (Monotonic Deque)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];

        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // store indices

        for (int i = 0; i < n; i++) {

            // remove indices out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // maintain decreasing deque
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // record answer when first window is ready
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }

    // 3) 102. Binary Tree Level Order Traversal (BFS)
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            ans.add(level);
        }

        return ans;
    }

    // 4) 622. Design Circular Queue
    static class MyCircularQueue {
        private int[] arr;
        private int front, rear, size, capacity;

        public MyCircularQueue(int k) {
            capacity = k;
            arr = new int[k];
            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            rear = (rear + 1) % capacity;
            arr[rear] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : arr[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : arr[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    // 5) 649. Dota2 Senate (Queue Simulation)
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') r.offer(i);
            else d.offer(i);
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int ri = r.poll();
            int di = d.poll();

            if (ri < di) {
                r.offer(ri + n); // Radiant bans Dire
            } else {
                d.offer(di + n); // Dire bans Radiant
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}

/*
Day 10: Queue Patterns

Covered:
- Basic Queue (RecentCounter)
- Monotonic Queue (Sliding Window Max)
- BFS (Level Order Traversal)
- Circular Queue (Design)
- Simulation (Dota2 Senate)

Key Ideas:
- FIFO processing
- Maintain window with queue/deque
- Level-wise traversal using size
- Circular indexing using modulo
- Queue-based simulation

Time: O(n) mostly
Space: O(n)
*/
