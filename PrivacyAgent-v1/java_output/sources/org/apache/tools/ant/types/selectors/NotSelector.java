package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class NotSelector extends org.apache.tools.ant.types.selectors.NoneSelector {
    public NotSelector() {
    }

    public NotSelector(org.apache.tools.ant.types.selectors.FileSelector fileSelector) {
        this();
        appendSelector(fileSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.NoneSelector, org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (hasSelectors()) {
            sb.append("{notselect: ");
            sb.append(super.toString());
            sb.append(com.alipay.sdk.m.u.i.d);
        }
        return sb.toString();
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        if (selectorCount() != 1) {
            setError("One and only one selector is allowed within the <not> tag");
        }
    }
}
