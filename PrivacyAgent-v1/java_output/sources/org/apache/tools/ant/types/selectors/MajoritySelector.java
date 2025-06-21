package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class MajoritySelector extends org.apache.tools.ant.types.selectors.BaseSelectorContainer {
    public boolean v = true;

    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        validate();
        java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements = selectorElements();
        int i = 0;
        int i2 = 0;
        while (selectorElements.hasMoreElements()) {
            if (selectorElements.nextElement().isSelected(file, str, file2)) {
                i++;
            } else {
                i2++;
            }
        }
        if (i > i2) {
            return true;
        }
        if (i2 > i) {
            return false;
        }
        return this.v;
    }

    public void setAllowtie(boolean z) {
        this.v = z;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (hasSelectors()) {
            sb.append("{majorityselect: ");
            sb.append(super.toString());
            sb.append(com.alipay.sdk.m.u.i.d);
        }
        return sb.toString();
    }
}
