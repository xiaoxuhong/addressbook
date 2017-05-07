package com.xiao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoxuhong on 2017/4/23.
 */
public interface JDBC_Find {
    public  List<String> Find_by_condition(String condition) throws ClassNotFoundException, SQLException;
}
