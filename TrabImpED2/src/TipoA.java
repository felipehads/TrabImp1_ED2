public class TipoA implements Comparable<TipoA> {
    

    private String key;
    private Double value;


    //constructor
    public TipoA(String key, Double value) {
        this.key = key;
        this.value = value;
    }


    public String getKey() {
        return key;
    }

    public Double getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public int compareTo (TipoA elm) {
        return this.getKey().compareTo(elm.getKey());
    }
    

}
