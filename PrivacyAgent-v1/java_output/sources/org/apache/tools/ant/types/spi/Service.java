package org.apache.tools.ant.types.spi;

/* loaded from: classes26.dex */
public class Service extends org.apache.tools.ant.ProjectComponent {
    public java.util.List<org.apache.tools.ant.types.spi.Provider> n = new java.util.ArrayList();
    public java.lang.String t;

    public void addConfiguredProvider(org.apache.tools.ant.types.spi.Provider provider) {
        provider.check();
        this.n.add(provider);
    }

    public void check() {
        java.lang.String str = this.t;
        if (str == null) {
            throw new org.apache.tools.ant.BuildException("type attribute must be set for service element", getLocation());
        }
        if (str.length() == 0) {
            throw new org.apache.tools.ant.BuildException("Invalid empty type classname", getLocation());
        }
        if (this.n.size() == 0) {
            throw new org.apache.tools.ant.BuildException("provider attribute or nested provider element must be set!", getLocation());
        }
    }

    public java.io.InputStream getAsStream() throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(byteArrayOutputStream, "UTF-8");
        java.util.Iterator<org.apache.tools.ant.types.spi.Provider> it = this.n.iterator();
        while (it.hasNext()) {
            outputStreamWriter.write(it.next().getClassName());
            outputStreamWriter.write("\n");
        }
        outputStreamWriter.close();
        return new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public java.lang.String getType() {
        return this.t;
    }

    public void setProvider(java.lang.String str) {
        org.apache.tools.ant.types.spi.Provider provider = new org.apache.tools.ant.types.spi.Provider();
        provider.setClassName(str);
        this.n.add(provider);
    }

    public void setType(java.lang.String str) {
        this.t = str;
    }
}
