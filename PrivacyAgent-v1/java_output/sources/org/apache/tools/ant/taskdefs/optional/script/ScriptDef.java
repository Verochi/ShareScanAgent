package org.apache.tools.ant.taskdefs.optional.script;

/* loaded from: classes25.dex */
public class ScriptDef extends org.apache.tools.ant.taskdefs.DefBase {
    public java.util.Set C;
    public java.util.Map D;
    public java.lang.String z;
    public org.apache.tools.ant.util.ScriptRunnerHelper y = new org.apache.tools.ant.util.ScriptRunnerHelper();
    public java.util.List A = new java.util.ArrayList();
    public java.util.List B = new java.util.ArrayList();

    public static class Attribute {
        public java.lang.String a;

        public void setName(java.lang.String str) {
            this.a = str.toLowerCase(java.util.Locale.ENGLISH);
        }
    }

    public static class NestedElement {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;

        public void setClassName(java.lang.String str) {
            this.c = str;
        }

        public void setName(java.lang.String str) {
            this.a = str.toLowerCase(java.util.Locale.ENGLISH);
        }

        public void setType(java.lang.String str) {
            this.b = str;
        }
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.y.add(resourceCollection);
    }

    public void addAttribute(org.apache.tools.ant.taskdefs.optional.script.ScriptDef.Attribute attribute) {
        this.A.add(attribute);
    }

    public void addElement(org.apache.tools.ant.taskdefs.optional.script.ScriptDef.NestedElement nestedElement) {
        this.B.add(nestedElement);
    }

    public void addText(java.lang.String str) {
        this.y.addText(str);
    }

    public java.lang.Object createNestedElement(java.lang.String str) {
        java.lang.Object newInstance;
        java.lang.Object obj;
        org.apache.tools.ant.taskdefs.optional.script.ScriptDef.NestedElement nestedElement = (org.apache.tools.ant.taskdefs.optional.script.ScriptDef.NestedElement) this.D.get(str);
        if (nestedElement == null) {
            throw new org.apache.tools.ant.BuildException("<" + this.z + "> does not support the <" + str + "> nested element");
        }
        java.lang.String str2 = nestedElement.c;
        if (str2 == null) {
            obj = getProject().createTask(nestedElement.b);
            if (obj == null) {
                obj = getProject().createDataType(nestedElement.b);
            }
        } else {
            try {
                newInstance = org.apache.tools.ant.util.ClasspathUtils.newInstance(str2, createLoader());
            } catch (org.apache.tools.ant.BuildException unused) {
                newInstance = org.apache.tools.ant.util.ClasspathUtils.newInstance(str2, org.apache.tools.ant.taskdefs.optional.script.ScriptDef.class.getClassLoader());
            }
            obj = newInstance;
            getProject().setProjectReference(obj);
        }
        if (obj != null) {
            return obj;
        }
        throw new org.apache.tools.ant.BuildException("<" + this.z + "> is unable to create the <" + str + "> nested element");
    }

    public final java.util.Map d() {
        java.util.Map map;
        org.apache.tools.ant.Project project = getProject();
        synchronized (project) {
            map = (java.util.Map) project.getReference(org.apache.tools.ant.MagicNames.SCRIPT_REPOSITORY);
            if (map == null) {
                map = new java.util.HashMap();
                project.addReference(org.apache.tools.ant.MagicNames.SCRIPT_REPOSITORY, map);
            }
        }
        return map;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        if (this.z == null) {
            throw new org.apache.tools.ant.BuildException("scriptdef requires a name attribute to name the script");
        }
        if (this.y.getLanguage() == null) {
            throw new org.apache.tools.ant.BuildException("<scriptdef> requires a language attribute to specify the script language");
        }
        if (getAntlibClassLoader() != null || hasCpDelegate()) {
            this.y.setClassLoader(createLoader());
        }
        this.C = new java.util.HashSet();
        for (org.apache.tools.ant.taskdefs.optional.script.ScriptDef.Attribute attribute : this.A) {
            if (attribute.a == null) {
                throw new org.apache.tools.ant.BuildException("scriptdef <attribute> elements must specify an attribute name");
            }
            if (this.C.contains(attribute.a)) {
                throw new org.apache.tools.ant.BuildException("scriptdef <" + this.z + "> declares the " + attribute.a + " attribute more than once");
            }
            this.C.add(attribute.a);
        }
        this.D = new java.util.HashMap();
        for (org.apache.tools.ant.taskdefs.optional.script.ScriptDef.NestedElement nestedElement : this.B) {
            if (nestedElement.a == null) {
                throw new org.apache.tools.ant.BuildException("scriptdef <element> elements must specify an element name");
            }
            if (this.D.containsKey(nestedElement.a)) {
                throw new org.apache.tools.ant.BuildException("scriptdef <" + this.z + "> declares the " + nestedElement.a + " nested element more than once");
            }
            if (nestedElement.c == null && nestedElement.b == null) {
                throw new org.apache.tools.ant.BuildException("scriptdef <element> elements must specify either a classname or type attribute");
            }
            if (nestedElement.c != null && nestedElement.b != null) {
                throw new org.apache.tools.ant.BuildException("scriptdef <element> elements must specify only one of the classname and type attributes");
            }
            this.D.put(nestedElement.a, nestedElement);
        }
        java.util.Map d = d();
        java.lang.String genComponentName = org.apache.tools.ant.ProjectHelper.genComponentName(getURI(), this.z);
        this.z = genComponentName;
        d.put(genComponentName, this);
        org.apache.tools.ant.AntTypeDefinition antTypeDefinition = new org.apache.tools.ant.AntTypeDefinition();
        antTypeDefinition.setName(this.z);
        antTypeDefinition.setClass(org.apache.tools.ant.taskdefs.optional.script.ScriptDefBase.class);
        org.apache.tools.ant.ComponentHelper.getComponentHelper(getProject()).addDataTypeDefinition(antTypeDefinition);
    }

    public void executeScript(java.util.Map map, java.util.Map map2) {
        executeScript(map, map2, null);
    }

    public void executeScript(java.util.Map map, java.util.Map map2, org.apache.tools.ant.taskdefs.optional.script.ScriptDefBase scriptDefBase) {
        org.apache.tools.ant.util.ScriptRunnerBase scriptRunner = this.y.getScriptRunner();
        scriptRunner.addBean("attributes", map);
        scriptRunner.addBean("elements", map2);
        scriptRunner.addBean("project", getProject());
        if (scriptDefBase != null) {
            scriptRunner.addBean("self", scriptDefBase);
        }
        scriptRunner.executeScript("scriptdef_" + this.z);
    }

    public boolean isAttributeSupported(java.lang.String str) {
        return this.C.contains(str);
    }

    public void setLanguage(java.lang.String str) {
        this.y.setLanguage(str);
    }

    public void setManager(java.lang.String str) {
        this.y.setManager(str);
    }

    public void setName(java.lang.String str) {
        this.z = str;
    }

    @Override // org.apache.tools.ant.ProjectComponent
    public void setProject(org.apache.tools.ant.Project project) {
        super.setProject(project);
        this.y.setProjectComponent(this);
        this.y.setSetBeans(false);
    }

    public void setSrc(java.io.File file) {
        this.y.setSrc(file);
    }
}
