package ua.con.funny;

//public enum MyEnum {
//    WINTER,
//    SUMMER,
//    SPRING,
//    FALL;
//}

import ua.con.funny.classes.Book;
import ua.con.funny.classes.Type;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// 
        System.out.println(Seasons.WINTER);
        System.out.println(Seasons.SUMMER);
        System.out.println(Seasons.SPRING);
        System.out.println(Seasons.FALL);
        
        Day current = Day.MONDAY;
        System.out.println(current);    // MONDAY
        
        // создали объект типа enum:
        Seasons arg = Seasons.FALL;
        // оператор switch, который печатает сообщение в зависимости от времени года
        // в case мы не должны писать полный путь (Seasons.FALL), а только название объекта - например, FALL: case WINTER:
        switch (arg)
        {
                case WINTER:
                System.out.println("It's winter! Christmas time!"); break;
                case SUMMER:
                    System.out.println("It's summer! Let's go to the beach!"); break;
                case SPRING:
                    System.out.println("It's spring! Easter is coming!"); break;
                case FALL:
                    System.out.println("It's fall! Helloween is coming!"); break;
        }
        
        Book b1 = new Book("War and Peace", "L. Tolstoy", Type.BELLETRE);
        System.out.printf("Book '%s'\t has a type %s\n", b1.name, b1.bookType);

        // С помощью конструкции switch..case можно проверить принадлежность значения bookType определенной константе перечисления.
         
        switch(b1.bookType){
            case BELLETRE:
                System.out.println("Belletre");
                break;
            case SCIENCE:
                System.out.println("Science");
                break;
            case SCIENCE_FICTION:
                System.out.println("Science fiction");
                break;
            case PHANTASY:
                System.out.println("Phantasy");
                break;
        }
        
        Type[] types = Type.values();
        for (Type s : types) { System.out.println(s); }
        
        System.out.println(Type.BELLETRE.ordinal());    // 1
        System.out.println(Color.RED.name()); //output: RED
        System.out.println(Color.RED.ordinal()); //output: 0
        
        boolean isEqualToItself = Color.RED.equals(Color.RED);
        boolean isEqualToDifferentColor = Color.RED.equals(Color.GREEN);
         
        System.out.println(Color.RED.equals(Color.RED)); //output: true
        System.out.println(Color.RED.equals(Color.GREEN));//output: false
        
        int hashOfRed = Color.RED.hashCode();
        int hashOfGreen = Color.GREEN.hashCode();
         
        System.out.println(hashOfRed); //output would be different every time: 366712642
        System.out.println(hashOfGreen); //output would be different every time: 1829164700

        Color[] colors = Color.values();
        System.out.println(Arrays.toString(colors)); //output: [RED, GREEN, BLUE]

        String red = Color.RED.toString();
        System.out.println(red); //output: RED
        
        System.out.println(Color.valueOf("RED").ordinal()); //output: 0

        // Если же такого значения в перечислении нет, то мы получим IllegalStateException

        Color.valueOf("BLACK"); //output: java.lang.IllegalArgumentException: No enum constant Color.BLACK
        
        System.out.println(Enum.valueOf(Color.class, "BLUE").ordinal()); //output: 2
        
        System.out.println(Color.GREEN.compareTo(Color.RED)); //output: 1
        System.out.println(Color.GREEN.compareTo(Color.GREEN)); //output: 0
        System.out.println(Color.GREEN.compareTo(Color.BLUE)); //output: -1
        System.out.println(Color.RED.compareTo(Color.BLUE)); //output: -2
        
        
        System.out.println(XColor.RED.getCode());        // #FF0000
        System.out.println(XColor.GREEN.getCode());      // #00FF00
        
        Operation op = Operation.SUM;
        System.out.println(op.action(10, 4));   // 14
        op = Operation.MULTIPLY;
        System.out.println(op.action(6, 4));    // 24
        
        for (Country country : Country.values()) {
            System.out.println(country + ", " + country.currency);
        }
        
        for (Country country : Country.values()) {
            System.out.print(country + " ");
            country.sayHello();
        }
        
        Set<Country> countries = EnumSet.allOf(Country.class);
        System.out.println(countries); //output: [CANADA, POLAND, GERMANY, LAOPAPAS, ZIMKABU]
        
        EnumSet.of(Country.GERMANY);
        EnumSet.of(Country.CANADA, Country.GERMANY);
        
        EnumSet<Country> range = EnumSet.range(Country.CANADA, Country.GERMANY);
        System.out.println(range); //output: [CANADA, POLAND, GERMANY]
        
        EnumSet<Country> canadaSet = EnumSet.of(Country.CANADA);
        Set<Country> germanySet = Set.of(Country.GERMANY);
        EnumSet<Country> canadaSetCopy = EnumSet.copyOf(canadaSet);
        EnumSet<Country> germanySetCopy = EnumSet.copyOf(germanySet);

        EnumSet<Country> initialSet = EnumSet.of(Country.CANADA, Country.POLAND, Country.GERMANY);
        EnumSet<Country> complement = EnumSet.complementOf(initialSet);
        System.out.println(complement); //output: [LAOPAPAS, ZIMKABU]
        
        EnumSet<Country> noneOf = EnumSet.noneOf(Country.class);
        System.out.println(noneOf); //output: []


       
        
	}

}
