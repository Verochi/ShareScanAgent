package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class DOMUtils {
    public static void appendCDATA(org.w3c.dom.Element element, java.lang.String str) {
        element.appendChild(element.getOwnerDocument().createCDATASection(str));
    }

    public static void appendCDATAElement(org.w3c.dom.Element element, java.lang.String str, java.lang.String str2) {
        appendCDATA(createChildElement(element, str), str2);
    }

    public static void appendText(org.w3c.dom.Element element, java.lang.String str) {
        element.appendChild(element.getOwnerDocument().createTextNode(str));
    }

    public static void appendTextElement(org.w3c.dom.Element element, java.lang.String str, java.lang.String str2) {
        appendText(createChildElement(element, str), str2);
    }

    public static org.w3c.dom.Element createChildElement(org.w3c.dom.Element element, java.lang.String str) {
        org.w3c.dom.Element createElement = element.getOwnerDocument().createElement(str);
        element.appendChild(createElement);
        return createElement;
    }

    public static org.w3c.dom.Document newDocument() {
        return org.apache.tools.ant.util.JAXPUtils.getDocumentBuilder().newDocument();
    }
}
