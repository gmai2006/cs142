public class InheritantExample {

    public static void main(String[] args) {
        Animal dog = new Dog("Nina");
        Animal cat = new Cat("NeMo");
        Animal duck = new Duck("Donald");
        System.out.println(dog.sound());
        System.out.println(cat.sound());
        System.out.println(duck.sound());
        System.out.println(duck.getName());

    }
    public static abstract class Animal {

        String name;

        public Animal(String name) {
            this.name = name;
        }

        public abstract String sound();

        public String getName() { return name; }
    }

    public static class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }

        @Override
        public String sound() {
           return "Wooh wooh";
        }
    }

    public static class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }

        @Override
        public String sound() {
            return "Moew Moew";
        }
    }

    public static class Duck extends Animal {

        public Duck(String name) {
            super(name);
        }

        @Override
        public String sound() {
            return "Whack wwack";
        }
    }
}
