package kadai_007;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Posts_Chapter07 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement preStatement = null;
		
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost/challenge_java",
				"root",
				"my700Hoiu"
			);
			
			System.out.println("データベース接続成功：" + con);
			
			//// INSERT実行
			// SQLテンプレート作成
			String insertSql = "INSERT INTO posts (user_id, posted_at, post_content, likes) VALUES (?, ?, ?, ?)";
			preStatement = con.prepareStatement(insertSql);
			
			String[][] postsList = {
					{"1003","2023-02-08","昨日の夜は徹夜でした・・","13"},
					{"1002","2023-02-08","お疲れ様です！","12"},
					{"1003","2023-02-09","今日も頑張ります！","18"},
					{"1001","2023-02-09","無理は禁物ですよ！","17"},
					{"1002","2023-02-10","明日から連休ですね！","20"}
			};
			
			// 実行
			int rowCnt = 0;
			System.out.println("レコードを追加します");
			
			for (int i = 0; i < postsList.length; i++) {
				for (int l = 0; l < 4; l++) {
					preStatement.setString(l+1, postsList[i][l]);
				}
				rowCnt = rowCnt + preStatement.executeUpdate();
			}
			
			System.out.println(rowCnt + "件のレコードが追加されました");
			
			//// SELECT実行
			// SQLテンプレート作成
			String selectSql = "SELECT posted_at, post_content, likes  FROM posts WHERE user_id = ?;";
			preStatement = con.prepareStatement(selectSql);
			
			// 検索するidを入力(今回は定数で指定)
			final int selectId = 1002;
			preStatement.setInt(1, selectId);
			
			// 実行
			ResultSet result = preStatement.executeQuery();
			System.out.println("ユーザーIDが" + selectId + "のレコードを検索しました");
			
			// 結果出力
			while(result.next()) {
				Date postedAt = result.getDate("posted_at");
				String postContent = result.getString("post_content");
				int likes = result.getInt("likes");
				System.out.println(result.getRow() + "件目：投稿日時=" + postedAt
												    + "／投稿内容="     + postContent
								                    + "／いいね数="     + likes);
			}
		} catch (SQLException e) {
			System.out.println("エラー発生：" + e.getMessage());
		} finally {
			if (con != null) {
				try { con.close(); } catch (SQLException ignore) {}
			} 
			if (preStatement != null) {
				try { preStatement.close(); } catch (SQLException ignore) {}
			} 			
		}

	}

}
