package com.kir138.lesson2Collection.trainingSkills.exampleWithUser;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//todo: HashMap (Как работает под катом? Хэш таблицу), Equals, HashCode
//todo: HashSet vs HashMap, ArrayList vs LinkedList
public class MapLooseExample {

    public static void main(String[] args) {
        Map<User, String> map = new HashMap<>();

        User user = new User(1L, "Igor", 29);
        User user2 = new User(2L, "Vasya", 30);

        map.put(user, "first");
        map.put(user2, "second");

        //После того, как мы положили ключ в мапу, мы в этом объекте поменяли ЗНАЧИМОЕ поле
        user.setName("Petr 1");

        //Почему null?
        System.out.println(map.get(user));
        System.out.println(map.get(user2));
    }

}

@Getter
class User {
    private Long id;
    @Setter
    private String name;
    private Integer age;

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(long l, String vasya, int i) {
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User user)) {
            return false;
        }

        return Objects.equals(getId(), user.getId())
            && Objects.equals(getName(), user.getName())
            && Objects.equals(getAge(), user.getAge());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getAge());
        return result;
    }
}
