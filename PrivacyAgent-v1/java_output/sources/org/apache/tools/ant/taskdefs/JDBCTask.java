package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public abstract class JDBCTask extends org.apache.tools.ant.Task {
    public static java.util.Hashtable<java.lang.String, org.apache.tools.ant.AntClassLoader> G = new java.util.Hashtable<>(3);
    public org.apache.tools.ant.types.Path v;
    public org.apache.tools.ant.AntClassLoader w;
    public boolean u = true;
    public boolean x = false;
    public java.lang.String y = null;
    public java.lang.String z = null;
    public java.lang.String A = null;
    public java.lang.String B = null;
    public java.lang.String C = null;
    public java.lang.String D = null;
    public boolean E = true;
    public java.util.List<org.apache.tools.ant.taskdefs.Property> F = new java.util.ArrayList();

    public static java.util.Hashtable<java.lang.String, org.apache.tools.ant.AntClassLoader> getLoaderMap() {
        return G;
    }

    public void addConnectionProperty(org.apache.tools.ant.taskdefs.Property property) {
        this.F.add(property);
    }

    public final java.sql.Driver c() throws org.apache.tools.ant.BuildException {
        java.lang.Class<?> cls;
        if (this.y == null) {
            throw new org.apache.tools.ant.BuildException("Driver attribute must be set!", getLocation());
        }
        try {
            if (this.v != null) {
                synchronized (G) {
                    if (this.u) {
                        this.w = G.get(this.y);
                    }
                    if (this.w == null) {
                        log("Loading " + this.y + " using AntClassLoader with classpath " + this.v, 3);
                        org.apache.tools.ant.AntClassLoader createClassLoader = getProject().createClassLoader(this.v);
                        this.w = createClassLoader;
                        if (this.u) {
                            G.put(this.y, createClassLoader);
                        }
                    } else {
                        log("Loading " + this.y + " using a cached AntClassLoader.", 3);
                    }
                }
                cls = this.w.loadClass(this.y);
            } else {
                log("Loading " + this.y + " using system loader.", 3);
                cls = java.lang.Class.forName(this.y);
            }
            return (java.sql.Driver) cls.newInstance();
        } catch (java.lang.ClassNotFoundException e) {
            throw new org.apache.tools.ant.BuildException("Class Not Found: JDBC driver " + this.y + " could not be loaded", e, getLocation());
        } catch (java.lang.IllegalAccessException e2) {
            throw new org.apache.tools.ant.BuildException("Illegal Access: JDBC driver " + this.y + " could not be loaded", e2, getLocation());
        } catch (java.lang.InstantiationException e3) {
            throw new org.apache.tools.ant.BuildException("Instantiation Exception: JDBC driver " + this.y + " could not be loaded", e3, getLocation());
        }
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.v == null) {
            this.v = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.v.createPath();
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        return this.v;
    }

    public java.sql.Connection getConnection() throws org.apache.tools.ant.BuildException {
        if (this.A == null) {
            throw new org.apache.tools.ant.BuildException("UserId attribute must be set!", getLocation());
        }
        if (this.B == null) {
            throw new org.apache.tools.ant.BuildException("Password attribute must be set!", getLocation());
        }
        if (this.z == null) {
            throw new org.apache.tools.ant.BuildException("Url attribute must be set!", getLocation());
        }
        try {
            log("connecting to " + getUrl(), 3);
            java.util.Properties properties = new java.util.Properties();
            properties.put(com.umeng.analytics.pro.ay.m, getUserId());
            properties.put("password", getPassword());
            for (org.apache.tools.ant.taskdefs.Property property : this.F) {
                java.lang.String name = property.getName();
                java.lang.String value = property.getValue();
                if (name != null && value != null) {
                    log("Setting connection property " + name + " to " + value, 3);
                    properties.put(name, value);
                }
                log("Only name/value pairs are supported as connection properties.", 1);
            }
            java.sql.Connection connect = c().connect(getUrl(), properties);
            if (connect != null) {
                connect.setAutoCommit(this.x);
                return connect;
            }
            throw new java.sql.SQLException("No suitable Driver for " + this.z);
        } catch (java.sql.SQLException e) {
            if (this.E) {
                throw new org.apache.tools.ant.BuildException(e, getLocation());
            }
            log("Failed to connect: " + e.getMessage(), 1);
            return null;
        }
    }

    public org.apache.tools.ant.AntClassLoader getLoader() {
        return this.w;
    }

    public java.lang.String getPassword() {
        return this.B;
    }

    public java.lang.String getRdbms() {
        return this.C;
    }

    public java.lang.String getUrl() {
        return this.z;
    }

    public java.lang.String getUserId() {
        return this.A;
    }

    public java.lang.String getVersion() {
        return this.D;
    }

    public boolean isAutocommit() {
        return this.x;
    }

    public void isCaching(boolean z) {
        this.u = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
    
        if (r7.contains(" " + r6.D) == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isValidRdbms(java.sql.Connection connection) {
        if (this.C == null && this.D == null) {
            return true;
        }
        try {
            java.sql.DatabaseMetaData metaData = connection.getMetaData();
            if (this.C != null) {
                java.lang.String lowerCase = metaData.getDatabaseProductName().toLowerCase();
                log("RDBMS = " + lowerCase, 3);
                if (lowerCase == null || !lowerCase.contains(this.C)) {
                    log("Not the required RDBMS: " + this.C, 3);
                    return false;
                }
            }
            if (this.D != null) {
                java.lang.String lowerCase2 = metaData.getDatabaseProductVersion().toLowerCase(java.util.Locale.ENGLISH);
                log("Version = " + lowerCase2, 3);
                if (lowerCase2 != null) {
                    if (!lowerCase2.startsWith(this.D)) {
                    }
                }
                log("Not the required version: \"" + this.D + "\"", 3);
                return false;
            }
            return true;
        } catch (java.sql.SQLException unused) {
            log("Failed to obtain required RDBMS information", 0);
            return false;
        }
    }

    public void setAutocommit(boolean z) {
        this.x = z;
    }

    public void setCaching(boolean z) {
        this.u = z;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        this.v = path;
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setDriver(java.lang.String str) {
        this.y = str.trim();
    }

    public void setFailOnConnectionError(boolean z) {
        this.E = z;
    }

    public void setPassword(java.lang.String str) {
        this.B = str;
    }

    public void setRdbms(java.lang.String str) {
        this.C = str;
    }

    public void setUrl(java.lang.String str) {
        this.z = str;
    }

    public void setUserid(java.lang.String str) {
        this.A = str;
    }

    public void setVersion(java.lang.String str) {
        this.D = str;
    }
}
