package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class DepthSelector extends org.apache.tools.ant.types.selectors.BaseExtendSelector {
    public static final java.lang.String MAX_KEY = "max";
    public static final java.lang.String MIN_KEY = "min";
    public int min = -1;
    public int max = -1;

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        validate();
        java.lang.String absolutePath = file.getAbsolutePath();
        java.lang.String absolutePath2 = file2.getAbsolutePath();
        java.lang.String str2 = java.io.File.separator;
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(absolutePath, str2);
        java.util.StringTokenizer stringTokenizer2 = new java.util.StringTokenizer(absolutePath2, str2);
        int i = -1;
        while (stringTokenizer2.hasMoreTokens()) {
            java.lang.String nextToken = stringTokenizer2.nextToken();
            if (!stringTokenizer.hasMoreTokens()) {
                i++;
                int i2 = this.max;
                if (i2 > -1 && i > i2) {
                    return false;
                }
            } else if (!stringTokenizer.nextToken().equals(nextToken)) {
                throw new org.apache.tools.ant.BuildException("File " + str + " does not appear within " + absolutePath + org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.DIRECTORY);
            }
        }
        if (!stringTokenizer.hasMoreTokens()) {
            int i3 = this.min;
            return i3 <= -1 || i >= i3;
        }
        throw new org.apache.tools.ant.BuildException("File " + str + " is outside of " + absolutePath + "directory tree");
    }

    public void setMax(int i) {
        this.max = i;
    }

    public void setMin(int i) {
        this.min = i;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.Parameterizable
    public void setParameters(org.apache.tools.ant.types.Parameter[] parameterArr) {
        super.setParameters(parameterArr);
        if (parameterArr != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameterArr) {
                java.lang.String name = parameter.getName();
                if (MIN_KEY.equalsIgnoreCase(name)) {
                    try {
                        setMin(java.lang.Integer.parseInt(parameter.getValue()));
                    } catch (java.lang.NumberFormatException unused) {
                        setError("Invalid minimum value " + parameter.getValue());
                    }
                } else if (MAX_KEY.equalsIgnoreCase(name)) {
                    try {
                        setMax(java.lang.Integer.parseInt(parameter.getValue()));
                    } catch (java.lang.NumberFormatException unused2) {
                        setError("Invalid maximum value " + parameter.getValue());
                    }
                } else {
                    setError("Invalid parameter " + name);
                }
            }
        }
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return "{depthselector min: " + this.min + " max: " + this.max + com.alipay.sdk.m.u.i.d;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        if (this.min < 0 && this.max < 0) {
            setError("You must set at least one of the min or the max levels.");
        }
        int i = this.max;
        if (i >= this.min || i <= -1) {
            return;
        }
        setError("The maximum depth is lower than the minimum.");
    }
}
