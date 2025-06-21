package com.huawei.secure.android.common.xml;

/* loaded from: classes22.dex */
public class SAXParserFactorySecurity {
    public static javax.xml.parsers.SAXParserFactory getInstance() throws javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException, java.lang.NullPointerException {
        javax.xml.parsers.SAXParserFactory newInstance = javax.xml.parsers.SAXParserFactory.newInstance();
        newInstance.setFeature(org.apache.tools.ant.util.XmlConstants.FEATURE_NAMESPACES, true);
        newInstance.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
        newInstance.setFeature(org.apache.tools.ant.util.XmlConstants.FEATURE_VALIDATION, false);
        newInstance.setFeature(org.apache.tools.ant.util.XmlConstants.FEATURE_EXTERNAL_ENTITIES, false);
        newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        newInstance.setFeature("http://xml.org/sax/features/string-interning", true);
        return newInstance;
    }
}
