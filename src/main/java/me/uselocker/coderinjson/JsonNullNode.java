package me.uselocker.coderinjson;

class JsonNullNode extends JsonNode {

    public JsonNullNode(String key) {
        this.key = key;
    }

    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    protected StringBuilder getJsonBuilder() {
        return new StringBuilder("null");
    }
}
