package Adapter_Disign_Pattern;

public class Main {
    public static void main(String[] args) {
        XmlService xmlService = new XmlService();
        JsonService adapter = new XmlToJsonAdapter(xmlService);

        adapter.sendJson("{ \"name\": \"Task A\", \"status\": \"DONE\" }");
    }
}
