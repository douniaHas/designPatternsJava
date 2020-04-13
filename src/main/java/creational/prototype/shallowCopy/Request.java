package creational.prototype.shallowCopy;

import java.util.List;

public class Request implements Cloneable {

    private String sql;
    private List<String> statement;
    private Report report;

    public Request(String sql, List<String> statement, Report report) {
        this.sql = sql;
        this.statement = statement;
        this.report = report;
    }

    public String getSql() {
        return sql;
    }

    public List<String> getStatement() {
        return statement;
    }

    public Report getReport() {
        return report;
    }

    @Override
    public Request clone() throws CloneNotSupportedException {
        return (Request) super.clone();
    }

}
