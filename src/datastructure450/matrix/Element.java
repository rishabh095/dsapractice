package datastructure450.matrix;

public class Element implements Comparable<Element> {
    int row;
    int col;
    int value;

    public Element(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @Override
    public int compareTo(Element o) {
        return this.value - o.value;
    }
}
