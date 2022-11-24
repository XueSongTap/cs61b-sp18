public class OffByN implements CharacterComparator {
    private int N;
    public OffByN(int n) {
        this.N = n;
    }
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return Math.abs(diff) == N;
    }
}
