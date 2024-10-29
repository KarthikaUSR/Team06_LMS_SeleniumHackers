package comPages;

public class Program {
	private String name;
    private String description;
    private String status;

    public Program(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }

}
