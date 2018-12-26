package braincohort.pku.edu.website.services;

import java.util.List;

public class DataManager<T> {
    private List<T> data;

    public DataManager(List<T> data) {
        this.data = data;
    }

    public List<T> getDataByPage(int page) {
        int start = 6 * page;
        int end = start + 6;
        if (end > data.size()) {
            end = data.size();
        }
        return data.subList(start, end);
    }

    public int getPageNum() {
        return data.size() / 6 + 1;
    }
}
