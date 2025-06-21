package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class GenerateKey extends org.apache.tools.ant.Task {
    protected java.lang.String alias;
    protected java.lang.String dname;
    protected org.apache.tools.ant.taskdefs.GenerateKey.DistinguishedName expandedDname;
    protected java.lang.String keyalg;
    protected java.lang.String keypass;
    protected int keysize;
    protected java.lang.String keystore;
    protected java.lang.String saname;
    protected java.lang.String sigalg;
    protected java.lang.String storepass;
    protected java.lang.String storetype;
    protected int validity;
    protected boolean verbose;

    public static class DistinguishedName {
        public java.util.Vector<org.apache.tools.ant.taskdefs.GenerateKey.DnameParam> a = new java.util.Vector<>();

        public java.lang.Object createParam() {
            org.apache.tools.ant.taskdefs.GenerateKey.DnameParam dnameParam = new org.apache.tools.ant.taskdefs.GenerateKey.DnameParam();
            this.a.addElement(dnameParam);
            return dnameParam;
        }

        public java.lang.String encode(java.lang.String str) {
            int indexOf = str.indexOf(44);
            if (-1 == indexOf) {
                return str;
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            int i = 0;
            while (-1 != indexOf) {
                stringBuffer.append(str.substring(i, indexOf));
                stringBuffer.append("\\,");
                i = indexOf + 1;
                indexOf = str.indexOf(44, i);
            }
            stringBuffer.append(str.substring(i));
            return stringBuffer.toString();
        }

        public java.util.Enumeration<org.apache.tools.ant.taskdefs.GenerateKey.DnameParam> getParams() {
            return this.a.elements();
        }

        public java.lang.String toString() {
            int size = this.a.size();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            boolean z = true;
            int i = 0;
            while (i < size) {
                if (!z) {
                    stringBuffer.append(" ,");
                }
                org.apache.tools.ant.taskdefs.GenerateKey.DnameParam elementAt = this.a.elementAt(i);
                if (elementAt.isComplete()) {
                    stringBuffer.append(encode(elementAt.getName()));
                    stringBuffer.append(com.alipay.sdk.m.n.a.h);
                    stringBuffer.append(encode(elementAt.getValue()));
                }
                i++;
                z = false;
            }
            return stringBuffer.toString();
        }
    }

    public static class DnameParam {
        public java.lang.String a;
        public java.lang.String b;

        public java.lang.String getName() {
            return this.a;
        }

        public java.lang.String getValue() {
            return this.b;
        }

        public boolean isComplete() {
            return (this.a == null || this.b == null) ? false : true;
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }

        public void setValue(java.lang.String str) {
            this.b = str;
        }
    }

    public org.apache.tools.ant.taskdefs.GenerateKey.DistinguishedName createDname() throws org.apache.tools.ant.BuildException {
        if (this.expandedDname != null) {
            throw new org.apache.tools.ant.BuildException("DName sub-element can only be specified once.");
        }
        if (this.dname != null) {
            throw new org.apache.tools.ant.BuildException("It is not possible to specify dname  both as attribute and element.");
        }
        org.apache.tools.ant.taskdefs.GenerateKey.DistinguishedName distinguishedName = new org.apache.tools.ant.taskdefs.GenerateKey.DistinguishedName();
        this.expandedDname = distinguishedName;
        return distinguishedName;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.alias == null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.SignJar.ERROR_NO_ALIAS);
        }
        if (this.storepass == null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.SignJar.ERROR_NO_STOREPASS);
        }
        if (this.dname == null && this.expandedDname == null) {
            throw new org.apache.tools.ant.BuildException("dname must be set");
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("-genkey ");
        if (this.verbose) {
            stringBuffer.append("-v ");
        }
        stringBuffer.append("-alias \"");
        stringBuffer.append(this.alias);
        stringBuffer.append("\" ");
        if (this.dname != null) {
            stringBuffer.append("-dname \"");
            stringBuffer.append(this.dname);
            stringBuffer.append("\" ");
        }
        if (this.expandedDname != null) {
            stringBuffer.append("-dname \"");
            stringBuffer.append(this.expandedDname);
            stringBuffer.append("\" ");
        }
        if (this.keystore != null) {
            stringBuffer.append("-keystore \"");
            stringBuffer.append(this.keystore);
            stringBuffer.append("\" ");
        }
        if (this.storepass != null) {
            stringBuffer.append("-storepass \"");
            stringBuffer.append(this.storepass);
            stringBuffer.append("\" ");
        }
        if (this.storetype != null) {
            stringBuffer.append("-storetype \"");
            stringBuffer.append(this.storetype);
            stringBuffer.append("\" ");
        }
        stringBuffer.append("-keypass \"");
        java.lang.String str = this.keypass;
        if (str != null) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(this.storepass);
        }
        stringBuffer.append("\" ");
        if (this.sigalg != null) {
            stringBuffer.append("-sigalg \"");
            stringBuffer.append(this.sigalg);
            stringBuffer.append("\" ");
        }
        if (this.keyalg != null) {
            stringBuffer.append("-keyalg \"");
            stringBuffer.append(this.keyalg);
            stringBuffer.append("\" ");
        }
        if (this.keysize > 0) {
            stringBuffer.append("-keysize \"");
            stringBuffer.append(this.keysize);
            stringBuffer.append("\" ");
        }
        if (this.validity > 0) {
            stringBuffer.append("-validity \"");
            stringBuffer.append(this.validity);
            stringBuffer.append("\" ");
        }
        if (this.saname != null) {
            stringBuffer.append("-ext ");
            stringBuffer.append("\"san=");
            stringBuffer.append(this.saname);
            stringBuffer.append("\" ");
        }
        log("Generating Key for " + this.alias);
        org.apache.tools.ant.taskdefs.ExecTask execTask = new org.apache.tools.ant.taskdefs.ExecTask(this);
        execTask.setExecutable(org.apache.tools.ant.util.JavaEnvUtils.getJdkExecutable("keytool"));
        execTask.createArg().setLine(stringBuffer.toString());
        execTask.setFailonerror(true);
        execTask.setTaskName(getTaskName());
        execTask.execute();
    }

    public void setAlias(java.lang.String str) {
        this.alias = str;
    }

    public void setDname(java.lang.String str) {
        if (this.expandedDname != null) {
            throw new org.apache.tools.ant.BuildException("It is not possible to specify dname  both as attribute and element.");
        }
        this.dname = str;
    }

    public void setKeyalg(java.lang.String str) {
        this.keyalg = str;
    }

    public void setKeypass(java.lang.String str) {
        this.keypass = str;
    }

    public void setKeysize(java.lang.String str) throws org.apache.tools.ant.BuildException {
        try {
            this.keysize = java.lang.Integer.parseInt(str);
        } catch (java.lang.NumberFormatException unused) {
            throw new org.apache.tools.ant.BuildException("KeySize attribute should be a integer");
        }
    }

    public void setKeystore(java.lang.String str) {
        this.keystore = str;
    }

    public void setSaname(java.lang.String str) {
        if (org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)) {
            this.saname = str;
        } else {
            log("The SubjectAlternativeName extension is not available for the Java Version being used.");
        }
    }

    public void setSigalg(java.lang.String str) {
        this.sigalg = str;
    }

    public void setStorepass(java.lang.String str) {
        this.storepass = str;
    }

    public void setStoretype(java.lang.String str) {
        this.storetype = str;
    }

    public void setValidity(java.lang.String str) throws org.apache.tools.ant.BuildException {
        try {
            this.validity = java.lang.Integer.parseInt(str);
        } catch (java.lang.NumberFormatException unused) {
            throw new org.apache.tools.ant.BuildException("Validity attribute should be a integer");
        }
    }

    public void setVerbose(boolean z) {
        this.verbose = z;
    }
}
