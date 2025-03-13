import java.util.Scanner;

public class Main {
    static class Task {
        int taskId;
        String taskName;
        String dueDate;

        Task(int taskId, String taskName, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.dueDate = dueDate;
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Task: " + taskName + ", Due Date: " + dueDate;
        }
    }

    static Task tasks[] = new Task[100];
    static int taskCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Task Management System ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addTask(sc);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask(sc);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter Task ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Task Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Due Date (e.g., YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        tasks[taskCount++] = new Task(id, name, dueDate);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("\n--- List of Tasks ---");
            for (int i = 0; i < taskCount; i++) {
                System.out.println(tasks[i]);
            }
        }
    }

    private static void deleteTask(Scanner scanner) {
        if (taskCount == 0) {
            System.out.println("No tasks to delete.");
            return;
        }

        System.out.print("Enter Task ID to delete: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].taskId == id) {
                for (int j = i; j < taskCount - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                tasks[--taskCount] = null;
                found = true;
                System.out.println("Task deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Task with ID " + id + " not found.");
        }
    }
}

