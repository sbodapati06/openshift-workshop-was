package org.pwte.example.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

//KLP
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ApplicationScoped
@Readiness
public class ReadinessCheck implements HealthCheck {
	
	
	
	@Override
	public HealthCheckResponse call() {
		HashMap hm = new HashMap();
		InitialContext ctx;
		try {
			System.out.println("In ReadinessCheck");
			ctx = new InitialContext();
			System.out.println("Initial Context created");
			DataSource ds = (DataSource) ctx.lookup("jdbc/orderds");
			System.out.println("DataSource located");
			Connection conn = ds.getConnection();
			System.out.println("Obtained Connection");
			PreparedStatement ps = conn.prepareStatement("select * from category");
			System.out.println("Prepared Statement");
			ResultSet rs = ps.executeQuery();
			System.out.println("Exdecuted Query");
			int rowNum = 1;
			while (rs.next()) {
   			   String catName = rs.getString("CAT_NAME");
               System.out.println("Retreived Data for row #" + rowNum);
               hm.put("row"+rowNum, catName);
               rowNum++;
			}  
			System.out.println("Printing HashMap");
			System.out.println("HashMap: " + hm);
			rs.close();
			ps.close();
			conn.close();
			System.out.println("Connection closed");


			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}

		if (hm !=null && hm.size()>0) 
        {
			return HealthCheckResponse.named("READY_FOR_DEMO")
			.withData("Theh ORDERDB database is UP. The number of Product categories discovered is:", hm.size())
			.up()
			.build();
		}
        else 
		{
			return HealthCheckResponse.named("READY_FOR_DEMO")
			.withData("ORDERDB is DOWN", "Start the database using the startDB2.sh script") 
			.down()
			.build();
		}

	}

}
