import java.util.Scanner; // импорт сканнера

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 70;
        int p = 10;
        int f = 5;
        int m = k+p; 
        System.out.println(m); 
        m = m-30;
        System.out.println(m);
        int s = m*f;
        System.out.println (s);
        s =s/f;
        System.out.println(s);
        
        m+= 7;
        System.out.print (m);
        
        int n = 2;
        n++;
        System.out.print (n);
        
        n--;
        System.out.println (n);
        
        n = 2;
        k = 2;
        int a = 2 * n++; //теперь значение a равно 4, а n равно 3
        int b = 2 * ++k; //теперь значение b равно 6, а k равно 3
        System.out.println(a);
        System.out.println(n);
        System.out.println(b);
        System.out.println(k);
        
        n = 2;
        k = 2;
        a = 2 * n--; //теперь значение a равно 4, а n равно 1
        b = 2 * --k; //теперь значение b равно 2, а k равно 1
        System.out.println(a);
        System.out.println(n);
        System.out.println(b);
        System.out.println(k);
        
        a = 8;
        b = 7;
        int c = a + 5 * ++b;      
        System.out.println(c);  // 48
        
        a = 8;
        b = 7;
        c = (a + 5) * ++b;    
        System.out.println(c);  // 104
        
        double d = 2.0 - 1.1;
        System.out.println(d);
        
        char ch=102; // символ 'f'
        System.out.println(ch);
        
        String hello = "Hello...";
        System.out.println(hello);
        
        // Создание строки с помощью конструктора
        String s1 = new String("Who let the dogs out?");

        // С помощью двойных кавычек (» «).
        String s2 = "Who who who who!";
        
        String text = "Hello \nworld";
        System.out.println(text);
        
        text = "Вот мысль, которой весь я предан,\n"+
                "Итог всего, что ум скопил.\n"+
                "Лишь тот, кем бой за жизнь изведан,\n"+
                "Жизнь и свободу заслужил.";
        System.out.println(text);
        
        text = """
                Вот мысль, которой весь я предан,
                Итог всего, что ум скопил.
                Лишь тот, кем бой за жизнь изведан,
                Жизнь и свободу заслужил.
                """;
        System.out.println(text);
        
        String morning1 ="доброе";
        String morning2 ="не доброе, потому что сегодня понедельник";

        System.out.println("Сегодня утро " + morning1);
        System.out.println("Сегодня утро " + morning2);

        String s3 = s1 + s2;

        // В Java нет перегрузки операторов! Оператор + определен только для строк, вы никогда не увидите его с другими объектами, только с примитивами.
        int num = 5;
        String s11 = "I have " + num + " cookies";
        // Заметьте, что кавычки с примитивами не используются.
        
        int x=5;
        int y=6;
        System.out.println("x=" + x + "; y=" + y);
        System.out.printf("x=%d; y=%d \n", x, y);
        String name = "Tom";
        int age = 30;
        float height = 1.7f;
          
        System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);
        
        System.out.printf("Sqrt of age: %.2f \n", Math.sqrt(age));
        
        Scanner in = new Scanner(System.in); // объявить сканер
        
        System.out.print("Input a number: ");
        int num1 = in.nextInt(); // считать число с консоли
          
        System.out.printf("Your number: %d \n", num1);
        //in.close();
                
        System.out.print("Input name: ");
        name = in.nextLine();
        System.out.print("Input age: ");
        age = in.nextInt();
        System.out.print("Input height: ");
        height = in.nextFloat();
        System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);
        //in.close();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите любое слово или фразу: ");
        String phrase1 = sc.next();
        System.out.println(phrase1);
        
        var xv = 10;
        System.out.println(xv);  // 10
        
        final int LIMIT = 5;
        System.out.println(LIMIT);  // 5
        
        final double Pi = 3.1415926536;
        // Константа Pi с типом данных для чисел c плавающей точкой
        double lengthl = 2*Pi*10;
        double length2 = 2*Pi*25;
        System.out.println ("Периметр круга при радиусе 10 см равен " + lengthl + ", а при радиусе 25 см равен " + length2);
        
        boolean boo = false;
        boo = true;

        boolean toBe = false;
        boo = toBe || !toBe;
        if (boo) {
            System.out.println(toBe);
        }
        
//        int children = 0;
//        b = children;  // Не будет работать, требуется boolean, а найден int
//        if (children) {  // Не будет работать, требуется boolean, а найден int
//            // Не будет работать, требуется boolean, а найден int
//        }
        
        int ab = 10;
        int bb = 4;
        boolean cb = ab == bb;         // false
        boolean db = ab == 10;       // true
        
        String as = new String("Wow");
        String bs = new String("Wow");
        String sameA = as;

        boolean r1 = as == bs;      // Ложь, так как a и b не один и тот же объект
        boolean r2 = as.equals(bs); // Истина, так как a и b логически равны
        boolean r3 = as == sameA;  // Истина, так как a и sameA действительно один и тот же объект
        
        int number = 45; // 1001 Значение, которое надо зашифровать - в двоичной форме 101101
        int key = 102; //Ключ шифрования - в двоичной системе 1100110
        int encrypt = number ^ key; //Результатом будет число 1001011 или 75
        System.out.println("Зашифрованное число: " +encrypt);
         
        int decrypt = encrypt ^ key; // Результатом будет исходное число 45
        System.out.println("Расшифрованное число: " + decrypt);
        

        a = 4;
        byte bt = (byte)a;  // преобразование типов: от типа int к типу byte
        System.out.println(bt); // 4
        
        bt = 7;
        int dt = bt;  // преобразование от byte к int
        
        a = 2147483647;
        float bf = a;            // от типа int к типу float
        System.out.println(bf);  // 2.14748365E9
        
        long al = 4;
        int bl = (int) al;
        
        int ai = 5;
        bt = (byte) ai;
        System.out.println(bt);      // 5
        
        double ad = 56.9898;
        int bd = (int)ad;
        
        int dc = 'a' + 5;
        System.out.println(dc);  // 102
        
        int num6 = 6;
        int num4 = 4;
        if(num6>num4){
            System.out.println("Первое число больше второго");
        }
        else{
            System.out.println("Первое число меньше второго");
        }
        
        num6 = 6;
        int num2 = 8;
        if(num6>num2){
            System.out.println("Первое число больше второго");
        }
        else if(num6<num2){
            System.out.println("Первое число меньше второго");
        }
        else{
            System.out.println("Числа равны");
        }
        // Также мы можем соединить сразу несколько условий, используя логические операторы:

        num2 = 6;
        if(num6 > num2 && num6>7){
            System.out.println("Первое число больше второго и больше 7");
        }
        
        int ar = 4;
        int result = ar == 4 ? 1 : 8;
        // result будет равен 1
        // Или обычная форма записи:
        
        if (ar == 4) {
            result = 1;
        } else {
            result = 8;
        }
        
        int nums = 8;
        switch(nums){
                     
            case 1: 
                System.out.println("число равно 1");
                break;
            case 8: 
                System.out.println("число равно 8");
                num++;
                break;
            case 9: 
                System.out.println("число равно 9");
                break;
            default:
                System.out.println("число не равно 1, 8, 9");
        }
        
        
        int numb = 3;
        int output = 0;
        switch(numb){
             
            case 1: 
                output = 3;
                break;
            case 2: 
            case 3: 
            case 4: 
                output = 6;
                break;
            case 5: 
                output = 12;
                break;
            default:
                output = 24;
        }
        System.out.println(output);
        
        int x1=3;
        int y1=2;
        int z = x1<y1? (x1+y1) : (x1-y1);
        System.out.println(z);
        


        
	}

}
