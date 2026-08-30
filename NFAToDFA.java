import java.util.*;

public class NFAToDFA {

    public static void main(String[] args) {

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

        List<Set<Integer>> dfa = new ArrayList<>();

        Queue<Set<Integer>> queue = new LinkedList<>();

        // DFA start state = {q0}
        Set<Integer> start = new HashSet<>();
        start.add(0);

        dfa.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {

            Set<Integer> current = queue.poll();

            System.out.println(
                "DFA State: " + current
            );

            for (int symbol = 0; symbol < 2; symbol++) {

                Set<Integer> next = new HashSet<>();

                for (int state : current)
                    next.addAll(nfa[state][symbol]);

                System.out.println(
                    "  " + symbol + " -> " + next
                );

                if (!dfa.contains(next) &&
                    !next.isEmpty()) {

                    dfa.add(next);
                    queue.add(next);
                }
            }
        }

        System.out.println("\nGenerated DFA:");

        for (int i = 0; i < dfa.size(); i++)
            System.out.println(
                "D" + i + " = " + dfa.get(i)
            );
    }
}