package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class cg implements com.xiaomi.push.ft {
    public static com.xiaomi.push.fk a(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return b(xmlPullParser);
        }
        return null;
    }

    private static com.xiaomi.push.fk b(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        java.lang.String[] strArr;
        java.lang.String[] strArr2;
        java.lang.String str;
        java.util.ArrayList arrayList;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        java.lang.String name = xmlPullParser.getName();
        java.lang.String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            java.lang.String[] strArr3 = new java.lang.String[xmlPullParser.getAttributeCount()];
            java.lang.String[] strArr4 = new java.lang.String[xmlPullParser.getAttributeCount()];
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                strArr3[i] = xmlPullParser.getAttributeName(i);
                strArr4[i] = com.xiaomi.push.fy.b(xmlPullParser.getAttributeValue(i));
            }
            strArr = strArr3;
            str = null;
            arrayList = null;
            strArr2 = strArr4;
        } else {
            strArr = null;
            strArr2 = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new com.xiaomi.push.fk(name, namespace, strArr, strArr2, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                com.xiaomi.push.fk b = b(xmlPullParser);
                if (b != null) {
                    arrayList.add(b);
                }
            }
        }
    }
}
