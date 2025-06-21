package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class fv {
    private static org.xmlpull.v1.XmlPullParser a;

    public static com.xiaomi.push.fl a(org.xmlpull.v1.XmlPullParser xmlPullParser, com.xiaomi.push.ev evVar) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue("", "id");
        java.lang.String attributeValue2 = xmlPullParser.getAttributeValue("", com.huawei.hms.push.constant.RemoteMessageConst.TO);
        java.lang.String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        java.lang.String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        com.xiaomi.push.fl.a a2 = com.xiaomi.push.fl.a.a(xmlPullParser.getAttributeValue("", "type"));
        java.util.HashMap hashMap = new java.util.HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            java.lang.String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        com.xiaomi.push.fl flVar = null;
        com.xiaomi.push.fr frVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                java.lang.String name = xmlPullParser.getName();
                xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    frVar = e(xmlPullParser);
                } else {
                    flVar = new com.xiaomi.push.fl();
                    flVar.a(f(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (flVar == null) {
            if (com.xiaomi.push.fl.a.a == a2 || com.xiaomi.push.fl.a.b == a2) {
                com.xiaomi.push.fw fwVar = new com.xiaomi.push.fw();
                fwVar.q = attributeValue;
                fwVar.r = attributeValue3;
                fwVar.f466s = attributeValue2;
                fwVar.a(com.xiaomi.push.fl.a.d);
                fwVar.t = attributeValue4;
                fwVar.v = new com.xiaomi.push.fr(com.xiaomi.push.fr.a.e);
                evVar.a(fwVar);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
            flVar = new com.xiaomi.push.fx();
        }
        flVar.q = attributeValue;
        flVar.r = attributeValue2;
        flVar.t = attributeValue4;
        flVar.f466s = attributeValue3;
        flVar.a(a2);
        flVar.v = frVar;
        flVar.a(hashMap);
        return flVar;
    }

    public static com.xiaomi.push.fn a(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        java.lang.String str;
        int i = 2;
        boolean z = false;
        java.lang.String str2 = null;
        com.xiaomi.push.fn fnVar = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            java.lang.String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            java.lang.String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            java.lang.String attributeValue4 = xmlPullParser.getAttributeValue("", com.huawei.hms.push.constant.RemoteMessageConst.TO);
            java.lang.String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            com.xiaomi.push.service.aj.b b = com.xiaomi.push.service.aj.a().b(attributeValue, attributeValue4);
            if (b == null) {
                b = com.xiaomi.push.service.aj.a().b(attributeValue, attributeValue3);
            }
            com.xiaomi.push.service.aj.b bVar = b;
            if (bVar == null) {
                throw new com.xiaomi.push.fh("the channel id is wrong while receiving a encrypted message");
            }
            while (!z) {
                int next = xmlPullParser.next();
                if (next == i) {
                    if (!"s".equals(xmlPullParser.getName())) {
                        throw new com.xiaomi.push.fh("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new com.xiaomi.push.fh("error while receiving a encrypted message with wrong format");
                    }
                    java.lang.String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                        com.xiaomi.push.fm fmVar = new com.xiaomi.push.fm();
                        fmVar.t = attributeValue;
                        fmVar.m = true;
                        fmVar.f466s = attributeValue3;
                        fmVar.r = attributeValue4;
                        fmVar.q = attributeValue2;
                        fmVar.a = attributeValue5;
                        com.xiaomi.push.fk fkVar = new com.xiaomi.push.fk("s");
                        if (!android.text.TextUtils.isEmpty(text)) {
                            text = com.xiaomi.push.fy.a(text);
                        }
                        fkVar.b = text;
                        fmVar.a(fkVar);
                        return fmVar;
                    }
                    byte[] a2 = com.xiaomi.push.service.as.a(com.xiaomi.push.service.as.a(bVar.i, attributeValue2), text);
                    if (a == null) {
                        try {
                            org.xmlpull.v1.XmlPullParser newPullParser = org.xmlpull.v1.XmlPullParserFactory.newInstance().newPullParser();
                            a = newPullParser;
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        } catch (org.xmlpull.v1.XmlPullParserException e) {
                            e.printStackTrace();
                        }
                    }
                    a.setInput(new java.io.InputStreamReader(new java.io.ByteArrayInputStream(a2)));
                    a.next();
                    fnVar = a(a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
                i = 2;
            }
            if (fnVar != null) {
                return fnVar;
            }
            throw new com.xiaomi.push.fh("error while receiving a encrypted message with wrong format");
        }
        com.xiaomi.push.fm fmVar2 = new com.xiaomi.push.fm();
        java.lang.String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        fmVar2.q = attributeValue6;
        fmVar2.r = xmlPullParser.getAttributeValue("", com.huawei.hms.push.constant.RemoteMessageConst.TO);
        fmVar2.f466s = xmlPullParser.getAttributeValue("", "from");
        fmVar2.t = xmlPullParser.getAttributeValue("", "chid");
        fmVar2.h = xmlPullParser.getAttributeValue("", "appid");
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (java.lang.Exception unused) {
            str = null;
        }
        try {
            java.lang.String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!android.text.TextUtils.isEmpty(attributeValue7)) {
                fmVar2.i = attributeValue7;
            }
        } catch (java.lang.Exception unused2) {
        }
        try {
            java.lang.String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!android.text.TextUtils.isEmpty(attributeValue8)) {
                fmVar2.j = attributeValue8;
            }
        } catch (java.lang.Exception unused3) {
        }
        try {
            java.lang.String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!android.text.TextUtils.isEmpty(attributeValue9)) {
                fmVar2.k = attributeValue9;
            }
        } catch (java.lang.Exception unused4) {
        }
        try {
            java.lang.String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!android.text.TextUtils.isEmpty(attributeValue10)) {
                fmVar2.l = attributeValue10;
            }
        } catch (java.lang.Exception unused5) {
        }
        fmVar2.g = !android.text.TextUtils.isEmpty(str) && str.equalsIgnoreCase(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        fmVar2.a = xmlPullParser.getAttributeValue("", "type");
        java.lang.String g = g(xmlPullParser);
        if (g == null || "".equals(g.trim())) {
            com.xiaomi.push.fn.f();
        } else {
            fmVar2.c = g;
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                java.lang.String name = xmlPullParser.getName();
                android.text.TextUtils.isEmpty(xmlPullParser.getNamespace());
                if (name.equals("subject")) {
                    g(xmlPullParser);
                    fmVar2.d = d(xmlPullParser);
                } else if (name.equals("body")) {
                    java.lang.String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    java.lang.String d = d(xmlPullParser);
                    boolean isEmpty = android.text.TextUtils.isEmpty(attributeValue11);
                    fmVar2.e = d;
                    if (!isEmpty) {
                        fmVar2.f = attributeValue11;
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    fmVar2.v = e(xmlPullParser);
                } else {
                    fmVar2.a(f(xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        fmVar2.b = str2;
        return fmVar2;
    }

    public static com.xiaomi.push.fp b(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        com.xiaomi.push.fp.b bVar = com.xiaomi.push.fp.b.available;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = com.xiaomi.push.fp.b.valueOf(attributeValue);
            } catch (java.lang.IllegalArgumentException unused) {
                java.lang.System.err.println("Found invalid presence type ".concat(attributeValue));
            }
        }
        com.xiaomi.push.fp fpVar = new com.xiaomi.push.fp(bVar);
        fpVar.r = xmlPullParser.getAttributeValue("", com.huawei.hms.push.constant.RemoteMessageConst.TO);
        fpVar.f466s = xmlPullParser.getAttributeValue("", "from");
        fpVar.t = xmlPullParser.getAttributeValue("", "chid");
        java.lang.String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fpVar.q = attributeValue2;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                java.lang.String name = xmlPullParser.getName();
                xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    fpVar.a = xmlPullParser.nextText();
                } else if (name.equals("priority")) {
                    try {
                        fpVar.a(java.lang.Integer.parseInt(xmlPullParser.nextText()));
                    } catch (java.lang.NumberFormatException unused2) {
                    } catch (java.lang.IllegalArgumentException unused3) {
                        fpVar.a(0);
                    }
                } else if (name.equals("show")) {
                    java.lang.String nextText = xmlPullParser.nextText();
                    try {
                        fpVar.b = com.xiaomi.push.fp.a.valueOf(nextText);
                    } catch (java.lang.IllegalArgumentException unused4) {
                        java.lang.System.err.println("Found invalid presence mode ".concat(java.lang.String.valueOf(nextText)));
                    }
                } else if (name.equals("error")) {
                    fpVar.v = e(xmlPullParser);
                } else {
                    fpVar.a(f(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return fpVar;
    }

    public static com.xiaomi.push.fq c(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        com.xiaomi.push.fq fqVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                fqVar = new com.xiaomi.push.fq(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return fqVar;
    }

    private static java.lang.String d(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        java.lang.String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    private static com.xiaomi.push.fr e(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String str = "-1";
        boolean z = false;
        java.lang.String str2 = null;
        java.lang.String str3 = null;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                str = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                str3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        java.lang.String str4 = null;
        java.lang.String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    java.lang.String name = xmlPullParser.getName();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(xmlPullParser.getNamespace())) {
                        str4 = name;
                    } else {
                        arrayList.add(f(xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new com.xiaomi.push.fr(java.lang.Integer.parseInt(str), str3 == null ? com.anythink.expressad.d.a.b.dO : str3, str2, str4, str5, arrayList);
    }

    private static com.xiaomi.push.fk f(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        java.lang.Object a2 = com.xiaomi.push.fu.a().a("all", "xm:chat");
        if (a2 == null || !(a2 instanceof com.xiaomi.push.service.cg)) {
            return null;
        }
        return com.xiaomi.push.service.cg.a(xmlPullParser);
    }

    private static java.lang.String g(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            java.lang.String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML.equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
