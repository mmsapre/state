// StateOrder.java
import java.util.*;

/**
 * Holds allowed state order: ingested -> staged -> master -> publish -> ack/nack.
 */
public final class StateOrder {
    private static final List<String> ORDER = List.of(
            "ingested", "staged", "master", "publish", "ack", "nack"
    );

    private static final Map<String, Integer> RANKS = new HashMap<>();
    static {
        for (int i = 0; i < ORDER.size(); i++) {
            RANKS.put(ORDER.get(i).toLowerCase(Locale.ROOT), i);
        }
    }

    public static int rankOf(String state) {
        return RANKS.getOrDefault(state.toLowerCase(Locale.ROOT), -1);
    }
}
