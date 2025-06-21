package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class EjbJar extends org.apache.tools.ant.taskdefs.MatchingTask {
    public java.io.File v;
    public org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.Config u = new org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.Config();
    public java.lang.String w = "-generic.jar";
    public java.lang.String x = "1.0";
    public java.util.ArrayList y = new java.util.ArrayList();

    public static class CMPVersion extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String CMP1_0 = "1.0";
        public static final java.lang.String CMP2_0 = "2.0";

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"1.0", "2.0"};
        }
    }

    public static class Config {
        public java.io.File a;
        public java.io.File b;
        public java.lang.String d;
        public org.apache.tools.ant.types.Path f;
        public org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme i;
        public java.io.File j;
        public java.lang.String k;
        public java.lang.String c = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        public boolean e = false;
        public java.util.List g = new java.util.ArrayList();
        public java.util.ArrayList h = new java.util.ArrayList();
    }

    public static class DTDLocation extends org.apache.tools.ant.types.DTDLocation {
    }

    public static class NamingScheme extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String BASEJARNAME = "basejarname";
        public static final java.lang.String DESCRIPTOR = "descriptor";
        public static final java.lang.String DIRECTORY = "directory";
        public static final java.lang.String EJB_NAME = "ejb-name";

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{EJB_NAME, DIRECTORY, DESCRIPTOR, BASEJARNAME};
        }
    }

    public void addDeploymentTool(org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool eJBDeploymentTool) {
        eJBDeploymentTool.setTask(this);
        this.y.add(eJBDeploymentTool);
    }

    public final void c() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.Config config = this.u;
        java.io.File file = config.a;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("The srcDir attribute must be specified");
        }
        if (config.b == null) {
            config.b = file;
        }
        org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme namingScheme = config.i;
        if (namingScheme == null) {
            config.i = new org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme();
            this.u.i.setValue(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.DESCRIPTOR);
        } else if (namingScheme.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.BASEJARNAME) && this.u.d == null) {
            throw new org.apache.tools.ant.BuildException("The basejarname attribute must be specified with the basejarname naming scheme");
        }
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.BorlandDeploymentTool createBorland() {
        log("Borland deployment tools", 3);
        org.apache.tools.ant.taskdefs.optional.ejb.BorlandDeploymentTool borlandDeploymentTool = new org.apache.tools.ant.taskdefs.optional.ejb.BorlandDeploymentTool();
        borlandDeploymentTool.setTask(this);
        this.y.add(borlandDeploymentTool);
        return borlandDeploymentTool;
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.Config config = this.u;
        if (config.f == null) {
            config.f = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.u.f.createPath();
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation createDTD() {
        org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation dTDLocation = new org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation();
        this.u.h.add(dTDLocation);
        return dTDLocation;
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetDeploymentTool createIplanet() {
        log("iPlanet Application Server deployment tools", 3);
        org.apache.tools.ant.taskdefs.optional.ejb.IPlanetDeploymentTool iPlanetDeploymentTool = new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetDeploymentTool();
        addDeploymentTool(iPlanetDeploymentTool);
        return iPlanetDeploymentTool;
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.JbossDeploymentTool createJboss() {
        org.apache.tools.ant.taskdefs.optional.ejb.JbossDeploymentTool jbossDeploymentTool = new org.apache.tools.ant.taskdefs.optional.ejb.JbossDeploymentTool();
        addDeploymentTool(jbossDeploymentTool);
        return jbossDeploymentTool;
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.JonasDeploymentTool createJonas() {
        log("JOnAS deployment tools", 3);
        org.apache.tools.ant.taskdefs.optional.ejb.JonasDeploymentTool jonasDeploymentTool = new org.apache.tools.ant.taskdefs.optional.ejb.JonasDeploymentTool();
        addDeploymentTool(jonasDeploymentTool);
        return jonasDeploymentTool;
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.OrionDeploymentTool createOrion() {
        org.apache.tools.ant.taskdefs.optional.ejb.OrionDeploymentTool orionDeploymentTool = new org.apache.tools.ant.taskdefs.optional.ejb.OrionDeploymentTool();
        addDeploymentTool(orionDeploymentTool);
        return orionDeploymentTool;
    }

    public org.apache.tools.ant.types.FileSet createSupport() {
        org.apache.tools.ant.types.FileSet fileSet = new org.apache.tools.ant.types.FileSet();
        this.u.g.add(fileSet);
        return fileSet;
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.WeblogicDeploymentTool createWeblogic() {
        org.apache.tools.ant.taskdefs.optional.ejb.WeblogicDeploymentTool weblogicDeploymentTool = new org.apache.tools.ant.taskdefs.optional.ejb.WeblogicDeploymentTool();
        addDeploymentTool(weblogicDeploymentTool);
        return weblogicDeploymentTool;
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.WeblogicTOPLinkDeploymentTool createWeblogictoplink() {
        log("The <weblogictoplink> element is no longer required. Please use the <weblogic> element and set newCMP=\"true\"", 2);
        org.apache.tools.ant.taskdefs.optional.ejb.WeblogicTOPLinkDeploymentTool weblogicTOPLinkDeploymentTool = new org.apache.tools.ant.taskdefs.optional.ejb.WeblogicTOPLinkDeploymentTool();
        addDeploymentTool(weblogicTOPLinkDeploymentTool);
        return weblogicTOPLinkDeploymentTool;
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.WebsphereDeploymentTool createWebsphere() {
        org.apache.tools.ant.taskdefs.optional.ejb.WebsphereDeploymentTool websphereDeploymentTool = new org.apache.tools.ant.taskdefs.optional.ejb.WebsphereDeploymentTool();
        addDeploymentTool(websphereDeploymentTool);
        return websphereDeploymentTool;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        c();
        if (this.y.size() == 0) {
            org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool genericDeploymentTool = new org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool();
            genericDeploymentTool.setTask(this);
            genericDeploymentTool.setDestdir(this.v);
            genericDeploymentTool.setGenericJarSuffix(this.w);
            this.y.add(genericDeploymentTool);
        }
        java.util.Iterator it = this.y.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool eJBDeploymentTool = (org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool) it.next();
            eJBDeploymentTool.configure(this.u);
            eJBDeploymentTool.validateConfigured();
        }
        try {
            javax.xml.parsers.SAXParserFactory newInstance = javax.xml.parsers.SAXParserFactory.newInstance();
            newInstance.setValidating(true);
            javax.xml.parsers.SAXParser newSAXParser = newInstance.newSAXParser();
            org.apache.tools.ant.DirectoryScanner directoryScanner = getDirectoryScanner(this.u.b);
            directoryScanner.scan();
            java.lang.String[] includedFiles = directoryScanner.getIncludedFiles();
            log(includedFiles.length + " deployment descriptors located.", 3);
            for (java.lang.String str : includedFiles) {
                java.util.Iterator it2 = this.y.iterator();
                while (it2.hasNext()) {
                    ((org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool) it2.next()).processDescriptor(str, newSAXParser);
                }
            }
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            throw new org.apache.tools.ant.BuildException("ParserConfigurationException while creating parser. Details: " + e.getMessage(), e);
        } catch (org.xml.sax.SAXException e2) {
            throw new org.apache.tools.ant.BuildException("SAXException while creating parser.  Details: " + e2.getMessage(), e2);
        }
    }

    public java.lang.String getCmpversion() {
        return this.x;
    }

    public java.io.File getDestdir() {
        return this.v;
    }

    public void setBasejarname(java.lang.String str) {
        org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.Config config = this.u;
        config.d = str;
        org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme namingScheme = config.i;
        if (namingScheme == null) {
            config.i = new org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme();
            this.u.i.setValue(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.BASEJARNAME);
        } else {
            if (namingScheme.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.BASEJARNAME)) {
                return;
            }
            throw new org.apache.tools.ant.BuildException("The basejarname attribute is not compatible with the " + this.u.i.getValue() + " naming scheme");
        }
    }

    public void setBasenameterminator(java.lang.String str) {
        this.u.c = str;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        this.u.f = path;
    }

    public void setCmpversion(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.CMPVersion cMPVersion) {
        this.x = cMPVersion.getValue();
    }

    public void setDependency(java.lang.String str) {
        this.u.k = str;
    }

    public void setDescriptordir(java.io.File file) {
        this.u.b = file;
    }

    public void setDestdir(java.io.File file) {
        this.v = file;
    }

    public void setFlatdestdir(boolean z) {
        this.u.e = z;
    }

    public void setGenericjarsuffix(java.lang.String str) {
        this.w = str;
    }

    public void setManifest(java.io.File file) {
        this.u.j = file;
    }

    public void setNaming(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme namingScheme) {
        this.u.i = namingScheme;
        if (namingScheme.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.BASEJARNAME) || this.u.d == null) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("The basejarname attribute is not compatible with the " + this.u.i.getValue() + " naming scheme");
    }

    public void setSrcdir(java.io.File file) {
        this.u.a = file;
    }
}
