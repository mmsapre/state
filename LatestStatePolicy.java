
import java.util.Comparator;

/**
 * Compares two events only by state rank and, if equal, by eventId
 * (useful for deterministic tie-breaking in case of duplicates).
 */
public final class LatestStatePolicy implements Comparator<DistributionEvent> {

    @Override
    public int compare(DistributionEvent a, DistributionEvent b) {
        int byRank = Integer.compare(a.state().rank(), b.state().rank());
        if (byRank != 0) return byRank;

        // tie-break if two events have same state: pick higher UUID
        return a.eventId().compareTo(b.eventId());
    }
}
