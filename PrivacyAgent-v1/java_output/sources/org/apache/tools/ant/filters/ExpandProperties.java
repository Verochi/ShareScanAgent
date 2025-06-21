package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class ExpandProperties extends org.apache.tools.ant.filters.BaseFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public char[] u;
    public int v;
    public org.apache.tools.ant.types.PropertySet w;

    /* renamed from: org.apache.tools.ant.filters.ExpandProperties$1, reason: invalid class name */
    public class AnonymousClass1 implements org.apache.tools.ant.property.GetProperty {
        public final /* synthetic */ java.util.Properties a;

        public AnonymousClass1(java.util.Properties properties) {
            this.a = properties;
        }

        @Override // org.apache.tools.ant.property.GetProperty
        public java.lang.Object getProperty(java.lang.String str) {
            return this.a.getProperty(str);
        }
    }

    public ExpandProperties() {
    }

    public ExpandProperties(java.io.Reader reader) {
        super(reader);
    }

    public void add(org.apache.tools.ant.types.PropertySet propertySet) {
        if (this.w != null) {
            throw new org.apache.tools.ant.BuildException("expandproperties filter accepts only one propertyset");
        }
        this.w = propertySet;
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.ExpandProperties expandProperties = new org.apache.tools.ant.filters.ExpandProperties(reader);
        expandProperties.setProject(getProject());
        expandProperties.add(this.w);
        return expandProperties;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        if (this.v > -1) {
            if (this.u == null) {
                java.lang.String readFully = readFully();
                org.apache.tools.ant.Project project = getProject();
                org.apache.tools.ant.types.PropertySet propertySet = this.w;
                java.lang.Object parseProperties = new org.apache.tools.ant.property.ParseProperties(project, org.apache.tools.ant.PropertyHelper.getPropertyHelper(project).getExpanders(), propertySet == null ? org.apache.tools.ant.PropertyHelper.getPropertyHelper(project) : new org.apache.tools.ant.filters.ExpandProperties.AnonymousClass1(propertySet.getProperties())).parseProperties(readFully);
                this.u = parseProperties == null ? new char[0] : parseProperties.toString().toCharArray();
            }
            int i = this.v;
            char[] cArr = this.u;
            if (i < cArr.length) {
                this.v = i + 1;
                return cArr[i];
            }
            this.v = -1;
        }
        return -1;
    }
}
