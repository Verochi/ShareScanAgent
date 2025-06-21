package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class NoneSelector extends org.apache.tools.ant.types.selectors.BaseSelectorContainer {
    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        validate();
        java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements = selectorElements();
        while (selectorElements.hasMoreElements()) {
            if (selectorElements.nextElement().isSelected(file, str, file2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (hasSelectors()) {
            sb.append("{noneselect: ");
            sb.append(super.toString());
            sb.append(com.alipay.sdk.m.u.i.d);
        }
        return sb.toString();
    }
}
