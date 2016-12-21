package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class SomeClass {
  public String publicField = "public field";
  private String privateField = "private field";
  protected String protectedField = "protected field";
  String defaultField = "default field";

  public String publicMethod() {
    return "Public Method";
  }

  private String privateMethod() {
    return "Private Method";
  }

 protected String protectedMethod() {
    return "Protected Method";
  }

  String defaultMethod() {
    return "Default Method";
  }

  @Override
  public String toString() {
    String str = "";
    str += "A class accessing its own things\n";
    str += str.replaceAll(".", "=");
    str += "private field:    " + this.privateField + "\n";
    str += "private method:   " + this.privateMethod() + "\n";
    str += "public field:     " + this.publicField + "\n";
    str += "public method:    " + this.publicMethod() + "\n";
    str += "protected field:  " + this.protectedField + "\n";
    str += "protected method: " + this.protectedMethod() + "\n";
    str += "default field:    " + this.defaultField + "\n";
    str += "default method:   " + this.defaultMethod() + "\n";

    InnerClass innerClass = new InnerClass();
    str += "\nA class accessing the inner class\n";
    str += "A class accessing the inner class\n".replaceAll(".", "=");
    str += "private field:    " + innerClass.privateInnerField + "\n";
    str += "private method:   " + innerClass.privateInnerMethod() + "\n";
    str += "public field:     " + innerClass.publicInnerField + "\n";
    str += "public method:    " + innerClass.publicInnerMethod() + "\n";
    str += "protected field:  " + innerClass.protectedInnerField + "\n";
    str += "protected method: " + innerClass.protectedInnerMethod() + "\n";
    str += "default field:    " + innerClass.defaultInnerField + "\n";
    str += "default method:   " + innerClass.defaultInnerMethod() + "\n";
    return str;
  }

  public class InnerClass {

    public String publicInnerField = "public field";
    private String privateInnerField = "private field";
    protected String protectedInnerField = "protected field";
    String defaultInnerField = "default field";

    public String publicInnerMethod() {
      return "SomeClass Public Method";
    }

    private String privateInnerMethod() {
      return "SomeClass Private Method";
    }

    protected String protectedInnerMethod() {
      return "SomeClass Protected Method";
    }

    String defaultInnerMethod() {
      return "SomeClass Default Method";
    }
    @Override
    public String toString() {
      String str = "";
      str += "An inner class accessing the outer class\n";
      str += str.replaceAll(".", "=");
      str += "private field:    " + privateField + "\n";
      str += "private method:   " + privateMethod() + "\n";
      str += "public field:     " + publicField + "\n";
      str += "public method:    " + publicMethod() + "\n";
      str += "protected field:  " + protectedField + "\n";
      str += "protected method: " + protectedMethod() + "\n";
      str += "default field:    " + defaultField + "\n";
      str += "default method:   " + defaultMethod() + "\n";
      return str;
    }
  }
}
