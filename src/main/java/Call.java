public class Call implements Comparable<Call> {
    private final int number;

    public Call(int number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public int compareTo(Call call) {
        return number;
    }
}
