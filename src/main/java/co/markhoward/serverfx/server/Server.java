package co.markhoward.serverfx.server;

import java.io.File;

public interface Server {

	void start(final File outputDirectory, final String host);

	boolean isRunning();

	void stop();

}
