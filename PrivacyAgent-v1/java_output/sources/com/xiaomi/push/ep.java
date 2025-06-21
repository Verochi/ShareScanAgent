package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ep {
    private org.xmlpull.v1.XmlPullParser a;

    public ep() {
        try {
            org.xmlpull.v1.XmlPullParser newPullParser = org.xmlpull.v1.XmlPullParserFactory.newInstance().newPullParser();
            this.a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (org.xmlpull.v1.XmlPullParserException unused) {
        }
    }

    public final com.xiaomi.push.fn a(byte[] bArr, com.xiaomi.push.ev evVar) {
        java.lang.String name;
        java.lang.String str;
        this.a.setInput(new java.io.InputStreamReader(new java.io.ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        java.lang.String name2 = this.a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name2.equals("message")) {
            return com.xiaomi.push.fv.a(this.a);
        }
        if (name2.equals("iq")) {
            return com.xiaomi.push.fv.a(this.a, evVar);
        }
        if (name2.equals("presence")) {
            return com.xiaomi.push.fv.b(this.a);
        }
        if (this.a.getName().equals("stream")) {
            return null;
        }
        if (this.a.getName().equals("error")) {
            throw new com.xiaomi.push.fh(com.xiaomi.push.fv.c(this.a));
        }
        if (this.a.getName().equals("warning")) {
            this.a.next();
            name = this.a.getName();
            str = "multi-login";
        } else {
            name = this.a.getName();
            str = "bind";
        }
        name.equals(str);
        return null;
    }
}
