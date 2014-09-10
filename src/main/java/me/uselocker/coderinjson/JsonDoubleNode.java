package me.uselocker.coderinjson;

class JsonDoubleNode extends JsonNode {

    private final Double value;
    
    public  JsonDoubleNode(String key, Double value) {
        this.key   = key;
        this.value  = new Double(value);
    }

    public  StringBuilder getJsonBuilder() {
        return new StringBuilder(value.toString());
    }

    public Double getValue(String key) {
        if(this.key.equals(key))
            return value;
        else
            return null;
    }
}
