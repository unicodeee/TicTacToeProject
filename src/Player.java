package src;

import java.util.Objects;

public class Player implements Comparable<Player>{
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age && name.equals(player.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString(){
        return " " + getAge() + " " + getName() + " " ;
    }

    @Override
    public int compareTo(Player s) {
        if (getName().equals(s.getName()))
            return getAge() - s.getAge();
        return getName().compareTo(s.getName());
    }
}
