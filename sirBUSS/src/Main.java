import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            Menu.showMenu();

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    AssetManager.addAsset();
                    break;

                case "2":
                    AssetManager.viewAssets();
                    break;

                case "3":
                    AssetManager.distributeAsset();
                    break;

                case "4":
                    AssetManager.exchangeAsset();
                    break;

                case "5":
                    AssetManager.returnAsset();
                    break;

                case "6":
                    AssetManager.searchAsset();
                    break;

                case "7":
                    System.out.println("\nThank you for using the system!");
                    scanner.close();
                    AssetManager.scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}