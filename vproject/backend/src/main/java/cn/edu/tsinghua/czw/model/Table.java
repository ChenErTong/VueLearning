package cn.edu.tsinghua.czw.model;

import java.util.List;

public class Table {
    private String[] header;
    private List<String[]> rows;

    public Table(String[] header, List<String[]> rows) {
        this.header = header;
        this.rows = rows;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public List<String[]> getRows() {
        return rows;
    }

    public void setRows(List<String[]> rows) {
        this.rows = rows;
    }
}
