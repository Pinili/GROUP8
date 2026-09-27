public class Asset {
    String id;
    String name;
    String category;
    String condition;
    String holder;
    String location;
    String status;

    public Asset(String id, String name, String category, String condition) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.condition = condition;
        this.holder = "None";
        this.location = "Storage";
        this.status = "Available";
    }
}