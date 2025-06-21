package org.apache.tools.ant.taskdefs.optional.jsp;

/* loaded from: classes25.dex */
public class JspNameMangler implements org.apache.tools.ant.taskdefs.optional.jsp.JspMangler {
    public static final java.lang.String[] keywords = {"assert", "abstract", "boolean", "break", "byte", com.anythink.expressad.foundation.d.r.ad, "catch", "char", "class", "const", "continue", "default", com.anythink.expressad.foundation.d.d.f238s, "double", "else", "extends", "final", "finally", "float", "for", com.igexin.push.core.b.r, "if", "implements", "import", "instanceof", com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "interface", "long", com.anythink.expressad.foundation.g.a.f.a, "new", "package", com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, "protected", "public", "return", "short", "static", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};

    public static java.lang.String a(char c) {
        if (c == java.io.File.separatorChar) {
            c = '/';
        }
        java.lang.String hexString = java.lang.Integer.toHexString(c);
        int length = 5 - hexString.length();
        char[] cArr = new char[6];
        int i = 0;
        cArr[0] = '_';
        for (int i2 = 1; i2 <= length; i2++) {
            cArr[i2] = '0';
        }
        int i3 = length + 1;
        while (i3 < 6) {
            cArr[i3] = hexString.charAt(i);
            i3++;
            i++;
        }
        return new java.lang.String(cArr);
    }

    public final java.lang.String b(java.io.File file) {
        java.lang.String c = c(file);
        int i = 0;
        while (true) {
            java.lang.String[] strArr = keywords;
            if (i >= strArr.length) {
                break;
            }
            if (c.equals(strArr[i])) {
                c = c + "%";
                break;
            }
            i++;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(c.length());
        char charAt = c.charAt(0);
        if (java.lang.Character.isJavaIdentifierStart(charAt)) {
            stringBuffer.append(charAt);
        } else {
            stringBuffer.append(a(charAt));
        }
        for (char c2 : c.substring(1).toCharArray()) {
            if (java.lang.Character.isJavaIdentifierPart(c2)) {
                stringBuffer.append(c2);
            } else {
                stringBuffer.append(a(c2));
            }
        }
        return stringBuffer.toString();
    }

    public final java.lang.String c(java.io.File file) {
        return org.apache.tools.ant.util.StringUtils.removeSuffix(file.getName(), ".jsp");
    }

    @Override // org.apache.tools.ant.taskdefs.optional.jsp.JspMangler
    public java.lang.String mapJspToJavaName(java.io.File file) {
        return b(file) + ".java";
    }

    @Override // org.apache.tools.ant.taskdefs.optional.jsp.JspMangler
    public java.lang.String mapPath(java.lang.String str) {
        return null;
    }
}
