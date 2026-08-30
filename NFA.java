import java.util.*;

public class NFA {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            /*
                 NFA:
                 q0 --0--> q0
                 q0 --1--> q0,q1
                 q1 --1--> q2
            */

            @SuppressWarnings("unchecked")
            Set<Integer>[][] nfa = new HashSet[3][2];

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 2; j++)
                    nfa[i][j] = new HashSet<>();

            nfa[0][0].add(0);

            nfa[0][1].add(0);
            nfa[0][1].add(1);

            nfa[1][1].add(2);

            int finalState = 2;

            System.out.print("Enter string: ");
            String input = sc.next();

            if (input.isEmpty()) {
                System.out.println("\nInvalid input");
                return;
            }

            Set<Integer> current = new HashSet<>();
            current.add(0);

            System.out.println("Start: " + current);

            for (char ch : input.toCharArray()) {
                if (ch != '0' && ch != '1') {
                    System.out.println("\nInvalid input");
                    return;
                }

                int symbol = ch - '0';
                Set<Integer> next = new HashSet<>();

                for (int state : current)
                    next.addAll(nfa[state][symbol]);

                current = next;

                System.out.println(
                    "After " + ch + ": " + current
                );
            }

            if (current.contains(finalState))
                System.out.println("Result: ACCEPTED");
            else
                System.out.println("Result: REJECTED");
        }
    }
}