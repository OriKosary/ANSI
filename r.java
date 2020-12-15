package AssistantStep1;

import javax.script.ScriptException;

public class r {
	 public static String drawDigitsFromString(String strValue){
         String str = strValue.trim();
         String digits="";
         for (int i = 0; i < str.length(); i++) {
             char chrs = str.charAt(i);              
             if (Character.isDigit(chrs))
                 digits = digits+chrs;
         }
         return digits;
     }
	public static void main(String[] args) throws ScriptException {
		//Reminder r = new Reminder();
		//r.start();
		Calculator calc = new Calculator();
		calc.isExRight();
//		System.out.println(drawDigitsFromString("xx123xx"));
	}
}