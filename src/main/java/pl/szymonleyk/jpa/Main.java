package pl.szymonleyk.jpa;

import pl.szymonleyk.jpa.entities.Client;
import pl.szymonleyk.jpa.entities.Room;
import pl.szymonleyk.jpa.services.ClientService;
import pl.szymonleyk.jpa.services.RoomService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RoomService roomService = new RoomService();
        Room room;
//        dodanie pokoju
//        room = new Room("Room 51");
//        roomService.add(room);

        // pobranie
        room = roomService.find(1);
        System.out.println(room);

        // update 1
        roomService.update(1, "Room 444");

        // update 2
//        room = new Room(123, "Room 123");
//        roomService.updateByMerge(room);

        // remove
//        roomService.remove(4);

        // poszukaj wszystkie pokoje
        List<Room> rooms = roomService.findAll();

        System.out.println(rooms);

        // poszukaj po nazwie
        rooms = roomService.findByName("Room 123");
        System.out.println(rooms);

        ClientService clientService = new ClientService();
        Client client;
        // dodaj klienta
//        room = roomService.find(1);
//        client = new Client("Marek", "Nowak", room);
//        clientService.add(client);

        System.out.println(clientService.findAll());

        room = new Room("Room 000");
        client = new Client("Czarek", "Kowalski", room);
        clientService.add(client);
    }
}
