import java.util.ArrayList;
import java.util.Scanner;

public class AssetManager {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Asset> assets = new ArrayList<>();

    // ADD ASSET
    static void addAsset() {
        System.out.println("\n===== ADD ASSET =====");

        System.out.print("Enter Asset ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Asset Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        System.out.print("Enter Condition: ");
        String condition = scanner.nextLine();

        Asset asset = new Asset(id, name, category, condition);
        assets.add(asset);

        System.out.println("\nAsset added successfully!");
    }

    // VIEW ASSETS
    static void viewAssets() {
        System.out.println("\n===== ASSET LIST =====");

        if (assets.isEmpty()) {
            System.out.println("No assets found.");
            return;
        }

        for (Asset asset : assets) {
            System.out.println("----------------------------");
            System.out.println("Asset ID  : " + asset.id);
            System.out.println("Name      : " + asset.name);
            System.out.println("Category  : " + asset.category);
            System.out.println("Condition : " + asset.condition);
            System.out.println("Holder    : " + asset.holder);
            System.out.println("Location  : " + asset.location);
            System.out.println("Status    : " + asset.status);
        }
    }

    // DISTRIBUTE ASSET
    static void distributeAsset() {
        System.out.println("\n===== DISTRIBUTE ASSET =====");

        System.out.print("Enter Asset ID: ");
        String id = scanner.nextLine();

        for (Asset asset : assets) {
            if (asset.id.equalsIgnoreCase(id)) {

                if (!asset.status.equals("Available")) {
                    System.out.println("Asset is not available.");
                    return;
                }

                System.out.print("Enter Recipient/Holder: ");
                String holder = scanner.nextLine();

                System.out.print("Enter Location/Department: ");
                String location = scanner.nextLine();

                asset.holder = holder;
                asset.location = location;
                asset.status = "Assigned";

                System.out.println("\nAsset distributed successfully!");
                return;
            }
        }

        System.out.println("Asset not found.");
    }

    // EXCHANGE ASSET
    static void exchangeAsset() {
        System.out.println("\n===== EXCHANGE ASSET =====");

        System.out.print("Enter Current Asset ID: ");
        String oldId = scanner.nextLine();

        Asset oldAsset = findAsset(oldId);

        if (oldAsset == null) {
            System.out.println("Asset not found.");
            return;
        }

        if (!oldAsset.status.equals("Assigned")) {
            System.out.println("This asset is not currently assigned.");
            return;
        }

        System.out.println("\nCurrent Asset:");
        System.out.println("Name   : " + oldAsset.name);
        System.out.println("Holder : " + oldAsset.holder);

        System.out.print("\nEnter Replacement Asset ID: ");
        String newId = scanner.nextLine();

        Asset newAsset = findAsset(newId);

        if (newAsset == null) {
            System.out.println("Replacement asset not found.");
            return;
        }

        if (!newAsset.status.equals("Available")) {
            System.out.println("Replacement asset is not available.");
            return;
        }

        newAsset.holder = oldAsset.holder;
        newAsset.location = oldAsset.location;
        newAsset.status = "Assigned";

        oldAsset.holder = "None";
        oldAsset.location = "Storage";
        oldAsset.status = "Available";

        System.out.println("\nAsset exchanged successfully!");
    }

    // RETURN ASSET
    static void returnAsset() {
        System.out.println("\n===== RETURN ASSET =====");

        System.out.print("Enter Asset ID: ");
        String id = scanner.nextLine();

        Asset asset = findAsset(id);

        if (asset == null) {
            System.out.println("Asset not found.");
            return;
        }

        if (!asset.status.equals("Assigned")) {
            System.out.println("This asset is not currently assigned.");
            return;
        }

        asset.holder = "None";
        asset.location = "Storage";
        asset.status = "Available";

        System.out.println("\nAsset returned successfully!");
    }

    // SEARCH ASSET
    static void searchAsset() {
        System.out.println("\n===== SEARCH ASSET =====");

        System.out.print("Enter Asset ID or Name: ");
        String keyword = scanner.nextLine();

        boolean found = false;

        for (Asset asset : assets) {

            if (asset.id.equalsIgnoreCase(keyword)
                    || asset.name.equalsIgnoreCase(keyword)) {

                System.out.println("\nAsset Found!");
                System.out.println("Asset ID  : " + asset.id);
                System.out.println("Name      : " + asset.name);
                System.out.println("Category  : " + asset.category);
                System.out.println("Condition : " + asset.condition);
                System.out.println("Holder    : " + asset.holder);
                System.out.println("Location  : " + asset.location);
                System.out.println("Status    : " + asset.status);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No asset found.");
        }
    }

    // FIND ASSET
    static Asset findAsset(String id) {
        for (Asset asset : assets) {
            if (asset.id.equalsIgnoreCase(id)) {
                return asset;
            }
        }

        return null;
    }
}