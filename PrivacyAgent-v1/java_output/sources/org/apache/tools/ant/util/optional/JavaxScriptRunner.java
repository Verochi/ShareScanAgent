package org.apache.tools.ant.util.optional;

/* loaded from: classes26.dex */
public class JavaxScriptRunner extends org.apache.tools.ant.util.ScriptRunnerBase {
    public org.apache.tools.ant.util.ReflectWrapper g;

    public static org.apache.tools.ant.BuildException c(java.lang.Throwable th) {
        org.apache.tools.ant.BuildException buildException = th instanceof org.apache.tools.ant.BuildException ? (org.apache.tools.ant.BuildException) th : null;
        while (th.getCause() != null) {
            th = th.getCause();
            if (th instanceof org.apache.tools.ant.BuildException) {
                buildException = (org.apache.tools.ant.BuildException) th;
            }
        }
        return buildException;
    }

    public final org.apache.tools.ant.util.ReflectWrapper b() {
        org.apache.tools.ant.util.ReflectWrapper reflectWrapper = this.g;
        if (reflectWrapper != null) {
            return reflectWrapper;
        }
        java.lang.Object invoke = new org.apache.tools.ant.util.ReflectWrapper(getClass().getClassLoader(), "javax.script.ScriptEngineManager").invoke("getEngineByName", java.lang.String.class, getLanguage());
        if (invoke == null) {
            return null;
        }
        org.apache.tools.ant.util.ReflectWrapper reflectWrapper2 = new org.apache.tools.ant.util.ReflectWrapper(invoke);
        if (getKeepEngine()) {
            this.g = reflectWrapper2;
        }
        return reflectWrapper2;
    }

    @Override // org.apache.tools.ant.util.ScriptRunnerBase
    public java.lang.Object evaluateScript(java.lang.String str) throws org.apache.tools.ant.BuildException {
        checkLanguage();
        java.lang.ClassLoader replaceContextLoader = replaceContextLoader();
        try {
            try {
                org.apache.tools.ant.util.ReflectWrapper b = b();
                if (b == null) {
                    throw new org.apache.tools.ant.BuildException("Unable to create javax script engine for " + getLanguage());
                }
                for (java.lang.String str2 : getBeans().keySet()) {
                    java.lang.Object obj = getBeans().get(str2);
                    if ("FX".equalsIgnoreCase(getLanguage())) {
                        b.invoke("put", java.lang.String.class, str2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + obj.getClass().getName(), java.lang.Object.class, obj);
                    } else {
                        b.invoke("put", java.lang.String.class, str2, java.lang.Object.class, obj);
                    }
                }
                return b.invoke("eval", java.lang.String.class, getScript());
            } catch (org.apache.tools.ant.BuildException e) {
                throw c(e);
            } catch (java.lang.Exception e2) {
                e = e2;
                java.lang.Throwable cause = e.getCause();
                if (cause != null) {
                    if (cause instanceof org.apache.tools.ant.BuildException) {
                        throw ((org.apache.tools.ant.BuildException) cause);
                    }
                    e = cause;
                }
                throw new org.apache.tools.ant.BuildException(e);
            }
        } finally {
            restoreContextLoader(replaceContextLoader);
        }
    }

    @Override // org.apache.tools.ant.util.ScriptRunnerBase
    public void executeScript(java.lang.String str) throws org.apache.tools.ant.BuildException {
        evaluateScript(str);
    }

    @Override // org.apache.tools.ant.util.ScriptRunnerBase
    public java.lang.String getManagerName() {
        return "javax";
    }

    @Override // org.apache.tools.ant.util.ScriptRunnerBase
    public boolean supportsLanguage() {
        if (this.g != null) {
            return true;
        }
        checkLanguage();
        java.lang.ClassLoader replaceContextLoader = replaceContextLoader();
        try {
            return b() != null;
        } catch (java.lang.Exception unused) {
            return false;
        } finally {
            restoreContextLoader(replaceContextLoader);
        }
    }
}
