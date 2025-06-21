package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class IPlanetDeploymentTool extends org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool {
    public java.io.File B;
    public java.lang.String C = ".jar";
    public boolean D = false;
    public boolean E = false;
    public java.lang.String F;
    public java.lang.String G;
    public java.lang.String H;

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void addVendorFiles(java.util.Hashtable hashtable, java.lang.String str) {
        hashtable.put("META-INF/ias-ejb-jar.xml", new java.io.File(getConfig().b, b()));
    }

    public final java.lang.String b() {
        java.lang.String str = this.G;
        if (str != null) {
            return str;
        }
        int lastIndexOf = this.F.lastIndexOf(java.io.File.separatorChar);
        java.lang.String str2 = "";
        java.lang.String substring = lastIndexOf != -1 ? this.F.substring(0, lastIndexOf + 1) : "";
        int i = lastIndexOf + 1;
        java.lang.String str3 = "ejb-jar.xml";
        if (!this.F.substring(i).equals("ejb-jar.xml")) {
            int indexOf = this.F.indexOf(getConfig().c, lastIndexOf);
            if (indexOf < 0 && this.F.lastIndexOf(46) - 1 < 0) {
                indexOf = this.F.length() - 1;
            }
            int i2 = indexOf + 1;
            str2 = this.F.substring(i, i2);
            str3 = this.F.substring(i2);
        }
        java.lang.String str4 = substring + str2 + "ias-" + str3;
        this.G = str4;
        return str4;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void checkConfiguration(java.lang.String str, javax.xml.parsers.SAXParser sAXParser) throws org.apache.tools.ant.BuildException {
        if (str.substring(str.lastIndexOf(java.io.File.separatorChar) + 1).equals("ejb-jar.xml") && getConfig().d == null) {
            throw new org.apache.tools.ant.BuildException("No name specified for the completed JAR file.  The EJB descriptor should be prepended with the JAR name or it should be specified using the attribute \"basejarname\" in the \"ejbjar\" task.", getLocation());
        }
        java.io.File file = new java.io.File(getConfig().b, b());
        if (!file.exists() || !file.isFile()) {
            throw new org.apache.tools.ant.BuildException("The iAS-specific EJB descriptor (" + file + ") was not found.", getLocation());
        }
        java.io.File file2 = this.B;
        if (file2 == null || file2.isDirectory()) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("If \"iashome\" is specified, it must be a valid directory (it was set to " + this.B + ").", getLocation());
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public java.lang.String getPublicId() {
        return null;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public java.io.File getVendorOutputJarFile(java.lang.String str) {
        java.io.File file = new java.io.File(getDestDir(), str + this.C);
        log("JAR file name: " + file.toString(), 3);
        return file;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public java.util.Hashtable parseEjbFiles(java.lang.String str, javax.xml.parsers.SAXParser sAXParser) throws java.io.IOException, org.xml.sax.SAXException {
        org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc iPlanetEjbc = new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc(new java.io.File(getConfig().b, str), new java.io.File(getConfig().b, b()), getConfig().a, getCombinedClasspath().toString(), sAXParser);
        iPlanetEjbc.setRetainSource(this.D);
        iPlanetEjbc.setDebugOutput(this.E);
        java.io.File file = this.B;
        if (file != null) {
            iPlanetEjbc.setIasHomeDir(file);
        }
        if (getConfig().h != null) {
            java.util.Iterator it = getConfig().h.iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation dTDLocation = (org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation) it.next();
                iPlanetEjbc.registerDTD(dTDLocation.getPublicId(), dTDLocation.getLocation());
            }
        }
        try {
            iPlanetEjbc.execute();
            this.H = iPlanetEjbc.getDisplayName();
            java.util.Hashtable ejbFiles = iPlanetEjbc.getEjbFiles();
            java.lang.String[] cmpDescriptors = iPlanetEjbc.getCmpDescriptors();
            if (cmpDescriptors.length > 0) {
                java.io.File file2 = getConfig().b;
                java.lang.String substring = str.substring(0, str.lastIndexOf(java.io.File.separator) + 1);
                for (java.lang.String str2 : cmpDescriptors) {
                    java.io.File file3 = new java.io.File(file2, substring + str2.substring(str2.lastIndexOf(47) + 1));
                    if (!file3.exists()) {
                        throw new org.apache.tools.ant.BuildException("The CMP descriptor file (" + file3 + ") could not be found.", getLocation());
                    }
                    ejbFiles.put(str2, file3);
                }
            }
            return ejbFiles;
        } catch (org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbcException e) {
            throw new org.apache.tools.ant.BuildException("An error has occurred while trying to execute the iAS ejbc utility", e, getLocation());
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool, org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool
    public void processDescriptor(java.lang.String str, javax.xml.parsers.SAXParser sAXParser) {
        this.F = str;
        this.G = null;
        log("iPlanet Deployment Tool processing: " + str + " (and " + b() + ")", 3);
        super.processDescriptor(str, sAXParser);
    }

    public void setDebug(boolean z) {
        this.E = z;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void setGenericJarSuffix(java.lang.String str) {
        log("Since a generic JAR file is not created during processing, the iPlanet Deployment Tool does not support the \"genericjarsuffix\" attribute.  It will be ignored.", 1);
    }

    public void setIashome(java.io.File file) {
        this.B = file;
    }

    public void setKeepgenerated(boolean z) {
        this.D = z;
    }

    public void setSuffix(java.lang.String str) {
        this.C = str;
    }
}
