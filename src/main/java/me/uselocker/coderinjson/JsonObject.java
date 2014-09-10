package me.uselocker.coderinjson;

import me.uselocker.coderinjson.exception.CyclicLinkException;

public class JsonObject extends JsonNode {

    private JsonObject tail = null;
    private JsonNode jsonNode = null;
    
    public JsonObject() {}

    private JsonObject(JsonObject jo) {
        tail = jo;
    }

    public JsonObject add(String key, JsonObject value) throws CyclicLinkException {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        if(value != null && value.equals(this))
            throw new CyclicLinkException();

        tail = new JsonObject(tail);
        if(value == null)
            tail.addJOnull(key);
        else
            tail.addJO(key, value);
        return this;
    }

    private void addJO(String key, JsonObject value) {
        jsonNode = value;
        jsonNode.key = key;
    }

    public JsonObject add(String key, JsonArrayNode value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        tail = new JsonObject(tail);
        if(value == null)
            tail.addJOnull(key);
        else
            tail.addJOArray(key, value);
        return this;
    }

    private void addJOArray(String index, JsonArrayNode value) {
        jsonNode = value;
        jsonNode.key = index;
    }

    public JsonObject add(String key, String value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        tail = new JsonObject(tail);
        if(value == null || value.toLowerCase().equals("null"))
            tail.addJOnull(key);
        else
            tail.addJOstr(key, value);
        return this;
    }
    
    private void addJOstr(String key, String value) {
        jsonNode = new JsonStringNode(key , value);
    }

    public JsonObject add(String key, Integer value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        tail = new JsonObject(tail);
        if(value == null)
            tail.addJOnull(key);
        else
            tail.addJOint(key, value);
        return this;
    }

    public JsonObject add(String key, int value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        tail = new JsonObject(tail);
        tail.addJOint(key, value);
        return this;
    }
    
    private void addJOint(String key, Integer value) {
        jsonNode = new JsonIntNode(key, value);
    }

    public JsonObject add(String key, Boolean value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        tail = new JsonObject(tail);
        if(value == null)
            tail.addJOnull(key);
        else
            tail.addJObool(key, value);
        return this;
    }
    
    public JsonObject add(String key, boolean value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        tail = new JsonObject(tail);
        tail.addJObool(key, value);
        return this;
    }
    
    private void addJObool(String key, Boolean value) {
        jsonNode = new JsonBooleanNode(key, value);
    }

    public JsonObject add(String key, Double value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        tail = new JsonObject(tail);
        if(value == null)
            tail.addJOnull(key);
        else
            tail.addJOdbl(key, value);
        return this;
    }
    
    public JsonObject add(String key, double value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        tail = new JsonObject(tail);
        tail.addJOdbl(key, value);
        return this;
    }
    
    private void addJOdbl(String key, double value) {
        jsonNode = new JsonDoubleNode(key, value);
    }

    private void addJOnull(String key) {
        jsonNode = new JsonNullNode(key);
    }

    @Override
    public Object getValue(String key) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        Object value = null;
        
        if(jsonNode != null && jsonNode.key.equals(key)) {
            if(jsonNode instanceof JsonObject ||
                    jsonNode instanceof JsonArrayNode)
                value = jsonNode;
            else
                value = jsonNode.getValue(key);
        }

        if(value == null && jsonNode != null)
            value = jsonNode.getValue(key);

        if(value == null && tail != null)
            value = tail.getValue(key);
        
        return value;
    }

    public boolean containsKey(String key) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        boolean value = false;

        if(this.key.equals(key))
            value = true;

        if(!value && jsonNode != null && jsonNode.key.equals(key))
            value = true;

        if(!value && jsonNode instanceof JsonObject)
            value = ((JsonObject) jsonNode).containsKey(key);

        if(!value && tail != null)
            value =  tail.containsKey(key);

        return value;
    }

    public void setValue(String key, JsonObject value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        JsonObject nodeHolder = getHolder(key);
        if(nodeHolder != null) {
            if(value != null)
                nodeHolder.addJO(key, value);
            else
                nodeHolder.addJOnull(key);
        }
    }

    public void setValue(String key, String value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        JsonObject nodeHolder = getHolder(key);
        if(nodeHolder != null) {
            if(value != null)
                nodeHolder.addJOstr(key, value);
            else
                nodeHolder.addJOnull(key);
        }
    }

    public void setValue(String key, Integer value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        JsonObject nodeHolder = getHolder(key);
        if(nodeHolder != null) {
            if(value != null)
                nodeHolder.addJOint(key, value);
            else
                nodeHolder.addJOnull(key);
        }
    }

    public void setValue(String key, int value) {
        setValue(key, Integer.valueOf(value));
    }

    public void setValue(String key, Double value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        JsonObject nodeHolder = getHolder(key);
        if(nodeHolder != null) {
            if(value != null)
                nodeHolder.addJOdbl(key, value);
            else
                nodeHolder.addJOnull(key);
        }
    }

    public void setValue(String key, double value) {
        setValue(key, Double.valueOf(value));
    }

    public void setValue(String key, Boolean value) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();

        JsonObject nodeHolder = getHolder(key);
        if(nodeHolder != null) {
            if(value != null)
            nodeHolder.addJObool(key, value);
            else
                nodeHolder.addJOnull(key);
        }
    }

    public void setValue(String key, boolean value) {
        setValue(key, Boolean.valueOf(value));
    }

    public JsonObject remove(String key) {
        if(isKeyNotValid(key))
            throw new IllegalArgumentException();
        return remove(key, this);
    }

    public String getJSON() {
        return getJsonBuilder().toString();
    }

    public void clear() {
        jsonNode = null;
        tail = null;
    }

    @Override
    public String toString() {
        return getJSON();
    }

    @Override
    protected StringBuilder getJsonBuilder() {
        StringBuilder data = new StringBuilder();
        if(jsonNode != null)
            data = new StringBuilder(jsonNode.getKey()).append(": ")
                    .append(jsonNode.getJsonBuilder());

        if(tail != null)
            data = data.length() > 0
                    ? tail.getJsonBuilder().append(", ").append(data)
                    : tail.getJsonBuilder();

        if(jsonNode == null)
            data = new StringBuilder("{").append(data).append("}");

        return data;
    }

    private boolean isKeyNotValid(String key) {
        return (key == null || key.length() == 0);
    }

    private JsonObject getHolder(String key) {
        Object value = null;

        if(jsonNode != null && jsonNode.key.equals(key))
            value = this;

        if(value == null && jsonNode instanceof JsonObject)
            value = ((JsonObject) jsonNode).getHolder(key);

        if(value == null && tail != null)
            value = tail.getHolder(key);

        return (JsonObject)value;
    }

    private JsonObject remove(String key, JsonObject head) {
        Object value = null;

        if(jsonNode != null && jsonNode.key.equals(key)) {
            head.tail = this.tail;
            value = this;
            this.tail = null;
        }

        if(value == null && jsonNode instanceof JsonObject)
            value = ((JsonObject) jsonNode).remove(key, this);

        if(tail != null && value == null)
            value = tail.remove(key, this);

        return (JsonObject)value;
    }
}
