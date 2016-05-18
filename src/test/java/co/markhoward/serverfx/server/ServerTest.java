package co.markhoward.serverfx.server;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ServerTest {
	
	@Test
	public void shouldCreateServer() throws IOException{
		int port = 8080;
		Server server = new UnderTowServer(port);
		Assert.assertTrue(server != null);
	}
}
