
public class OuterClass {
	String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    private int num = 2018;  
     
    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
        
        public int getNum() {
            System.out.println("Это метод getnum внутреннего класса");
            return num;
         }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
            
        }
    }
    
    public void test() {
        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();
        OuterClass outerObject = new OuterClass();
        staticNestedObject.accessMembers(outerObject);
	}
}
