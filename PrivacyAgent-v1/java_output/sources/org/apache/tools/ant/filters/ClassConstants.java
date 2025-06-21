package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class ClassConstants extends org.apache.tools.ant.filters.BaseFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.lang.String u;

    public ClassConstants() {
        this.u = null;
    }

    public ClassConstants(java.io.Reader reader) {
        super(reader);
        this.u = null;
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        return new org.apache.tools.ant.filters.ClassConstants(reader);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        java.lang.String str = this.u;
        if (str != null && str.length() == 0) {
            this.u = null;
        }
        java.lang.String str2 = this.u;
        if (str2 != null) {
            char charAt = str2.charAt(0);
            java.lang.String substring = this.u.substring(1);
            this.u = substring;
            if (substring.length() != 0) {
                return charAt;
            }
            this.u = null;
            return charAt;
        }
        java.lang.String readFully = readFully();
        if (readFully != null && readFully.length() != 0) {
            try {
                java.lang.StringBuffer stringBuffer = (java.lang.StringBuffer) java.lang.Class.forName("org.apache.tools.ant.filters.util.JavaClassHelper").getMethod("getConstants", byte[].class).invoke(null, readFully.getBytes("ISO-8859-1"));
                if (stringBuffer.length() > 0) {
                    this.u = stringBuffer.toString();
                    return read();
                }
            } catch (java.lang.reflect.InvocationTargetException e) {
                java.lang.Throwable targetException = e.getTargetException();
                if (targetException instanceof java.lang.NoClassDefFoundError) {
                    throw ((java.lang.NoClassDefFoundError) targetException);
                }
                if (targetException instanceof java.lang.RuntimeException) {
                    throw ((java.lang.RuntimeException) targetException);
                }
                throw new org.apache.tools.ant.BuildException(targetException);
            } catch (java.lang.Exception e2) {
                throw new org.apache.tools.ant.BuildException(e2);
            } catch (java.lang.NoClassDefFoundError e3) {
                throw e3;
            } catch (java.lang.RuntimeException e4) {
                throw e4;
            }
        }
        return -1;
    }
}
