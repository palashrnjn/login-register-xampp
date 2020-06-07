import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

	public class DataReg
	{
			private String dburl = "jdbc:mysql://localhost:3306/office?useTimezone=true&serverTimezone=UTC";
			private String dbuName = "root";
			private String dbpassword = "";
			private String dbdriver = "com.mysql.cj.jdbc.Driver";
			public void loadDriver(String dbDriver)
			{
				try {
					Class.forName(dbDriver);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			public Connection getConnection() 
			{
				Connection con=null;
				try {
					con=DriverManager.getConnection(dburl,dbuName,dbpassword);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return con;
	}
			public String insert(Member member) 
			{
				loadDriver(dbdriver);
				Connection con=getConnection();
				String result="Data entered successfully";
				String sql="insert into employees values(?,?,?,?)";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, member.getUname());
					ps.setString(2, member.getPassword());
					ps.setString(3, member.getEmail());
					ps.setString(4, member.getPhone());
					ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					result="Data not entered";
				}
				return result;
				
				
			}
	}


