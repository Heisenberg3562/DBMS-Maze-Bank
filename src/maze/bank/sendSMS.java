/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.bank;

/**
 *
 * @author Omkar
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class sendSMS {
	public String sendSms() {
		try {
			// Construct data
			String apiKey = "apikey=" + "wkP2tVim5O0-Cv3HSaeu4A2Ay8cMnxNOWywaiuqYkE";
			String message = "&message=" + "Hey Janvi Karia. Special Discount for Aliens!! Use code JANVIYEDU";
			String sender = "&sender=" + "mazebank";
			String numbers = "&numbers=" + "919930923562";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
        
        public void sms(){
//            HttpResponse<String> response = Unirest.post("https://sms77io.p.rapidapi.com/status")
//	.header("x-rapidapi-host", "sms77io.p.rapidapi.com")
//	.header("x-rapidapi-key", "1a0a0dd50cmsh296f6823c8c1afdp1476a8jsn98b7a82b0760")
//	.header("content-type", "application/x-www-form-urlencoded")
//	.body("msg_id=%3Crequired%3E&p=%3Crequired%3E")
//	.asString();

            
        }
}
