package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class SelectSelector extends org.apache.tools.ant.types.selectors.BaseSelectorContainer {
    public java.lang.Object v;
    public java.lang.Object w;

    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.selectors.SelectorContainer
    public void appendSelector(org.apache.tools.ant.types.selectors.FileSelector fileSelector) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        super.appendSelector(fileSelector);
    }

    public final org.apache.tools.ant.types.selectors.SelectSelector b() {
        return (org.apache.tools.ant.types.selectors.SelectSelector) getCheckedRef(getClass(), "SelectSelector");
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.selectors.SelectorContainer
    public org.apache.tools.ant.types.selectors.FileSelector[] getSelectors(org.apache.tools.ant.Project project) {
        return isReference() ? b().getSelectors(project) : super.getSelectors(project);
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.selectors.SelectorContainer
    public boolean hasSelectors() {
        return isReference() ? b().hasSelectors() : super.hasSelectors();
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        validate();
        if (!passesConditions()) {
            return false;
        }
        java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements = selectorElements();
        if (selectorElements.hasMoreElements()) {
            return selectorElements.nextElement().isSelected(file, str, file2);
        }
        return true;
    }

    public boolean passesConditions() {
        org.apache.tools.ant.PropertyHelper propertyHelper = org.apache.tools.ant.PropertyHelper.getPropertyHelper(getProject());
        return propertyHelper.testIfCondition(this.v) && propertyHelper.testUnlessCondition(this.w);
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.selectors.SelectorContainer
    public int selectorCount() {
        return isReference() ? b().selectorCount() : super.selectorCount();
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.selectors.SelectorContainer
    public java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements() {
        return isReference() ? b().selectorElements() : super.selectorElements();
    }

    public void setIf(java.lang.Object obj) {
        this.v = obj;
    }

    public void setIf(java.lang.String str) {
        setIf((java.lang.Object) str);
    }

    public void setUnless(java.lang.Object obj) {
        this.w = obj;
    }

    public void setUnless(java.lang.String str) {
        setUnless((java.lang.Object) str);
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelectorContainer, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (hasSelectors()) {
            stringBuffer.append("{select");
            if (this.v != null) {
                stringBuffer.append(" if: ");
                stringBuffer.append(this.v);
            }
            if (this.w != null) {
                stringBuffer.append(" unless: ");
                stringBuffer.append(this.w);
            }
            stringBuffer.append(" ");
            stringBuffer.append(super.toString());
            stringBuffer.append(com.alipay.sdk.m.u.i.d);
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        int selectorCount = selectorCount();
        if (selectorCount < 0 || selectorCount > 1) {
            setError("Only one selector is allowed within the <selector> tag");
        }
    }
}
