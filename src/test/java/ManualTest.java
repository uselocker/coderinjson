import me.uselocker.coderinjson.JsonArrayNode;
import me.uselocker.coderinjson.JsonObject;
import me.uselocker.coderinjson.exception.CyclicLinkException;

public class ManualTest {
    public static void main(String[] args) throws CyclicLinkException {
        /*
        Example for creating JSON for description menu item like:

        {"menu": {
            "id": "file",
            "value": "File",
            "popup": {
                "menuitem": [
                    {"value": "New", "onclick": "CreateNewDoc()"},
                    {"value": "Open", "onclick": "OpenDoc()"},
                    {"value": "Close", "onclick": "CloseDoc()"}
                    ]
                }
            }
        }
        */

        JsonObject menuItemNew = new JsonObject().add("value", "New").add("onclick", "CreateNewDoc()");
        JsonObject menuItemOpen = new JsonObject().add("value", "Open").add("onclick", "OpenDoc()");
        JsonObject menuItemClose = new JsonObject().add("value", "Close").add("onclick", "CloseDoc()");
        JsonObject headObject = new JsonObject()
                .add("menu", new JsonObject()
                        .add("id", "file")
                        .add("value", "file")
                        .add("popup", new JsonObject()
                                .add("menuitem", new JsonArrayNode()
                                        .add(menuItemNew)
                                        .add(menuItemOpen)
                                        .add(menuItemClose)
                                )
                        )
                );

        System.out.println(headObject.getJSON());
        //{"menu": {"id": "file", "value": "file", "popup": {"menuitem": [{"value": "New", "onclick": "CreateNewDoc()"}, {"value": "Open", "onclick": "OpenDoc()"}, {"value": "Close", "onclick": "CloseDoc()"}]}}}
    }
}
