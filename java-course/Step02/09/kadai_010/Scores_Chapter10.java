package kadai_010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Scores_Chapter10 {

	public static void main(String[] args) {
		Connection con = null;
		Statement statement = null;
		
		try {
			
			//// データベース接続
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost/challenge_java",
				"root",
				"my700Hoiu"
			);
			
			System.out.println("データベース接続成功：" + con);
			
			//// UPDATE
			// クエリ作成
			String updateSql = "UPDATE scores SET score_math = 95, score_english = 80 WHERE name = '武者小路勇気'";
			
			// クエリ実行
			System.out.println("レコード更新を実行します");
			statement = con.createStatement();
			int rowCnt = statement.executeUpdate(updateSql);
			
			System.out.println(rowCnt + "件のレコードが更新されました");
			
			//// SELECT(SORT)
			// クエリ作成
			String selectSql = "SELECT * FROM scores ORDER BY score_math DESC, score_english DESC";
			ResultSet result = statement.executeQuery(selectSql);
			
			// クエリ実行
			System.out.println("数学・英語の点数が高い順に並べ替えました");
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				int scoreMath = result.getInt("score_math");
				int scoreEnglish = result.getInt("score_english");
				
				System.out.println(result.getRow() + "件目：生徒ID=" + id 
													+ "／氏名=" + name 
													+ "／数学=" + scoreMath
													+ "／英語=" + scoreEnglish);
			}
			
		} catch (SQLException e) {
			System.out.println("エラー発生：" + e.getMessage());
		} finally {
			if (con != null) {
				try { con.close(); } catch (SQLException ignore) {}
			} 
			if (statement != null) {
				try { statement.close(); } catch (SQLException ignore) {}
			} 			
		}
	}

}
