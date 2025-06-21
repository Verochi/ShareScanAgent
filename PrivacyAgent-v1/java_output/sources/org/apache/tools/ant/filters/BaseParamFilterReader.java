package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public abstract class BaseParamFilterReader extends org.apache.tools.ant.filters.BaseFilterReader implements org.apache.tools.ant.types.Parameterizable {
    public org.apache.tools.ant.types.Parameter[] u;

    public BaseParamFilterReader() {
    }

    public BaseParamFilterReader(java.io.Reader reader) {
        super(reader);
    }

    public final org.apache.tools.ant.types.Parameter[] getParameters() {
        return this.u;
    }

    @Override // org.apache.tools.ant.types.Parameterizable
    public final void setParameters(org.apache.tools.ant.types.Parameter[] parameterArr) {
        this.u = parameterArr;
        setInitialized(false);
    }
}
