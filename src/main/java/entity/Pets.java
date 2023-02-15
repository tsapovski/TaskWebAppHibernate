package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name="pets", schema = "animals")
public class Pets {
    private long id;
    private String typePet;
    private String name;
    private Integer age;
    private String color;
    private byte ownerStatus;

    public Pets() {
    }

    public Pets(String typePet, String name, Integer age, String color, byte ownerStatus) {
        this.typePet = typePet;
        this.name = name;
        this.age = age;
        this.color = color;
        this.ownerStatus = ownerStatus;
    }

    public Pets(long id, String typePet, String name, Integer age, String color, byte ownerStatus) {
        this.id = id;
        this.typePet = typePet;
        this.name = name;
        this.age = age;
        this.color = color;
        this.ownerStatus = ownerStatus;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "typePet", nullable = false, length = 20)
    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "color", nullable = false, length = 20)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "ownerStatus", nullable = false)
    public byte getOwnerStatus() {
        return ownerStatus;
    }

    public void setOwnerStatus(byte ownerStatus) {
        this.ownerStatus = ownerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pets pets = (Pets) o;
        return id == pets.id && ownerStatus == pets.ownerStatus && Objects.equals(typePet, pets.typePet) && Objects.equals(name, pets.name) && Objects.equals(age, pets.age) && Objects.equals(color, pets.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typePet, name, age, color, ownerStatus);
    }
}
