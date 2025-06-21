package com.huawei.secure.android.common.xml;

/* loaded from: classes22.dex */
public class XmlPullParserFactorySecurity {
    public static org.xmlpull.v1.XmlPullParserFactory getInstance() throws org.xmlpull.v1.XmlPullParserException {
        org.xmlpull.v1.XmlPullParserFactory newInstance = org.xmlpull.v1.XmlPullParserFactory.newInstance();
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes", false);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", true);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#validation", false);
        return newInstance;
    }
}
