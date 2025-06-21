package com.huawei.secure.android.common.xml;

/* loaded from: classes22.dex */
public class DocumentBuilderFactorySecurity {
    public static javax.xml.parsers.DocumentBuilderFactory getInstance() throws javax.xml.parsers.ParserConfigurationException, java.lang.NullPointerException {
        javax.xml.parsers.DocumentBuilderFactory newInstance = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        newInstance.setFeature(org.apache.tools.ant.util.XmlConstants.FEATURE_NAMESPACES, true);
        newInstance.setFeature(org.apache.tools.ant.util.XmlConstants.FEATURE_VALIDATION, false);
        newInstance.setExpandEntityReferences(false);
        return newInstance;
    }
}
