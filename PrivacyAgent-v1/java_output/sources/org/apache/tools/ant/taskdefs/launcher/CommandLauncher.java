package org.apache.tools.ant.taskdefs.launcher;

/* loaded from: classes25.dex */
public class CommandLauncher {
    protected static final org.apache.tools.ant.util.FileUtils FILE_UTILS = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static org.apache.tools.ant.taskdefs.launcher.CommandLauncher a;
    public static org.apache.tools.ant.taskdefs.launcher.CommandLauncher b;

    static {
        a = null;
        b = null;
        if (!org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_OS2)) {
            a = new org.apache.tools.ant.taskdefs.launcher.Java13CommandLauncher();
        }
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily("mac") && !org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX)) {
            b = new org.apache.tools.ant.taskdefs.launcher.MacCommandLauncher(new org.apache.tools.ant.taskdefs.launcher.CommandLauncher());
            return;
        }
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_OS2)) {
            b = new org.apache.tools.ant.taskdefs.launcher.OS2CommandLauncher(new org.apache.tools.ant.taskdefs.launcher.CommandLauncher());
            return;
        }
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS)) {
            org.apache.tools.ant.taskdefs.launcher.CommandLauncher commandLauncher = new org.apache.tools.ant.taskdefs.launcher.CommandLauncher();
            if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_9X)) {
                b = new org.apache.tools.ant.taskdefs.launcher.ScriptCommandLauncher("bin/antRun.bat", commandLauncher);
                return;
            } else {
                b = new org.apache.tools.ant.taskdefs.launcher.WinNTCommandLauncher(commandLauncher);
                return;
            }
        }
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_NETWARE)) {
            b = new org.apache.tools.ant.taskdefs.launcher.PerlScriptCommandLauncher("bin/antRun.pl", new org.apache.tools.ant.taskdefs.launcher.CommandLauncher());
        } else if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
            b = new org.apache.tools.ant.taskdefs.launcher.VmsCommandLauncher();
        } else {
            b = new org.apache.tools.ant.taskdefs.launcher.ScriptCommandLauncher("bin/antRun", new org.apache.tools.ant.taskdefs.launcher.CommandLauncher());
        }
    }

    public static org.apache.tools.ant.taskdefs.launcher.CommandLauncher a(java.lang.String str, org.apache.tools.ant.Project project) {
        org.apache.tools.ant.taskdefs.launcher.CommandLauncher commandLauncher = project != null ? (org.apache.tools.ant.taskdefs.launcher.CommandLauncher) project.getReference(str) : null;
        return commandLauncher == null ? b(str) : commandLauncher;
    }

    public static org.apache.tools.ant.taskdefs.launcher.CommandLauncher b(java.lang.String str) {
        java.lang.String property = java.lang.System.getProperty(str);
        if (property != null) {
            try {
                return (org.apache.tools.ant.taskdefs.launcher.CommandLauncher) java.lang.Class.forName(property).newInstance();
            } catch (java.lang.ClassNotFoundException e) {
                java.lang.System.err.println("Could not instantiate launcher class " + property + ": " + e.getMessage());
            } catch (java.lang.IllegalAccessException e2) {
                java.lang.System.err.println("Could not instantiate launcher class " + property + ": " + e2.getMessage());
            } catch (java.lang.InstantiationException e3) {
                java.lang.System.err.println("Could not instantiate launcher class " + property + ": " + e3.getMessage());
            }
        }
        return null;
    }

    public static org.apache.tools.ant.taskdefs.launcher.CommandLauncher getShellLauncher(org.apache.tools.ant.Project project) {
        org.apache.tools.ant.taskdefs.launcher.CommandLauncher a2 = a(org.apache.tools.ant.MagicNames.ANT_SHELL_LAUNCHER_REF_ID, project);
        return a2 == null ? b : a2;
    }

    public static org.apache.tools.ant.taskdefs.launcher.CommandLauncher getVMLauncher(org.apache.tools.ant.Project project) {
        org.apache.tools.ant.taskdefs.launcher.CommandLauncher a2 = a(org.apache.tools.ant.MagicNames.ANT_VM_LAUNCHER_REF_ID, project);
        return a2 == null ? a : a2;
    }

    public static void setShellLauncher(org.apache.tools.ant.Project project, org.apache.tools.ant.taskdefs.launcher.CommandLauncher commandLauncher) {
        if (project != null) {
            project.addReference(org.apache.tools.ant.MagicNames.ANT_SHELL_LAUNCHER_REF_ID, commandLauncher);
        }
    }

    public static void setVMLauncher(org.apache.tools.ant.Project project, org.apache.tools.ant.taskdefs.launcher.CommandLauncher commandLauncher) {
        if (project != null) {
            project.addReference(org.apache.tools.ant.MagicNames.ANT_VM_LAUNCHER_REF_ID, commandLauncher);
        }
    }

    public java.lang.Process exec(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2) throws java.io.IOException {
        if (project != null) {
            project.log("Execute:CommandLauncher: " + org.apache.tools.ant.types.Commandline.describeCommand(strArr), 4);
        }
        return java.lang.Runtime.getRuntime().exec(strArr, strArr2);
    }

    public java.lang.Process exec(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2, java.io.File file) throws java.io.IOException {
        if (file == null) {
            return exec(project, strArr, strArr2);
        }
        throw new java.io.IOException("Cannot execute a process in different directory under this JVM");
    }
}
