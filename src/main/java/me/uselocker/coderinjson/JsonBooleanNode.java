package me.uselocker.coderinjson;

class JsonBooleanNode extends JsonNode {

    private Boolean value;
    
    public  JsonBooleanNode(String key, Boolean value) {
        this.key   = key;
        this.value  = new Boolean(value);
    }

    @Override
    public  StringBuilder getJsonBuilder() {
        return new StringBuilder(value.toString());
    }

    @Override
    public Boolean getValue(String key) {
        if(this.key.equals(key))
            return value;
        else
            return null;
    }
}
