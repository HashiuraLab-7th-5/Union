package database;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import org.eclipse.core.resources.IFile;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;


import marker.GetResource;
import property.Property;


public class SQLiteSample extends ClassLoader{
	private InputStream inputStream = null;
	private String databaseName = "union_test";
	private String projectPath;
    private Connection conn = null;
    private Statement statement = null;



	public void conectSample() throws IOException {

		//　プロジェクトパスの取得
		IResource resouece = getResouece();
		getFile(resouece);

	}

	//Tableにあるエラーを読み取る
	public ArrayList<Map<String,String>> getTable(String tableName) {
		String[] kolum = {"id","errorcode","classname","start","end"}; //　union_test
		ArrayList<Map<String,String>> tableData = new ArrayList<Map<String,String>>();	//保管しておくやつ


		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

        try {
        	System.out.println("プロジェクトのパス" + projectPath);
			conn = DriverManager.getConnection("jdbc:sqlite:" + projectPath);
            statement = conn.createStatement();
            System.out.println("データベースつながった");

            String sql = "select * from " + databaseName + ";";
            ResultSet rs = statement.executeQuery(sql);

            //Mapのの方がやりやすいかも
            int columCount = rs.getMetaData().getColumnCount();	//テーブルの列の数
            while(rs.next()) {

            	Map<String,String> data = new HashMap<String,String>();
            	for(int num = 0; num < columCount; num++) {
            		data.put(kolum[num],rs.getString(kolum[num]));
            	}
            	tableData.add(data);

            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
            System.out.println("SQLException");

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                	System.out.println("SQLException");
                }
            }
        }

        return tableData;
	}

	private void getProjectPath(IResource resouece) {

		this.projectPath = resouece.getLocation().toString();

	}

	private IResource getResouece() {

		String projectName = "Union";
		IResource resouece = GetResource.getResource(projectName);
		return resouece;

	}

	private IFile getFile(IResource resource) {

		try {
			resource.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if(resource.getType() == IResource.FILE)
					{
						String ext = resource.getFileExtension();
						if(ext != null)
						{
							if(resource.getName().equals("test.sqlite3"))
							{
								getProjectPath(resource);
							}
						}

					}
					return true;
				}
			});
		} catch (CoreException e2) {
			// TODO 自動生成された catch ブロック
			e2.printStackTrace();
		}
		return null;
	}
	protected String findLibraty(String libname) {

		return super.findLibrary(libname);

	}

}

/*		File path = new File(url.getPath());

System.out.println("directory変数：" + path.getCanonicalPath());
BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
StringBuilder sb = new StringBuilder();
String line;

while ((line = br.readLine()) != null) {
    sb.append(line);
}

String database = url.getPath();
System.out.println("データベースのディレクトリ：" + database);

br.close();

System.out.println("url変数：" + url.toString());

		ClassLoader c = SQLiteSample.class.getClassLoader();
		String directory = findLibraty(INIT_FILE_PATH);
		inputStream = SQLiteSample.class.getClassLoader().getResourceAsStream(INIT_FILE_PATH);
		URL url = SQLiteSample.class.getClassLoader().getResource(INIT_FILE_PATH);

            final String sql = "SELECT name FROM hoge WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
                pstmt.setInt(1, 2);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.format("name：%s", rs.getString("name"));
                    }
                }
            }
*/
