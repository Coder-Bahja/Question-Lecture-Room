import java.util.Scanner;

class LectureRoom {
    private int students;
    private boolean[] lights;

    public LectureRoom() {
        students = 0;
        lights = new boolean[3]; // Represents lights 1, 2, 3, all initially off.
    }

    public void addStudents(int count) {
        students += count;
    }

    public void removeStudents(int count) {
        students = Math.max(0, students - count);  // Ensure the number of students doesn't go below 0.
    }

    public void turnOnLight(int lightNumber) {
        if (lightNumber >= 1 && lightNumber <= 3) {
            lights[lightNumber - 1] = true;
        }
    }

    public void turnOffLight(int lightNumber) {
        if (lightNumber >= 1 && lightNumber <= 3) {
            lights[lightNumber - 1] = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder status = new StringBuilder("Students: " + students + "\nLights Status: ");
        for (int i = 0; i < lights.length; i++) {
            status.append("Light ").append(i + 1).append(": ").append(lights[i] ? "On" : "Off");
            if (i < lights.length - 1) status.append(", ");
        }
        return status.toString();
    }
}

public class Main {

    public static void main(String[] args) {
        LectureRoom room = new LectureRoom();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLecture Room Control Menu:");
            System.out.println("W: Add Students");
            System.out.println("X: Remove Students");
            System.out.println("Y: Turn On Light");
            System.out.println("Z: Turn Off Light");
            System.out.println("Q: Quit");
            System.out.println("Other: Display Room Status");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "W":
                    System.out.print("Enter number of students to add: ");
                    int addCount = scanner.nextInt();
                    room.addStudents(addCount);
                    System.out.println(addCount + " students added.");
                    scanner.nextLine();  // Clear the newline
                    break;

                case "X":
                    System.out.print("Enter number of students to remove: ");
                    int removeCount = scanner.nextInt();
                    room.removeStudents(removeCount);
                    System.out.println(removeCount + " students removed.");
                    scanner.nextLine();  // Clear the newline
                    break;

                case "Y":
                    System.out.print("Enter light number to turn on (1-3): ");
                    int lightOn = scanner.nextInt();
                    if (lightOn >= 1 && lightOn <= 3) {
                        room.turnOnLight(lightOn);
                        System.out.println("Light " + lightOn + " turned on.");
                    } else {
                        System.out.println("Invalid light number. Please enter a number between 1 and 3.");
                    }
                    scanner.nextLine();  // Clear the newline
                    break;

                case "Z":
                    System.out.print("Enter light number to turn off (1-3): ");
                    int lightOff = scanner.nextInt();
                    if (lightOff >= 1 && lightOff <= 3) {
                        room.turnOffLight(lightOff);
                        System.out.println("Light " + lightOff + " turned off.");
                    } else {
                        System.out.println("Invalid light number. Please enter a number between 1 and 3.");
                    }
                    scanner.nextLine();  // Clear the newline
                    break;

                case "Q":
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println(room);
            }
        }
    }
}