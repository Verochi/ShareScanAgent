package org.apache.tools.ant.attribute;

/* loaded from: classes25.dex */
public class IfBlankAttribute extends org.apache.tools.ant.attribute.BaseIfAttribute {

    public static class Unless extends org.apache.tools.ant.attribute.IfBlankAttribute {
        public Unless() {
            setPositive(false);
        }
    }

    @Override // org.apache.tools.ant.attribute.EnableAttribute
    public boolean isEnabled(org.apache.tools.ant.UnknownElement unknownElement, java.lang.String str) {
        return convertResult(str == null || "".equals(str));
    }
}
