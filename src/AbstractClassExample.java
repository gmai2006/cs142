public class AbstractClassExample {

    static abstract class Animal {
        public abstract String speak();
        public abstract String getName();
    }

    static abstract class Pet extends Animal {

    }

    static abstract class WildAnimal extends Animal {

    }

    static class Dog extends Animal {

        String name;

        public Dog(String name) { this.name = name; }

        @Override
        public String speak() {
            return "Woof woof";
        }

        @Override
        public String getName() { return name; }
    }
}
