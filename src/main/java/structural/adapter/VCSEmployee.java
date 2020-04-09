package structural.adapter;

public class VCSEmployee {

    private int id;
    private String surName;
    private String usualName;

    public VCSEmployee(int id, String surName, String usualName) {
        this.id = id;
        this.surName = surName;
        this.usualName = usualName;
    }

    public int getId() {
        return id;
    }

    public String getSurName() {
        return surName;
    }

    public String getUsualName() {
        return usualName;
    }
}
