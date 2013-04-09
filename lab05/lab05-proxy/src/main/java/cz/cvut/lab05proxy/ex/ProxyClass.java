package cz.cvut.lab05proxy.ex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ProxyClass implements InvocationHandler {

	private Object delegate;

	public ProxyClass(Object o) {
		delegate = o;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		Object result = null;
		Long timer = System.currentTimeMillis();
		try {
			// Do something before the method is called ...

			System.out.println(this.getClass().getSimpleName() + ": #Calling "
					+ printMethood(delegate, m, args));

                        
                    if (m.getName().equals("method")) {
                        if (!Arrays.asList(m.getParameterTypes()).isEmpty()) {
                            if (args[0].equals("Grrr")) {
                                throw new Exception("Illegal arg: Grrr");
                            }
                        }
                    }
                        
			result = m.invoke(delegate, args);

		} catch (InvocationTargetException e) {
		} catch (Exception e) {
			System.out.println("#Proxy method for " + printMethood(delegate, m, args)
					+ " ends with Exception");
			throw e;
		} finally {
			// Do something after the method is called ...
			System.out.println(this.getClass().getSimpleName() + ": #Call " + printMethood(delegate, m, args)
					+ " over. It took (" + (System.currentTimeMillis() - timer) + " ms)");
		}
		return result;
	}

	private String printMethood(Object proxy, Method m, Object[] args) {
		return delegate.getClass().getSimpleName() + "#" + m.getName() + "(" + printArray(args) + ")";
	}

	private String printArray(Object[] args) {
		if (args == null) {
			return "";
		} else {
			String out = "";
			for (int i = 0; i < args.length; i++) {
				out += args[i].getClass().getSimpleName() + ",";
			}
			return out.substring(0, out.length() - 1);
		}
	}
}
