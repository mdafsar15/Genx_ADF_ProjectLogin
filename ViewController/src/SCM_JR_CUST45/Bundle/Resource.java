package SCM_JR_CUST45.Bundle;

import java.util.ListResourceBundle;
import java.io.File;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import oracle.adf.share.config.resources.Messages_en;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.javatools.resourcebundle.ResourceBundleManagerRT;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Resource extends ListResourceBundle {
    public Resource() {
        for (int i = 0; i < 15000; i++) {
            contents[i][0] = "";
            contents[i][1] = "";
        }
    }

    private static final Object[][] contents = new Object[15000][2];

    public Object[][] getContents() {
        //System.out.println("Resource.java Called");
        String fileNm = AdfFacesContext.getCurrentInstance().getPageFlowScope().get("iUsrRepf").toString();  // uncomment before jar creation
		
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

        String path = AdfFacesContext.getCurrentInstance().getPageFlowScope().get("iFsPath").toString();
        //System.out.println("file name is-->" + fileNm);
        //System.out.println("path  is-->" + path);
        //System.out.println("final dir is--->" + (path + "//Resource" + "//" + fileNm));
        try {

            File file = new File(path + "//Resource" + "//" + fileNm);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("label");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    contents[temp][0] = getTagValue("key", eElement);
                    contents[temp][1] = getTagValue("value", eElement);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }

    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }
}
