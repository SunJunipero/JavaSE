package com.relations.example;

import java.util.HashSet;
import java.util.Set;

public class Employee extends Man{
    private String position;
    private IdCard idCard;
    private Set<Room> rooms = new HashSet<>();
    private Department department;
    private Set<PastPosition> pastPositions = new HashSet<>();

    Employee(String name, String surname, String position){
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    public void addPastPosition(PastPosition pastPosition){
        pastPositions.add(pastPosition);
    }

    public void deletePastPosition(PastPosition pastPosition){
        pastPositions.remove(pastPosition);
    }

    public Set<PastPosition> getPastPositions() {
        return pastPositions;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addRoom(Room newRoom){
        rooms.add(newRoom);
    }

    public void deleteRoom(Room currentRoom){
        rooms.remove(currentRoom);
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }
}
