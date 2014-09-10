package me.uselocker.coderinjson;

abstract class JsonNode {

    protected String key = "";

    protected String getKey() {
        return "\"" + key + "\"";
    }

    protected abstract Object getValue(String key);

    protected abstract StringBuilder getJsonBuilder();
}


// todo size()
// todo implement flag for Boxing
// todo implement returnIfInt...(); for getValue(); Object