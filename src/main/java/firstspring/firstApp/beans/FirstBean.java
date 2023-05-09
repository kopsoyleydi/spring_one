package firstspring.firstApp.beans;

public class FirstBean {
    private String name;
    private int age;

    public FirstBean() {
        System.out.println("Without param");
    }
    public FirstBean(String name, int age){
        System.out.println("With Param");
        this.name = name;
        this.age = age;
    }
    public String getText(){
        return "This first bean: " + this.name + " " + this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
