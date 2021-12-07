package src;

public class Player {
    private int age;
    private String name;

    public Player(){
        this.age =  0;
        this.name = null;
    }
    public Player(int age,String name){
        this.age =  age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return " " + getAge() + " " + getName() + " " ;
    }
}
