package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class ResourceSelectorContainer extends org.apache.tools.ant.types.DataType {
    public final java.util.List<org.apache.tools.ant.types.resources.selectors.ResourceSelector> n = new java.util.ArrayList();

    public ResourceSelectorContainer() {
    }

    public ResourceSelectorContainer(org.apache.tools.ant.types.resources.selectors.ResourceSelector[] resourceSelectorArr) {
        for (org.apache.tools.ant.types.resources.selectors.ResourceSelector resourceSelector : resourceSelectorArr) {
            add(resourceSelector);
        }
    }

    public void add(org.apache.tools.ant.types.resources.selectors.ResourceSelector resourceSelector) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (resourceSelector == null) {
            return;
        }
        this.n.add(resourceSelector);
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.DataType
    public void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
            return;
        }
        for (java.lang.Object obj : this.n) {
            if (obj instanceof org.apache.tools.ant.types.DataType) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.DataType) obj, stack, project);
            }
        }
        setChecked(true);
    }

    public java.util.Iterator<org.apache.tools.ant.types.resources.selectors.ResourceSelector> getSelectors() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.selectors.ResourceSelectorContainer) getCheckedRef()).getSelectors();
        }
        dieOnCircularReference();
        return java.util.Collections.unmodifiableList(this.n).iterator();
    }

    public boolean hasSelectors() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.selectors.ResourceSelectorContainer) getCheckedRef()).hasSelectors();
        }
        dieOnCircularReference();
        return !this.n.isEmpty();
    }

    public int selectorCount() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.selectors.ResourceSelectorContainer) getCheckedRef()).selectorCount();
        }
        dieOnCircularReference();
        return this.n.size();
    }
}
