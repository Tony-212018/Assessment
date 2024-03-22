package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.*;

class Employee {
    private int empId;
    private String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Employee employee = (Employee) obj;
        return empId == employee.empId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId);
    }
}

class Address {
    private int houseNo;
    private String street;
    private String city;
    private int pincode;

    public Address(int houseNo, String street, String city, int pincode) {
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return houseNo + "," + street + "," + city + "," + pincode;
    }
}

public class Main {
    public static void main(String[] args) {

        Map<Employee, Address> employeeAddressMap = new HashMap<>();


        Employee emp1 = new Employee(1, "John");
        Employee emp2 = new Employee(2, "Alice");
        Employee emp3 = new Employee(3, "Bob");

        employeeAddressMap.put(emp1, new Address(101, "Main St", "New York", 12345));
        employeeAddressMap.put(emp2, new Address(202, "Broad St", "Los Angeles", 67890));
        employeeAddressMap.put(emp3, new Address(303, "Oak St", "Chicago", 45678));

// passing emp2
        getAddress(employeeAddressMap, emp2);


        Set<String> distinctCities = new TreeSet<>();
        for (Address address : employeeAddressMap.values()) {
            distinctCities.add(address.toString());
        }
        System.out.println("Distinct Cities in Ascending Order: " + distinctCities);
    }


    public static void getAddress(Map<Employee, Address> map, Employee employee) {
        Address address = map.get(employee);
        if (address != null) {
            System.out.println("Employee's Address: " + address);
        } else {
            System.out.println("Employee does not exist.");
        }
    }
}
