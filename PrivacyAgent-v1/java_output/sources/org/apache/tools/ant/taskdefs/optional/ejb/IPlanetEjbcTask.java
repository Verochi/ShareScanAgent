package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class IPlanetEjbcTask extends org.apache.tools.ant.Task {
    public java.io.File A;
    public java.io.File u;
    public java.io.File v;
    public java.io.File w;
    public org.apache.tools.ant.types.Path x;
    public boolean y = false;
    public boolean z = false;

    public final void c(javax.xml.parsers.SAXParser sAXParser) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc iPlanetEjbc = new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc(this.u, this.v, this.w, getClasspath().toString(), sAXParser);
        iPlanetEjbc.setRetainSource(this.y);
        iPlanetEjbc.setDebugOutput(this.z);
        java.io.File file = this.A;
        if (file != null) {
            iPlanetEjbc.setIasHomeDir(file);
        }
        try {
            iPlanetEjbc.execute();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("An IOException occurred while trying to read the XML descriptor file: " + e.getMessage(), e, getLocation());
        } catch (org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbcException e2) {
            throw new org.apache.tools.ant.BuildException("An exception occurred while trying to run the ejbc utility: " + e2.getMessage(), e2, getLocation());
        } catch (org.xml.sax.SAXException e3) {
            throw new org.apache.tools.ant.BuildException("A SAXException occurred while trying to read the XML descriptor file: " + e3.getMessage(), e3, getLocation());
        }
    }

    public final void checkConfiguration() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.u;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("The standard EJB descriptor must be specified using the \"ejbdescriptor\" attribute.", getLocation());
        }
        if (!file.exists() || !this.u.isFile()) {
            throw new org.apache.tools.ant.BuildException("The standard EJB descriptor (" + this.u + ") was not found or isn't a file.", getLocation());
        }
        java.io.File file2 = this.v;
        if (file2 == null) {
            throw new org.apache.tools.ant.BuildException("The iAS-speific XML descriptor must be specified using the \"iasdescriptor\" attribute.", getLocation());
        }
        if (!file2.exists() || !this.v.isFile()) {
            throw new org.apache.tools.ant.BuildException("The iAS-specific XML descriptor (" + this.v + ") was not found or isn't a file.", getLocation());
        }
        java.io.File file3 = this.w;
        if (file3 == null) {
            throw new org.apache.tools.ant.BuildException("The destination directory must be specified using the \"dest\" attribute.", getLocation());
        }
        if (!file3.exists() || !this.w.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("The destination directory (" + this.w + ") was not found or isn't a directory.", getLocation());
        }
        java.io.File file4 = this.A;
        if (file4 == null || file4.isDirectory()) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("If \"iashome\" is specified, it must be a valid directory (it was set to " + this.A + ").", getLocation());
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.x == null) {
            this.x = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.x.createPath();
    }

    public final javax.xml.parsers.SAXParser d() throws org.apache.tools.ant.BuildException {
        try {
            javax.xml.parsers.SAXParserFactory newInstance = javax.xml.parsers.SAXParserFactory.newInstance();
            newInstance.setValidating(true);
            return newInstance.newSAXParser();
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            throw new org.apache.tools.ant.BuildException("Unable to create a SAXParser: " + e.getMessage(), e, getLocation());
        } catch (org.xml.sax.SAXException e2) {
            throw new org.apache.tools.ant.BuildException("Unable to create a SAXParser: " + e2.getMessage(), e2, getLocation());
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        checkConfiguration();
        c(d());
    }

    public final org.apache.tools.ant.types.Path getClasspath() {
        org.apache.tools.ant.types.Path path = this.x;
        return path == null ? new org.apache.tools.ant.types.Path(getProject()).concatSystemClasspath("last") : path.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.x;
        if (path2 == null) {
            this.x = path;
        } else {
            path2.append(path);
        }
    }

    public void setDebug(boolean z) {
        this.z = z;
    }

    public void setDest(java.io.File file) {
        this.w = file;
    }

    public void setEjbdescriptor(java.io.File file) {
        this.u = file;
    }

    public void setIasdescriptor(java.io.File file) {
        this.v = file;
    }

    public void setIashome(java.io.File file) {
        this.A = file;
    }

    public void setKeepgenerated(boolean z) {
        this.y = z;
    }
}
