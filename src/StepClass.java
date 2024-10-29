public class StepClass {
    public static void main(String[] args) {
        Animal[] animals = { new Dog("Nina", 20, 4),
                new Cat("Cat", 20, 4),
                new Duck("Duck", 20, 2)
        };
        for (Animal animal: animals) {
            System.out.println(animal.getName() + " " + animal.speak() );

            animal.age = 55;

            if (animal instanceof Pet)  {
                System.out.println(((Pet)animal).showAffection() + " " + ((Pet)animal).x1() + " " + ((Pet)animal).x2());
            }
        }
    }

    static abstract class Animal {
        private int lifeSpan;
        private String name;

        public int age;

        public Animal(String name, int lifeSpan) {
            this.name = name;
            this.lifeSpan = lifeSpan;
        }

        public int getLifeSpan() {
            return lifeSpan;
        }

        public String getName() {
            return name;
        }

        public abstract String speak();
    }

    static abstract class Pet extends Animal {
        private int legs;

        public Pet(String name, int lifeSpan) {
            super(name, lifeSpan);
        }

        public Pet(String name, int lifeSpan, int legs) {
            super(name, lifeSpan);
            this.legs = legs;
        }

        public int x1(){
            return this.legs;
        }

        public String x2(){
            return this.getName();
        }

        public abstract String showAffection();
    }

    static class Dog extends Pet {
        public Dog(String name, int lifeSpan, int legs) {
            super(name, lifeSpan, legs);
        }

        @Override
        public String speak() {
            return "Wooh wooh";
        }

        @Override
        public String showAffection() {
            return "This is Dog";
        }
    }

    static class Cat extends Pet {
        public Cat(String name, int lifeSpan, int legs) {
            super(name, lifeSpan, legs);
        }

        @Override
        public String speak() {
            return "Meow meow";
        }

        @Override
        public String showAffection() {
            return "This is " + super.getName();
        }
    }

    static class Duck extends Pet {
        public Duck(String name, int lifeSpan, int legs) {
            super(name, lifeSpan, legs);
        }

        @Override
        public String speak() {
            return "Quack Quack";
        }

        @Override
        public String showAffection() {
            return "This is Duck";
        }
    }


}
