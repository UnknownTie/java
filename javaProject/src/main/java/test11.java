import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class test11 {
	 public static void main(String[] args) throws Exception {
	    ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptEngine engine = manager.getEngineByName("JavaScript");

	    Invocable inv = (Invocable) engine;
	    //String javascriptPath = "drive:/folder/fileName.js";
	    String javascriptPath = "drive:/Login_Site.js";
	    engine.eval("load('" + javascriptPath + "')");
	    Object myCalculations = engine.get("testA");

	    int x = 10;
	    int y = 5;
	    Object addingResult = inv.invokeMethod(myCalculations, "testA");

	    System.out.println("Your addition result will be: " + addingResult);
	  }
}
