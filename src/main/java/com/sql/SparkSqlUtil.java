package com.sql;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.spark.sql.catalyst.parser.SqlBaseLexer;
import org.apache.spark.sql.catalyst.parser.SqlBaseParser;

import java.util.Map;
import java.util.Set;

public class SparkSqlUtil {
    public static Map<String, Set<String>> getDataBaseTablenameAndOper(String sql){
        SqlBaseLexer lexer = new SqlBaseLexer(new ANTLRNoCaseStringStream(sql));

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokenStream);
        ParseTreeWalker walker = new ParseTreeWalker();
        MySqlBaseBaseListener mySqlBaseBaseListener = new MySqlBaseBaseListener();

        walker.walk(mySqlBaseBaseListener, parser.statement());

        return mySqlBaseBaseListener.getDataBaseTablenameAndOper();
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM T_USERS";

        Map<String, Set<String>> dataBaseTablename = SparkSqlUtil.getDataBaseTablenameAndOper(sql);

        System.out.println(dataBaseTablename);
    }
}