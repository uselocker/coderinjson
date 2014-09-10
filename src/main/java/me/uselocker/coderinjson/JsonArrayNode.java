package me.uselocker.coderinjson;

import me.uselocker.coderinjson.utils.Counter;

public class JsonArrayNode extends JsonNode {

    private JsonArrayNode tail = null;
    private JsonNode jsonNode = null;
    private Counter counter = null;
    private int index = -1;

    public JsonArrayNode() {counter = new Counter();}

    private JsonArrayNode(JsonArrayNode jan, int index) {
        this.index = index;
        tail = jan;
    }

    public JsonArrayNode add(JsonArrayNode value) {

        tail = new JsonArrayNode(tail, counter.inc());
        if(value == null)
            tail.addJOnull();
        else
            tail.addJOArray(value);

        return this;
    }

    private void addJOArray(JsonArrayNode value) {
        jsonNode = value;
        jsonNode.key = getKeyByIndex();
    }

    public JsonArrayNode add(JsonObject value) {

        tail = new JsonArrayNode(tail, counter.inc());
        if(value == null)
            tail.addJOnull();
        else
            tail.addJO(value);

        return this;
    }

    private void addJO(JsonObject value) {
        jsonNode = value;
        jsonNode.key = getKeyByIndex();
    }

    public JsonArrayNode add(String value) {

        tail = new JsonArrayNode(tail, counter.inc());
        if(value == null || value.toLowerCase().equals("null"))
            tail.addJOnull();
        else
            tail.addJOstr(value);

        return this;
    }

    private void addJOstr(String value) {
        jsonNode = new JsonStringNode(getKeyByIndex() , value);
    }

    public JsonArrayNode add(Integer value) {

        tail = new JsonArrayNode(tail, counter.inc());
        if(value == null)
            tail.addJOnull();
        else
            tail.addJOint(value);

        return this;
    }

    public JsonArrayNode add(int value) {

        tail = new JsonArrayNode(tail, counter.inc());
        tail.addJOint(value);

        return this;
    }

    private void addJOint(Integer value) {
        jsonNode = new JsonIntNode(getKeyByIndex(), value);
    }

    public JsonArrayNode add(Boolean value) {

        tail = new JsonArrayNode(tail, counter.inc());
        if(value == null)
            tail.addJOnull();
        else
            tail.addJObool(value);

        return this;
    }

    public JsonArrayNode add(boolean value) {

        tail = new JsonArrayNode(tail, counter.inc());
        tail.addJObool(value);

        return this;
    }

    private void addJObool(Boolean value) {
        jsonNode = new JsonBooleanNode(getKeyByIndex(), value);
    }

    public JsonArrayNode add(Double value) {

        tail = new JsonArrayNode(tail, counter.inc());
        if(value == null)
            tail.addJOnull();
        else
            tail.addJOdbl(value);

        return this;
    }

    public JsonArrayNode add(double value) {

        tail = new JsonArrayNode(tail, counter.inc());
        tail.addJOdbl(value);

        return this;
    }

    private void addJOdbl(double value) {
        jsonNode = new JsonDoubleNode(getKeyByIndex(), value);
    }

    private void addJOnull() {
        jsonNode = new JsonNullNode(getKeyByIndex());
    }

    public void setValue(int index, JsonArrayNode value) {
        if(index < 0)
            return;

        JsonArrayNode nodeHolder = getHolder(index);
        if(nodeHolder != null) {
            if(value != null)
                nodeHolder.addJOArray(value);
            else
                nodeHolder.addJOnull();
        }
    }

    public void setValue(int index, JsonObject value) {
        if(index < 0)
            return;

        JsonArrayNode nodeHolder = getHolder(index);
        if(nodeHolder != null) {
            if(value != null)
                nodeHolder.addJO(value);
            else
                nodeHolder.addJOnull();
        }
    }

    public void setValue(int index, String value) {
        if(index < 0)
            return;

        JsonArrayNode nodeHolder = getHolder(index);
        if(nodeHolder != null) {
            if(value != null)
                nodeHolder.addJOstr(value);
            else
                nodeHolder.addJOnull();
        }
    }

    public void setValue(int index, int value) {
        setValue(index, Integer.valueOf(value));
    }

    public void setValue(int index, Integer value) {
        if(index < 0)
            return;

        JsonArrayNode nodeHolder = getHolder(index);
        if(nodeHolder != null) {
            if(value != null)
                nodeHolder.addJOint(value);
            else
                nodeHolder.addJOnull();
        }
    }

    public void setValue(int index, double value) {
        setValue(index, Double.valueOf(value));
    }

    public void setValue(int index, Double value) {
        if(index < 0)
            return;

        JsonArrayNode nodeHolder = getHolder(index);
        if(nodeHolder != null) {
            if(value != null)
                nodeHolder.addJOdbl(value);
            else
                nodeHolder.addJOnull();
        }
    }

    public void setValue(int index, boolean value) {
        setValue(index, Boolean.valueOf(value));
    }

    public void setValue(int index, Boolean value) {
        if(index < 0)
            return;

        JsonArrayNode nodeHolder = getHolder(index);
        if(nodeHolder != null) {
            if(value != null)
                nodeHolder.addJObool(value);
            else
                nodeHolder.addJOnull();
        }
    }

    private JsonArrayNode getHolder(int index) {

        JsonArrayNode value = null;

        if(this.index == index)
            value = this;

        if(tail != null && value == null)
            value = tail.getHolder(index);

        return value;
    }

    @Override
    protected Object getValue(String index) {
        return getValue(Integer.valueOf(index));
    }

    public Object getValue(int index) {
        if(index < 0 )
            return null;

        Object value = null;

        if(this.index == index) {
            if(jsonNode instanceof JsonArrayNode ||
                    jsonNode instanceof JsonObject)
                value = jsonNode;
            else
                value = jsonNode.getValue(getKeyByIndex());
        }


        if(value == null && tail != null)
            value = tail.getValue(index);

        return value;
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
            data = new StringBuilder(jsonNode.getJsonBuilder());

        if(tail != null)
            data = data.length() > 0
                    ? tail.getJsonBuilder().append(", ").append(data)
                    : tail.getJsonBuilder();

        if(jsonNode == null)
            data = new StringBuilder("[").append(data).append("]");

        return data;
    }

    public JsonArrayNode remove(int index) {
        if(index < 0)
            return null;

        JsonArrayNode jsonArrayNode = remove(index, this);
        if(jsonArrayNode != null)
            counter.dec();
        return jsonArrayNode;
    }

    private JsonArrayNode remove(int index, JsonArrayNode head) {
        JsonArrayNode value = null;

        if(this.index == index) {
            head.tail = this.tail;
            value = this;
            this.tail = null;
        }

        if(tail != null && value == null)
            value = tail.remove(index, this);

        if(value != null) {
            this.index--;
            if(jsonNode != null)
                jsonNode.key = getKeyByIndex();
        }

        return value;
    }

    private String getKeyByIndex() {
        return String.valueOf(index);
    }
}
