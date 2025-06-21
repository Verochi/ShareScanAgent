package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Permissions {
    public static final java.lang.Class<?>[] g = {java.lang.String.class, java.lang.String.class};
    public final java.util.List<org.apache.tools.ant.types.Permissions.Permission> a;
    public final java.util.List<org.apache.tools.ant.types.Permissions.Permission> b;
    public java.security.Permissions c;
    public java.lang.SecurityManager d;
    public boolean e;
    public final boolean f;

    public class MySM extends java.lang.SecurityManager {
        public MySM() {
        }

        public /* synthetic */ MySM(org.apache.tools.ant.types.Permissions permissions, org.apache.tools.ant.types.Permissions.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void a(java.security.Permission permission) {
            java.util.Iterator it = org.apache.tools.ant.types.Permissions.this.b.iterator();
            while (it.hasNext()) {
                if (((org.apache.tools.ant.types.Permissions.Permission) it.next()).a(permission)) {
                    throw new java.lang.SecurityException("Permission " + permission + " was revoked.");
                }
            }
        }

        @Override // java.lang.SecurityManager
        public void checkExit(int i) {
            try {
                checkPermission(new java.lang.RuntimePermission("exitVM", null));
            } catch (java.lang.SecurityException e) {
                throw new org.apache.tools.ant.ExitException(e.getMessage(), i);
            }
        }

        @Override // java.lang.SecurityManager
        public void checkPermission(java.security.Permission permission) {
            if (org.apache.tools.ant.types.Permissions.this.e) {
                if (org.apache.tools.ant.types.Permissions.this.f && !permission.getName().equals("exitVM")) {
                    boolean implies = org.apache.tools.ant.types.Permissions.this.c.implies(permission);
                    a(permission);
                    if (implies || org.apache.tools.ant.types.Permissions.this.d == null) {
                        return;
                    }
                    org.apache.tools.ant.types.Permissions.this.d.checkPermission(permission);
                    return;
                }
                if (org.apache.tools.ant.types.Permissions.this.c.implies(permission)) {
                    a(permission);
                    return;
                }
                throw new java.lang.SecurityException("Permission " + permission + " was not granted.");
            }
        }
    }

    public static class Permission {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public java.util.Set<java.lang.String> d;

        public boolean a(java.security.Permission permission) {
            if (!this.a.equals(permission.getClass().getName())) {
                return false;
            }
            java.lang.String str = this.b;
            if (str != null) {
                if (str.endsWith("*")) {
                    java.lang.String name = permission.getName();
                    java.lang.String str2 = this.b;
                    if (!name.startsWith(str2.substring(0, str2.length() - 1))) {
                        return false;
                    }
                } else if (!this.b.equals(permission.getName())) {
                    return false;
                }
            }
            if (this.d != null) {
                java.util.Set<java.lang.String> b = b(permission.getActions());
                int size = b.size();
                b.removeAll(this.d);
                if (b.size() == size) {
                    return false;
                }
            }
            return true;
        }

        public final java.util.Set<java.lang.String> b(java.lang.String str) {
            java.util.HashSet hashSet = new java.util.HashSet();
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                java.lang.String trim = stringTokenizer.nextToken().trim();
                if (!trim.equals("")) {
                    hashSet.add(trim);
                }
            }
            return hashSet;
        }

        public java.lang.String getActions() {
            return this.c;
        }

        public java.lang.String getClassName() {
            return this.a;
        }

        public java.lang.String getName() {
            return this.b;
        }

        public void setActions(java.lang.String str) {
            this.c = str;
            if (str.length() > 0) {
                this.d = b(str);
            }
        }

        public void setClass(java.lang.String str) {
            this.a = str.trim();
        }

        public void setName(java.lang.String str) {
            this.b = str.trim();
        }

        public java.lang.String toString() {
            return "Permission: " + this.a + " (\"" + this.b + "\", \"" + this.d + "\")";
        }
    }

    public Permissions() {
        this(false);
    }

    public Permissions(boolean z) {
        this.a = new java.util.LinkedList();
        this.b = new java.util.LinkedList();
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = z;
    }

    public void addConfiguredGrant(org.apache.tools.ant.types.Permissions.Permission permission) {
        this.a.add(permission);
    }

    public void addConfiguredRevoke(org.apache.tools.ant.types.Permissions.Permission permission) {
        this.b.add(permission);
    }

    public final java.security.Permission f(org.apache.tools.ant.types.Permissions.Permission permission) {
        try {
            return (java.security.Permission) java.lang.Class.forName(permission.getClassName()).asSubclass(java.security.Permission.class).getConstructor(g).newInstance(permission.getName(), permission.getActions());
        } catch (java.lang.Exception unused) {
            return new java.security.UnresolvedPermission(permission.getClassName(), permission.getName(), permission.getActions(), null);
        }
    }

    public final void g() throws org.apache.tools.ant.BuildException {
        this.c = new java.security.Permissions();
        for (org.apache.tools.ant.types.Permissions.Permission permission : this.b) {
            if (permission.getClassName() == null) {
                throw new org.apache.tools.ant.BuildException("Revoked permission " + permission + " does not contain a class.");
            }
        }
        for (org.apache.tools.ant.types.Permissions.Permission permission2 : this.a) {
            if (permission2.getClassName() == null) {
                throw new org.apache.tools.ant.BuildException("Granted permission " + permission2 + " does not contain a class.");
            }
            this.c.add(f(permission2));
        }
        this.c.add(new java.net.SocketPermission("localhost:1024-", "listen"));
        this.c.add(new java.util.PropertyPermission("java.version", "read"));
        this.c.add(new java.util.PropertyPermission("java.vendor", "read"));
        this.c.add(new java.util.PropertyPermission("java.vendor.url", "read"));
        this.c.add(new java.util.PropertyPermission("java.class.version", "read"));
        this.c.add(new java.util.PropertyPermission("os.name", "read"));
        this.c.add(new java.util.PropertyPermission("os.version", "read"));
        this.c.add(new java.util.PropertyPermission("os.arch", "read"));
        this.c.add(new java.util.PropertyPermission("file.encoding", "read"));
        this.c.add(new java.util.PropertyPermission("file.separator", "read"));
        this.c.add(new java.util.PropertyPermission("path.separator", "read"));
        this.c.add(new java.util.PropertyPermission("line.separator", "read"));
        this.c.add(new java.util.PropertyPermission("java.specification.version", "read"));
        this.c.add(new java.util.PropertyPermission("java.specification.vendor", "read"));
        this.c.add(new java.util.PropertyPermission("java.specification.name", "read"));
        this.c.add(new java.util.PropertyPermission("java.vm.specification.version", "read"));
        this.c.add(new java.util.PropertyPermission("java.vm.specification.vendor", "read"));
        this.c.add(new java.util.PropertyPermission("java.vm.specification.name", "read"));
        this.c.add(new java.util.PropertyPermission("java.vm.version", "read"));
        this.c.add(new java.util.PropertyPermission("java.vm.vendor", "read"));
        this.c.add(new java.util.PropertyPermission("java.vm.name", "read"));
    }

    public synchronized void restoreSecurityManager() {
        this.e = false;
        java.lang.System.setSecurityManager(this.d);
    }

    public synchronized void setSecurityManager() throws org.apache.tools.ant.BuildException {
        this.d = java.lang.System.getSecurityManager();
        g();
        java.lang.System.setSecurityManager(new org.apache.tools.ant.types.Permissions.MySM(this, null));
        this.e = true;
    }
}
