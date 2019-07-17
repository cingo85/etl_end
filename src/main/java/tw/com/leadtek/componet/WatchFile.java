package tw.com.leadtek.componet;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchFile {
	public void run() {
		final Path path = Paths.get("D:/test");
		WatchService watchService;
		try {
			watchService = FileSystems.getDefault().newWatchService();

			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE);

			while (true) {
				final WatchKey key = watchService.take();

				for (WatchEvent<?> watchEvent : key.pollEvents()) {
					final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
					final Path filename = watchEventPath.context();

					System.out.println("kind: " + watchEvent.kind().toString());
					System.out.println("filename: " + filename.toString());
				}
				key.reset();
				break;
			}

			watchService.close();
			System.out.println("exit");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
