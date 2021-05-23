package jm.task.core.jdbc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Integer age;

    public User(Long id, String name, String lastName, Integer age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User() {

    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - id: "+ id + ", name: " + name+ ", lastName: " + lastName + ", age: "+ age;
    }
}
