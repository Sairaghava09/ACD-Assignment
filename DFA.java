import java.util.*;

public class DFA {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // DFA transition table
            //       0   1
            // q0    q0  q1
            // q1    q0  q2
            // q2    q2  q1

            int[][] dfa = {
                {0, 1},
                {0, 2},
                {2, 1}
            };

            int start = 0;
            int finalState = 2;

            System.out.print("Enter string: ");
            String input = sc.next();

            if (input.isEmpty()) {
                System.out.println("\nInvalid input");
                return;
            }

            int current = start;

            System.out.print("Path: q" + current);

            for (char ch : input.toCharArray()) {
                if (ch != '0' && ch != '1') {
                    System.out.println("\nInvalid input");
                    return;
                }

                int symbol = ch - '0';
                current = dfa[current][symbol];

                System.out.print(" -> q" + current);
            }

            if (current == finalState)
                System.out.println("\nResult: ACCEPTED");
            else
                System.out.println("\nResult: REJECTED");
        }
    }
}