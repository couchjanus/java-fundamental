package ua.con.funny;

public enum Country {
	//	CANADA("CAD"), POLAND("PLN"), GERMANY("EUR"), LAOPAPAS, ZIMKABU();
    
	// Теперь нам нужно реализовать этот метод во всех значениях перечисления

	CANADA("CAD") {
	    @Override
	    void sayHello() {
	        System.out.println("Hello");
	    }
	},
	POLAND("PLN") {
	    @Override
	    void sayHello() {
	        System.out.println("Cześć");
	    }
	},
	GERMANY("EUR") {
	    @Override
	    void sayHello() {
	        System.out.println("Hallo");
	    }
	},
	LAOPAPAS {
	    @Override
	    void sayHello() {
	        System.out.println("Lapapioooo");
	    }
	},
	ZIMKABU() {
	    @Override
	    void sayHello() {
	        System.out.println("Shakalaka");
	    }
	};

	// добавим абстрактный метод void sayHello()
	abstract void sayHello();
	
    String currency;
 
    Country(String currency) {
        this.currency = currency;
    }
    
    Country() {
    }
    
}
