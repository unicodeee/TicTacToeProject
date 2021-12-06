package src;

public class Player {
    private int age;
    private String name;
    private boolean win;

    public Player(){
        this.age =  0;
        this.name = null;
        this.win = Boolean.parseBoolean(null);
    }
    public Player(int age,String name, boolean win){
        this.age =  age;
        this.name = name;
        this.win = win;
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

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    @Override
    public String toString(){
        return " " + getAge() + " " + getName() + " " + isWin() + " " ;
    }
}
