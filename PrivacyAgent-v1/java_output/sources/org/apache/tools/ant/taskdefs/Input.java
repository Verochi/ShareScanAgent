package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Input extends org.apache.tools.ant.Task {
    public java.lang.String u = null;
    public java.lang.String v = "";
    public java.lang.String w = null;
    public java.lang.String x = null;
    public org.apache.tools.ant.taskdefs.Input.Handler y = null;
    public boolean z;

    public class Handler extends org.apache.tools.ant.taskdefs.DefBase {
        public java.lang.String y = null;
        public org.apache.tools.ant.taskdefs.Input.HandlerType z = null;
        public java.lang.String A = null;

        public Handler() {
        }

        public final org.apache.tools.ant.input.InputHandler e() {
            org.apache.tools.ant.taskdefs.Input.HandlerType handlerType = this.z;
            if (handlerType != null) {
                return handlerType.b();
            }
            if (this.y == null) {
                java.lang.String str = this.A;
                if (str != null) {
                    return (org.apache.tools.ant.input.InputHandler) org.apache.tools.ant.util.ClasspathUtils.newInstance(str, createLoader(), org.apache.tools.ant.input.InputHandler.class);
                }
                throw new org.apache.tools.ant.BuildException("Must specify refid, classname or type");
            }
            try {
                return (org.apache.tools.ant.input.InputHandler) getProject().getReference(this.y);
            } catch (java.lang.ClassCastException e) {
                throw new org.apache.tools.ant.BuildException(this.y + " does not denote an InputHandler", e);
            }
        }

        public java.lang.String getClassname() {
            return this.A;
        }

        public java.lang.String getRefid() {
            return this.y;
        }

        public org.apache.tools.ant.taskdefs.Input.HandlerType getType() {
            return this.z;
        }

        public void setClassname(java.lang.String str) {
            this.A = str;
        }

        public void setRefid(java.lang.String str) {
            this.y = str;
        }

        public void setType(org.apache.tools.ant.taskdefs.Input.HandlerType handlerType) {
            this.z = handlerType;
        }
    }

    public static class HandlerType extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String[] b = {"default", "propertyfile", "greedy", "secure"};
        public static final org.apache.tools.ant.input.InputHandler[] c = {new org.apache.tools.ant.input.DefaultInputHandler(), new org.apache.tools.ant.input.PropertyFileInputHandler(), new org.apache.tools.ant.input.GreedyInputHandler(), new org.apache.tools.ant.input.SecureInputHandler()};

        public final org.apache.tools.ant.input.InputHandler b() {
            return c[getIndex()];
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return b;
        }
    }

    public void addText(java.lang.String str) {
        if (this.z && "".equals(str.trim())) {
            return;
        }
        this.v += getProject().replaceProperties(str);
    }

    public org.apache.tools.ant.taskdefs.Input.Handler createHandler() {
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("Cannot define > 1 nested input handler");
        }
        org.apache.tools.ant.taskdefs.Input.Handler handler = new org.apache.tools.ant.taskdefs.Input.Handler();
        this.y = handler;
        return handler;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.lang.String str;
        if (this.w != null && getProject().getProperty(this.w) != null) {
            log("skipping " + getTaskName() + " as property " + this.w + " has already been set.");
            return;
        }
        java.lang.String str2 = this.u;
        org.apache.tools.ant.input.InputRequest multipleChoiceInputRequest = str2 != null ? new org.apache.tools.ant.input.MultipleChoiceInputRequest(this.v, org.apache.tools.ant.util.StringUtils.split(str2, 44)) : new org.apache.tools.ant.input.InputRequest(this.v);
        multipleChoiceInputRequest.setDefaultValue(this.x);
        org.apache.tools.ant.taskdefs.Input.Handler handler = this.y;
        (handler == null ? getProject().getInputHandler() : handler.e()).handleInput(multipleChoiceInputRequest);
        java.lang.String input = multipleChoiceInputRequest.getInput();
        if ((input == null || input.trim().length() == 0) && (str = this.x) != null) {
            input = str;
        }
        if (this.w == null || input == null) {
            return;
        }
        getProject().setNewProperty(this.w, input);
    }

    public void setAddproperty(java.lang.String str) {
        this.w = str;
    }

    public void setDefaultvalue(java.lang.String str) {
        this.x = str;
    }

    public void setMessage(java.lang.String str) {
        this.v = str;
        this.z = true;
    }

    public void setValidargs(java.lang.String str) {
        this.u = str;
    }
}
