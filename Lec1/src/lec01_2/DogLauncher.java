package lec01_2;

public class DogLauncher {
    public static void main(String[] args) {
        Dog d = new Dog(51);
        //Dog.makeNoise();
        d.makeNoise();
        Dog[] dogs = new Dog [2];
        dogs[0] = new Dog(5);
        dogs[1] = new Dog(26);
        for(int i = 0; i < dogs.length; i++ ){
            dogs[i].makeNoise();
        }
        Dog bigger = d.maxDog(dogs[1]);
        bigger.makeNoise();
        //System.out.println(d.binomen);
        System.out.println(Dog.binomen);

    }
}
