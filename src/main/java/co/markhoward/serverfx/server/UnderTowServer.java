package co.markhoward.serverfx.server;

import static io.undertow.Handlers.resource;

import java.io.File;

import io.undertow.Undertow;
import io.undertow.server.handlers.resource.PathResourceManager;

public class UnderTowServer implements Server {
	private final int port;
	private Undertow server;
	private boolean running = false;

	public UnderTowServer(final int port) {
		this.port = port;
	}

	@Override
	public void start(final File outputDirectory, final String host) {
		this.server = Undertow.builder()
                .addHttpListener(port, host)
                .setHandler(resource(new PathResourceManager(outputDirectory.toPath(), 100))
                        .setDirectoryListingEnabled(true))
                .build();
        this.server.start();
        this.running = true;
	}
	
	@Override
	public boolean isRunning(){
		return this.running;
	}
	
	@Override
	public void stop(){
		this.server.stop();
		this.server = null;
	}

}
