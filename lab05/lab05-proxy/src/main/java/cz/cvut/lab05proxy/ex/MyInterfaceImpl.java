package cz.cvut.lab05proxy.ex;

public class MyInterfaceImpl implements MyInterface {

	public String method() {
		System.out.println(this.getClass().getSimpleName() + "#method");
		System.gc(); // something long

		return "MyImpl";
	}

	public String method(String parameter) {
		System.out.println(this.getClass().getSimpleName() + "#method(String)");
		System.gc(); // something long

		return "MyImpl(" + parameter + ")";
	}
}
