package structural.adapter;

public class EmployeeFromMyLegacyApp{

    private String id;
    private String fn;
    private String ln;

    public EmployeeFromMyLegacyApp(String id, String fn, String ln) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
    }


    public String getId() {
        return id;
    }

    public String getFn() {
        return fn;
    }

    public String getLn() {
        return ln;
    }
}
