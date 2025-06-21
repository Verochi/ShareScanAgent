package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class DependSelector extends org.apache.tools.ant.types.selectors.MappingSelector {
    @Override // org.apache.tools.ant.types.selectors.MappingSelector
    public boolean selectionTest(java.io.File file, java.io.File file2) {
        return org.apache.tools.ant.types.selectors.SelectorUtils.isOutOfDate(file, file2, this.granularity);
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("{dependselector targetdir: ");
        java.io.File file = this.targetdir;
        if (file == null) {
            sb.append("NOT YET SET");
        } else {
            sb.append(file.getName());
        }
        sb.append(" granularity: ");
        sb.append(this.granularity);
        if (this.map != null) {
            sb.append(" mapper: ");
            sb.append(this.map.toString());
        } else if (this.mapperElement != null) {
            sb.append(" mapper: ");
            sb.append(this.mapperElement.toString());
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }
}
