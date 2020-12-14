package pl.szymonleyk.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="room_id", referencedColumnName = "id")
    private Room room;

    public Client(){};

    public Client(String name, String surname, Room room) {
        this.name = name;
        this.surname = surname;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", room=" + room +
                '}';
    }
}
