public class Day1Patterns {
    public static void main(String[] args) {
        int n = 5;

        // Pattern 1: Single row
        for(int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println("\n");

        // Pattern 2: Single column
        for(int i = 0; i < n; i++) {
            System.out.println("*");
        }
        System.out.println();

        // Pattern 3: Square
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 4: Row-wise numbers
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 5: Column-wise numbers
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 6: Hollow square
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || i == n-1 || j == 0 || j == n-1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}

/*
Day 1: Pattern Programming

Concepts Covered:
- Basic loops
- Nested loops
- Row vs column logic
- Boundary conditions (hollow square)

Time Complexity: O(n^2)
Space Complexity: O(1)
*/
