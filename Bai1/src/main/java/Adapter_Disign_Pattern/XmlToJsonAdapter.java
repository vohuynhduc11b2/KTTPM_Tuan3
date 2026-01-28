package Adapter_Disign_Pattern;

public class XmlToJsonAdapter implements JsonService {
    private XmlService xmlService;

    public XmlToJsonAdapter(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public void sendJson(String json) {
        String xml = convertJsonToXml(json);
        xmlService.sendXml(xml);
    }

    private String convertJsonToXml(String json) {
        // Demo đơn giản
        return "<data>" + json + "</data>";
    }
}
