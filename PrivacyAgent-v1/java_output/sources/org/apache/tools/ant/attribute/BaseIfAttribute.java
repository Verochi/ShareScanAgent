package org.apache.tools.ant.attribute;

/* loaded from: classes25.dex */
public abstract class BaseIfAttribute extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.attribute.EnableAttribute {
    public boolean n = true;

    public boolean convertResult(boolean z) {
        return this.n ? z : !z;
    }

    public java.util.Map getParams(org.apache.tools.ant.UnknownElement unknownElement) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : unknownElement.getWrapper().getAttributeMap().entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.String str = (java.lang.String) entry.getValue();
            if (key.startsWith("ant-attribute:param")) {
                hashMap.put(key.substring(key.lastIndexOf(58) + 1), unknownElement.getProject().replaceProperties(str));
            }
        }
        return hashMap;
    }

    public boolean isPositive() {
        return this.n;
    }

    public void setPositive(boolean z) {
        this.n = z;
    }
}
