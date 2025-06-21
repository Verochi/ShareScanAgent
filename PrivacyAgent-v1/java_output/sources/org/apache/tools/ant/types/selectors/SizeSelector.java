package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class SizeSelector extends org.apache.tools.ant.types.selectors.BaseExtendSelector {
    public static final java.lang.String SIZE_KEY = "value";
    public static final java.lang.String UNITS_KEY = "units";
    public static final java.lang.String WHEN_KEY = "when";
    public long u = -1;
    public long v = 1;
    public long w = -1;
    public org.apache.tools.ant.types.Comparison x = org.apache.tools.ant.types.Comparison.EQUAL;

    public static class ByteUnits extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"K", "k", "kilo", "KILO", "Ki", "KI", "ki", "kibi", "KIBI", "M", com.anythink.expressad.d.a.b.dH, "mega", "MEGA", "Mi", "MI", com.getui.gtc.extension.distribution.gbd.f.b.i, "mebi", "MEBI", "G", "g", "giga", "GIGA", "Gi", "GI", "gi", "gibi", "GIBI", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "t", "tera", "TERA", "Ti", com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_TASKID, "ti", "tebi", "TEBI"};
        }
    }

    public static class SizeComparisons extends org.apache.tools.ant.types.Comparison {
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        validate();
        if (file2.isDirectory()) {
            return true;
        }
        long length = file2.length() - this.w;
        return this.x.evaluate(length == 0 ? 0 : (int) (length / java.lang.Math.abs(length)));
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.Parameterizable
    public void setParameters(org.apache.tools.ant.types.Parameter[] parameterArr) {
        super.setParameters(parameterArr);
        if (parameterArr != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameterArr) {
                java.lang.String name = parameter.getName();
                if ("value".equalsIgnoreCase(name)) {
                    try {
                        setValue(java.lang.Long.parseLong(parameter.getValue()));
                    } catch (java.lang.NumberFormatException unused) {
                        setError("Invalid size setting " + parameter.getValue());
                    }
                } else if (UNITS_KEY.equalsIgnoreCase(name)) {
                    org.apache.tools.ant.types.selectors.SizeSelector.ByteUnits byteUnits = new org.apache.tools.ant.types.selectors.SizeSelector.ByteUnits();
                    byteUnits.setValue(parameter.getValue());
                    setUnits(byteUnits);
                } else if ("when".equalsIgnoreCase(name)) {
                    org.apache.tools.ant.types.selectors.SizeSelector.SizeComparisons sizeComparisons = new org.apache.tools.ant.types.selectors.SizeSelector.SizeComparisons();
                    sizeComparisons.setValue(parameter.getValue());
                    setWhen(sizeComparisons);
                } else {
                    setError("Invalid parameter " + name);
                }
            }
        }
    }

    public void setUnits(org.apache.tools.ant.types.selectors.SizeSelector.ByteUnits byteUnits) {
        int index = byteUnits.getIndex();
        this.v = 0L;
        if (index > -1 && index < 4) {
            this.v = 1000L;
        } else if (index < 9) {
            this.v = 1024L;
        } else if (index < 13) {
            this.v = 1000000L;
        } else if (index < 18) {
            this.v = 1048576L;
        } else if (index < 22) {
            this.v = 1000000000L;
        } else if (index < 27) {
            this.v = 1073741824L;
        } else if (index < 31) {
            this.v = 1000000000000L;
        } else if (index < 36) {
            this.v = 1099511627776L;
        }
        long j = this.v;
        if (j > 0) {
            long j2 = this.u;
            if (j2 > -1) {
                this.w = j2 * j;
            }
        }
    }

    public void setValue(long j) {
        this.u = j;
        long j2 = this.v;
        if (j2 == 0 || j <= -1) {
            return;
        }
        this.w = j * j2;
    }

    public void setWhen(org.apache.tools.ant.types.selectors.SizeSelector.SizeComparisons sizeComparisons) {
        this.x = sizeComparisons;
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return "{sizeselector value: " + this.w + "compare: " + this.x.getValue() + com.alipay.sdk.m.u.i.d;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        if (this.u < 0) {
            setError("The value attribute is required, and must be positive");
        } else if (this.v < 1) {
            setError("Invalid Units supplied, must be K,Ki,M,Mi,G,Gi,T,or Ti");
        } else if (this.w < 0) {
            setError("Internal error: Code is not setting sizelimit correctly");
        }
    }
}
