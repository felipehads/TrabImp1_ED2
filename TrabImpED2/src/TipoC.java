public class TipoC implements Comparable<TipoC> {
    
    private int key;
    private int[] value;

    //constructor
    public TipoC(int key, int[] value) {
        this.key = key;
        this.value = value;
    }


    public int getKey() {
        return key;
    }

    public int[] getValue() {
        return value;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

    @Override
    public int compareTo (TipoC elm) {
        return this.getKey() - (elm.getKey());
    }
    
}
