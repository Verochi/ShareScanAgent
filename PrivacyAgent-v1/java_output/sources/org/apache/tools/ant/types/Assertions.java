package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Assertions extends org.apache.tools.ant.types.DataType {
    public java.lang.Boolean n;
    public java.util.ArrayList<org.apache.tools.ant.types.Assertions.BaseAssertion> t = new java.util.ArrayList<>();

    public static abstract class BaseAssertion {
        public java.lang.String a;
        public java.lang.String b;

        public java.lang.String getClassName() {
            return this.b;
        }

        public abstract java.lang.String getCommandPrefix();

        public java.lang.String getPackageName() {
            return this.a;
        }

        public void setClass(java.lang.String str) {
            this.b = str;
        }

        public void setPackage(java.lang.String str) {
            this.a = str;
        }

        public java.lang.String toCommand() {
            if (getPackageName() != null && getClassName() != null) {
                throw new org.apache.tools.ant.BuildException("Both package and class have been set");
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(getCommandPrefix());
            if (getPackageName() != null) {
                stringBuffer.append(':');
                stringBuffer.append(getPackageName());
                if (!stringBuffer.toString().endsWith("...")) {
                    stringBuffer.append("...");
                }
            } else if (getClassName() != null) {
                stringBuffer.append(':');
                stringBuffer.append(getClassName());
            }
            return stringBuffer.toString();
        }
    }

    public static class DisabledAssertion extends org.apache.tools.ant.types.Assertions.BaseAssertion {
        @Override // org.apache.tools.ant.types.Assertions.BaseAssertion
        public java.lang.String getCommandPrefix() {
            return "-da";
        }
    }

    public static class EnabledAssertion extends org.apache.tools.ant.types.Assertions.BaseAssertion {
        @Override // org.apache.tools.ant.types.Assertions.BaseAssertion
        public java.lang.String getCommandPrefix() {
            return "-ea";
        }
    }

    public static void b(org.apache.tools.ant.types.CommandlineJava commandlineJava, java.lang.String str) {
        commandlineJava.createVmArgument().setValue(str);
    }

    public void addDisable(org.apache.tools.ant.types.Assertions.DisabledAssertion disabledAssertion) {
        checkChildrenAllowed();
        this.t.add(disabledAssertion);
    }

    public void addEnable(org.apache.tools.ant.types.Assertions.EnabledAssertion enabledAssertion) {
        checkChildrenAllowed();
        this.t.add(enabledAssertion);
    }

    public void applyAssertions(java.util.List<java.lang.String> list) {
        getProject().log("Applying assertions", 4);
        org.apache.tools.ant.types.Assertions c = c();
        if (java.lang.Boolean.TRUE.equals(c.n)) {
            getProject().log("Enabling system assertions", 4);
            list.add("-enablesystemassertions");
        } else if (java.lang.Boolean.FALSE.equals(c.n)) {
            getProject().log("disabling system assertions", 4);
            list.add("-disablesystemassertions");
        }
        java.util.Iterator<org.apache.tools.ant.types.Assertions.BaseAssertion> it = c.t.iterator();
        while (it.hasNext()) {
            java.lang.String command = it.next().toCommand();
            getProject().log("adding assertion " + command, 4);
            list.add(command);
        }
    }

    public void applyAssertions(java.util.ListIterator<java.lang.String> listIterator) {
        getProject().log("Applying assertions", 4);
        org.apache.tools.ant.types.Assertions c = c();
        if (java.lang.Boolean.TRUE.equals(c.n)) {
            getProject().log("Enabling system assertions", 4);
            listIterator.add("-enablesystemassertions");
        } else if (java.lang.Boolean.FALSE.equals(c.n)) {
            getProject().log("disabling system assertions", 4);
            listIterator.add("-disablesystemassertions");
        }
        java.util.Iterator<org.apache.tools.ant.types.Assertions.BaseAssertion> it = c.t.iterator();
        while (it.hasNext()) {
            java.lang.String command = it.next().toCommand();
            getProject().log("adding assertion " + command, 4);
            listIterator.add(command);
        }
    }

    public void applyAssertions(org.apache.tools.ant.types.CommandlineJava commandlineJava) {
        org.apache.tools.ant.types.Assertions c = c();
        if (java.lang.Boolean.TRUE.equals(c.n)) {
            b(commandlineJava, "-enablesystemassertions");
        } else if (java.lang.Boolean.FALSE.equals(c.n)) {
            b(commandlineJava, "-disablesystemassertions");
        }
        java.util.Iterator<org.apache.tools.ant.types.Assertions.BaseAssertion> it = c.t.iterator();
        while (it.hasNext()) {
            b(commandlineJava, it.next().toCommand());
        }
    }

    public final org.apache.tools.ant.types.Assertions c() {
        if (getRefid() == null) {
            return this;
        }
        java.lang.Object referencedObject = getRefid().getReferencedObject(getProject());
        if (referencedObject instanceof org.apache.tools.ant.types.Assertions) {
            return (org.apache.tools.ant.types.Assertions) referencedObject;
        }
        throw new org.apache.tools.ant.BuildException("reference is of wrong type");
    }

    @Override // org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        org.apache.tools.ant.types.Assertions assertions = (org.apache.tools.ant.types.Assertions) super.clone();
        assertions.t = new java.util.ArrayList<>(this.t);
        return assertions;
    }

    public final int d() {
        return this.t.size() + (this.n != null ? 1 : 0);
    }

    public void setEnableSystemAssertions(java.lang.Boolean bool) {
        checkAttributesAllowed();
        this.n = bool;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.t.size() > 0 || this.n != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public int size() {
        return c().d();
    }
}
