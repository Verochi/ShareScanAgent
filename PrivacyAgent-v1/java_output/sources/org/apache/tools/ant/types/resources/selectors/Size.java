package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class Size implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public long n = -1;
    public org.apache.tools.ant.types.Comparison t = org.apache.tools.ant.types.Comparison.EQUAL;

    public long getSize() {
        return this.n;
    }

    public org.apache.tools.ant.types.Comparison getWhen() {
        return this.t;
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        long size = resource.getSize() - this.n;
        return this.t.evaluate(size == 0 ? 0 : (int) (size / java.lang.Math.abs(size)));
    }

    public void setSize(long j) {
        this.n = j;
    }

    public void setWhen(org.apache.tools.ant.types.Comparison comparison) {
        this.t = comparison;
    }
}
