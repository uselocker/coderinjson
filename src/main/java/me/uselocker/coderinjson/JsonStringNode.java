package me.uselocker.coderinjson;

class JsonStringNode extends JsonNode {

    private String value;

    public  JsonStringNode(String key, String value) {
        this.key = key;
        this.value  = value.trim();
    }

    @Override
    public  StringBuilder getJsonBuilder() {
        return new StringBuilder("\"").append(value).append("\"");
    }

    @Override
    public String getValue(String key) {
        if(this.key.equals(key))
            return value;
        else
            return null;
    }
}
