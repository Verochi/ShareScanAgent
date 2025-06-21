package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class Not implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public org.apache.tools.ant.types.resources.selectors.ResourceSelector n;

    public Not() {
    }

    public Not(org.apache.tools.ant.types.resources.selectors.ResourceSelector resourceSelector) {
        add(resourceSelector);
    }

    public void add(org.apache.tools.ant.types.resources.selectors.ResourceSelector resourceSelector) {
        if (this.n != null) {
            throw new java.lang.IllegalStateException("The Not ResourceSelector accepts a single nested ResourceSelector");
        }
        this.n = resourceSelector;
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        return !this.n.isSelected(resource);
    }
}
