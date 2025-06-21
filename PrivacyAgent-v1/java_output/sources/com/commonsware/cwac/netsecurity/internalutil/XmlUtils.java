package com.commonsware.cwac.netsecurity.internalutil;

/* loaded from: classes22.dex */
public class XmlUtils {
    private static final java.lang.String STRING_ARRAY_SEPARATOR = ":";

    public interface ReadMapCallback {
        java.lang.Object readThisUnknownObjectXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException;
    }

    public interface WriteMapCallback {
        void writeUnknownObject(java.lang.Object obj, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException;
    }

    public static final void beginDocument(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
        }
        if (xmlPullParser.getName().equals(str)) {
            return;
        }
        throw new org.xmlpull.v1.XmlPullParserException("Unexpected start tag: found " + xmlPullParser.getName() + ", expected " + str);
    }

    public static final boolean convertValueToBoolean(java.lang.CharSequence charSequence, boolean z) {
        return charSequence == null ? z : charSequence.equals("1") || charSequence.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE) || charSequence.equals("TRUE");
    }

    public static final int convertValueToInt(java.lang.CharSequence charSequence, int i) {
        int i2;
        int i3;
        if (charSequence == null) {
            return i;
        }
        java.lang.String charSequence2 = charSequence.toString();
        int length = charSequence2.length();
        if ('-' == charSequence2.charAt(0)) {
            i2 = -1;
            i3 = 1;
        } else {
            i2 = 1;
            i3 = 0;
        }
        int i4 = 16;
        if ('0' == charSequence2.charAt(i3)) {
            if (i3 == length - 1) {
                return 0;
            }
            int i5 = i3 + 1;
            char charAt = charSequence2.charAt(i5);
            if ('x' == charAt || 'X' == charAt) {
                i3 += 2;
            } else {
                i3 = i5;
                i4 = 8;
            }
        } else if ('#' == charSequence2.charAt(i3)) {
            i3++;
        } else {
            i4 = 10;
        }
        return java.lang.Integer.parseInt(charSequence2.substring(i3), i4) * i2;
    }

    public static final int convertValueToList(java.lang.CharSequence charSequence, java.lang.String[] strArr, int i) {
        if (charSequence != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (charSequence.equals(strArr[i2])) {
                    return i2;
                }
            }
        }
        return i;
    }

    public static int convertValueToUnsignedInt(java.lang.String str, int i) {
        return str == null ? i : parseUnsignedIntAttribute(str);
    }

    public static final void nextElement(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                return;
            }
        } while (next != 1);
    }

    public static boolean nextElementWithin(org.xmlpull.v1.XmlPullParser xmlPullParser, int i) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return false;
            }
            if (next == 3 && xmlPullParser.getDepth() == i) {
                return false;
            }
            if (next == 2 && xmlPullParser.getDepth() == i + 1) {
                return true;
            }
        }
    }

    public static int parseUnsignedIntAttribute(java.lang.CharSequence charSequence) {
        java.lang.String charSequence2 = charSequence.toString();
        int length = charSequence2.length();
        int i = 0;
        int i2 = 16;
        if ('0' == charSequence2.charAt(0)) {
            if (length - 1 == 0) {
                return 0;
            }
            char charAt = charSequence2.charAt(1);
            if ('x' == charAt || 'X' == charAt) {
                i = 2;
            } else {
                i = 1;
                i2 = 8;
            }
        } else if ('#' == charSequence2.charAt(0)) {
            i = 1;
        } else {
            i2 = 10;
        }
        return (int) java.lang.Long.parseLong(charSequence2.substring(i), i2);
    }

    public static android.graphics.Bitmap readBitmapAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        byte[] readByteArrayAttribute = readByteArrayAttribute(xmlPullParser, str);
        if (readByteArrayAttribute != null) {
            return android.graphics.BitmapFactory.decodeByteArray(readByteArrayAttribute, 0, readByteArrayAttribute.length);
        }
        return null;
    }

    public static boolean readBooleanAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        return java.lang.Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, str));
    }

    public static boolean readBooleanAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, boolean z) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? z : java.lang.Boolean.parseBoolean(attributeValue);
    }

    public static byte[] readByteArrayAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return android.util.Base64.decode(attributeValue, 0);
        }
        return null;
    }

    public static float readFloatAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws java.io.IOException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        try {
            return java.lang.Float.parseFloat(attributeValue);
        } catch (java.lang.NumberFormatException unused) {
            throw new java.net.ProtocolException("problem parsing " + str + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + attributeValue + " as long");
        }
    }

    public static int readIntAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws java.io.IOException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        try {
            return java.lang.Integer.parseInt(attributeValue);
        } catch (java.lang.NumberFormatException unused) {
            throw new java.net.ProtocolException("problem parsing " + str + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + attributeValue + " as int");
        }
    }

    public static int readIntAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i) {
        try {
            return java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, str));
        } catch (java.lang.NumberFormatException unused) {
            return i;
        }
    }

    public static long readLongAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws java.io.IOException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        try {
            return java.lang.Long.parseLong(attributeValue);
        } catch (java.lang.NumberFormatException unused) {
            throw new java.net.ProtocolException("problem parsing " + str + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + attributeValue + " as long");
        }
    }

    public static long readLongAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j) {
        try {
            return java.lang.Long.parseLong(xmlPullParser.getAttributeValue(null, str));
        } catch (java.lang.NumberFormatException unused) {
            return j;
        }
    }

    public static final java.util.HashSet readSetXml(java.io.InputStream inputStream) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        return (java.util.HashSet) readValueXml(newPullParser, new java.lang.String[1]);
    }

    public static java.lang.String readStringAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        return xmlPullParser.getAttributeValue(null, str);
    }

    public static final java.util.HashMap<java.lang.String, ?> readThisArrayMapXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr, com.commonsware.cwac.netsecurity.internalutil.XmlUtils.ReadMapCallback readMapCallback) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.util.HashMap<java.lang.String, ?> hashMap = new java.util.HashMap<>();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashMap.put(strArr[0], readThisValueXml(xmlPullParser, strArr, readMapCallback, true));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashMap;
                }
                throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final boolean[] readThisBooleanArrayXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            int parseInt = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            boolean[] zArr = new boolean[parseInt];
            int eventType = xmlPullParser.getEventType();
            int i = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        zArr[i] = java.lang.Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value")).booleanValue();
                    } catch (java.lang.NullPointerException unused) {
                        throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in item");
                    } catch (java.lang.NumberFormatException unused2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return zArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
        } catch (java.lang.NullPointerException unused3) {
            throw new org.xmlpull.v1.XmlPullParserException("Need num attribute in string-array");
        } catch (java.lang.NumberFormatException unused4) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in num attribute in string-array");
        }
    }

    public static final double[] readThisDoubleArrayXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            int parseInt = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            double[] dArr = new double[parseInt];
            int eventType = xmlPullParser.getEventType();
            int i = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        dArr[i] = java.lang.Double.parseDouble(xmlPullParser.getAttributeValue(null, "value"));
                    } catch (java.lang.NullPointerException unused) {
                        throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in item");
                    } catch (java.lang.NumberFormatException unused2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return dArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
        } catch (java.lang.NullPointerException unused3) {
            throw new org.xmlpull.v1.XmlPullParserException("Need num attribute in double-array");
        } catch (java.lang.NumberFormatException unused4) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in num attribute in double-array");
        }
    }

    public static final int[] readThisIntArrayXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            int parseInt = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            int[] iArr = new int[parseInt];
            int eventType = xmlPullParser.getEventType();
            int i = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        iArr[i] = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"));
                    } catch (java.lang.NullPointerException unused) {
                        throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in item");
                    } catch (java.lang.NumberFormatException unused2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return iArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
        } catch (java.lang.NullPointerException unused3) {
            throw new org.xmlpull.v1.XmlPullParserException("Need num attribute in byte-array");
        } catch (java.lang.NumberFormatException unused4) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }

    public static final java.util.ArrayList readThisListXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        return readThisListXml(xmlPullParser, str, strArr, null, false);
    }

    private static final java.util.ArrayList readThisListXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr, com.commonsware.cwac.netsecurity.internalutil.XmlUtils.ReadMapCallback readMapCallback, boolean z) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(readThisValueXml(xmlPullParser, strArr, readMapCallback, z));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final long[] readThisLongArrayXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            int parseInt = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            long[] jArr = new long[parseInt];
            int eventType = xmlPullParser.getEventType();
            int i = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        jArr[i] = java.lang.Long.parseLong(xmlPullParser.getAttributeValue(null, "value"));
                    } catch (java.lang.NullPointerException unused) {
                        throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in item");
                    } catch (java.lang.NumberFormatException unused2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return jArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
        } catch (java.lang.NullPointerException unused3) {
            throw new org.xmlpull.v1.XmlPullParserException("Need num attribute in long-array");
        } catch (java.lang.NumberFormatException unused4) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in num attribute in long-array");
        }
    }

    public static final java.util.HashMap<java.lang.String, ?> readThisMapXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        return readThisMapXml(xmlPullParser, str, strArr, null);
    }

    public static final java.util.HashMap<java.lang.String, ?> readThisMapXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr, com.commonsware.cwac.netsecurity.internalutil.XmlUtils.ReadMapCallback readMapCallback) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.util.HashMap<java.lang.String, ?> hashMap = new java.util.HashMap<>();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashMap.put(strArr[0], readThisValueXml(xmlPullParser, strArr, readMapCallback, false));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashMap;
                }
                throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static final java.lang.Object readThisPrimitiveValueXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            if (str.equals(com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                return java.lang.Integer.valueOf(java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            }
            if (str.equals("long")) {
                return java.lang.Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("float")) {
                return new java.lang.Float(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("double")) {
                return new java.lang.Double(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("boolean")) {
                return java.lang.Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            return null;
        } catch (java.lang.NullPointerException unused) {
            throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in <" + str + ">");
        } catch (java.lang.NumberFormatException unused2) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in <" + str + ">");
        }
    }

    public static final java.util.HashSet readThisSetXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        return readThisSetXml(xmlPullParser, str, strArr, null, false);
    }

    private static final java.util.HashSet readThisSetXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr, com.commonsware.cwac.netsecurity.internalutil.XmlUtils.ReadMapCallback readMapCallback, boolean z) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.util.HashSet hashSet = new java.util.HashSet();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashSet.add(readThisValueXml(xmlPullParser, strArr, readMapCallback, z));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashSet;
                }
                throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final java.lang.String[] readThisStringArrayXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            int parseInt = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            java.lang.String[] strArr2 = new java.lang.String[parseInt];
            int eventType = xmlPullParser.getEventType();
            int i = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        strArr2[i] = xmlPullParser.getAttributeValue(null, "value");
                    } catch (java.lang.NullPointerException unused) {
                        throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in item");
                    } catch (java.lang.NumberFormatException unused2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return strArr2;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
        } catch (java.lang.NullPointerException unused3) {
            throw new org.xmlpull.v1.XmlPullParserException("Need num attribute in string-array");
        } catch (java.lang.NumberFormatException unused4) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in num attribute in string-array");
        }
    }

    private static final java.lang.Object readThisValueXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String[] strArr, com.commonsware.cwac.netsecurity.internalutil.XmlUtils.ReadMapCallback readMapCallback, boolean z) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        java.lang.Object obj = null;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        java.lang.String name = xmlPullParser.getName();
        if (!name.equals(com.igexin.push.core.b.m)) {
            if (name.equals(com.anythink.expressad.foundation.h.i.g)) {
                java.lang.String str = "";
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 1) {
                        throw new org.xmlpull.v1.XmlPullParserException("Unexpected end of document in <string>");
                    }
                    if (next2 == 3) {
                        if (xmlPullParser.getName().equals(com.anythink.expressad.foundation.h.i.g)) {
                            strArr[0] = attributeValue;
                            return str;
                        }
                        throw new org.xmlpull.v1.XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                    }
                    if (next2 == 4) {
                        str = str + xmlPullParser.getText();
                    } else if (next2 == 2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                    }
                }
            } else {
                obj = readThisPrimitiveValueXml(xmlPullParser, name);
                if (obj == null) {
                    if (name.equals("int-array")) {
                        int[] readThisIntArrayXml = readThisIntArrayXml(xmlPullParser, "int-array", strArr);
                        strArr[0] = attributeValue;
                        return readThisIntArrayXml;
                    }
                    if (name.equals("long-array")) {
                        long[] readThisLongArrayXml = readThisLongArrayXml(xmlPullParser, "long-array", strArr);
                        strArr[0] = attributeValue;
                        return readThisLongArrayXml;
                    }
                    if (name.equals("double-array")) {
                        double[] readThisDoubleArrayXml = readThisDoubleArrayXml(xmlPullParser, "double-array", strArr);
                        strArr[0] = attributeValue;
                        return readThisDoubleArrayXml;
                    }
                    if (name.equals("string-array")) {
                        java.lang.String[] readThisStringArrayXml = readThisStringArrayXml(xmlPullParser, "string-array", strArr);
                        strArr[0] = attributeValue;
                        return readThisStringArrayXml;
                    }
                    if (name.equals("boolean-array")) {
                        boolean[] readThisBooleanArrayXml = readThisBooleanArrayXml(xmlPullParser, "boolean-array", strArr);
                        strArr[0] = attributeValue;
                        return readThisBooleanArrayXml;
                    }
                    if (name.equals("map")) {
                        xmlPullParser.next();
                        java.util.HashMap<java.lang.String, ?> readThisArrayMapXml = z ? readThisArrayMapXml(xmlPullParser, "map", strArr, readMapCallback) : readThisMapXml(xmlPullParser, "map", strArr, readMapCallback);
                        strArr[0] = attributeValue;
                        return readThisArrayMapXml;
                    }
                    if (name.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST)) {
                        xmlPullParser.next();
                        java.util.ArrayList readThisListXml = readThisListXml(xmlPullParser, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, strArr, readMapCallback, z);
                        strArr[0] = attributeValue;
                        return readThisListXml;
                    }
                    if (name.equals("set")) {
                        xmlPullParser.next();
                        java.util.HashSet readThisSetXml = readThisSetXml(xmlPullParser, "set", strArr, readMapCallback, z);
                        strArr[0] = attributeValue;
                        return readThisSetXml;
                    }
                    if (readMapCallback != null) {
                        java.lang.Object readThisUnknownObjectXml = readMapCallback.readThisUnknownObjectXml(xmlPullParser, name);
                        strArr[0] = attributeValue;
                        return readThisUnknownObjectXml;
                    }
                    throw new org.xmlpull.v1.XmlPullParserException("Unknown tag: " + name);
                }
            }
        }
        do {
            next = xmlPullParser.next();
            if (next == 1) {
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected end of document in <" + name + ">");
            }
            if (next == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    return obj;
                }
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
            }
            if (next == 4) {
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
            }
        } while (next != 2);
        throw new org.xmlpull.v1.XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
    }

    public static android.net.Uri readUriAttribute(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return android.net.Uri.parse(attributeValue);
        }
        return null;
    }

    public static final java.lang.Object readValueXml(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
            }
            if (eventType == 4) {
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
            }
            eventType = xmlPullParser.next();
            if (eventType == 1) {
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected end of document");
            }
        }
        return readThisValueXml(xmlPullParser, strArr, null, false);
    }

    public static void skipCurrentTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    @java.lang.Deprecated
    public static void writeBitmapAttribute(org.xmlpull.v1.XmlSerializer xmlSerializer, java.lang.String str, android.graphics.Bitmap bitmap) throws java.io.IOException {
        if (bitmap != null) {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
            writeByteArrayAttribute(xmlSerializer, str, byteArrayOutputStream.toByteArray());
        }
    }

    public static final void writeBooleanArrayXml(boolean[] zArr, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (zArr == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.m);
            xmlSerializer.endTag(null, com.igexin.push.core.b.m);
            return;
        }
        xmlSerializer.startTag(null, "boolean-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", java.lang.Integer.toString(zArr.length));
        for (boolean z : zArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", java.lang.Boolean.toString(z));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "boolean-array");
    }

    public static void writeBooleanAttribute(org.xmlpull.v1.XmlSerializer xmlSerializer, java.lang.String str, boolean z) throws java.io.IOException {
        xmlSerializer.attribute(null, str, java.lang.Boolean.toString(z));
    }

    public static void writeByteArrayAttribute(org.xmlpull.v1.XmlSerializer xmlSerializer, java.lang.String str, byte[] bArr) throws java.io.IOException {
        if (bArr != null) {
            xmlSerializer.attribute(null, str, android.util.Base64.encodeToString(bArr, 0));
        }
    }

    public static final void writeByteArrayXml(byte[] bArr, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (bArr == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.m);
            xmlSerializer.endTag(null, com.igexin.push.core.b.m);
            return;
        }
        xmlSerializer.startTag(null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", java.lang.Integer.toString(bArr.length));
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b >> 4;
            sb.append(i >= 10 ? (i + 97) - 10 : i + 48);
            int i2 = b & 255;
            sb.append(i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
        }
        xmlSerializer.text(sb.toString());
        xmlSerializer.endTag(null, "byte-array");
    }

    public static final void writeDoubleArrayXml(double[] dArr, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (dArr == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.m);
            xmlSerializer.endTag(null, com.igexin.push.core.b.m);
            return;
        }
        xmlSerializer.startTag(null, "double-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", java.lang.Integer.toString(dArr.length));
        for (double d : dArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", java.lang.Double.toString(d));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "double-array");
    }

    public static void writeFloatAttribute(org.xmlpull.v1.XmlSerializer xmlSerializer, java.lang.String str, float f) throws java.io.IOException {
        xmlSerializer.attribute(null, str, java.lang.Float.toString(f));
    }

    public static final void writeIntArrayXml(int[] iArr, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (iArr == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.m);
            xmlSerializer.endTag(null, com.igexin.push.core.b.m);
            return;
        }
        xmlSerializer.startTag(null, "int-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", java.lang.Integer.toString(iArr.length));
        for (int i : iArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", java.lang.Integer.toString(i));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "int-array");
    }

    public static void writeIntAttribute(org.xmlpull.v1.XmlSerializer xmlSerializer, java.lang.String str, int i) throws java.io.IOException {
        xmlSerializer.attribute(null, str, java.lang.Integer.toString(i));
    }

    public static final void writeListXml(java.util.List list, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (list == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.m);
            xmlSerializer.endTag(null, com.igexin.push.core.b.m);
            return;
        }
        xmlSerializer.startTag(null, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST);
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            writeValueXml(list.get(i), null, xmlSerializer);
        }
        xmlSerializer.endTag(null, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST);
    }

    public static final void writeLongArrayXml(long[] jArr, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (jArr == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.m);
            xmlSerializer.endTag(null, com.igexin.push.core.b.m);
            return;
        }
        xmlSerializer.startTag(null, "long-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", java.lang.Integer.toString(jArr.length));
        for (long j : jArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", java.lang.Long.toString(j));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "long-array");
    }

    public static void writeLongAttribute(org.xmlpull.v1.XmlSerializer xmlSerializer, java.lang.String str, long j) throws java.io.IOException {
        xmlSerializer.attribute(null, str, java.lang.Long.toString(j));
    }

    public static final void writeMapXml(java.util.Map map, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        writeMapXml(map, str, xmlSerializer, null);
    }

    public static final void writeMapXml(java.util.Map map, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer, com.commonsware.cwac.netsecurity.internalutil.XmlUtils.WriteMapCallback writeMapCallback) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (map == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.m);
            xmlSerializer.endTag(null, com.igexin.push.core.b.m);
            return;
        }
        xmlSerializer.startTag(null, "map");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        writeMapXml(map, xmlSerializer, writeMapCallback);
        xmlSerializer.endTag(null, "map");
    }

    public static final void writeMapXml(java.util.Map map, org.xmlpull.v1.XmlSerializer xmlSerializer, com.commonsware.cwac.netsecurity.internalutil.XmlUtils.WriteMapCallback writeMapCallback) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (map == null) {
            return;
        }
        for (java.util.Map.Entry entry : map.entrySet()) {
            writeValueXml(entry.getValue(), (java.lang.String) entry.getKey(), xmlSerializer, writeMapCallback);
        }
    }

    public static final void writeSetXml(java.util.Set set, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (set == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.m);
            xmlSerializer.endTag(null, com.igexin.push.core.b.m);
            return;
        }
        xmlSerializer.startTag(null, "set");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        java.util.Iterator it = set.iterator();
        while (it.hasNext()) {
            writeValueXml(it.next(), null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "set");
    }

    public static final void writeStringArrayXml(java.lang.String[] strArr, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (strArr == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.m);
            xmlSerializer.endTag(null, com.igexin.push.core.b.m);
            return;
        }
        xmlSerializer.startTag(null, "string-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", java.lang.Integer.toString(strArr.length));
        for (java.lang.String str2 : strArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", str2);
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "string-array");
    }

    public static void writeStringAttribute(org.xmlpull.v1.XmlSerializer xmlSerializer, java.lang.String str, java.lang.String str2) throws java.io.IOException {
        if (str2 != null) {
            xmlSerializer.attribute(null, str, str2);
        }
    }

    public static void writeUriAttribute(org.xmlpull.v1.XmlSerializer xmlSerializer, java.lang.String str, android.net.Uri uri) throws java.io.IOException {
        if (uri != null) {
            xmlSerializer.attribute(null, str, uri.toString());
        }
    }

    public static final void writeValueXml(java.lang.Object obj, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        writeValueXml(obj, str, xmlSerializer, null);
    }

    private static final void writeValueXml(java.lang.Object obj, java.lang.String str, org.xmlpull.v1.XmlSerializer xmlSerializer, com.commonsware.cwac.netsecurity.internalutil.XmlUtils.WriteMapCallback writeMapCallback) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String str2;
        if (obj == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.m);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.endTag(null, com.igexin.push.core.b.m);
            return;
        }
        if (obj instanceof java.lang.String) {
            xmlSerializer.startTag(null, com.anythink.expressad.foundation.h.i.g);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, com.anythink.expressad.foundation.h.i.g);
            return;
        }
        if (obj instanceof java.lang.Integer) {
            str2 = com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        } else if (obj instanceof java.lang.Long) {
            str2 = "long";
        } else if (obj instanceof java.lang.Float) {
            str2 = "float";
        } else if (obj instanceof java.lang.Double) {
            str2 = "double";
        } else {
            if (!(obj instanceof java.lang.Boolean)) {
                if (obj instanceof byte[]) {
                    writeByteArrayXml((byte[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof int[]) {
                    writeIntArrayXml((int[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof long[]) {
                    writeLongArrayXml((long[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof double[]) {
                    writeDoubleArrayXml((double[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof java.lang.String[]) {
                    writeStringArrayXml((java.lang.String[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof boolean[]) {
                    writeBooleanArrayXml((boolean[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof java.util.Map) {
                    writeMapXml((java.util.Map) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof java.util.List) {
                    writeListXml((java.util.List) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof java.util.Set) {
                    writeSetXml((java.util.Set) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof java.lang.CharSequence) {
                    xmlSerializer.startTag(null, com.anythink.expressad.foundation.h.i.g);
                    if (str != null) {
                        xmlSerializer.attribute(null, "name", str);
                    }
                    xmlSerializer.text(obj.toString());
                    xmlSerializer.endTag(null, com.anythink.expressad.foundation.h.i.g);
                    return;
                }
                if (writeMapCallback != null) {
                    writeMapCallback.writeUnknownObject(obj, str, xmlSerializer);
                    return;
                }
                throw new java.lang.RuntimeException("writeValueXml: unable to write value " + obj);
            }
            str2 = "boolean";
        }
        xmlSerializer.startTag(null, str2);
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "value", obj.toString());
        xmlSerializer.endTag(null, str2);
    }
}
