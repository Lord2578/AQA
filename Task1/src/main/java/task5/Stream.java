package task5;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        int count = 10;
        if(args.length > 0) {
            count = Integer.parseInt(args[0]);
        }
        // a) Генерація 10 випадкових об'єктів Person
        List<Person> people = generateRandomPeople(count);

        // Вивід згенерованих об'єктів
        System.out.println("--- Згенеровані Об'єкти ---");
        people.forEach(System.out::println);

        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge)
                        .thenComparing(Person::getName))
                .collect(Collectors.toList());

        // Вивід відсортованих об'єктів
        System.out.println("\n--- Відсортовані Об'єкти ---");
        sortedPeople.forEach(System.out::println);

        // c) Фільтрація за двома умовами: age > 25 та married == true
        List<Person> filteredPeople = sortedPeople.stream()
                .filter(person -> person.getAge() > 25)
                .filter(Person::isMarried)
                .collect(Collectors.toList());

        // Вивід відфільтрованих об'єктів
        System.out.println("\n--- Відфільтровані Об'єкти (age > 25 та married == true) ---");
        filteredPeople.forEach(System.out::println);

        // d) Збірка у список
        List<Map<String, Object>> mainFieldsList = filteredPeople.stream()
                .map(person -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", person.getName());
                    map.put("age", person.getAge());
                    return map;
                })
                .toList();

        // Вивід зібраних основних полів
        System.out.println("\n--- Зібрані Основні Поля (name та age) ---");
        mainFieldsList.forEach(System.out::println);
    }

    // Метод для генерації випадкових осіб
    private static List<Person> generateRandomPeople(int count) {
        List<Person> people = new ArrayList<>();
        String[] names = {"John", "Jane", "Mark", "Lucy", "Michael", "Emma", "Robert", "Olivia", "David", "Sophia"};
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"};
        String[] states = {"NY", "CA", "IL", "TX", "AZ"};

        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)];
            int age = 20 + random.nextInt(30); // Вік від 20 до 49
            boolean married = random.nextBoolean();
            String city = cities[random.nextInt(cities.length)];
            String state = states[random.nextInt(states.length)];

            Person.Address address = new Person.Address(city, state);
            Person person = new Person(name, age, married, address);
            people.add(person);
        }

        return people;
    }
}
