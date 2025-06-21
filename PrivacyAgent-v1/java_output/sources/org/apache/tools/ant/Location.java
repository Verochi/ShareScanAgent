package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class Location implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    private final int columnNumber;
    private final java.lang.String fileName;
    private final int lineNumber;
    public static final org.apache.tools.ant.Location UNKNOWN_LOCATION = new org.apache.tools.ant.Location();
    private static final org.apache.tools.ant.util.FileUtils FILE_UTILS = org.apache.tools.ant.util.FileUtils.getFileUtils();

    private Location() {
        this(null, 0, 0);
    }

    public Location(java.lang.String str) {
        this(str, 0, 0);
    }

    public Location(java.lang.String str, int i, int i2) {
        if (str == null || !str.startsWith("file:")) {
            this.fileName = str;
        } else {
            this.fileName = FILE_UTILS.fromURI(str);
        }
        this.lineNumber = i;
        this.columnNumber = i2;
    }

    public Location(org.xml.sax.Locator locator) {
        this(locator.getSystemId(), locator.getLineNumber(), locator.getColumnNumber());
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

    public java.lang.String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String str = this.fileName;
        if (str != null) {
            stringBuffer.append(str);
            if (this.lineNumber != 0) {
                stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                stringBuffer.append(this.lineNumber);
            }
            stringBuffer.append(": ");
        }
        return stringBuffer.toString();
    }
}
