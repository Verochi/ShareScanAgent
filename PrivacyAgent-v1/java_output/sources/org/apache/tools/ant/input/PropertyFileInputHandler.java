package org.apache.tools.ant.input;

/* loaded from: classes25.dex */
public class PropertyFileInputHandler implements org.apache.tools.ant.input.InputHandler {
    public static final java.lang.String FILE_NAME_KEY = "ant.input.properties";
    public java.util.Properties a = null;

    public final synchronized void a() throws org.apache.tools.ant.BuildException {
        if (this.a == null) {
            java.lang.String property = java.lang.System.getProperty(FILE_NAME_KEY);
            if (property == null) {
                throw new org.apache.tools.ant.BuildException("System property ant.input.properties for PropertyFileInputHandler not set");
            }
            java.util.Properties properties = new java.util.Properties();
            this.a = properties;
            try {
                properties.load(new java.io.FileInputStream(property));
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("Couldn't load " + property, e);
            }
        }
    }

    @Override // org.apache.tools.ant.input.InputHandler
    public void handleInput(org.apache.tools.ant.input.InputRequest inputRequest) throws org.apache.tools.ant.BuildException {
        a();
        java.lang.Object obj = this.a.get(inputRequest.getPrompt());
        if (obj == null) {
            throw new org.apache.tools.ant.BuildException("Unable to find input for '" + inputRequest.getPrompt() + "'");
        }
        inputRequest.setInput(obj.toString());
        if (inputRequest.isInputValid()) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("Found invalid input " + obj + " for '" + inputRequest.getPrompt() + "'");
    }
}
