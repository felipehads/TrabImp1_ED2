public class TipoB implements Comparable<TipoB> {
    
    private Double key;
    private String value;


    //constructor
    public TipoB(Double key, String value) {
        this.key = key;
        this.value = value;
    }



    public Double getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKey(Double key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }



    @Override
    public int compareTo (TipoB elm) {
        return this.getKey().compareTo(elm.getKey());
    }
    
}
