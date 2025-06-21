package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class ag {
    private ag() {
    }

    private static java.lang.String a(java.lang.String str) {
        int indexOf = str.indexOf(58);
        return indexOf == -1 ? str : str.substring(indexOf + 1);
    }

    private static boolean a(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    private static boolean a(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        return (xmlPullParser.getEventType() == 3) && xmlPullParser.getName().equals(str);
    }

    private static boolean b(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    private static boolean b(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        return b(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    private static boolean c(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        return b(xmlPullParser) && a(xmlPullParser.getName()).equals(str);
    }

    private static java.lang.String d(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    private static java.lang.String e(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (a(xmlPullParser.getAttributeName(i)).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
