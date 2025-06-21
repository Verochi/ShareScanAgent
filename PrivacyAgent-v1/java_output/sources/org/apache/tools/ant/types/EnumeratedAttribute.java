package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public abstract class EnumeratedAttribute {
    public int a = -1;
    protected java.lang.String value;

    public static org.apache.tools.ant.types.EnumeratedAttribute getInstance(java.lang.Class<? extends org.apache.tools.ant.types.EnumeratedAttribute> cls, java.lang.String str) throws org.apache.tools.ant.BuildException {
        if (!org.apache.tools.ant.types.EnumeratedAttribute.class.isAssignableFrom(cls)) {
            throw new org.apache.tools.ant.BuildException("You have to provide a subclass from EnumeratedAttribute as clazz-parameter.");
        }
        try {
            org.apache.tools.ant.types.EnumeratedAttribute newInstance = cls.newInstance();
            newInstance.setValue(str);
            return newInstance;
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public final boolean containsValue(java.lang.String str) {
        return indexOfValue(str) != -1;
    }

    public final int getIndex() {
        return this.a;
    }

    public final java.lang.String getValue() {
        return this.value;
    }

    public abstract java.lang.String[] getValues();

    public final int indexOfValue(java.lang.String str) {
        java.lang.String[] values = getValues();
        if (values != null && str != null) {
            for (int i = 0; i < values.length; i++) {
                if (str.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public final void setValue(java.lang.String str) throws org.apache.tools.ant.BuildException {
        int indexOfValue = indexOfValue(str);
        if (indexOfValue != -1) {
            this.a = indexOfValue;
            this.value = str;
        } else {
            throw new org.apache.tools.ant.BuildException(str + " is not a legal value for this attribute");
        }
    }

    public java.lang.String toString() {
        return getValue();
    }
}
