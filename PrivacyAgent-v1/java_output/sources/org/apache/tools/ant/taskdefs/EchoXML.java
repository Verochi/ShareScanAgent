package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class EchoXML extends org.apache.tools.ant.util.XMLFragment {
    public java.io.File u;
    public boolean v;
    public org.apache.tools.ant.taskdefs.EchoXML.NamespacePolicy w = org.apache.tools.ant.taskdefs.EchoXML.NamespacePolicy.DEFAULT;

    public static class NamespacePolicy extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final org.apache.tools.ant.taskdefs.EchoXML.NamespacePolicy DEFAULT = new org.apache.tools.ant.taskdefs.EchoXML.NamespacePolicy(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);

        public NamespacePolicy() {
        }

        public NamespacePolicy(java.lang.String str) {
            setValue(str);
        }

        public org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy getPolicy() {
            java.lang.String value = getValue();
            if (org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE.equalsIgnoreCase(value)) {
                return org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy.IGNORE;
            }
            if ("elementsOnly".equalsIgnoreCase(value)) {
                return org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy.ONLY_QUALIFY_ELEMENTS;
            }
            if ("all".equalsIgnoreCase(value)) {
                return org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy.QUALIFY_ALL;
            }
            throw new org.apache.tools.ant.BuildException("Invalid namespace policy: " + value);
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE, "elementsOnly", "all"};
        }
    }

    public void execute() {
        org.apache.tools.ant.util.DOMElementWriter dOMElementWriter = new org.apache.tools.ant.util.DOMElementWriter(!this.v, this.w.getPolicy());
        try {
            try {
                try {
                    java.io.OutputStream fileOutputStream = this.u != null ? new java.io.FileOutputStream(this.u.getAbsolutePath(), this.v) : new org.apache.tools.ant.taskdefs.LogOutputStream(this, 2);
                    org.w3c.dom.Node firstChild = getFragment().getFirstChild();
                    if (firstChild == null) {
                        throw new org.apache.tools.ant.BuildException("No nested XML specified");
                    }
                    dOMElementWriter.write((org.w3c.dom.Element) firstChild, fileOutputStream);
                    org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                } catch (java.lang.Exception e) {
                    throw new org.apache.tools.ant.BuildException(e);
                }
            } catch (org.apache.tools.ant.BuildException e2) {
                throw e2;
            }
        } catch (java.lang.Throwable th) {
            org.apache.tools.ant.util.FileUtils.close((java.io.OutputStream) null);
            throw th;
        }
    }

    public void setAppend(boolean z) {
        this.v = z;
    }

    public void setFile(java.io.File file) {
        this.u = file;
    }

    public void setNamespacePolicy(org.apache.tools.ant.taskdefs.EchoXML.NamespacePolicy namespacePolicy) {
        this.w = namespacePolicy;
    }
}
