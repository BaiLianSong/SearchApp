package mvp.model;

import java.util.List;

/**
 *创建Bean类
 * Copyright 星期四 YourCompany.
 */
public class RootData {
    public int status;
    public String message;
    public List<Shop> data;

    @Override
    public String toString() {
        return "RootData{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
