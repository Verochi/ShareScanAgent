package org.apache.tools.ant.attribute;

/* loaded from: classes25.dex */
public class IfTrueAttribute extends org.apache.tools.ant.attribute.BaseIfAttribute {

    public static class Unless extends org.apache.tools.ant.attribute.IfTrueAttribute {
        public Unless() {
            setPositive(false);
        }
    }

    @Override // org.apache.tools.ant.attribute.EnableAttribute
    public boolean isEnabled(org.apache.tools.ant.UnknownElement unknownElement, java.lang.String str) {
        return convertResult(org.apache.tools.ant.Project.toBoolean(str));
    }
}
