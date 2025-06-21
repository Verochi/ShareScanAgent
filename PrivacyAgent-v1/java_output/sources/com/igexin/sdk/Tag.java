package com.igexin.sdk;

/* loaded from: classes23.dex */
public class Tag implements java.io.Serializable {
    private static final long serialVersionUID = 7265815580156141684L;
    private java.lang.String name;

    private boolean isValidTagName(java.lang.String str) {
        boolean z = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            z = (charAt >= 19968 && charAt <= 40869) || (charAt >= 'A' && charAt <= 'Z') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= '0' && charAt <= '9') || charAt == '+' || charAt == '-' || charAt == '*' || charAt == '_' || charAt == ' ' || charAt == ':'));
            if (!z) {
                break;
            }
        }
        return z;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public boolean isValidTagValue(java.lang.String str) {
        return isValidTagName(str);
    }

    public com.igexin.sdk.Tag setName(java.lang.String str) {
        this.name = str;
        return this;
    }
}
