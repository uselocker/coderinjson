package me.uselocker.coderinjson;

class JsonIntNode extends JsonNode {

    private final Integer value;
    
    public  JsonIntNode(String key, Integer value) {
        super.key   = key;
        this.value  = new Integer(value);
    }

    @Override
    public  StringBuilder getJsonBuilder() {
        return new StringBuilder(value.toString());
    }

    @Override
    public Integer getValue(String key) {
        if(this.key.equals(key))
            return value;
        else
            return null;
    }
}
