public class TipoC {
    
    private Integer key;
    private Integer[] value;

    //constructor
    public TipoC(Integer key, Integer[] value) {
        this.key = key;
        this.value = value;
    }


    public Integer getKey() {
        return key;
    }

    public Integer[] getValue() {
        return value;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setValue(Integer[] value) {
        this.value = value;
    }


    public int compareTo (TipoC elm) {
        return this.getKey().compareTo(elm.getKey());
    }
    
}
