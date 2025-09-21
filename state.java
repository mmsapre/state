
public enum State {
    INGESTED(10),
    STAGED(20),
    MASTER(30),
    PUBLISH(40),
    ACK(50),
    NACK(50); // ACK/NACK are terminal peers

    private final int rank;
    State(int rank) { this.rank = rank; }
    public int rank() { return rank; }
}
