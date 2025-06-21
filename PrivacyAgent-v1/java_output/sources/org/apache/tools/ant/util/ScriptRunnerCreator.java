package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ScriptRunnerCreator {
    public org.apache.tools.ant.Project a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.ClassLoader d = null;

    public ScriptRunnerCreator(org.apache.tools.ant.Project project) {
        this.a = project;
    }

    public final org.apache.tools.ant.util.ScriptRunnerBase a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (!this.b.equals("auto") && !this.b.equals(str)) {
            return null;
        }
        if (!str2.equals("org.apache.bsf.BSFManager")) {
            try {
                java.lang.Class.forName(str2, true, this.d);
            } catch (java.lang.Exception unused) {
                return null;
            }
        } else {
            if (this.d.getResource(org.apache.tools.ant.util.LoaderUtils.classNameToResource(str2)) == null) {
                return null;
            }
            new org.apache.tools.ant.util.ScriptFixBSFPath().fixClassLoader(this.d, this.c);
        }
        try {
            org.apache.tools.ant.util.ScriptRunnerBase scriptRunnerBase = (org.apache.tools.ant.util.ScriptRunnerBase) java.lang.Class.forName(str3, true, this.d).newInstance();
            scriptRunnerBase.setProject(this.a);
            scriptRunnerBase.setLanguage(this.c);
            scriptRunnerBase.setScriptClassLoader(this.d);
            return scriptRunnerBase;
        } catch (java.lang.Exception e) {
            throw org.apache.tools.ant.util.ReflectUtil.toBuildException(e);
        }
    }

    public synchronized org.apache.tools.ant.util.ScriptRunnerBase createRunner(java.lang.String str, java.lang.String str2, java.lang.ClassLoader classLoader) {
        org.apache.tools.ant.util.ScriptRunnerBase a;
        this.b = str;
        this.c = str2;
        this.d = classLoader;
        if (str2 == null) {
            throw new org.apache.tools.ant.BuildException("script language must be specified");
        }
        if (!str.equals("auto") && !str.equals("javax") && !str.equals("bsf")) {
            throw new org.apache.tools.ant.BuildException("Unsupported language prefix " + str);
        }
        a = a("bsf", "org.apache.bsf.BSFManager", "org.apache.tools.ant.util.optional.ScriptRunner");
        if (a == null) {
            a = a("javax", "javax.script.ScriptEngineManager", "org.apache.tools.ant.util.optional.JavaxScriptRunner");
        }
        if (a == null) {
            if ("javax".equals(str)) {
                throw new org.apache.tools.ant.BuildException("Unable to load the script engine manager (javax.script.ScriptEngineManager)");
            }
            if ("bsf".equals(str)) {
                throw new org.apache.tools.ant.BuildException("Unable to load the BSF script engine manager (org.apache.bsf.BSFManager)");
            }
            throw new org.apache.tools.ant.BuildException("Unable to load a script engine manager (org.apache.bsf.BSFManager or javax.script.ScriptEngineManager)");
        }
        return a;
    }
}
