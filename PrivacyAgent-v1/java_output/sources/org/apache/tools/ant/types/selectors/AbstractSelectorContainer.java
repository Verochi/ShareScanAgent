package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public abstract class AbstractSelectorContainer extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.selectors.SelectorContainer {
    public java.util.Vector<org.apache.tools.ant.types.selectors.FileSelector> n = new java.util.Vector<>();

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void add(org.apache.tools.ant.types.selectors.FileSelector fileSelector) {
        appendSelector(fileSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addAnd(org.apache.tools.ant.types.selectors.AndSelector andSelector) {
        appendSelector(andSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addContains(org.apache.tools.ant.types.selectors.ContainsSelector containsSelector) {
        appendSelector(containsSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addContainsRegexp(org.apache.tools.ant.types.selectors.ContainsRegexpSelector containsRegexpSelector) {
        appendSelector(containsRegexpSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addCustom(org.apache.tools.ant.types.selectors.ExtendSelector extendSelector) {
        appendSelector(extendSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDate(org.apache.tools.ant.types.selectors.DateSelector dateSelector) {
        appendSelector(dateSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDepend(org.apache.tools.ant.types.selectors.DependSelector dependSelector) {
        appendSelector(dependSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDepth(org.apache.tools.ant.types.selectors.DepthSelector depthSelector) {
        appendSelector(depthSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDifferent(org.apache.tools.ant.types.selectors.DifferentSelector differentSelector) {
        appendSelector(differentSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addFilename(org.apache.tools.ant.types.selectors.FilenameSelector filenameSelector) {
        appendSelector(filenameSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addMajority(org.apache.tools.ant.types.selectors.MajoritySelector majoritySelector) {
        appendSelector(majoritySelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addModified(org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector modifiedSelector) {
        appendSelector(modifiedSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addNone(org.apache.tools.ant.types.selectors.NoneSelector noneSelector) {
        appendSelector(noneSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addNot(org.apache.tools.ant.types.selectors.NotSelector notSelector) {
        appendSelector(notSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addOr(org.apache.tools.ant.types.selectors.OrSelector orSelector) {
        appendSelector(orSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addPresent(org.apache.tools.ant.types.selectors.PresentSelector presentSelector) {
        appendSelector(presentSelector);
    }

    public void addReadable(org.apache.tools.ant.types.selectors.ReadableSelector readableSelector) {
        appendSelector(readableSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addSelector(org.apache.tools.ant.types.selectors.SelectSelector selectSelector) {
        appendSelector(selectSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addSize(org.apache.tools.ant.types.selectors.SizeSelector sizeSelector) {
        appendSelector(sizeSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addType(org.apache.tools.ant.types.selectors.TypeSelector typeSelector) {
        appendSelector(typeSelector);
    }

    public void addWritable(org.apache.tools.ant.types.selectors.WritableSelector writableSelector) {
        appendSelector(writableSelector);
    }

    public void appendSelector(org.apache.tools.ant.types.selectors.FileSelector fileSelector) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.n.addElement(fileSelector);
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public synchronized java.lang.Object clone() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.selectors.AbstractSelectorContainer) getCheckedRef()).clone();
        }
        try {
            org.apache.tools.ant.types.selectors.AbstractSelectorContainer abstractSelectorContainer = (org.apache.tools.ant.types.selectors.AbstractSelectorContainer) super.clone();
            abstractSelectorContainer.n = new java.util.Vector<>(this.n);
            return abstractSelectorContainer;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            java.util.Iterator<org.apache.tools.ant.types.selectors.FileSelector> it = this.n.iterator();
            while (it.hasNext()) {
                java.lang.Object obj = (org.apache.tools.ant.types.selectors.FileSelector) it.next();
                if (obj instanceof org.apache.tools.ant.types.DataType) {
                    org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.DataType) obj, stack, project);
                }
            }
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public org.apache.tools.ant.types.selectors.FileSelector[] getSelectors(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return ((org.apache.tools.ant.types.selectors.AbstractSelectorContainer) getCheckedRef(project)).getSelectors(project);
        }
        dieOnCircularReference(project);
        org.apache.tools.ant.types.selectors.FileSelector[] fileSelectorArr = new org.apache.tools.ant.types.selectors.FileSelector[this.n.size()];
        this.n.copyInto(fileSelectorArr);
        return fileSelectorArr;
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public boolean hasSelectors() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.selectors.AbstractSelectorContainer) getCheckedRef()).hasSelectors();
        }
        dieOnCircularReference();
        return !this.n.isEmpty();
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public int selectorCount() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.selectors.AbstractSelectorContainer) getCheckedRef()).selectorCount();
        }
        dieOnCircularReference();
        return this.n.size();
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.selectors.AbstractSelectorContainer) getCheckedRef()).selectorElements();
        }
        dieOnCircularReference();
        return this.n.elements();
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements = selectorElements();
        if (selectorElements.hasMoreElements()) {
            while (selectorElements.hasMoreElements()) {
                sb.append(selectorElements.nextElement().toString());
                if (selectorElements.hasMoreElements()) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }

    public void validate() {
        if (isReference()) {
            ((org.apache.tools.ant.types.selectors.AbstractSelectorContainer) getCheckedRef()).validate();
        }
        dieOnCircularReference();
        java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements = selectorElements();
        while (selectorElements.hasMoreElements()) {
            org.apache.tools.ant.types.selectors.FileSelector nextElement = selectorElements.nextElement();
            if (nextElement instanceof org.apache.tools.ant.types.selectors.BaseSelector) {
                ((org.apache.tools.ant.types.selectors.BaseSelector) nextElement).validate();
            }
        }
    }
}
